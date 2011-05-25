package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import zone.I_SelectedListener;

import main.Commande;
import main.Main_CTTE;
import modele.Tache;
import modele.Type;

public class ControleurZoneButton implements ActionListener {

	private Main_CTTE ui;
	
	
	public ControleurZoneButton(Main_CTTE ui){
		super();
		this.ui = ui;
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String commande = e.getActionCommand();
		int value = Integer.parseInt(commande);
		
		switch(value){
		case Commande.CREATE_ABSTRACTTASK :
			ui.ajoutUneTache(new Tache("", new Type(Type.TYPE.t_ABSTRACT)));
			break;
		case Commande.CREATE_INTERACTIVETASK:
			ui.ajoutUneTache(new Tache("", new Type(Type.TYPE.t_INTERACTION)));			
			break;
		case Commande.CREATE_MACHINETASK:
			ui.ajoutUneTache(new Tache( "", new Type(Type.TYPE.t_MACHINE)));			
			break;
		case Commande.CREATE_USERTASK:
			ui.ajoutUneTache(new Tache("", new Type(Type.TYPE.t_USER)));	
			//ui.saveDessin();
			break;
		/*case Commande.CREATE_ABSTRACTTASK :
			ui.ajoutUneTache(new TacheAbstraite(AbsIcon, ""));
			break; */
		case Commande.CREATE_RELATION_iterative:
			break;
		case Commande.CREATE_RELATION_arrowico:
			break;
		case Commande.CREATE_RELATION_optional:
			//ui.saveDessin();
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}

}
