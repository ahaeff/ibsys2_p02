package scstool.gui.comp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import scstool.utils.Repository;

public class OvertimePane extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Radiobuttons
	JRadioButton rbnt01;
	JRadioButton rbnt02;


	
	
	public OvertimePane()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new GridBagLayout());
		buildOvertimeSetting();
	}
	
	private void buildOvertimeSetting()
	{
		ButtonGroup grp = new ButtonGroup();
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(5, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx =1.0;
		c.gridy = 0;
		c.gridx = 0;
		
		this.rbnt01 = new JRadioButton("erlaubt");
		this.rbnt01.setActionCommand("true");
		this.rbnt01.setSelected(true);
		this.rbnt01.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt01);
		add(this.rbnt01,c);
		
		c.gridy = 1;
		c.gridx = 0;
		this.rbnt02 = new JRadioButton("nicht erlaubt");
		this.rbnt02.setActionCommand("false");
		this.rbnt02.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt02);
		add(this.rbnt02,c);
	}
	private class RadioButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Repository repo = Repository.getInstance();
			switch(e.getActionCommand())
			{
				case "true":
					repo.setOvertime(true);
					break;
				case "false":
					repo.setOvertime(false);
					break;
			}
			
		}
	}
}
