package scstool.gui.tab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scstool.gui.comp.NTextField;
import scstool.obj.ProductionProg;
import scstool.utils.Repository;




/**
 * Eingabe des Produktionsprogramms, Prognosen und Direktverkaeufe
 * 
 * @author haeff
 *
 */
public class ProdProgrammTab extends JPanel 
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<ProductionProg> prog;

	
	
	public ProdProgrammTab()
	{
		
		init();
	}
	
	private void init()
	{
		
		
		
		prog = Repository.getInstance().getProdProg();
		setLayout(new GridBagLayout());
		addComponents();
	}
	
	private void addComponents()
	{  	
		GridBagConstraints c = new GridBagConstraints();
		ChangeListener l = new ChangeListener();
		c.insets = new Insets(10, 10, 0, 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 10;
		
		NTextField txt;
		
		//1. Zeile
		c.gridy = 0;
		c.gridx = 0;
		add(new  JLabel(""),c);
		
	
		c.gridx=1;
		add(new  JLabel("Aufträge"),c);
		
		c.gridx=2;
		add(new  JLabel("Prognose 1"),c);
		
		c.gridx=3;
		add(new  JLabel("Prognose 2"),c);
		
		c.gridx=4;
		add(new  JLabel("Prognose 3"),c);
		
		
		//2. Zeile
		c.gridy = 1;
		c.gridx = 0;
		add(new  JLabel("P1"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt.addActionListener(l);
		add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt.addActionListener(l);
		add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt.addActionListener(l);
		add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt.addActionListener(l);
		add(txt,c);
		
		
/*		for(int y=1;y<=3;y++)
		{
			c.gridy++;
			c.gridx=0;
			add(new JLabel("P"+y),c);
			for(int x=1; x<= 4;x++ )
			{
				c.gridx=x;
				add(t,c);
			}
		}*/
	}
	
	

	
	class ChangeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("tttttt");
			
		}
		
	}
}
