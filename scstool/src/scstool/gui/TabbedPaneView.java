package scstool.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;


import scstool.gui.comp.NTextField;
import scstool.gui.tab.ProdProgrammTab;
import scstool.utils.Repository;


/**
 * Registerkarten View
 * 
 * @author haeff
 *
 */
public class TabbedPaneView extends JTabbedPane 
{

	private static final long serialVersionUID = 1L;
	private ProdProgrammTab tab01;
	

	public TabbedPaneView() 
	{
		init();
	}

	private void init() 
	{

		setTabPlacement(JTabbedPane.TOP);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Tab Produktions Programm
		tab01 = new ProdProgrammTab();
		tab01.addChangeListener(new ChangeListener());
		add("Produktionsprogramm",tab01);


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
			// not used
			
		}

		@Override
		public void focusLost(FocusEvent e) 
		{
			if(e.getSource() instanceof NTextField)
			{
				NTextField txt = (NTextField) e.getSource();
				
				String key = tab01.getNTextFieldKey(txt);
				String[] arr = key.split("_");
				
				int product = Integer.valueOf(arr[0]);
				int periode = Integer.valueOf(arr[1]);
		
				if(txt.getText().matches("[0-9]+"))
				{
					int value = Integer.parseInt(txt.getText());
					Repository.getInstance().setProdProg(product, periode, value);
				}

				
			}
			System.out.println("Lost Focus");
			
		}
		

		
	}
}
