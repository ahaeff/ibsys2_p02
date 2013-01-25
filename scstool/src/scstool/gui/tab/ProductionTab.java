package scstool.gui.tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;


import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.gui.comp.OrderRiskPane;
import scstool.gui.comp.OvertimePane;
import scstool.utils.Repository;

/**
 * 
 * Darstellung der Kapzitaet
 * 
 * @author haeff
 *
 */
public class ProductionTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

	private int bnt_var;
	
	//Button Panel
	private ButtonPane bnt_pane;
	
	
	//Risiko Einstellungen fuer Bestellungen
	private OrderRiskPane risk_pane;
	private Map<String, JTextField> txtfields;
	
	private static 	String[] matnr = {
		"1",
		"2",
		"3",
		"51",
		"56",
		"31",
		"50",
		"55",
		"30",
		"4",
		"5",
		"6",
		"10",
		"11",
		"12",
		"49",
		"54",
		"29",
		"7",
		"8",
		"9",
		"13",
		"14",
		"15",
		"18",
		"19",
		"20"
	};
	
	private static 	String[] matnr_all = {
		"26",
		"16",
		"17"
	};
	
	public ProductionTab(int bnt_var)
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
		
		c.insets = new Insets(10, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx =1.0;
	
		c.gridy = 0;
		c.gridx = 1;
		pane.add(new  CustLabel("Kinderfahrrad"),c);

		c.gridy = 0;
		c.gridx = 3;
		pane.add(new  CustLabel("Damenfahrrad"),c);
		
		c.gridy = 0;
		c.gridx = 5;
		pane.add(new  CustLabel("Herrenfahrrad"),c);
		
		
		c.gridy = 1;
		c.gridx = 0;
			
		JTextField txt;
		
		for(int i = 0; i<matnr.length;i++)
		{
			c.insets.left = 50;
			txt = new JTextField();
			txt.setEditable(false);
			txt.setText(matnr[i]);
			txt.setPreferredSize(new Dimension(30, 20));
			txt.setMinimumSize(txt.getPreferredSize());
			txtfields.put(matnr[i]+"_id",txt);
			pane.add(txt,c);
			
			c.insets.left = 5;
			c.gridx++;
			txt = new JTextField();
			txt.setEditable(false);
			txtfields.put(matnr[i]+"_amount",txt);
			pane.add(txt,c);
			c.gridx++;
			
			if(c.gridx==6)
			{
				c.gridx=0;
				c.gridy++;
			}
		}
		
		c.insets.top=20;
		c.insets.left = 50;
		c.gridwidth = 6;
		Border border = BorderFactory.createMatteBorder(0,0,5,0,Color.gray);
		JPanel line = new JPanel();
		line.setBorder(border);
		pane.add(line,c);
		
		c.gridy++;
		c.insets.top=10;
		
		pane.add(new  CustLabel("Gemeinsam genutzte Teile:"),c);
		
		c.insets.top=10;
		c.gridwidth = 1;
		c.gridy++;
		
		for(int i = 0; i<matnr_all.length;i++)
		{
			c.insets.left = 50;
			txt = new JTextField();
			txt.setEditable(false);
			txt.setText(matnr_all[i]);
			txt.setPreferredSize(new Dimension(30, 20));
			txt.setMinimumSize(txt.getPreferredSize());
			txtfields.put(matnr_all[i]+"_id",txt);
			pane.add(txt,c);
			
			c.insets.left = 5;
			c.gridx++;
			txt = new JTextField();
			txt.setEditable(false);
			txtfields.put(matnr_all[i]+"_amount",txt);
			pane.add(txt,c);
			c.gridx++;
			
			if(c.gridx==6)
			{
				c.gridx=0;
				c.gridy++;
			}
		}		
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
		Repository repo = Repository.getInstance();
		List<Integer[]> prod = repo.getProductionProgram();
		for(Integer[] mat : prod)
		{
			txtfields.get(mat[0] + "_amount").setText(mat[1].toString());
		}
	}
		
	
	
}
