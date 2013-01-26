package scstool.gui.comp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import scstool.gui.MessageListenerIF;
import scstool.gui.StatusMessageEvent;

public class StatusPane extends JPanel implements MessageListenerIF 
{

	private static final long serialVersionUID = 1L;
	private int width = -1;
	private int height = 30;


	private JLabel message;
	
	public StatusPane()
	{
		init();
			
	}
	
	
	private void init()
	{
		this.setPreferredSize(new Dimension(width, height));
		//fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		this.setMinimumSize(this.getPreferredSize());
		Border border = BorderFactory.createMatteBorder(1,0,0,0,Color.gray);
		this.setLayout(new GridBagLayout());
	
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 15, 5, 5);
	    c.gridheight =1;
	    c.weightx= 1;
	    c.weighty= 1;
	    
		this.message = new JLabel("init");	
		this.add(message, c);
		this.setBorder(border);
	}
	
	public void setMessage(String m)
	{
		this.message.setText(m);
	}


	@Override
	public void setStatusMessage(StatusMessageEvent e) 
	{
		setMessage(e.getMsg());
		
	}
}
