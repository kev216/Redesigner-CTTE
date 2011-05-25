package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;

import zone.ZoneInfo;

import controleur.ControleurzoneMenu;

public class MenuRaccourci extends JToolBar implements ActionListener
{
	private ControleurzoneMenu controleur;
	private JButton but_nouveau = new JButton();
	private JButton but_ouvrir = new JButton();
	private JButton but_sauver = new JButton();
	private JButton but_undo = new JButton();
	private JButton but_redo = new JButton();
	private JButton but_couper = new JButton();
	private JButton but_copier = new JButton();
	private JButton but_coller = new JButton();
	private JButton but_zoomplus = new JButton();
	private JButton but_zoommoins = new JButton();
	private JButton but_aide = new JButton();
	private JButton but_print = new JButton(); 
	private double zoom = 1;
	private ZoneInfo info ;
	
	public MenuRaccourci(ControleurzoneMenu controleur)
	{
		this.controleur = controleur;
		add(but_nouveau);
    	add(but_ouvrir);
    	add(but_sauver);
    	add(but_print);
    	add(new Separator());
    	add(but_copier);
    	add(but_couper);
    	add(but_coller);
    	add(new Separator());
    	add(but_undo);
    	add(but_redo);
    	add(new Separator());
    	add(but_zoommoins);
    	add(but_zoomplus);
    	add(new Separator());
    	add(but_aide);
    	
	   but_nouveau.setIcon(new ImageIcon(getClass().getResource("../images/new.gif")));
	   but_ouvrir.setIcon(new ImageIcon(getClass().getResource("../images/open.gif")));
	   but_sauver.setIcon(new ImageIcon(getClass().getResource("../images/save.gif"))); 
	   but_print.setIcon(new ImageIcon(getClass().getResource("../images/print.gif")));   
	   but_undo.setIcon(new ImageIcon(getClass().getResource("../images/undo.gif")));
	   but_redo.setIcon(new ImageIcon(getClass().getResource("../images/redo.gif")));    
	   but_couper.setIcon(new ImageIcon(getClass().getResource("../images/cut.gif")));
	   but_copier.setIcon(new ImageIcon(getClass().getResource("../images/copy.gif")));         
	   but_coller.setIcon(new ImageIcon(getClass().getResource("../images/paste.gif")));
	   but_zoomplus.setIcon(new ImageIcon(getClass().getResource("../images/zoomin.gif")));
	   but_zoommoins.setIcon(new ImageIcon(getClass().getResource("../images/zoomout.gif")));
	   but_aide.setIcon(new ImageIcon(getClass().getResource("../images/help.gif")));
	   
	   but_nouveau.setEnabled(true);
	   but_nouveau.setFocusable(false);
	   but_nouveau.setToolTipText("Nouveau");
	   
	   but_ouvrir.setEnabled(true);
	   but_ouvrir.setFocusable(false);
	   but_ouvrir.setToolTipText("Ouvrir");
	   
	   but_sauver.setEnabled(true);
	   but_sauver.setFocusable(false);
	   but_sauver.setToolTipText("Sauvegarder");
	   
	   but_print.setEnabled(true);
	   but_print.setFocusable(false);
	   but_print.setToolTipText("Imprimer");
	   
	   but_undo.setEnabled(true);
	   but_undo.setFocusable(false);
	   but_undo.setToolTipText("Annuler");
	   
	   but_redo.setEnabled(true);
	   but_redo.setFocusable(false);
	   but_redo.setToolTipText("Refaire");
	   
	   but_copier.setEnabled(true);
	   but_copier.setFocusable(false);
	   but_copier.setToolTipText("Copier");
	   
	   but_coller.setEnabled(true);
	   but_coller.setFocusable(false);
	   but_coller.setToolTipText("Coller");
       
	   but_couper.setEnabled(true);
	   but_couper.setFocusable(false);
	   but_couper.setToolTipText("Couper");
	   
	   but_zoommoins.setEnabled(true);
	   but_zoommoins.setFocusable(false);
	   but_zoommoins.setToolTipText("Zoom moins");
	   
	   but_zoomplus.setEnabled(true);
	   but_zoomplus.setFocusable(false);
	   but_zoomplus.setToolTipText("Zoom plus");
	   
	   but_aide.setEnabled(true);
	   but_aide.setFocusable(false);
	   but_aide.setToolTipText("Aide");
	   
	   but_nouveau.addActionListener(this);
	   but_ouvrir.addActionListener(this);
	   but_sauver.addActionListener(this);
	   but_print.addActionListener(this);
	   but_undo.addActionListener(this);
	   but_redo.addActionListener(this);
	   but_coller.addActionListener(this);
	   but_copier.addActionListener(this);
	   but_couper.addActionListener(this);
	   but_zoommoins.addActionListener(this);
	   but_zoomplus.addActionListener(this);
	   but_aide.addActionListener(this);
	   this.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == but_nouveau)
		{
			
		}
		else if(source == but_ouvrir)
		{
			JFileChooser chooser = new JFileChooser();
			  int option = chooser.showOpenDialog(getParent());
		        if (option == JFileChooser.APPROVE_OPTION)
		        {
		          System.out.println("Vous avez choisi le fichier :"+ chooser.getSelectedFile().getName() 
		        		  + "\nL'emplacement du fichier :" +chooser.getSelectedFile().getAbsolutePath());
		        } else {
		        	System.out.println("Vous avez annulé...");
		        }
		}
		else if(source == but_sauver)
		{
			
		}
		else if(source == but_coller)
		{
			
		}
		else if(source == but_copier)
		{
			
		}
		else if(source == but_couper)
		{
			
		}
		else if(source == but_print)
		{
			
		}
		else if(source == but_undo)
		{
			
		}
		else if(source == but_redo)
		{
			
		}
		else if(source == but_zoommoins)
		{
			if(zoom > 0){
				zoom -= 0.2;
				controleur.setZoom(zoom);
			}

		}
		else if(source == but_zoomplus)
		{
			if(zoom < 4){
				zoom += 0.2;
				controleur.setZoom(zoom);	
			}		
		}
		else if(source == but_aide){
			info = new ZoneInfo();
		}
	}
}
