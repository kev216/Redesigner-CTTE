package modele;

import java.io.Serializable;

import javax.swing.ImageIcon;


public class Relation implements Serializable {
	protected ImageIcon icon;
	protected boolean isUnaire;
	
	public Relation( ImageIcon icon, boolean isUnaire){
		this.icon = icon;
		this.isUnaire = isUnaire;
	}
	
	public boolean isUnaire () {
		return isUnaire;
	}
	
	public ImageIcon getIcon(){
		return icon;
	}

}
