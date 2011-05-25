package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Helper {
	

	public static void saveObject(Object obj, FileOutputStream monFichier)throws Exception {
		ObjectOutputStream serial = new ObjectOutputStream(monFichier);
		serial.writeObject(obj);
		serial.flush();
		serial.close();
	}
	
	public static Object getObject(FileInputStream monFichier) throws Exception {
		ObjectInputStream serial = new ObjectInputStream(monFichier);
		Object obj = serial.readObject() ;
		serial.close();
		return obj;
	}
	
	
	
	
	public static void saveDessin(JPanel p, File fichier,int tailleEnX, int tailleEnY)throws IOException{
		BufferedImage tamponSauvegarde = new BufferedImage(tailleEnX, tailleEnY, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = tamponSauvegarde.getGraphics();
		//g.setColor(Color.WHITE);
		//g.fillRect(	0,	0, 	tailleEnX,	tailleEnY	);
		p.paint(g);
		ImageIO.write(tamponSauvegarde, "JPG", fichier);		
	}
	
	
	public static void saveDessin(JPanel p, File fichier)throws IOException{
		BufferedImage tamponSauvegarde = new BufferedImage(p.getSize().width, p.getSize().height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = tamponSauvegarde.getGraphics();
		//g.setColor(Color.WHITE);
		//g.fillRect(	0,	0, 	p.getWidth(), p.getHeight()	);
		p.paint(g);
		ImageIO.write(tamponSauvegarde, "JPG", fichier);		
	}



}
