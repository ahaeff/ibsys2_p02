package scstool.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;


import scstool.gui.tab.ProdProgrammTab;


/**
 * Registerkarten View
 * 
 * @author haeff
 *
 */
public class TabbedPaneView extends JTabbedPane 
{

	private static final long serialVersionUID = 1L;

	

	public TabbedPaneView() 
	{
		init();
	}

	private void init() 
	{

		setTabPlacement(JTabbedPane.TOP);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Tab Produktions Programm
		ProdProgrammTab tab01 = new ProdProgrammTab();
		tab01.addChangeListener(new ChangeListener());
		add(tab01);


	}

	/**
	 * Focus Listener für die Textfields
	 * @author haeff
	 *
	 */
	class ChangeListener implements FocusListener
	{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) 
		{
			System.out.println("Lost Focus");
			
		}
		
	}
}
