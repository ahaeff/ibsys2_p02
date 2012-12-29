package scstool.gui.comp;

import java.awt.Dimension;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class NTextField extends JFormattedTextField
{
	private int width = 100;
	private int height = 30;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NTextField() {
	
		init();
	}
	
	private void init()
	{
		//beite und hoehe
		this.setPreferredSize(new Dimension(width, height));
		
		//Eingabe auf 
		this.setDocument(new IntegerDocument());
	}
	
}
