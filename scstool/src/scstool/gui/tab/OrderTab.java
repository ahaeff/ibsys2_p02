package scstool.gui.tab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.obj.Order;
import scstool.proc.OrderService;

public class OrderTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

	private int bnt_var;
	private OrderService service;
	
	//Button Panel
	private ButtonPane bnt_pane;
	
	
	public OrderTab(int bnt_var)
	{
		this.bnt_var = bnt_var;
		init();
	}
	
	private void init()
	{
		service = new OrderService();
		List<Order> orders = service.ordering();
		buildGui();
	     
	}
	
	private void buildGui()
	{
		int rows = 3;
		int column = 3;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
	    c.gridheight =1;
	    c.weightx= 1;
	    c.weighty= 1;	
		
		//Platzhalter 1. Zeile
		c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = column;
	    c.weightx = 0.0;
	    c.weighty = 0.0;
	    add(getTopRow(),c);		
		
		//Platzhalter links
	    c.weightx= 0.0;
	    c.weighty= 0.0;
	    c.gridwidth = 1;    
	    c.gridx = 0;
	    c.gridy = 1;
		add(getLeft(),c);
		
		//Content mitte
	    c.weightx= 1.0;
	    c.weighty= 1.0;
		c.gridx = 1;
	    c.gridy = 1;
	    c.fill = GridBagConstraints.NONE;
	    c.anchor = GridBagConstraints.NORTHWEST;
	    add(getContent(),c);
		
	    //Platzhalter rechts
	    c.fill = GridBagConstraints.BOTH;
	    c.weightx= 0.0;
	    c.weighty= 0.0;
		c.gridx = 2;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
		add(getRight(),c);
		
		//Letzte Zeile
		c.gridx = 0;
		c.gridy = rows-1;
	    c.gridwidth = column;
	    c.weightx = 0.0;
	    c.weighty = 0.0;
	    bnt_pane = new ButtonPane(this.bnt_var);
	    add(bnt_pane,c);
		//add(getBottomRow(),c);
		
	}
	
	/**
	 * Erstellt den Inhalt des Platzhalters ersten Zeile
	 * 
	 * @return
	 */
	private JPanel getTopRow()
	{
		int width = 0;
		int height = 50;
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width,height));
		
		//fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());
		
		return pane;
	}
	
	/**
	 * Erstellt den Inhalt des Platzhalters letzte Zeile
	 * 
	 * @return
	 */
/*	private JPanel getBottomRow()
	{
		int width = 0;
		int height = 50;
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width,height));
		
		//fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());
		
		return pane;
		
	}*/
	
	/**
	 * Erstellt den Inhalt des Platzhalters links vom Content
	 * 
	 * @return
	 */
	private JPanel getLeft()
	{
		int width = 100;
		int height = 0;
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width,height));

		//fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());
		
		return pane;
	}
	
	/**
	 * Erstellt den Inhalt des Platzhalters rechts vom Content
	 * 
	 * @return
	 */
	private JPanel getRight()
	{
		int width = 100;
		int height = 0;
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width,height));
		
		//fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());
		
		return pane;
	}	
	/**
	 * Erstellt den Inhalt des Content
	 * 
	 * @return
	 */
	private JPanel getContent()
	{

		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
				
		GridBagConstraints c = new GridBagConstraints();
		NTextField ntxt;
		JTextField txt;
		
		c.insets = new Insets(10, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx =1.0;
		c.gridy = 0;
		c.gridx = 0;
		pane.add(new  CustLabel("Artikel"),c);
		
		c.gridy = 0;
		c.gridx = 1;
		pane.add(new  CustLabel("Menge"),c);
		
		c.gridy = 0;
		c.gridx = 2;		
		pane.add(new  CustLabel("Modus"),c);
		
		c.gridy = 1;
		c.gridx = 0;
		txt = new JTextField();
		txt.setText("55");
		txt.setEditable(false);
		pane.add(txt,c);
		
		c.gridy = 1;
		c.gridx = 1;
		txt = new JTextField();
		txt.setText("2000");
		txt.setEditable(false);
		pane.add(txt,c);
		
		c.gridy = 1;
		c.gridx = 2;
		txt = new JTextField();
		txt.setText("Normal");
		txt.setEditable(false);
		pane.add(txt,c);
		
		c.gridy = 2;
		c.gridx = 0;
		txt = new JTextField();
		txt.setText("56");
		txt.setEditable(false);
		pane.add(txt,c);
		
		c.gridy = 2;
		c.gridx = 1;
		txt = new JTextField();
		txt.setText("5000");
		txt.setEditable(false);
		pane.add(txt,c);
		
		c.gridy = 2;
		c.gridx = 2;
		txt = new JTextField();
		txt.setText("Eil");
		txt.setEditable(false);
		pane.add(txt,c);
		
		return pane;
	}
	
	
	/**
	 * Gibt den Buttonlistener an das ButtonPanel weiter
	 * @param l: Actionlistener
	 */
	public void addButtonListener(ActionListener l)
	{
		bnt_pane.addButtonListener(l);
	}
}
