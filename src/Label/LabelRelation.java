package Label;

import javax.swing.JLabel;

import modele.Relation;

public class LabelRelation  extends JLabel{
	private LabelTache gauche;
	private LabelTache droite;
	
	private Relation r;
	
	public LabelRelation(Relation r , LabelTache g, LabelTache d){
		super();
		this.r = r;
		setIcon(r.getIcon());
		this.gauche = g;
		this.droite = d;
	}
	
	
	

}
