package panel.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import zone.ZoneDessin;

import controleur.ControleurZoneDessin;


public class PopMenuTache extends JPopupMenu implements ActionListener {
	
	private JMenuItem[] items;
	private ControleurZoneDessin controleur;
	private ZoneDessin c;
	
	public PopMenuTache(ZoneDessin c , int x, int y,ControleurZoneDessin controleur){
		super();
		this.controleur = controleur;
		this.c = c;
		items = new JMenuItem[5];
		items[0] = new JMenuItem("Copier");
		this.add(items[0]);
		items[1] = new JMenuItem("Couper");
		this.add(items[1]);
		items[2] = new JMenuItem("Coller");
		this.add(items[2]);
		this.add( new JSeparator());		
		items[3] = new JMenuItem("Voir propriétés");
		this.add(items[3]);
		items[4] = new JMenuItem("Supprimer cette tâche");
		items[4].setActionCommand("supprimer");
		items[4].addActionListener(this);
		this.add(items[4]);
		this.show(c,x,y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("supprimer")){
			controleur.deleteTache();			
		}
		// TODO Auto-generated method stub
		
	}

}
