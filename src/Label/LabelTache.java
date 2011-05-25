package Label;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Tache;

public class LabelTache extends JLabel {
	
	private Point position;
	private Tache tache;
	private LabelTache parent;
	private ArrayList<LabelTache> fils;
	
	public LabelTache(String name,Tache tache,LabelTache parent){
		super( tache.getImageIcon());
		this.tache = tache;
		this.parent = parent;
		tache.setNom(name);
		fils = new ArrayList<LabelTache>();
	}
	
	
	
	public LabelTache(Tache tache,LabelTache parent){
		super( tache.getImageIcon());
		this.tache = tache;
		this.parent = parent;
		fils = new ArrayList<LabelTache>();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));		
	}
	
	
	
	public ArrayList<LabelTache> getFils(){
		return fils;
	}
	
	
	public int getNbFils(){
		return fils.size();
	}
	
	public void addFils(LabelTache t_fils){
		fils.add(t_fils);
		t_fils.setParent(this);
	}
	
	
	public void setParent(LabelTache parent){
		this.parent = parent;
	}
	
	
	
	public void removeFils(LabelTache t_fils){
		fils.remove(t_fils);
		t_fils.setParent(null);
	}
	
	
	
	public void setPosition(Point p){
		position = p; 
		this.setLocation(position);
	}

	
	
	public void isSelected(boolean value){
		if(value) {
			setBorder(BorderFactory.createLineBorder(Color.PINK,2));
		}else {
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
	}
	
	
	
	public Point getPosistion(){
		return position;
	}
	
	
	
	public Tache getTache(){
		return this.tache;
	}
	
	
	public void delete(){
		if(parent != null )parent.removeFils(this);
		while( 0 < fils.size())
			fils.remove(0);		
	}
	
	
	public void setTache(Tache tache){
		this.tache = tache;
	}
	
}
