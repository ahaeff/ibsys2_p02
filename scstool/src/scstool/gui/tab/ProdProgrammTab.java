package scstool.gui.tab;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<NTextField> txtfields;
		
	private FocusListener changeListener;
	
	
	//ActionCommands
	private final static String P1_PREFIX = "P1";
	private final static String P2_PREFIX = "P2";
	private final static String P3_PREFIX = "P3";
	
	private final static String PERIOD_0 = "_N";
	private final static String PERIOD_1 = "_N1";
	private final static String PERIOD_2 = "_N2";
	private final static String PERIOD_3 = "_N3";
	
	public ProdProgrammTab()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());

		txtfields = new ArrayList<NTextField>();
		
		buildNorth();
		buildSouth();
	}
	
	public void addChangeListener(FocusListener l)
	{
		this.changeListener = l;
		registerChangeListener();
	}
	
	private void registerChangeListener()
	{
		if(this.changeListener != null)
		{
			for(NTextField txt : txtfields)
			{
				txt.addFocusListener(this.changeListener);
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

	private void buildSouth()
	{
		add(new ButtonPane(3),BorderLayout.PAGE_END);
	}
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
		txt.setActionCommand(P1_PREFIX+PERIOD_0);
		txtfields.add(txt);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt.setActionCommand(P1_PREFIX+PERIOD_1);
		txtfields.add(txt);		
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt.setActionCommand(P1_PREFIX+PERIOD_2);
		txtfields.add(txt);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt.setActionCommand(P1_PREFIX+PERIOD_3);
		txtfields.add(txt);
		pane.add(txt,c);
		
		//3. Zeile
		c.gridy = 2;
		c.gridx = 0;
		pane.add(new  CustLabel("P2"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P2_PREFIX+PERIOD_0);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P2_PREFIX+PERIOD_1);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P2_PREFIX+PERIOD_2);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P2_PREFIX+PERIOD_3);
		pane.add(txt,c);
		
		//4. Zeile
		c.gridy = 3;
		c.gridx = 0;
		pane.add(new  CustLabel("P3"),c);
		
		c.gridx = 1;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P3_PREFIX+PERIOD_0);
		pane.add(txt,c);
		
		c.gridx = 2;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P3_PREFIX+PERIOD_1);
		pane.add(txt,c);
		
		c.gridx = 3;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P3_PREFIX+PERIOD_2);
		pane.add(txt,c);
		
		c.gridx = 4;
		txt = new NTextField();
		txt = new NTextField();
		txt.setActionCommand(P3_PREFIX+PERIOD_3);
		pane.add(txt,c);
		
		return pane;
	}
}
