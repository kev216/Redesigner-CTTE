package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main_CTTE;
import zone.I_SelectedListener;

public class ControleurPropriete  implements ActionListener {

	private Main_CTTE ui;
	
	
	public ControleurPropriete(Main_CTTE ui){
		super();
		this.ui = ui;		
	}

	
	
	
    public void addSelectedListener(I_SelectedListener listener){
		ui.addSelectedListener(listener);
	}




@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
