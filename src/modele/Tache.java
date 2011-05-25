package modele;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Tache implements Serializable {
	
	private String name;
	private String typ;
	private String idetext;
	private String categorie;
	private String frequence;
	private boolean pda = false;
	private boolean desktop = false;
	private boolean mobile = false;
	private boolean vocal = false;
	private String ptext;
	private boolean iterative;
	private boolean optionnel = false;
	private boolean parttach = false;
	private String obstext;
	private String[] platformPlusAjt = new String[1]; //new JList(l);
	private String[] platformPlusAct = new String[1]; //new JList(l);;
	
	
private Type typeTache;
	
	
	
	public Tache(String name){
		this.name = name; 
	}
	
	public Tache(String name,Type typeTache){
		this.name = name;
		this.typeTache = typeTache;
	}
	
	
	public ImageIcon getImageIcon(){
		return typeTache.getIconType();
	}
	
	
 //****************************************************************************//
	public String  getObservation(){
		return obstext; 
	}
	
	public void setObservation(String newText){
		obstext = newText; 
	}

 //****************************************************************************//
	public String  getPrecondition(){
		return ptext; 
	}
	
	public void setPrecondition(String newText){
		ptext = newText; 
	}
	
	
 //****************************************************************************//
	public String  getNom(){
		return name; 
	}
	
	public void setNom(String newText){
		name = newText; 
	}

 //****************************************************************************//
	public String  getType(){
		return typ; 
	}
	
	public void setType(String newText){
		typ = newText; 
	}
	
 //****************************************************************************//
	public String  getIdentifiant(){
		return idetext; 
	}
	
	public void setIdentifiant(String newText){
		idetext = newText; 
	}
	

	 //****************************************************************************//
		public String  getCategorie(){
			return categorie; 
		}
		
		public void setCategorie(String newText){
			categorie = newText; 
		}
				
 //****************************************************************************//
		public String  getFrequence(){
		return 	frequence; 
	}
		
	public void setFrequence(String newText){
		frequence = newText; 
	}
		

 //****************************************************************************//
	public boolean  getPDA(){
		return pda; 
	}

	public void setPDA(boolean newBool){
		pda = newBool; 
	}
			
 //****************************************************************************//
	public boolean  getDesktop(){
		return desktop; 
	}
			
	public void setDesktop(boolean newBool){
		desktop = newBool; 
	}
			
	
	 //****************************************************************************//
		public boolean  getIterative(){
			return 	iterative; 
		}
			
		public void setIterative(boolean newBool){
			iterative = newBool; 
		}
			

	 //****************************************************************************//
		public boolean  getVocal(){
			return vocal; 
		}

		public void setVocal(boolean newBool){
			vocal = newBool; 
		}
				
 //****************************************************************************//
	public boolean  getMobile(){
		return mobile; 
	}
				
	public void setMobile(boolean newBool){
		mobile = newBool; 
	}
				
	 //****************************************************************************//
	public boolean  getPartTach(){
		return parttach; 
	}

	public void setPartTach(boolean newBool){
		parttach = newBool; 
	}
			
//****************************************************************************//
	public boolean  getOptionnel(){
		return optionnel; 
	}
			
	public void setOptionnel(boolean newBool){
		optionnel = newBool; 
	}		
	
	
 //****************************************************************************//
	public String[]  getPlatFormPlusAjout(){
		return platformPlusAjt; 
	}
			
	public void setplatformPlusAjout(String[] plt){
		if(plt != null)
		platformPlusAjt = plt; 
	}		
	
	public boolean isListAjtModif(String[] list){
		boolean modif =false;
		for(int i = 0; i < list.length; i++){
			modif = true;
			for(int j = 0; j < platformPlusAct.length; j++){
				if(platformPlusAct[i].equals(list[j])){modif = false;}
			}
			if(modif == true) return modif;
		}
		 return modif;
	}
	
 //****************************************************************************//
	public String[]  getPlatFormPlusActif(){
		return platformPlusAct; 
	}
				
	public void setplatformPlusActif(String[] plt){
		try {
			if(plt != null)
			platformPlusAct = plt;
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}		
	
	public boolean isListActModif(String[] list){
		boolean modif =false;
		for(int i = 0; i < list.length; i++){
			modif = true;
			for(int j = 0; j < platformPlusAct.length; j++){
				if(platformPlusAct[i].equals(list[j])){modif = false;}
			}
			if(modif == true) return modif;
		}
		 return modif;
	}

	
	
	
	
}
