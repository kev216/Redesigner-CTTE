package zone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import java.lang.Math;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import controleur.ControleurZoneDessin;
import panel.component.PopMenuTache;

import modele.Tache;


import Label.LabelTache;

public class ZoneDessin  extends JPanel implements Serializable, I_PublishSelected{
	private static final long serialVersionUID = 1L;
	
	enum STATE{UP,DRAG,CLICK,CREATE_BOUND};
	
	private ArrayList<I_SelectedListener> SelectedListeners;
	private ArrayList<LabelTache> list = new ArrayList<LabelTache>();;
	private LabelTache selected = null;
	private LabelTache selectedToDragg = null;
	private ControleurZoneDessin controleur;
	private ImplementeurMouseInputListener listener = new ImplementeurMouseInputListener();

	private Point p = null;
	private Point q = null;
	 
	
	
	private STATE state = STATE.UP;
	private double zoom = 1;
	
	public ZoneDessin(ControleurZoneDessin controleur){
		super();
		setLayout(null);
		SelectedListeners = new ArrayList<I_SelectedListener>();
		this.controleur = controleur;
		setPreferredSize(getMaximumSize()); 
		setBackground(Color.WHITE);		
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void setControleur(ControleurZoneDessin controleur){
		this.controleur = controleur;
	}
	
	public void ajouterTache(Tache tacheToAdd) throws Exception{
		 if(list.size() > 0 && selected == null)
			 throw new Exception("Vous n'avez pas selectionné le parent de la tache");
		 
		LabelTache label = new LabelTache("task",tacheToAdd,selected);			
		add(label);
		list.add(label);				

		if(selected != null ) {	
			int x = selected.getPosistion().x+(selected.getNbFils()*45)+1;
			int y = selected.getPosistion().y+60;
			selected.addFils(label);
			label.setPosition(new Point(x,y));
			label.setBounds(x, y, 30, 30);
		}else{
			int x = this.getParent().getWidth() / 2 ;
			int y = 10;
			label.setPosition(new Point(x,y));
			label.setBounds(x, y, 30, 30);
		}	
		repaint();
		validate();			
	}
	
	
	
	
	
	
	public void deleteSelectedTache()throws Exception {
		if(selected == null)
			throw new Exception("Aucune tache n'est selectionnée");	
		
		selected.delete(); 
		list.remove(selected);
		remove(selected);
		repaint();		
	}
	

	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g; 
		AffineTransform backup = g2.getTransform(); 
        g2.scale(zoom, zoom); 
        super.paint(g);
        g2.setTransform(backup); 
		try {
			for(int i = 0 ; list != null && i < list.size() ; i++){
				int xParent = (((LabelTache)list.get(i)).getPosistion().x);
				int widhtParent = ((LabelTache)list.get(i)).getWidth(); 
				int yParent = (((LabelTache)list.get(i)).getPosistion().y);
				int HeightParent = ((LabelTache)list.get(i)).getHeight();
		
				ArrayList<LabelTache> fils = ((LabelTache)list.get(i)).getFils();
				for(int j = 0 ; j < fils.size() ; j ++) {
					int xFils = (((LabelTache)fils.get(j)).getPosistion().x);
					int widhtF = ((LabelTache)fils.get(j)).getWidth();
					int yFils = (((LabelTache)fils.get(j)).getPosistion().y);
					int heightF = ((LabelTache)fils.get(j)).getHeight();
					creatLine(g2, xParent ,yParent ,widhtParent ,HeightParent, xFils ,yFils,widhtF,heightF );
				}
			}
		} catch (Exception e) {	System.out.println(e.getMessage());}
		
		if(p != null && q != null){
			g.drawRect(Math.min(p.x,q.x), Math.min(p.y,q.y), Math.abs(p.x-q.x), Math.abs(p.y-q.y));
		}
	}
	
	
	
	
	
	
	
	
	private void creatLine(Graphics2D g2, int xP, int yP, int widhtP, int heightP,
			                              int xF, int yF, int widhtF, int heightF){		
		int Xmin = (int)((2*(xP*zoom))+(widhtP*zoom)) /2;
		int Xmax = (int)((2*(xF*zoom))+(widhtF*zoom)) /2;		
		int Ymin = (int)((yP*zoom)+ (heightP*zoom)) ;
		int Ymax = (int) (yF*zoom);		
		g2.drawLine(Xmin, Ymin,Xmax,Ymax);
	}
	
	
	
	public void showMenuTache(int x, int y){
		new PopMenuTache(this,x,y, controleur);
	}
	
	
	
	public void zoom( double zoom){	
		this.zoom  = zoom;
		repaint();	
	}
	
	

	
	class ImplementeurMouseInputListener implements  MouseInputListener {
		@Override
		public synchronized void mouseClicked(MouseEvent e) {
			switch(state){
			case UP:
				if(selected != null)
					selected.isSelected(false);				
				validate();
				repaint();
				selected = null;
				int x = (int) (e.getX() / zoom) ;
				int y = (int) (e.getY() / zoom) ;
					
				Rectangle r;				
				for (int i = 0; i < list.size(); i++) {
					r = ((LabelTache) list.get(i)).getBounds();
					if (r.x < (int) x && (r.width + r.x) > (int) x &&
						r.y < (int) y && (r.height + r.y) > (int) y) {
							selected = list.get(i);
							selected.isSelected(true);
							validate();
							repaint();
							break;
					}
				}
				if (selected != null && (e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
					 showMenuTache(e.getX(), e.getY());
				}
				upDate(selected);	
				p = null;				
				break;
			case CLICK:				
				break;				
			case DRAG:			
				break;			
			case CREATE_BOUND:
				break;			
			default:
				break;			
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			switch(state){
			case UP:	
				p = e.getPoint();
				break;
			case CLICK:
				break;				
			case DRAG:			
				break;			
			case CREATE_BOUND:
				break;			
			default:
				break;			
			}
		}		
		@Override
		public void mouseMoved(MouseEvent e) { }
		@Override
		public synchronized void mouseReleased(MouseEvent e) {			
			switch(state){
			case UP:	
				p = e.getPoint();
				break;
			case CLICK:
				selectedToDragg = null;
				state = STATE.UP;
				break;				
			case DRAG:
				selectedToDragg = null;
				state = STATE.UP;			
				break;			
			case CREATE_BOUND:
				selectedToDragg = null;
				state = STATE.UP;
				break;			
			default:
				break;			
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {			
			Rectangle r;	

			int x = (int) (e.getX() / zoom) ;
			int y = (int) (e.getY() / zoom) ;
			
			switch(state){
			case UP:				
				if(selectedToDragg == null){
					for (int i = 0; i < list.size(); i++) {
						r = ((LabelTache) list.get(i)).getBounds();
						if (r.x < (int) x && (r.width + r.x) > (int) x
							&& r.y < (int) y && (r.height + r.y) > (int) y) {
							selectedToDragg = list.get(i);
							 break;
						}
					}
				}									
				if(selectedToDragg != null){
					selectedToDragg.setPosition(new Point(x,y));
					p = q = null;
					state = STATE.DRAG;
				}else {
					state = STATE.CREATE_BOUND;
				}				
				break;
			case CLICK:
				break;				
			case DRAG:
				if(selectedToDragg != null)
					selectedToDragg.setPosition(new Point(x,y));
				break;			
			case CREATE_BOUND:
				q = e.getPoint();				
				break;			
			default:
				break;			
			}			
			repaint();			
			// TODO Auto-generated method stub			
		}		
	}




	@Override
	public void addSelectedListener(I_SelectedListener listener) {
		SelectedListeners.add(listener);
	}
	@Override
	public void removeSelectedListener(I_SelectedListener listener) {
		SelectedListeners.remove(listener);
	}
	@Override
	public void upDate(Object o) {
		for(int i = 0 ; i < SelectedListeners.size() ; i++)
			SelectedListeners.get(i).notify(selected);
	}
	
	
	
}
