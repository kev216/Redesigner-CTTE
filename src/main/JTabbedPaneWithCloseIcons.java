package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JTabbedPane;


/**
 * 
 * @author maleye
 */
public class JTabbedPaneWithCloseIcons extends javax.swing.JTabbedPane   {
	JTabbedPaneWithCloseIcons moi; // pour avoir acces au l'element this dans
									// les class internes
	Hashtable<String, JTextPane> listeFenetrePrivee; // liste des Zones de
														// saisies instanciées
	// Notre collection d'observateurs !
	//private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	private String nameOfClosedTAB; // stock pour un moment le nom de la fenetre
									// fermé

	public JTabbedPaneWithCloseIcons() {
		super();
		moi = this;
	}

	
	public JTabbedPaneWithCloseIcons(int v) {
		super(v);
		moi = this;
	}

	
	public void addTab(String title, Component component, int endroit) {
		super.addTab(title, component); // on ajoute une Tab à JTabbedPane
		super.setTabComponentAt(endroit, new CloseTabPanel(title)); 
	}

	// fonction qui permet d'affiché le bouton close
	public void afficheIconAt(int endroit) {
		((CloseTabPanel) moi.getTabComponentAt(endroit)).afficheIcon(true);
	}

	// fonction qui permet d'enlever le bouton close
	public void cacheIconAt(int endroit) {
		((CloseTabPanel) moi.getTabComponentAt(endroit)).afficheIcon(false);
	}

	class CloseTabPanel extends JPanel {
		JButton button;

		// constructeur sans boolean qui de base met un bouton close
		public CloseTabPanel(String titre) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setBackground(Color.WHITE);
			JLabel label = new JLabel(titre);
			add(label);
			button = new TabButton();
			add(button);
			setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		}

		// constructeur avec boolean qui permet de choisir si oui ou non on veux
		// un bouton close
		public CloseTabPanel(String titre, boolean b) {
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setOpaque(false);
			JLabel label = new JLabel(titre);
			add(label);
			button = new TabButton();
			if (b) {
				add(button);
			}
			// add more space to the top of the component
			setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		}

		// permet d'afficher ou cacher le bouton close
		public void afficheIcon(boolean b) {
			if (b) {
				if (this.getComponentCount() == 1)
					this.add(button);
			} else {
				if (this.getComponentCount() > 1)
					this.remove(button);
			}
		}
	}

	class TabButton extends JButton implements ActionListener {
		public TabButton() {
			int size = 17;
			setPreferredSize(new Dimension(size, size));
			setToolTipText("Fermer cet onglet");
			setUI(new BasicButtonUI());
			setContentAreaFilled(false);
			setFocusable(false);
			setBorder(BorderFactory.createEtchedBorder());
			setBorderPainted(false);
			addActionListener(this);
		}

		/*
		 * fonction qui ferme l'onglet du bouton close sur lequel on a cliqué
		 */
		public void actionPerformed(ActionEvent e) {
			int X = new Double(((JButton) e.getSource()).getMousePosition().getX()).intValue();
			int Y = new Double(((JButton) e.getSource()).getMousePosition().getY()).intValue();

			int i = moi.getUI().tabForCoordinate((JTabbedPane) moi, X, Y);
			if (i != -1) {

				// ------------
				// if(listeFenetrePrivee != null)
				// recuperer le titre

				// listeFenetrePrivee.remove(nameOfClosedTAB); // vide les
				// ressources de la case si elles existent

				// ----------------
				nameOfClosedTAB = moi.getTitleAt(i + 1);
				moi.remove(i + 1);
			//	updateObservateur(); // signaler la fenetre à fernmer afin de le
										// signaler au serveur

			}
		}

		// we don't want to update UI for this button
		public void updateUI() {
		}

		// dessine la croix dans le bouton
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g.create();
			// shift the image for pressed buttons
			if (getModel().isPressed()) {
				g2.translate(1, 1);
			}
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.BLACK);
			if (getModel().isRollover()) {
				g2.setColor(Color.MAGENTA);
			}
			int delta = 6;
			g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight()
					- delta - 1);
			g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight()
					- delta - 1);
			g2.dispose();
		}
	}

	// public void setListeFenetrePrivee(Hashtable<String, JTextPane> liste ) {
	// listeFenetrePrivee = liste;
	// }

	/**
	 * Ajoute un observateur à la liste
	 *//*
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	/**
	 * Retire tous les observateurs de la liste
	 *//*
	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	/**
	 * Avertit les observateurs que l'observable a changé et invoque la méthode
	 * update de chaque observateur !
	 *//*
	public void updateObservateur() {
		for (Observateur obs : this.listObservateur)
			obs.update(nameOfClosedTAB);
		nameOfClosedTAB = ""; // vide le champs
	} */

	public void signalerRecceptionMessage(String tabName) {
		// cas 1 :si le panel est actif ne rien faire
		// cas 2 : si le panel n`est pas actif changer la couleur du tab

		int tabId = this.indexOfTab(tabName);
		// verifier si le tab est de type privé et si il n'est pas selectionné
		if (tabId > 0 && this.getSelectedIndex() != tabId) {
			getTabComponentAt(tabId).setBackground(Color.ORANGE);
			// setBackgroundAt(tabId, Color.ORANGE);
		}
	}
}