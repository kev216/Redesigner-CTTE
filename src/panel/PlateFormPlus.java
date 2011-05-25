/**
 * 
 */
package panel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * @author ProjetCompte
 *
 */
public class PlateFormPlus extends JDialog{

	private Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private JList Listactif = new JList();
	private JList Listajout = new JList();
	private JTextField newPlatform;
	
	PlateFormPlus(JFrame f,String[] act, String[] ajts,boolean modal){
		super(f,modal);
		this.setTitle("Personnalisation des plateformes");
		this.setSize(400,300);
		this.setResizable(false);
		Listajout = new JList(ajts);
		Listactif = new JList(act);
		placerButton();
		placerList();
	}
	
	private void placerButton(){
		JButton ajt = new JButton(" + ");
		ajt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutNewPlatForm();
			}
		});
		
		JButton del = new JButton(" - ");
		del.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 removePlatform();
			}
		});
		
		JButton close = new JButton("Fermer");
		close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		JPanel panButon = new JPanel();
		panButon.add(ajt);
		panButon.add(del);
		panButon.add(close);


		newPlatform = new JTextField(25);
		newPlatform.setSize(new Dimension(2,2));
		
		JPanel pansouth = new JPanel();
		pansouth.setLayout(new GridLayout(2,1));

		pansouth.add(panButon, 1, 0);
		pansouth.add(newPlatform, 0, 0);
		pansouth.setBorder(raisedetched);
		this.add(pansouth, BorderLayout.SOUTH);
		
	}
	
	private void placerList(){

		int H =(getHeight()/2) - 20;
		int W = (getWidth()/2) - 35;
		String[] platform = {};
		String[] platform1 = {};
		
		
		//Listajout = new JList(platform);
		//Listactif = new JList(platform1);
		
		JScrollPane scrolAjout = new JScrollPane(Listajout);
		JScrollPane scrolActif = new JScrollPane(Listactif);
		
		scrolActif.setBorder(BorderFactory.createTitledBorder("PlateForme Active"));
		scrolActif.setPreferredSize(new Dimension(W, H));
		
		scrolAjout.setBorder(BorderFactory.createTitledBorder("Nouveau PlateForme"));
		scrolAjout.setPreferredSize(new Dimension(W, H));
		
		
		JButton rd_actif = new JButton(">");
		rd_actif.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlacerActif();
			}
		});
		
		JButton rd_TTactif = new JButton(">>");
		rd_TTactif.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlacerToutActif();
			}
		});

		
		JButton rd_inactif = new JButton("<");
		rd_inactif.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnleverActif();
			}
		});

		
		JButton rd_TTinactif = new JButton("<<");
		rd_TTinactif.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnleverToutActif();
			}
		});
		JPanel panButton = new JPanel();
		panButton.setLayout(new GridLayout(4,1));
		panButton.add(rd_TTinactif, 0, 0);
		panButton.add(rd_inactif, 1, 0);
		panButton.add(rd_TTactif, 2, 0);
		panButton.add(rd_actif, 3, 0);
		panButton.setBorder(raisedetched);
		
		JPanel pancenter = new JPanel();
		pancenter.setLayout(new BorderLayout());
		pancenter.add(scrolActif, BorderLayout.EAST);
		pancenter.add(panButton, BorderLayout.CENTER);
		pancenter.add(scrolAjout, BorderLayout.WEST);
		pancenter.setBorder(raisedetched);

		this.add(pancenter, BorderLayout.CENTER);
	}
	
	
	public String[] getlistActif(){
		String[] Listact = null;
		ListModel model = Listactif.getModel();
		 if (model.getSize() > 0) {
			 Listact = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					Listact[i] = (String) model.getElementAt(i);
				}
		 }
		return Listact;
	}
	
	public String[] getlistAjout(){
		String[] Listajt = null;
		ListModel model = Listajout.getModel();
		 if (model.getSize() > 0) {
			 Listajt = new String[model.getSize()];
				for (int i = 0; i < model.getSize(); i++) {
					Listajt[i] = (String) model.getElementAt(i);
				}
		 }
		return Listajt;
	}
	
	// Methode de gestion des listes de plate-forme
	 private DefaultListModel removePlate(String name, ListModel model){
		 DefaultListModel dlm = new DefaultListModel();
		 if(model.getSize() > 0) {
		    	for (int i = 0; i < model.getSize(); i++) {
		    		dlm.add(i, model.getElementAt(i));
		    	}
		}
		if (dlm.contains(name)){
		   	dlm.removeElement(name);
		}
		 return dlm;
	 }
	 
	 private DefaultListModel ajoutPlate(String name, ListModel model){
		 DefaultListModel dlm = new DefaultListModel();
		 if (model.getSize() > 0) {
				for (int i = 0; i < model.getSize(); i++) {
				     dlm.add(i, model.getElementAt(i));
				}
			    }
			    if (!dlm.contains(name)){
			    	dlm.addElement(name);
			    }
			    else{JOptionPane.showMessageDialog(null, "La plateforme spécifier est déjà ajouter");}
		 return dlm;
	 }
	 
// -----------------------------------------------------------------------------
	 // Ajout et Suppression d'un nouveau plateforme
	
	protected void AjoutNewPlatForm(){
        ListModel backup = Listajout.getModel();
	    if(newPlatform.getText() != null && (! newPlatform.getText().equals(""))){
		    Listajout.setModel(ajoutPlate(newPlatform.getText(), backup)); 
		    newPlatform.setText(null);
		}
		else{JOptionPane.showMessageDialog(null, "Aucun nom de plateforme n'a été spécifier");}
	   
     }
	 

	 protected void removePlatform(){
		String select = (String) Listajout.getSelectedValue();
        ListModel backup = Listajout.getModel();
        
	    if(select != null && (! select.equals(""))){
	    	int rep = JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir supprimer la plateforme : \" " + (String)Listajout.getSelectedValue() + " \"",
                    "Confirmation Message", JOptionPane.YES_NO_OPTION);
	    	if(rep == JOptionPane.YES_OPTION) Listajout.setModel(removePlate(select, backup)); 
	    }
	    else{JOptionPane.showMessageDialog(null, "Veuillez selectionner une plateforme sur la liste \" Nouveau plateforme\"");}
     }
	 
// ----------------------------------------------------------------------------------------------------------
	 protected void PlacerActif(){
		 String select = (String) Listajout.getSelectedValue();
	     ListModel backup_actif = Listactif.getModel();
	     ListModel backup_ajout = Listajout.getModel();
	     
	     if(select != null && (! select.equals(""))){
	     	Listajout.setModel(removePlate(select, backup_ajout));
	     	Listactif.setModel(ajoutPlate(select, backup_actif));
	 	 }
	     else{JOptionPane.showMessageDialog(null, "Veuillez selectionner une plateforme sur la liste \" Nouveau plateforme\"");}
	 }
	 
	 protected void EnleverActif(){
		 String select = (String) Listactif.getSelectedValue();
	     ListModel backup_actif = Listactif.getModel();
	     ListModel backup_ajout = Listajout.getModel();
	     if(select != null && (! select.equals(""))){
	     	Listactif.setModel(removePlate(select, backup_actif));
	     	Listajout.setModel(ajoutPlate(select, backup_ajout));
	 	 }
	     else{JOptionPane.showMessageDialog(null, "Veuillez selectionner une plateforme sur la liste \"Plateforme actif\"");}
	 }
	 
	 protected void EnleverToutActif(){
	     ListModel backup_actif = Listactif.getModel();
	     ListModel backup_ajout = Listajout.getModel();
    	 String select; 
    	 
		 while (backup_actif.getSize() > 0){
			select = (String) backup_actif.getElementAt(0);
			if(! select.equals("")){
		   	Listactif.setModel(removePlate(select, backup_actif));
		   	Listajout.setModel(ajoutPlate(select, backup_ajout));
			}
			else{JOptionPane.showMessageDialog(null, "Veuillez selectionner une plateforme sur la liste \"Nouveau plateforme \"");}
			backup_actif = Listactif.getModel();
			backup_ajout = Listajout.getModel();
		 }
	}
	 
	 protected void PlacerToutActif(){
	     ListModel backup_actif = Listactif.getModel();
	     ListModel backup_ajout = Listajout.getModel();
    	 String select; 
    	 
		 while (backup_ajout.getSize() > 0){
			select = (String) backup_ajout.getElementAt(0);
			if(! select.equals("")){
				Listajout.setModel(removePlate(select, backup_ajout));
				Listactif.setModel(ajoutPlate(select, backup_actif));
			}
			else{JOptionPane.showMessageDialog(null,"Veuillez selectionner une plateforme sur la liste \"Plateforme actif\"");}
			backup_actif = Listactif.getModel();
			backup_ajout = Listajout.getModel();
		 }
	}

}
