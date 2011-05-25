package main;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

public class ErrorHelper {
	
	public static boolean showError(JTextPane textpane , Exception e) throws BadLocationException{
		textpane.getDocument().insertString(textpane.getDocument().getLength(),e.getMessage() + "\n", null);
		textpane.setCaretPosition(textpane.getDocument().getLength());
		return true;		
	}

}
