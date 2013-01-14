package scstool.gui.tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import scstool.gui.comp.ButtonPane;

public class LayoutExampleTab extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Button Panel
	private ButtonPane bnt_pane;
	private int bnt_var;
	
	public LayoutExampleTab(int bnt_var)
	{
		this.bnt_var = bnt_var;
		init();
	}
	
	private void init()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel pane;
		
		setBackground(Color.cyan);
		setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		
		
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridheight =1;
	    c.weightx= 1;
	    c.weighty= 1;

	    
	    //lbl = 	new JLabel("0.0");
	    //add(lbl,c);
	    c.gridheight =3;
	    c.weightx = 0.0;
	    c.weighty = 0.0;
	    pane = new JPanel();
	    pane.setBackground(Color.GREEN);
	    pane.setPreferredSize(new Dimension(100, 0));
	    
	    add(pane,c);
	    c.weightx= 1;
	    c.weighty= 1;
	    c.gridheight =1;
	    c.gridx = 1;
	    add(new JLabel("0.1"),c);
	    
	    c.gridx = 2;
	    add(new JLabel("0.2"),c);
	    
	    c.gridx = 0;
	    c.gridy = 1;
	    //add(new JLabel("1.0"),c);
	    
	    c.gridx = 1;
	    //add(new JLabel("1.1"),c);
	    pane = new JPanel();
	    pane.setBackground(Color.RED);
	    add(pane,c);
	    
	    c.gridx = 2;
	    add(new JLabel("1.2"),c);
	    
	    
	    //add(new JLabel("2.0"),c);
	    c.gridy = 2;
	    c.gridx = 1;
	    c.gridwidth = 2;
	    c.weightx = 2;

	    pane = new JPanel();
	    pane.setBackground(Color.BLUE);
	    add(pane,c);
	    
	    //c.gridx = 2;
	    //add(new JLabel("2.2"),c);	    
	}
	    
}
