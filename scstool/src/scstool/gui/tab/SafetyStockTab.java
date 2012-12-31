package scstool.gui.tab;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import scstool.gui.comp.ButtonPane;



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

	//Button Panel
	private ButtonPane bnt_pane;
	
	
	public SafetyStockTab()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		
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
	 * Erzeugt den Teil des Contents der im Page_End Bereich eingefuegt wird
	 */
	private void buildSouth()
	{
		bnt_pane = new ButtonPane(1);
		
		add(bnt_pane,BorderLayout.PAGE_END);
	}
}
