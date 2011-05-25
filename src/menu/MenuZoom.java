package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MenuZoom extends JMenu implements ActionListener 
{
	/**
	 * Variables
	 */
	private JMenuItem mZoomplus;
	private JMenuItem mZoommoins;
	
	/**
	 * Constructeur
	 * @param name: nom du menu
	 */
	public MenuZoom (String name)
	{
		super(name);
		
	
         mZoomplus = new JMenuItem("Augmenter zoom");
         add(new JSeparator());
         mZoommoins = new JMenuItem("Réduire zoom");
       		 
     	add(mZoomplus);
    	add( new JSeparator());
		add(mZoommoins);
		
		
		 mZoomplus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		 mZoommoins.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
       
         mZoomplus.setToolTipText("Augmente la taille du dessin");
         mZoommoins.setToolTipText("Réduit la taille du dessin");
        
         
         mZoommoins.addActionListener(this);
		 mZoomplus.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == mZoommoins)
		{
			
		}
		else if(source == mZoomplus)
		{
			
		}
	}

}
