package scstool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;

import scstool.gui.comp.NTextField;
import scstool.gui.tab.ProdProgrammTab;
import scstool.gui.tab.SafetyStockTab;
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
	
	//1. Tab
	private ProdProgrammTab tab01;
	
	//2. Tab
	private SafetyStockTab tab02;

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
		tab01.addChangeListener(new ProdProgChangeListener());
		tab01.addButtonListener(new ButtonListener());
		add("Produktionsprogramm",tab01);

		
		//Sicherheitsbestand
		tab02 = new SafetyStockTab();
		tab02.addButtonListener(new ButtonListener());
		add("Sicherheitsbestand",tab02);
		
	}

	/**
	 * Focus Listener für die Textfields
	 * @author haeff
	 *
	 */
	class ProdProgChangeListener implements FocusListener
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
		}
	}
	
	/**
	 * ButtonListener für das Wechseln der Tabs über die Buttons
	 * 
	 * @author haeff
	 *
	 */
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int index = getSelectedIndex();
			switch(e.getActionCommand())
			{
				case "L":
					index--;
					break;
				case "R":
					index++;
					break;
					
			}
			setSelectedIndex(index);
			
		}
		
	}
}
