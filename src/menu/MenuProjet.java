package menu;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import controleur.ControleurzoneMenu;

import zone.ZoneDessin;

public class MenuProjet extends JMenu implements ActionListener
{
	/**
	 * Variables
	 */
	
	private ControleurzoneMenu controleur;
	private JMenuItem mNew;
	private JMenuItem mOpen;
	private JMenuItem mSave;
	private JMenuItem mSaveAsImage;

	private JMenuItem mSaveAs;
	private JMenuItem mQuit;
	private JMenuItem mPrint;
	
	/**
	 * Constructeur
	 * @param name
	 */
	public MenuProjet(String name, ControleurzoneMenu controleur)
	{
		super(name);
		
		this.controleur = controleur;
		mNew = new JMenuItem ("New");
		mOpen = new JMenuItem ("Open");
		mSave = new JMenuItem ("Save");
		mSaveAs = new JMenuItem ("Save As");
		mSaveAsImage =  new JMenuItem ("Save As image");
		mQuit = new JMenuItem ("Quit");
		mPrint = new JMenuItem("Print");
		
		add(mNew);
		add( new JSeparator());
		add(mOpen);
		add( new JSeparator());
		add(mSave);
		add(mSaveAs);
		add(mSaveAsImage);
		add( new JSeparator());
		add(mPrint);
		add( new JSeparator());
		add(mQuit);
		
		mOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.ALT_MASK));
		mOpen.setMnemonic('O');
		mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_MASK));
		mNew.setMnemonic('N');
		mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_MASK));
		mSave.setMnemonic('S');
		mPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK));
		mPrint.setMnemonic('P');
		mQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_MASK));
		mQuit.setMnemonic('Q');
		
		mOpen.addActionListener(this);
		mNew.addActionListener(this);
		mSave.addActionListener(this);
		mQuit.addActionListener(this);
		mSaveAs.addActionListener(this);
		mPrint.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == mOpen)
		{
			JFileChooser chooser = new JFileChooser();
			  int option = chooser.showOpenDialog(getParent());
		        if (option == JFileChooser.APPROVE_OPTION) {
		          System.out.println("Vous avez choisi le fichier :"+ chooser.getSelectedFile().getName() 
		        		  + "\nL'emplacement du fichier :" +chooser.getSelectedFile().getAbsolutePath());
		        } else {
		        	System.out.println("Vous avez annulé...");
		        }
		}
		else if(source == mNew)
		{
		//	ZoneDessin newZoneDessin = new ZoneDessin();
			
		}
		else if(source == mSave)
		{
		//	ZoneDessin newZoneDessin = new ZoneDessin();
			
		}
		else if(source == mSaveAs)
		{
			controleur.saveProjet();
		//	ZoneDessin newZoneDessin = new ZoneDessin();
			
		}
		else if(source == mQuit)
		{
			int reponse = JOptionPane.showConfirmDialog(this,
				       "Voulez-vous vraiment quitter?",
				       "Quitter", 
				        JOptionPane.YES_NO_OPTION);
		  if (reponse == JOptionPane.YES_OPTION)
			  System.exit(0);
		}
		else if(source == mPrint)
		{
			
		}
		
	}

	

}
