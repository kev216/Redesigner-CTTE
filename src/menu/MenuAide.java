package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import zone.ZoneInfo;

public class MenuAide extends JMenu implements ActionListener 
{
	/**
	 * Variables
	 */
	
	private JMenuItem maApropos;
	private JMenuItem maDescription;
	private ZoneInfo info ;
	
	/**
	 * Constructeur
	 * @param name
	 */
	public MenuAide (String name)
	{
		super(name);
		
		maApropos = new JMenuItem ("A propos de CTTE");
		maDescription = new JMenuItem ("Plus de details");
		
		add(maApropos);
		add( new JSeparator());
		add(maDescription);
				
		maApropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK));
		maApropos.setMnemonic('P');
		maDescription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.ALT_MASK));
		maDescription.setMnemonic('D');
		
		maApropos.addActionListener(this);
		maDescription.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == maApropos)
		{
			info = new ZoneInfo();
		}
		else if(source == maDescription)
		{
			
		}
	}

}
