package scstool.gui.comp;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * TitelPanel innerhalb des TabedPanel
 * 
 * @author haeff
 *
 */
public class TitlePane extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private String title;
	private JLabel lbl_title;
	
	//Schrift
	private int fontsize = 15;
	private String font ="Arial";
	private int fontweight = Font.BOLD;
	
	public TitlePane(String title) 
	{
		this.title = title;
		init();
	}
	
	private void init()
	{
		lbl_title = new JLabel(this.title);
		Font font1 = new Font(font, fontweight, fontsize);
		lbl_title.setFont(font1);
		add(lbl_title);
		
		//Abstand zwischen den Panels
		setBorder(new EmptyBorder(10, 0, 20, 0) );
	}
}
