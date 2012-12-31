package scstool.gui.comp;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Button Panel fuer ein Tab
 * 
 * @author haeff
 * 
 */
public class ButtonPane extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	// Pfad im Project
	private final static String ICONPATH01 = "/arrow_right.png";
	private final static String ICONPATH02 = "/arrow_left.png";
	
	//ist eines der beiden negativ wird das Seitenverhältnis beibehalten
	private int icon_width = 40;
	private int icon_height = -1;
	
	//Variante des Buttonpanel. 
	//1 => nur Button links
	//2 => nur Button rechts
	//3 => Button links und rechts
	private int variant;
	
	private JButton bnt_right;
	private JButton bnt_left;
	
	
	public ButtonPane(int var) 
	{
		variant = var;
		init();
		
	}
	
	
	private void init()
	{
		
		setLayout(new BorderLayout());
		
		ImageIcon icon = getButtonIcon(ICONPATH01);
		
		bnt_right = new JButton("",icon);
		bnt_right.setActionCommand("R");
		
		icon = getButtonIcon(ICONPATH02);
		bnt_left = new JButton("",icon);
		bnt_left.setActionCommand("L");
		
		switch(variant)
		{
			case 1:
				add(bnt_left, BorderLayout.LINE_START);
				break;
			case 2:
				add(bnt_right, BorderLayout.LINE_END);
				break;
			case 3:
				add(bnt_left, BorderLayout.LINE_START);
				add(bnt_right, BorderLayout.LINE_END);
				break;		
		}
		
	}
	
	/**
	 * skaliert ein Icon auf den angegebenen Wert.
	 * 
	 * @param path: pfad des icons im Project
	 * @return : neu skaliertes Icon
	 */
	public ImageIcon getButtonIcon(String path)
	{
		ImageIcon icon = new ImageIcon( getClass().getResource(path));
		
		//neu skalieren
		return new ImageIcon( icon.getImage().getScaledInstance(icon_width, icon_height, Image.SCALE_SMOOTH));	
	}
	
	public void addButtonListener(ActionListener l)
	{
		bnt_right.addActionListener(l);
		bnt_left.addActionListener(l);
	}
	
}
