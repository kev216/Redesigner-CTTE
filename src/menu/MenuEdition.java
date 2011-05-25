package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import controleur.ControleurzoneMenu;

public class MenuEdition  extends JMenu implements ActionListener
{
	/**
	 * Variables
	 */
	
	private ControleurzoneMenu controleur;
	private JMenuItem meCouper;
	private JMenuItem meCopier;
	private JMenuItem meColler;	
	private JMenuItem meUndo;
	private JMenuItem meRedo;
	
	public MenuEdition (String name,ControleurzoneMenu controleur)
	{
		super(name);
		
		this.controleur = controleur;
		 meCouper = new JMenuItem("Couper");
		 meCopier = new JMenuItem("Copier");
		 meColler = new JMenuItem("Coller");
         meUndo = new JMenuItem("Annuler");
         meRedo = new JMenuItem("Refaire");
       		 
         add(meCouper);
         add(new JSeparator());
 		 add(meCopier);
 		 add(new JSeparator());
 		 add(meColler);
 		 add(new JSeparator());
 		 add(meUndo);
 		 add(new JSeparator());
 		 add(meRedo);
 		
         
		 meCouper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		 meCopier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
         meColler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
         meUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
         meRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK));
     
         meCouper.setToolTipText("Coupe la sélection");
         meCopier.setToolTipText("Copie la sélection");
         meColler.setToolTipText("Colle le contenu");
         meUndo.setToolTipText("Annule la dernière instruction");
         meRedo.setToolTipText("Refaire ");
        
         
         meCouper.addActionListener(this);
		 meCopier.addActionListener(this);
		 meColler.addActionListener(this);
		 meUndo.addActionListener(this);
         meRedo.addActionListener(this);
       
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == meColler)
		{
			
		}
		else if(source == meCopier)
		{
			
		}
		else if(source == meCouper)
		{
			
		}
		else if(source == meUndo)
		{
			
		}
		else if(source == meRedo)
		{
			
		}
	}

}
