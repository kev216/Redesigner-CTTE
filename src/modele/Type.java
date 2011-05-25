package modele;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Type implements Serializable {
	
	
	
	public enum TYPE{t_USER, t_ABSTRACT,t_MACHINE, t_INTERACTION};
	private TYPE type;
	
	
	private ImageIcon AbsIcon = new ImageIcon(getClass().getResource("../images/abstraction.gif"));
	private ImageIcon UserIcon = new ImageIcon(getClass().getResource("../images/user.gif"));
	private ImageIcon IntIcon = new ImageIcon(getClass().getResource("../images/interaction.gif"));
	private ImageIcon MacIcon = new ImageIcon(getClass().getResource("../images/application.gif"));		
	
	public Type(TYPE type){		
		this.type = type;
		switch(type){
		case t_ABSTRACT:
			
			break;
		case t_INTERACTION:
			break;
			
		case t_MACHINE:
			
			break;
		case t_USER:
			
			break;
			default:
				break;
			
		}
	}
	
	
	public void setType(TYPE type){		
		this.type = type;
		switch(type){
		case t_ABSTRACT:
			
			break;
		case t_INTERACTION:
			break;
			
		case t_MACHINE:
			
			break;
		case t_USER:
			
			break;
			default:
				break;
			
		}
	}
	public ImageIcon getIconType(){
	  switch(type){
		case t_ABSTRACT:
			return AbsIcon;
		case t_INTERACTION:
			return IntIcon;			
		case t_MACHINE:
			return MacIcon;
		case t_USER:
			return UserIcon;
		default:
		    return null;			
	   }
	}

}
