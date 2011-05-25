package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main_CTTE;

public class ControleurZoneDessin implements ActionListener {

	private Main_CTTE ui;


	public ControleurZoneDessin(Main_CTTE ui){
		super();
		this.ui = ui;
	}
	
		
	public void deleteTache(){
		ui.deleteSelectedTache();
	}
	
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
