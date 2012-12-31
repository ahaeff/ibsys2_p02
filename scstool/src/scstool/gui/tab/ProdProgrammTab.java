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
 * Eingabe des Produktionsprogramms, Prognosen und Direktverkaeufe
 * 
 * @author haeff
 *
 */
public class ProdProgrammTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

		
	private Map<NTextField, String> txtfields;
	private FocusListener changeListener;
	
	private final static String P1_PREFIX = "1";
	private final static String P2_PREFIX = "2";
	private final static String P3_PREFIX = "3";
	
	private final static String PERIOD_0 = "_0";
	private final static String PERIOD_1 = "_1";
	private final static String PERIOD_2 = "_2";
	private final static String PERIOD_3 = "_3";
	
	//Button Panel
	private ButtonPane bnt_pane;
	
	public ProdProgrammTab()
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
		pane.add(new TitlePane("Verkaufswunsch und Prognosen eingeben"));
		
		//Content
		pane.add(getProgComponents());
		add(pane,BorderLayout.PAGE_START);
		
	}

	/**
	 * Erzeugt den Teil des Contents der im Page_End Bereich eingefuegt wird
	 */
	private void buildSouth()
	{
		bnt_pane = new ButtonPane(2);
		add(bnt_pane,BorderLayout.PAGE_END);
	}
	
	
	/**
	 * Erstellt ein Panel mit den Eingabefeldern fuer das Produktionsprogramm
	 */
	private JPanel getProgComponents()
	{  	
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		
		
		GridBagConstraints c = new GridBagConstraints();
		
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
		txtfields.put(txt,P1_PREFIX+PERIOD_0);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		
		txtfields.put(txt,P1_PREFIX+PERIOD_1);		
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt,P1_PREFIX+PERIOD_2);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt,P1_PREFIX+PERIOD_3);
		pane.add(txt,c);
		
		//3. Zeile
		c.gridy = 2;
		c.gridx = 0;
		pane.add(new  CustLabel("P2"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txtfields.put(txt,P2_PREFIX+PERIOD_0);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txtfields.put(txt,P2_PREFIX+PERIOD_1);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt,P2_PREFIX+PERIOD_2);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt,P2_PREFIX+PERIOD_3);
		pane.add(txt,c);
		
		//4. Zeile
		c.gridy = 3;
		c.gridx = 0;
		pane.add(new  CustLabel("P3"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txtfields.put(txt,P3_PREFIX+PERIOD_0);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txtfields.put(txt,P3_PREFIX+PERIOD_1);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt,P3_PREFIX+PERIOD_2);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt,P3_PREFIX+PERIOD_3);
		pane.add(txt,c);
		
		return pane;
	}
	
	public String getNTextFieldKey(NTextField txt)
	{
		return txtfields.get(txt);
	}
	
}
