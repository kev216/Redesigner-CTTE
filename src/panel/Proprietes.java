/**
 * 
 */
package panel;

/**
 * @author ProjetCompte
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modele.Tache;


/**
 * @author Diouf
 *
 */
public class Proprietes  extends JFrame{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlateFormPlus platplus = null;
	private JButton update;
	private JButton ok;
	private JButton annuler;
	
	private JTextField nomtext;
	private JTextField typ;
	private JTextField idetext;
	private JComboBox categorie;
	private JComboBox frequence;
	private JCheckBox pda;
	private JCheckBox desktop;
	private JCheckBox mobile;
	private JCheckBox vocal;
	private JTextArea ptext;
	private JCheckBox iterative;
	private JCheckBox optionnel;
	private JCheckBox parttach;
	private JTextArea obstext;
	  	
	private Tache Prop;
	
	
	 public Proprietes(Tache prop,JFrame f, boolean modal){
		 //super(f,modal);
	   this.setTitle("Caracteristiques de la tâche");
	   this.setSize(500,600);
	  // this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	   this.setLocation(150, 50);
	   this.setVisible(true);
	   //this.setResizable(false);
	   this.Prop = prop; 
	  
	//*************************************************
	  JLabel titre_page = new JLabel(" Propiriétés de la tâche ");
	  titre_page.setFont(new Font("sansserif", Font.BOLD, 28));
	  

	//*************************************************    
	  JLabel nom = new JLabel("Nom :          ");
	  nomtext = new JTextField(25);
	  nomtext.setText(Prop.getNom());
	  
	//*************************************************
	  JLabel type= new JLabel("Type :          ");
	  typ= new  JTextField(25);
	  typ.setText(Prop.getType());
	  

	//*************************************************  
	  JLabel identifiant= new JLabel("Identifiant :");
	  idetext= new  JTextField(25);
	  idetext.setSize(new Dimension(2,2));
	  idetext.setText(Prop.getIdentifiant());
	  	  
	//*************************************************  
	  JLabel ChoixCategorie = new JLabel("Categorie  :          ");
	  categorie = new JComboBox();
	  categorie.addItem("Abstraction");
	  categorie.addItem("Application");
	  categorie.addItem("Interaction");
	  categorie.addItem("User");
	  categorie.setSelectedItem(Prop.getCategorie());
	  
	//*************************************************    
	  JLabel ChoixFrequence=new JLabel("Frequency  :              ");
	  frequence = new JComboBox();
	  frequence.addItem("Low");
	  frequence.addItem("Medium  ");
	  frequence.addItem("High");
	  
	  frequence.setSelectedItem(Prop.getFrequence());
	    
	//*************************************************  
	  JPanel panelPlatform = new JPanel();
	  panelPlatform.setLayout(new FlowLayout(FlowLayout.LEFT));
	  JLabel platforme= new JLabel("Plateforme :");
	  pda = new JCheckBox("PDA");
	  pda.setSelected(Prop.getPDA());
	  desktop = new JCheckBox("Desktop");
	  desktop.setSelected(Prop.getDesktop());
	  mobile = new JCheckBox("Mobile");
	  mobile.setSelected(Prop.getMobile());
	  vocal = new JCheckBox("Vocal");
	  vocal.setSelected(Prop.getVocal());
	  
	  
	  JButton other= new JButton(" + ");
	  other.addActionListener(new ActionListener(){
	   	public void actionPerformed(ActionEvent e){
			AjouterPlatForm();
		} 	  
	  });

	  panelPlatform.setLocation(5,5);
	  panelPlatform.add(pda);
	  panelPlatform.add(desktop);
	  panelPlatform.add(mobile);
	  panelPlatform.add(vocal);
	  panelPlatform.add(other);


	//*************************************************  
	  JLabel precon= new JLabel("Précondition :");
	  ptext = new JTextArea(5, 17);
	  ptext.setText(Prop.getPrecondition());
	  JScrollPane scrollZoneText= new JScrollPane(ptext);
	  
	  iterative = new JCheckBox("Iterative");
	  iterative.setSelected(Prop.getIterative());
	  optionnel = new JCheckBox("Optionnel");
	  optionnel.setSelected(Prop.getOptionnel());
	  parttach = new JCheckBox("Part.tache Coop.");
	  parttach.setSelected(Prop.getPartTach());
	  
	  JPanel PanelCheckBoxOption = new JPanel();
	  PanelCheckBoxOption.setLayout(new GridLayout(3,1));
	  PanelCheckBoxOption.add(iterative);
	  PanelCheckBoxOption.add(optionnel);
	  PanelCheckBoxOption.add(parttach);
	  
	  JPanel PanelPrecondtion = new JPanel();
	  PanelPrecondtion.setLayout(new BorderLayout());
	  PanelPrecondtion.add(scrollZoneText, BorderLayout.CENTER);
	  PanelPrecondtion.add(PanelCheckBoxOption, BorderLayout.EAST);
	
	 //*************************************************
	  JLabel obs= new JLabel("Observation :");
	  obstext= new JTextArea(5,27);
	  JScrollPane scrollObservation = new JScrollPane(obstext);
	    
	  
	//************************************************* 
	  
	  JPanel panelbouton = new JPanel();
	  panelbouton.setLayout(new FlowLayout( FlowLayout.RIGHT)); 
	  update = new JButton("Update");
	  update.addActionListener(new GestButtonListenner());
	  ok = new JButton("OK");
	  ok.addActionListener(new GestButtonListenner());
	  annuler = new JButton("Annuler");
	  annuler.addActionListener(new GestButtonListenner());
	  panelbouton.add(update);
	  panelbouton.add(ok);
	  panelbouton.add(annuler);  
	  
	// ************************************ 

	  
	  JPanel panelcenter = new JPanel();

	  panelcenter.setLayout(new GridBagLayout());
	  GridBagConstraints c = new GridBagConstraints();

	  GridBagConstraints contWest = new GridBagConstraints();
	  
	  c.fill = GridBagConstraints.HORIZONTAL;
	  c.gridx = 0;
	  c.gridy = 0;
	  c.ipady = 5;
	  
	  contWest.fill = GridBagConstraints.HORIZONTAL;
	 
	  contWest.gridx = 0;
	  contWest.gridy = 0;
	  contWest.ipady = 5;
	  
	  

	  
	  c.gridy = 6;
	  JPanel panelnom = new JPanel();
	  panelnom.add(nom);
	  panelnom.add(nomtext);
	  panelcenter.add(panelnom, c);
	  
	  
	  JPanel paneltype = new JPanel();
	  paneltype.add(type);
	  paneltype.add(typ);
	  c.gridy = 9;
	  panelcenter.add(paneltype, c);
	  JPanel panelid = new JPanel();
	  panelid.add(identifiant);
	  panelid.add(idetext);
	  c.gridy = 12;
	  panelcenter.add(panelid, c);
	  
	  
	  JPanel panelCat = new JPanel();
	  panelCat.add(ChoixCategorie);
	  panelCat.add(categorie);
	  c.gridy = 15;
	  panelcenter.add(panelCat, c);
	  
	  
	  JPanel panelFreq = new JPanel();
	  panelFreq.add(ChoixFrequence);
	  panelFreq.add(frequence);
	  c.gridy = 18;
	  panelcenter.add(panelFreq, c);
	  
	  
	  JPanel panelplatform = new JPanel();
	  panelplatform.add(platforme);
	  panelplatform.add(panelPlatform);
	  c.gridy = 21;
	  panelcenter.add(panelplatform, c);
	 
	  
	  JPanel panelprecond = new JPanel();
	  panelprecond.add(precon);
	  panelprecond.add(PanelPrecondtion);
	  c.gridy = 24;
	  panelcenter.add(panelprecond, c);
	  
	  
	  JPanel panelobserv = new JPanel();
	  panelobserv.add(obs);
	  panelobserv.add(scrollObservation);
	  c.gridy = 27;
	  panelcenter.add(panelobserv, c);
	  
	  
	  c.gridy = 65;
	  panelcenter.add(panelbouton, c);
	  
	  setLayout(new BorderLayout());
	  
	  JPanel titre = new JPanel();
	  titre.setLayout(new FlowLayout(FlowLayout.CENTER));
	  titre.add(titre_page);
	  
	  //*********************  Ajout dans le frame
	  add(titre, BorderLayout.NORTH);
	  add(panelcenter, BorderLayout.CENTER);
	  
	 }
	 
	 protected boolean updatePossible(){
		 	try {
				if ((nomtext.getText().equals(Prop.getNom()))
						&& ((typ.getText()).equals(Prop.getType()))
						&& ((idetext.getText()).equals(Prop.getIdentifiant()))
						&& (Prop.getCategorie().equals((String) categorie
								.getSelectedItem()))
						&& (Prop.getFrequence().equals((String) frequence
								.getSelectedItem()))
						&& (Prop.getPDA() == pda.isSelected())
						&& (Prop.getDesktop() == desktop.isSelected())
						&& (Prop.getMobile() == mobile.isSelected())
						&& (Prop.getVocal() == vocal.isSelected())
						&& (Prop.getPrecondition().equals(ptext.getText()))
						&& (Prop.getObservation().equals(obstext.getText()))
						&& (Prop.getIterative() == iterative.isSelected())
						&& (Prop.getOptionnel() == optionnel.isSelected())
						&& (Prop.getPartTach() == parttach.isSelected())
						&& (Prop.isListActModif(platplus.getlistActif()))
						&& (Prop.isListAjtModif(platplus.getlistAjout()))) {
					return true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		return false;
	 }
				
	 
	 protected void updatePropriete(){
		Prop.setNom(nomtext.getText()); 
		Prop.setType(typ.getText());
		Prop.setIdentifiant(idetext.getText());
		Prop.setCategorie((String)categorie.getSelectedItem());
		Prop.setFrequence((String) frequence.getSelectedItem());
		Prop.setPDA(pda.isSelected());
		Prop.setDesktop(desktop.isSelected());
		Prop.setMobile(mobile.isSelected());
		Prop.setVocal(vocal.isSelected());
		Prop.setPrecondition(ptext.getText());
		Prop.setObservation(obstext.getText());
		Prop.setIterative(iterative.isSelected());
		Prop.setOptionnel(optionnel.isSelected());
		Prop.setPartTach(parttach.isSelected());
		Prop.setplatformPlusActif(platplus.getlistActif());
		Prop.setplatformPlusAjout(platplus.getlistAjout());
	 }
	 
	 protected void validerModifPropriete(){
		 if(updatePossible()){
			 int rep = JOptionPane.showConfirmDialog(null, " voulez vous sauvegardez les modifications ? ",
	                    "Confirmation Message", JOptionPane.YES_NO_OPTION);
		    	if(rep == JOptionPane.YES_OPTION){
		    		updatePropriete();
		    	}
		 }
		 dispose();
	 }
	 
	 protected void annulerModifPropriete(){
		 if(updatePossible()){
			 int rep = JOptionPane.showConfirmDialog(null, " voulez vous sauvegardez les modifications ? ",
	                    "Confirmation Message", JOptionPane.YES_NO_OPTION);
		    	if(rep == JOptionPane.YES_OPTION){
		    		updatePropriete();
		    	}
		 }
		 dispose();
	 }
	 
	 
	 public void AjouterPlatForm(){
		 if(platplus == null){
			platplus = new PlateFormPlus(null,Prop.getPlatFormPlusActif(), Prop.getPlatFormPlusAjout(),true);
		 }
		 platplus.setVisible(true);
		 platplus.setLocation(200, 150);
	 }
	 
	 
	 class GestButtonListenner implements KeyListener, ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == update){
				updatePropriete();
			}
			else if(e.getSource() == ok){
				validerModifPropriete();
			}
			else if(e.getSource() == annuler){
				annulerModifPropriete();
			}
			
		}
		
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
}
