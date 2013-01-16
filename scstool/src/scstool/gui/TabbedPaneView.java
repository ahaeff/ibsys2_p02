package scstool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTabbedPane;

import scstool.gui.comp.NTextField;
import scstool.gui.tab.LayoutExampleTab;
import scstool.gui.tab.OrderTab;
import scstool.gui.tab.SellWishTab;
import scstool.gui.tab.SafetyStockTab;
import scstool.gui.tab.SettingsTab;
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
	private SellWishTab tab01;
	
	//2. Tab
	private SafetyStockTab tab02;

	//3. Tab
	private SettingsTab tab03;
	
	//4. Tab
	private OrderTab tab04;
	
	//TODO nach ende des Layouting loeschen
	//Beispiel Tab
	private LayoutExampleTab expTab;
	
	public TabbedPaneView() 
	{
		init();
	}

	private void init() 
	{

		setTabPlacement(JTabbedPane.TOP);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Tab Produktions Programm
		tab01 = new SellWishTab(2);
		tab01.addButtonListener(new ButtonListener());		
		tab01.addChangeListener(new ProdProgChangeListener());
		add("Vertriebswunsch",tab01);

		
		//Sicherheitsbestand
		tab02 = new SafetyStockTab(3);
		tab02.addButtonListener(new ButtonListener());
		tab02.addChangeListener(new SafetyStockChangeListener());
		add("Sicherheitsbestand",tab02);
		
		//Einstellungen
		tab03 = new SettingsTab(3);
		tab03.addButtonListener(new ButtonListener());
		//tab03.addChangeListener(new SafetyStockChangeListener());
		add("Einstellungen",tab03);
		
		//Bestellungen
		tab04 = new OrderTab(1);
		tab04.addButtonListener(new ButtonListener());
		//tab03.addChangeListener(new SafetyStockChangeListener());
		add("Bestellungen",tab04);
		
		expTab = new LayoutExampleTab(1);
		add("Layout Spielerei",expTab);
		
	}

	/**
	 * Focus Listener f�r die Textfields
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
					Repository.getInstance().setSellWish(product, periode, value);
				}	
			}
		}
	}
	
	
	class SafetyStockChangeListener implements FocusListener
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
				
				String strkey = tab02.getNTextFieldKey(txt);
				int key = Integer.parseInt(strkey.substring(1));
				if(txt.getText().matches("[0-9]+"))
				{
					int value = Integer.parseInt(txt.getText());
					Repository.getInstance().setSafetyStock(key, value);
				}
			}
			
		}
	}
	
	/**
	 * ButtonListener f�r das Wechseln der Tabs �ber die Buttons
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
