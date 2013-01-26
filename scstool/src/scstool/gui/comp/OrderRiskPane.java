package scstool.gui.comp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import scstool.utils.Repository;



public class OrderRiskPane extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//Radiobuttons
	JRadioButton rbnt01;
	JRadioButton rbnt02;
	JRadioButton rbnt03;
	JRadioButton rbnt04;
	
	NTextField txtPercent;
	
	
	public OrderRiskPane()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new GridBagLayout());
		buildRiskSetting();
	}
	private void buildRiskSetting()
	{
		
		ButtonGroup grp = new ButtonGroup();
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(5, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx =1.0;
		c.gridy = 0;
		c.gridx = 0;
		
				
		this.rbnt01 = new JRadioButton("risikoavers");
		this.rbnt01.setActionCommand("ra");
		this.rbnt01.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt01);
		add(this.rbnt01,c);
		
		c.gridy = 1;
		c.gridx = 0;
		this.rbnt02 = new JRadioButton("neutral");
		this.rbnt02.setActionCommand("n");
		this.rbnt02.setSelected(true);
		Repository.getInstance().setRiskPercente(50);
		this.rbnt02.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt02);
		add(this.rbnt02,c);
		
		c.gridy = 2;
		c.gridx = 0;
		this.rbnt03 = new JRadioButton("risikofreudig");
		this.rbnt03.setActionCommand("rf");
		this.rbnt03.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt03);
		add(this.rbnt03,c);

		
		c.gridy = 3;
		c.gridx = 0;
		this.rbnt04 = new JRadioButton("benutzerdefiniert");
		this.rbnt04.setActionCommand("b");
		this.rbnt04.addActionListener(new RadioButtonListener());
		grp.add(this.rbnt04);
		add(this.rbnt04,c);
		
		
		c.gridy = 3;
		c.gridx = 1;
		this.txtPercent = new NTextField();
		this.txtPercent.setEnabled(false);
		this.txtPercent.setText("50");
		this.txtPercent.addFocusListener(new RiskChangeListener());
		add(this.txtPercent,c);
		
		c.gridy = 3;
		c.gridx = 2;
		JLabel lbl = new JLabel("%");
		add(lbl,c);
		
	}
	
	private class RadioButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Repository repo = Repository.getInstance();
			switch(e.getActionCommand())
			{
				case "ra":
					txtPercent.setText("100");
					txtPercent.setEnabled(false);
					repo.setRiskPercente(100);
					break;
				case "n":
					txtPercent.setText("50");
					txtPercent.setEnabled(false);
					repo.setRiskPercente(50);
					break;
				case "rf":
					txtPercent.setText("0");
					txtPercent.setEnabled(false);
					repo.setRiskPercente(0);
					break;
				case "b":
					txtPercent.setText("");
					txtPercent.setEnabled(true);
					break;
			}
            validate();
            repaint();
			
		}
	}
	class RiskChangeListener implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent e) {
			//not used
			
		}

		@Override
		public void focusLost(FocusEvent e) 
		{
			if(e.getSource() instanceof NTextField)
			{
				NTextField txt = (NTextField) e.getSource();
				if(txt.getText().matches("[0-9]+"))
				{
					int value = Integer.parseInt(txt.getText());
					Repository.getInstance().setRiskPercente(value);
				}
			}
			
			
		}
		
	}
}
