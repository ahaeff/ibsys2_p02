package scstool.gui.tab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.proc.WarehouseService;

/**
 * 
 * Einstellung der Planung
 * 
 * @author haeff
 *
 */
public class OverviewTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

	private int bnt_var;
	
	//Button Panel
	private ButtonPane bnt_pane;
	private Map<String, JTextField> txtfields;
	
	
	public OverviewTab(int bnt_var)
	{
		this.bnt_var = bnt_var;
		init();
	}
	
	private void init()
	{
		txtfields = new HashMap<String, JTextField>(); 
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
	    bnt_pane = new ButtonPane(this.bnt_var,true);
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
		
		JTextField txt;
		
		c.insets = new Insets(10, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx =1.0;
		c.gridy = 0;
		c.gridx = 0;
		pane.add(new CustLabel("Übersicht"),c);
		
		c.gridy = 1;
		c.gridx = 0;
		pane.add(new JLabel("Lagerwert"),c);
		
		c.gridx=1;
		txt = new JTextField();
		txt.setEditable(false);
		txt.setPreferredSize(new Dimension(75, 20));
		txt.setMinimumSize(txt.getPreferredSize());
		txtfields.put("warehousestock", txt);
		pane.add(txt,c);
		

		c.gridy = 2;
		c.gridx = 0;
		pane.add(new JLabel("Gewinn(ohne Leerzeitkosten)"),c);
		
		c.gridx=1;
		txt = new JTextField();
		txt.setEditable(false);
		txt.setPreferredSize(new Dimension(75, 20));
		txt.setMinimumSize(txt.getPreferredSize());
		txtfields.put("profit", txt);
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
	
	public void refresh()
	{
		 WarehouseService service = new  WarehouseService();
		 DecimalFormat df = new DecimalFormat( "###,##0.00 \u00A4" );
		 
		 String warehousestock = df.format(service.getFutureWarehouseStock());
		 txtfields.get("warehousestock").setText(warehousestock);
		 String profit = df.format(service.getProfit());
		 txtfields.get("profit").setText(profit);
	}
}
