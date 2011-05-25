package zone;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import panel.Proprietes;

import Label.LabelTache;

import main.I_UpdateListener;
import modele.Tache;

import controleur.ControleurPropriete;

public class zonePropriete  extends JPanel implements I_SelectedListener,I_UpdateListener{

	
	private ControleurPropriete controleur;
	private JTextField textFieldNom;
	private JTextField textFielType;
	private JTextField textFielIdentifiant;
	private Choice choixCategorie;
	private Choice choixFrequence;
	Proprietes prop;
	private Tache tacheAfficher;
	
	private JButton btn_prop;
	
	private JLabel labTitre;
	private JPanel pane;
	
	private GridBagConstraints c;
	
	public zonePropriete(ControleurPropriete controleur){
		super(new BorderLayout());
		this.controleur = controleur;		
		pane =  new JPanel(new GridBagLayout());		
		c = new GridBagConstraints();
		
		c.gridx = 0; c.gridy = 0;
		pane.add(new JLabel("Nom:"),c);
		c.gridx = 1; c.gridy = 0;		
		pane.add(textFieldNom = new JTextField (11),c);
		textFieldNom.setEditable(false);
		
		c.gridx = 0; c.gridy = 1;		
		pane.add(new JLabel("Type:"),c);
		c.gridx = 1; c.gridy = 1;		
		pane.add(textFielType = new JTextField (11),c);
		textFielType.setEditable(false);
		
		c.gridx = 0; c.gridy = 2;
		pane.add(new JLabel("Identifiant:"),c);
		c.gridx = 1; c.gridy = 2;
		pane.add(textFielIdentifiant = new JTextField (11),c);
		textFielIdentifiant.setEnabled(false);
		
		c.gridx = 0; c.gridy = 3;
		pane.add(new JLabel("Catégorie:"),c);
		c.gridx = 1; c.gridy = 3;		
		pane.add(new Choice(),c);
		
		c.gridx = 0; c.gridy = 4;		
		pane.add(new JLabel("Fréquence:"),c);
		c.gridx = 1; c.gridy = 4;
		pane.add(new Choice(),c);
		
		c.gridx = 0; c.gridy = 5;		
		pane.add(new JLabel(" "),c);
		JPanel p = new JPanel(new BorderLayout());
		p.add(btn_prop = new JButton("+"), BorderLayout.AFTER_LINE_ENDS);
				
		add( getPanelTitre(),BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		setMinimumSize(new Dimension(60,70));
		btn_prop.setEnabled(false);		
		btn_prop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				prop = new Proprietes(tacheAfficher, null, true);
			}
			
		});
	}
	
	private JPanel getPanelTitre(){
		JPanel paneTitre = new JPanel( new FlowLayout(FlowLayout.CENTER));
		 paneTitre.add(labTitre = new JLabel("Caratéristique tâche"));
		return paneTitre;
	}

	@Override
	public void notify(Object o) {
		if(o != null) {
			tacheAfficher = ((LabelTache)o).getTache();
			textFieldNom.setText(tacheAfficher.getNom());
			textFielType.setText(tacheAfficher.getType());
			textFielIdentifiant.setText(tacheAfficher.getIdentifiant());
			btn_prop.setEnabled(true);
		}
		else {
			textFieldNom.setText("");
			textFielType.setText("");
			textFielIdentifiant.setText("");
			btn_prop.setEnabled(false);
		}		
	}
	
	public void sabonnerAI_PublishSelected(){
		controleur.addSelectedListener(this);
	}

	@Override
	public void UpdateListener() {
		sabonnerAI_PublishSelected();
		// TODO Auto-generated method stub
		
	}
	
	
	
}
