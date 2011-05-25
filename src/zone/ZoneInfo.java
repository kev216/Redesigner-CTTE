package zone;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ZoneInfo extends JFrame{
	private JLabel nom = new JLabel();
	private JTextArea resumé;
	private JScrollPane scrollResume;
	private JButton ok;
	//private JButton annuler;
	private  JPanel panelInfo = new JPanel();
	private  JPanel panelBouton = new JPanel(); 
	private JPanel panelTitre = new JPanel();
	 JLabel titre2;
	  
	public ZoneInfo(){
		   this.setTitle("Comment utiliser CTTE");
		   this.setSize(500,600);
		  //this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		   this.setLocation(150, 50);
		   this.setVisible(true);
		   this.setResizable(false);
		   
		   
		   nom.setText(" Lisez le texte suivant pour savoir comment vous servir de cet outil.");
		   titre2 = new JLabel(" Vous pourrez retrouvez cette fenêtre dans le menu Aide. ");
		   nom.setFont(new Font("sansserif", Font.BOLD, 12));
		   titre2.setFont(new Font("sansserif", Font.BOLD, 12));
		
		   resumé = new JTextArea(3,4);
		   resumé.setText("RESUME [COMMENT UTILISER CTTE]");
		   scrollResume =  new JScrollPane(resumé);
		
		  ok = new JButton("OK");
		  ok.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		  panelBouton.setLayout(new BorderLayout() );
		 panelBouton.add(ok,BorderLayout.CENTER);
		 // panelBouton.add(annuler);
		  panelTitre.setLayout(new BorderLayout());
		   panelTitre.add(nom,BorderLayout.NORTH);
		   panelTitre.add(titre2,BorderLayout.SOUTH);
			
		  panelInfo.setLayout(new BorderLayout());
		  panelInfo.add(panelTitre,BorderLayout.NORTH);
		  panelInfo.add(panelBouton,BorderLayout.SOUTH);
		  panelInfo.add(scrollResume,BorderLayout.CENTER);
		  
		 add(panelInfo,BorderLayout.CENTER);
	}

}
