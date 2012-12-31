package scstool.gui.comp;

import java.awt.Font;

import javax.swing.JLabel;

public class CustLabel extends JLabel
{
	

	private static final long serialVersionUID = 1L;
	
	//Schrift
	private int fontsize = 15;
	private String font ="Arial";
	private int fontweight = Font.BOLD;
	

	public CustLabel(String s) 
	{
		
		super(s);
		init();
	}
	
	private void init()
	{	
		Font font1 = new Font(font, fontweight, fontsize);
		setFont(font1);
		
	}
}
