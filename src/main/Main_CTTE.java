package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

import controleur.ControleurPropriete;
import controleur.ControleurZoneButton;
import controleur.ControleurZoneDessin;
import controleur.ControleurzoneMenu;

import menu.LeMenuBar;
import modele.Tache;

import zone.I_SelectedListener;
import zone.ZoneDessin;
import zone.ZoneInfo;
import zone.ZoneMenu;
import zone.zoneButton;
import zone.zonePropriete;




public class Main_CTTE extends JFrame implements ComponentListener, WindowListener,I_NofityUpdate {
	
	
	private ZoneDessin zoneDessin;
	private JScrollPane scrollPaneZoneDessin;

	private JPanel zoneMenu;
	private JPanel zonePropriete;
	
	private JPanel zoneButton;
	private JScrollPane scrollPaneZoneButton;
	
	private JSplitPane spliter;
	private JPanel pane,panelError;

	private JTabbedPaneWithCloseIcons tabbedpane;
	private JTextPane textError;
	private JScrollPane scrollpaneTextError;

	private ControleurZoneDessin c_dessin = new ControleurZoneDessin(this);
	private ControleurzoneMenu  c_menu = new ControleurzoneMenu(this);
	private ControleurZoneButton c_button = new ControleurZoneButton(this);
	private ControleurPropriete c_propriete = new ControleurPropriete(this);
		
	public Main_CTTE(String name){
		super(name);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(700,500));
		setPreferredSize(getMinimumSize());
		setJMenuBar(new LeMenuBar(c_menu));	
	
		spliter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);		
		tabbedpane = new JTabbedPaneWithCloseIcons(JTabbedPane.BOTTOM);		
		scrollpaneTextError = new JScrollPane(textError = new JTextPane());
		textError.setEditable(false);
		scrollpaneTextError.setMinimumSize(new Dimension(this.getWidth(), 0));
		tabbedpane.addTab("Error",scrollpaneTextError,0);
		pane = new JPanel(new BorderLayout());
		pane.add(zoneMenu = new ZoneMenu(c_menu), BorderLayout.NORTH);
		scrollPaneZoneButton = new JScrollPane(getPanelButton(),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	  
		scrollPaneZoneButton.setPreferredSize(new Dimension(100,200));
		pane.add( scrollPaneZoneButton, BorderLayout.WEST);
		pane.add(getPanelPropriete(), BorderLayout.EAST);
		
		zoneDessin = new ZoneDessin(c_dessin);
		scrollPaneZoneDessin = new JScrollPane(zoneDessin, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPaneZoneDessin, BorderLayout.CENTER);
		pane.setMinimumSize(new Dimension(this.getWidth(), 0));
		pane.setPreferredSize(new Dimension(this.getWidth(), (this.getHeight()*2) / 3));
		
		spliter.setTopComponent(pane);
		spliter.setBottomComponent(tabbedpane);
				
		add(spliter, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		addComponentListener(this);	
		update();
	}
	
	
	private JPanel getPanelPropriete(){
		 JPanel pane = new JPanel (new FlowLayout(FlowLayout.CENTER));
		 pane.setPreferredSize(new Dimension(200,200));
		 pane.add(zonePropriete  = new zonePropriete(c_propriete));		 
		 return pane;
	}
	
	
	private JPanel getPanelButton(){		
		JPanel pane = new JPanel (new FlowLayout(FlowLayout.CENTER));
		 pane.setMinimumSize(new Dimension(200,200));
		 pane.add(zoneButton = new zoneButton(c_button));		 
		 return pane;		
	}
	
	
	public void createNewZoneDessin(){
		zoneDessin.removeAll();
		repaint();
	}
	
	public void addSelectedListener(I_SelectedListener listener){
		zoneDessin.addSelectedListener(listener);
	}
	
	
	public static void main(String[] args) {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { System.out.println(e.getMessage());	}		
		SwingUtilities.invokeLater( new Runnable(){
			public void run() {( new Main_CTTE("PROJET IHM")).setVisible(true);}			
		});		
	}


	/**
	 * 
	 * @param zoom
	 */
	public void zoom(double zoom){
		zoneDessin.zoom(zoom);
		repaint();
	}
	
	
	
	public void ouvrirDessin(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean saveDessin(String path){
		try {
			File file = null; 
			JFileChooser fc = new JFileChooser (); 
			fc.setCurrentDirectory (new File (".")); 
		//	fc.setFileFilter (fJavaFilter);
			//fc.setSelectedFile (fFile); 
			// Open chooser dialog 
			int result = fc.showSaveDialog (this); 
			if (result == JFileChooser.CANCEL_OPTION) { 
			return true; 
			} else if (result == JFileChooser.APPROVE_OPTION) { 			
				Helper.saveDessin(zoneDessin, new File(path));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	
	
	public boolean savePanelDessin(String path){
		try {
			File file = null; 
			JFileChooser fc = new JFileChooser (); 
			fc.setCurrentDirectory (new File (".")); 
		//	fc.setFileFilter (fJavaFilter);
			//fc.setSelectedFile (fFile); 
			// Open chooser dialog 
			int result = fc.showSaveDialog (this); 
			if (result == JFileChooser.CANCEL_OPTION) { 
			return true; 
			} else if (result == JFileChooser.APPROVE_OPTION) { 
			  File fFile = fc.getSelectedFile ();			
				Helper.saveObject(zoneDessin, new FileOutputStream(/*new File(path)*/fFile));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			
		}
		return true;
	}
	
	
	
	/**
	 * 
	 * @param t
	 */
	public void ajoutUneTache(Tache t){
		try {
			zoneDessin.ajouterTache(t);
			repaint();
		} catch (Exception e) {
			try {
				ErrorHelper.showError(textError, e);
			} catch (BadLocationException e1) {	
				System.out.println(e1.getMessage());
			} System.out.println(e.getMessage());

		}	
	}
	
	/**
	 * 
	 * 
	 */
	public void deleteSelectedTache(){
		try {
			zoneDessin.deleteSelectedTache();
			repaint();			
		} catch (Exception e) {
			try {
				ErrorHelper.showError(textError, e);
			} catch (BadLocationException e1) {	
				System.out.println(e1.getMessage());
			}System.out.println(e.getMessage());
		}
	}


	@Override
	public void componentHidden(ComponentEvent arg0) { }
	@Override
	public void componentMoved(ComponentEvent arg0) { }
	@Override
	public void componentShown(ComponentEvent arg0) { }
	@Override
	public void componentResized(ComponentEvent arg0) {
		repaint();
	    spliter.setDividerLocation(spliter.getHeight() - 80);
        repaint();		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		((I_UpdateListener)zonePropriete).UpdateListener();
	}

}
