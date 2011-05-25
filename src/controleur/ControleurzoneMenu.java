package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main_CTTE;

public class ControleurzoneMenu  implements ActionListener  {

	private Main_CTTE ui;

	public ControleurzoneMenu( Main_CTTE ui){
		this.ui = ui;
	}

	
	public void setZoom(double zoom){
		ui.zoom(zoom);
	}
	
	
	public void createNewZoneDessin(){
		ui.createNewZoneDessin();
	}
	
	public void saveProjet(){
		ui.savePanelDessin("");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
