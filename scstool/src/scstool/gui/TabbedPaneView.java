package scstool.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import scstool.gui.comp.NTextField;
import scstool.gui.tab.LayoutExampleTab;
import scstool.gui.tab.OrderTab;
import scstool.gui.tab.SellWishTab;
import scstool.gui.tab.SafetyStockTab;
import scstool.gui.tab.SettingsTab;
import scstool.obj.SellWish;
import scstool.proc.DispositionService;
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
	
	
	//Title Icons
	private final static String ICON01 = "/icon/tab/num1_22x16.png";
	private final static String ICON02 = "/icon/tab/num2_22x16.png";
	private final static String ICON03 = "/icon/tab/num3_22x16.png";
	private final static String ICON_OK ="/icon/tab/ok_22x16.png";
	
	
	private int activeIndex = 0;
	
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
		addChangeListener(new TabListener());
		URL url;
		
		//Tab Produktions Programm
		tab01 = new SellWishTab(2);
		tab01.addButtonListener(new ButtonListener());		
		tab01.addChangeListener(new ProdProgChangeListener());
		addTab("Vertriebswunsch",getTitleIcon(ICON01),tab01);;

		//Sicherheitsbestand
		tab02 = new SafetyStockTab(3);
		tab02.addButtonListener(new ButtonListener());
		tab02.addChangeListener(new SafetyStockChangeListener());
		addTab("Sicherheitsbestand",getTitleIcon(ICON02),tab02);
		
		//Einstellungen
		tab03 = new SettingsTab(3);
		tab03.addButtonListener(new ButtonListener());
		//tab03.addChangeListener(new SafetyStockChangeListener());
		addTab("Einstellungen",getTitleIcon(ICON03),tab03);
		
		//Bestellungen
		tab04 = new OrderTab(1);
		tab04.addButtonListener(new ButtonListener());
		//tab03.addChangeListener(new SafetyStockChangeListener());
		add("Bestellungen",tab04);
		
		expTab = new LayoutExampleTab(1);
		add("Layout Spielerei",expTab);
		
	}

	
	private void checkSellWisch()
	{
		Repository repo = Repository.getInstance();
		 Map<Integer,SellWish> sellwish = repo.getSellWishAll();
		 
		for(Integer i: sellwish.keySet())
		{
			SellWish s = sellwish.get(i);
			if( s.getN()  == 0 ||
				s.getN1() == 0 ||
				s.getN2() == 0 ||
				s.getN3() == 0 )
			{
				setIconAt(0, getTitleIcon(ICON01));
				return;
			}
		}
		setIconAt(0, getTitleDoneIcon(ICON01));
	}
	
	private void checkSafetyStock()
	{
		Repository repo = Repository.getInstance();
		Map<Integer,Integer> saftystock = repo.getStafetyStockAll();
		
		for(Map.Entry<Integer, Integer> e:saftystock.entrySet())
		{
			if(e.getValue() == 0)
			{
				setIconAt(1, getTitleIcon(ICON02));
				return;
			}
		}
		setIconAt(1, getTitleDoneIcon(ICON02));
		return;
	}
	
	private ImageIcon getTitleIcon(String path)
	{
		URL url = this.getClass().getResource(path);
		return new ImageIcon(url);

	}
	private ImageIcon getTitleDoneIcon(String path)
	{
		
		BufferedImage image;
		BufferedImage overlay;
	
		
		URL url;
		try {
		url = this.getClass().getResource(path);
		image = ImageIO.read(url);
		
		url = this.getClass().getResource(ICON_OK);
		overlay = ImageIO.read(url);

		// create the new image, canvas size is the max. of both image sizes
		int w = Math.max(image.getWidth(), overlay.getWidth());
		int h = Math.max(image.getHeight(), overlay.getHeight());
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.drawImage(overlay, 0, 0, null);
       
		return new ImageIcon(combined);

            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return null;
		
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
				else
				{
					Repository.getInstance().setSellWish(product, periode, 0);
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
				else
				{
					Repository.getInstance().setSafetyStock(key, 0);
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
	
	class TabListener implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e) 
		{
			if(activeIndex == 0)
			{
				checkSellWisch();
			}
			
			
			//beim Wechsel von Sicherheistbestand nach irgendwo
			if(activeIndex == 1)
			{	
				checkSafetyStock();
				
				DispositionService disServ = new DispositionService();	
				disServ.QueueInput1();
				disServ.QueueInput2();
				disServ.QueueInput3();
				
			}
			
			activeIndex = getSelectedIndex();

		
			
			
			
		}
		
	}
}
