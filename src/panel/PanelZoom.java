package panel;


import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controleur.ControleurzoneMenu;

public class PanelZoom extends JPanel {
	
	private final ControleurzoneMenu controleur;
	private JSlider slider;
//	private JTextField textSize;
	private static final int FPS_MIN = 1;
	private static final int FPS_MAX = 100;
	private static final int FPS_INIT = 50;
	
	public PanelZoom( ControleurzoneMenu controleur	){
		super();

		this.controleur = controleur;
		slider = new JSlider(JSlider.HORIZONTAL,FPS_MIN, FPS_MAX, FPS_INIT);
		//textSize = new JTextField(2);
		slider.setMajorTickSpacing(11);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent arg0) { 
				 JSlider source = (JSlider)arg0.getSource();
				    if (!source.getValueIsAdjusting()) {
				        int fps = (int)source.getValue();
				        double value = ((double)fps) / FPS_INIT;
				        zoom(value);
				    }				
			}		
		});
		//setMinimumSize(new Dimension(50,20));
		//setPreferredSize(getMinimumSize());
		add(slider);
		//add(textSize);
		
	}
	
	
	

	private void zoom(double value) {
        controleur.setZoom(value);		
	}

}
