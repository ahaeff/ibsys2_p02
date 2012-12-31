package scstool.gui.comp;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFormattedTextField;


/**
 * @author haeff
 * 
 *	Eigene Textfield Klasse fuer Numerische Textfelder
 *
 */
public class NTextField extends JFormattedTextField
{
	
	private static final long serialVersionUID = 1L;
	
	//Textfeld
	private int width = 100;
	private int height = 30;
	private int maxChars = 4;
	//Schrift
	private int fontsize = 20;
	private String font ="Arial";
	private int fontweight = Font.BOLD;


	
	public NTextField() 
	{
	
		init();
	}
	
	private void init()
	{
		//beite und hoehe
		this.setPreferredSize(new Dimension(width, height));
		
		//Eingabe nur Numerisch 
		this.setDocument(new IntegerDocument(maxChars));
		
		//Schriftart,Groesse.. setzen
		Font font1 = new Font(font, fontweight, fontsize);
		this.setFont(font1);
		
		//Ausrichtung
		this.setHorizontalAlignment(RIGHT);
	}
	
}
