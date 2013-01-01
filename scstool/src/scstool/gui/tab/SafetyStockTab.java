package scstool.gui.tab;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.gui.comp.TitlePane;



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

	private Map<NTextField, String> txtfields;
	private FocusListener changeListener;
	
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
	//Button Panel
	private ButtonPane bnt_pane;
	
	
	public SafetyStockTab()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		txtfields = new HashMap<NTextField,String>();
		
		buildNorth();
		buildSouth();
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
	
	/**
	 * Erzeugt den Teil des Contents der im Page_Start Bereich eingefuegt wird
	 */
	private void buildNorth()
	{
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		//Titel
		pane.add(new TitlePane("Sicherheitsbestand der Einzelnen E-Teile eingeben"));
		
		//Content
		pane.add(getProgComponents());
		
		add(pane,BorderLayout.PAGE_START);
		
	}
	
	
	/**
	 * Erzeugt den Teil des Contents der im Page_End Bereich eingefuegt wird
	 */
	private void buildSouth()
	{
		bnt_pane = new ButtonPane(1);
		
		add(bnt_pane,BorderLayout.PAGE_END);
	}
	
	private JPanel getProgComponents()
	{
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 10;
		
		c.gridy = 0;
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
		c.insets.top=50;
		c.gridwidth = 6;
		pane.add(new  CustLabel("Gemeinsam genutzte Teile"),c);
		
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
	public String getNTextFieldKey(NTextField txt)
	{
		return txtfields.get(txt);
	}
}
