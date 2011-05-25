package menu;

import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controleur.ControleurzoneMenu;


public class LeMenuBar extends JMenuBar
{	
	private ControleurzoneMenu controleur;
	
	public LeMenuBar(ControleurzoneMenu controleur)
	{
		super();
		this.controleur = controleur;
		add(new MenuProjet(" Projet ",controleur));
		add(new MenuEdition("Edition",controleur));
		add(new MenuTache(" Tâche ",controleur));
		add(new MenuAffichage("Affichage"/*,controleur*/));
		add(new MenuZoom ("Zoom"/*,controleur */));
		add(new MenuAide("Aide ?"));		
	}

}
