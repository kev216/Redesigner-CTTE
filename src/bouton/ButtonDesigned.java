package bouton;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonDesigned extends JButton implements MouseListener {
	
	public ButtonDesigned(String name){
		super(name);
		addMouseListener(this);		
		setSize(new Dimension(20,20));
	}
	
	public ButtonDesigned(ImageIcon icon){
		super(icon);
		addMouseListener(this);		
		setSize(new Dimension(20,20));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		//Cursor.		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
