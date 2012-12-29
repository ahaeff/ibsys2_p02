package scstool.gui.tab;

import java.awt.Color;
import java.awt.Font;
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

import scstool.gui.comp.CustLabel;
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

	GridBagConstraints gc = new GridBagConstraints();
	
	
	public ProdProgrammTab()
	{
		
		init();
	}
	
	private void init()
	{
		
		gc.insets = new Insets(10, 10, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor  = GridBagConstraints.NORTH;
		//gc.ipadx = 10;
		gc.gridy = 0;
		gc.gridx = 0;
		
		setLayout(new GridBagLayout());
		
		prog = Repository.getInstance().getProdProg();
		
		
		
		addTitelPane("Verkaufswunsch und Prognosen eingeben");
		addComponents();
	}
	
	private void addTitelPane(String txt)
	{
		int fontsize = 30;
		String font ="Arial";
		int fontweight = Font.BOLD;
		
		JPanel pane = new JPanel();
		JLabel lbl = new JLabel(txt);
		
		Font font1 = new Font(font, fontweight, fontsize);
		lbl.setFont(font1);
		pane.add(lbl);
		gc.gridy = 0;
		add(pane,gc);
	}
	
	private void addComponents()
	{  	
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints c = new GridBagConstraints();
		ChangeListener l = new ChangeListener();
		c.insets = new Insets(10, 10, 0, 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 10;
		
		NTextField txt;
		
		//1. Zeile
		c.gridy = 0;
		c.gridx = 0;
		pane.add(new  CustLabel(""),c);
		
	
		c.gridx=1;
		pane.add(new  CustLabel("Aufträge"),c);
		
		c.gridx=2;
		pane.add(new  CustLabel("Prognose 1"),c);
		
		c.gridx=3;
		pane.add(new  CustLabel("Prognose 2"),c);
		
		c.gridx=4;
		pane.add(new  CustLabel("Prognose 3"),c);
		
		
		//2. Zeile
		c.gridy = 1;
		c.gridx = 0;
		pane.add(new  CustLabel("P1"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		//3. Zeile
		c.gridy = 2;
		c.gridx = 0;
		pane.add(new  CustLabel("P2"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		//4. Zeile
		c.gridy = 3;
		c.gridx = 0;
		pane.add(new  CustLabel("P3"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt.addActionListener(l);
		pane.add(txt,c);
		
		gc.gridy = 1;
		add(pane,gc);

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
