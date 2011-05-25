package zone;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Commande;

import controleur.ControleurZoneButton;

import bouton.ButtonDesigned;

public class zoneButton extends JPanel{
	
	private ControleurZoneButton controleur;
	private JPanel panelTache;
	private JButton btntUser;
	private JButton btntAbs;
	private JButton btntMac;
	private JButton btntInt;
	private GridBagConstraints c;

		
	private JPanel panelOperateur;
	private JLabel hpriority;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	
	private JLabel lpriority;
	private JButton btn9;
	private JButton btn10;
	private JButton btnt11;
	private GridBagConstraints c2;

	
	
	public zoneButton(ControleurZoneButton controleur){
		super(new BorderLayout());
		this.controleur = controleur;
		add(getPanelTache(), BorderLayout.NORTH);
		add(getPanelOperateur(), BorderLayout.SOUTH);
		
	}
	
	
	
	
	
	private JPanel getPanelTache(){
		JPanel pane = new JPanel(new BorderLayout());
		JPanel paneTitre = new JPanel( new FlowLayout(FlowLayout.CENTER));
		paneTitre.add( new JLabel("Tâches"));
		pane.add(paneTitre, BorderLayout.NORTH);
		
		panelTache = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();

		c.gridx = 0; c.gridy = 0;
		panelTache.add(btntUser = new ButtonDesigned(new ImageIcon(getClass().getResource("../images/userico.gif"))),c);
		btntUser.setActionCommand(Integer.toString(Commande.CREATE_USERTASK));
		btntUser.addActionListener(controleur);
		
		c.gridx = 0; c.gridy = 1;
		panelTache.add(btntAbs = new JButton(new ImageIcon(getClass().getResource("../images/abstractionico.gif"))),c);
		btntAbs.setActionCommand(Integer.toString(Commande.CREATE_ABSTRACTTASK));
		btntAbs.addActionListener(controleur);
		
		c.gridx = 0; c.gridy = 2;
		panelTache.add(btntMac = new JButton(new ImageIcon(getClass().getResource("../images/applicationico.gif"))),c);
		btntMac.setActionCommand(Integer.toString(Commande.CREATE_MACHINETASK));
		btntMac.addActionListener(controleur);
		
		c.gridx = 0; c.gridy = 3;
		panelTache.add(btntInt = new JButton(new ImageIcon(getClass().getResource("../images/interactionico.gif"))),c);
		btntInt.setActionCommand(Integer.toString(Commande.CREATE_INTERACTIVETASK));
		btntInt.addActionListener(controleur);
		pane.add(panelTache, BorderLayout.SOUTH);		
		return pane;
	}
	
	
	
	
	
	
	private JPanel getPanelOperateur(){
		JPanel pane = new JPanel(new BorderLayout());
		JPanel paneTitre = new JPanel( new FlowLayout(FlowLayout.CENTER));
		paneTitre.add( new JLabel("Opérateurs"));
		pane.add(paneTitre, BorderLayout.NORTH);
		
		panelOperateur =  new JPanel(new GridBagLayout());
		c2 = new GridBagConstraints();

			//new JPanel(new GridLayout(14,1));
 
		c2.gridx = 0; c2.gridy = 0;
		panelOperateur.add(hpriority = new JLabel("High Priority"));

		c2.gridx = 0; c2.gridy = 1;
		panelOperateur.add( btn1 = new JButton(new ImageIcon(getClass().getResource("../images/choice_.gif"))),c2);
		
		c2.gridx = 0; c2.gridy = 2;
		panelOperateur.add( btn2 = new JButton(new ImageIcon(getClass().getResource("../images/order.gif"))),c2);

		c2.gridx = 0; c2.gridy = 3;
		panelOperateur.add( btn3 = new JButton(new ImageIcon(getClass().getResource("../images/interleave_.gif"))),c2);

		c2.gridx = 0; c2.gridy = 4;
		panelOperateur.add( btn4 = new JButton(new ImageIcon(getClass().getResource("../images/abstractionico.gif"))),c2);

		c2.gridx = 0; c2.gridy = 5;
		panelOperateur.add( btn5 = new JButton(new ImageIcon(getClass().getResource("../images/disabling_.gif"))),c2);

		c2.gridx = 0; c2.gridy = 6;
		panelOperateur.add( btn6 = new JButton(new ImageIcon(getClass().getResource("../images/suspend_.gif"))),c2);
		
		c2.gridx = 0; c2.gridy = 7;
		panelOperateur.add( btn7 = new JButton(new ImageIcon(getClass().getResource("../images/enabling_.gif"))),c2);
		
		c2.gridx = 0; c2.gridy = 8;
		panelOperateur.add( btn8 = new JButton(new ImageIcon(getClass().getResource("../images/enablinginfo_.gif"))),c2);

		c2.gridx = 0; c2.gridy = 9;
		panelOperateur.add(new JLabel(""),c2);

		c2.gridx = 0; c2.gridy = 10;
		panelOperateur.add( lpriority = new JLabel("Low Priority"),c2);

		c2.gridx = 0; c2.gridy = 11;
		panelOperateur.add( btn9 = new JButton(new ImageIcon(getClass().getResource("../images/iterative.gif"))),c2);
		btn9.setActionCommand(Integer.toString(Commande.CREATE_RELATION_iterative));
		btn9.addActionListener(controleur);

		c2.gridx = 0; c2.gridy = 12;
		panelOperateur.add( btn10 = new JButton(new ImageIcon(getClass().getResource("../images/optional.gif"))),c2);
		btn10.setActionCommand(Integer.toString(Commande.CREATE_RELATION_optional));
		btn10.addActionListener(controleur);
		
		c2.gridx = 0; c2.gridy = 13;
		panelOperateur.add( btnt11 = new JButton(new ImageIcon(getClass().getResource("../images/arrowico.gif"))),c2);
		btnt11.setActionCommand(Integer.toString(Commande.CREATE_RELATION_arrowico));
		btnt11.addActionListener(controleur);

		pane.add(panelOperateur, BorderLayout.SOUTH);		
		return pane;
	}

}
