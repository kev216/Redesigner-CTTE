package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import controleur.ControleurzoneMenu;

public class MenuTache extends JMenu implements ActionListener
{	
	/**
	 * Variables
	 */
	
	private ControleurzoneMenu controleur;
	private JMenuItem mtAjout;
	private JMenuItem mtModifier;
	private JMenuItem mtSuppr;
	private JMenuItem mtCreer;
	
	public MenuTache(String name, ControleurzoneMenu controleur)
	{
		super(name);
		
		this.controleur = controleur;
		mtAjout = new JMenuItem ("Ajouter");
		mtModifier = new JMenuItem ("Modifier");
		mtSuppr = new JMenuItem ("Supprimer");
		mtCreer = new JMenuItem ("Deplacer");
		
		add(mtAjout);
		add( new JSeparator());
		add(mtModifier);
		add( new JSeparator());
		add(mtSuppr);
		add( new JSeparator());
		add(mtCreer);
		
				
		mtAjout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_MASK));
		mtAjout.setMnemonic('A');
		mtModifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.ALT_MASK));
		mtModifier.setMnemonic('M');
		mtSuppr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.ALT_MASK));
		mtSuppr.setMnemonic('U');
		mtCreer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_MASK));
		mtCreer.setMnemonic('C');
		
		mtAjout.addActionListener(this);
		mtModifier.addActionListener(this);
		mtSuppr.addActionListener(this);
		mtCreer.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == mtAjout)
		{
			
		}
		else if(source == mtModifier)
		{
			
		}
		else if(source == mtSuppr)
		{
			
		}
		else if(source == mtSuppr)
		{
			
		}
	}

}
