package zone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import menu.MenuRaccourci;
import controleur.ControleurzoneMenu;
import panel.PanelZoom;

public class ZoneMenu  extends JPanel{

	private ControleurzoneMenu controleur;
	
	public ZoneMenu(ControleurzoneMenu controleur){
		super(new BorderLayout());
		this.controleur = controleur;
		
		JPanel pWest = new JPanel(new BorderLayout());
		//setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setMinimumSize(new Dimension(100,55));
		setPreferredSize(getMinimumSize());
		add(pWest.add(new MenuRaccourci(controleur)), BorderLayout.WEST);
		add(new PanelZoom(controleur),BorderLayout.EAST);
	}

}
