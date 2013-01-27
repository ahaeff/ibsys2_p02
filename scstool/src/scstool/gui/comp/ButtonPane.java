package scstool.gui.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scstool.gui.MainView;

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
	
	//ist eines der beiden negativ wird das Seitenverh�ltnis beibehalten
	private int icon_width = 40;
	private int icon_height = -1;
	
	//Variante des Buttonpanel. 
	//1 => nur Button links
	//2 => nur Button rechts
	//3 => Button links und rechts
	private int variant;
	private boolean export;
	
	private JButton bnt_right;
	private JButton bnt_left;
	private JButton bnt_left01;
	private JButton bnt_export;
	
	public ButtonPane(int var)
	{
		this(var,false);
	}
	public ButtonPane(int var,boolean exp) 
	{
		this.export = exp;
		this.variant = var;
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
		bnt_left01 = new JButton("",icon);
		bnt_left01.setActionCommand("START");
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(0, 375, 0, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.weightx =1.0;
		
		bnt_export = new JButton("Export");
		bnt_export.setPreferredSize(new Dimension(100, 50));
		bnt_export.setMinimumSize(this.getPreferredSize());	
		bnt_export.setActionCommand("EXP");
		bnt_export.setIcon(new ImageIcon(ButtonPane.class.getResource("/icon/ImportXMLFile-24.png")));
			
		pane.add(bnt_export,c);

		switch(variant)
		{
			case 1:
				add(bnt_left, BorderLayout.LINE_START);
				break;
			case 2:
				add(bnt_left01, BorderLayout.LINE_START);
				add(bnt_right, BorderLayout.LINE_END);
				break;
			case 3:
				add(bnt_left, BorderLayout.LINE_START);
				add(bnt_right, BorderLayout.LINE_END);
				break;		
		}
		if(export)
		{
			add(pane,BorderLayout.CENTER);
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
		bnt_left01.addActionListener(l);
		bnt_export.addActionListener(l);
	}
	
}
