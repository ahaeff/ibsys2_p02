package scstool.gui.tab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.utils.Repository;




/**
 * Eingabe des Sicherheitsbestands
 * @author haeff
 *
 */
/**
 * @author haeff
 *
 */
public class SafetyStockTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

	private int bnt_var;
	
	private Map<NTextField, String> txtfields;
	private FocusListener changeListener;
	
	
	//Button Panel
	private ButtonPane bnt_pane;
	
	
	private static 	String[] matnr = {
		"P1",
		"P2",
		"P3",
		"E51",
		"E56",
		"E31",
		"E50",
		"E55",
		"E30",
		"E4",
		"E5",
		"E6",
		"E10",
		"E11",
		"E12",
		"E49",
		"E54",
		"E29",
		"E7",
		"E8",
		"E9",
		"E13",
		"E14",
		"E15",
		"E18",
		"E19",
		"E20"
	};
	
	private static 	String[] matnr_all = {
		"E26",
		"E16",
		"E17"
	};

	
	
	public SafetyStockTab(int bnt_var)
	{
		this.bnt_var = bnt_var;
		init();
	}
	
	private void init()
	{
		txtfields = new HashMap<NTextField,String>();
		
		buildGui();
		
		
		setTestData();
	}
	
	
	/**
	 * Gibt den Buttonlistener an das ButtonPanel weiter
	 * @param l: Actionlistener
	 */
	public void addButtonListener(ActionListener l)
	{
		bnt_pane.addButtonListener(l);
	}
	
	/**
	 * Registiert den Foculistener bei den Textfeldern
	 * @param l: Focuslistener
	 */
	public void addChangeListener(FocusListener l)
	{
		this.changeListener = l;
		registerChangeListener();
	}
	
	/**
	 * Alle textfelder erhlaten einen Actionlistener
	 */
	private void registerChangeListener()
	{
		if(this.changeListener != null)
		{
			for(NTextField key : txtfields.keySet())
			{
				key.addFocusListener(this.changeListener);
			}
		}
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
			
		NTextField txt;
		
		for(int i = 0; i<matnr.length;i++)
		{
			c.insets.left = 50;
			pane.add(new  CustLabel(matnr[i]),c);
			
			c.insets.left = 5;
			c.gridx++;
			txt = new NTextField();
			txtfields.put(txt,matnr[i]);
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
		Border border = BorderFactory.createMatteBorder(0,0,5,0,Color.BLACK);
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
			pane.add(new  CustLabel(matnr_all[i]),c);
			
			c.insets.left = 5;
			c.gridx++;
			txt = new NTextField();
			txtfields.put(txt,matnr_all[i]);
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

	private void setTestData()
	{
		Repository repo = Repository.getInstance();
		int value = 100;
		
		
		for(Map.Entry<NTextField,String> e :txtfields.entrySet())
		{
			e.getKey().setText(String.valueOf(value)); 
			
			String str = e.getValue().substring(1);
			int matnr = Integer.parseInt(str);
			
			repo.setSafetyStock(matnr, value);
		}
		
		
	}
	
	
	public String getNTextFieldKey(NTextField txt)
	{
		return txtfields.get(txt);
	}
}
