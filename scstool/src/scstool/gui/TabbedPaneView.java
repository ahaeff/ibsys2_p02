package scstool.gui;

import java.awt.Desktop.Action;
import java.awt.Graphics;
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
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import scstool.gui.comp.NTextField;
import scstool.gui.tab.CapacityTab;
import scstool.gui.tab.OrderTab;
import scstool.gui.tab.OverviewTab;
import scstool.gui.tab.ProductionTab;
import scstool.gui.tab.SellWishTab;
import scstool.gui.tab.SafetyStockTab;
import scstool.gui.tab.SettingsTab;
import scstool.obj.SellWish;
import scstool.proc.DispositionService;
import scstool.proc.ExportXmlController;
import scstool.proc.StatusSingleton;
import scstool.utils.Repository;

/**
 * Registerkarten View
 * 
 * @author haeff
 * 
 */
public class TabbedPaneView extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private JFrame parent;
	
	// 1. Tab
	private SellWishTab tab01;

	// 2. Tab
	private SafetyStockTab tab02;

	// 3. Tab
	private SettingsTab tab03;

	// 4. Tab
	private OrderTab tab04;

	// 5. Tab
	private CapacityTab tab05;

	// 6 Tab
	private ProductionTab tab06;

	// 7. Tab
	private OverviewTab tab07;

	// Title Icons
	private final static String ICON01 = "/icon/tab/num1_22x16.png";
	private final static String ICON02 = "/icon/tab/num2_22x16.png";
	private final static String ICON03 = "/icon/tab/num3_22x16.png";
	private final static String ICON_OK = "/icon/tab/ok_22x16.png";

	private int activeIndex = 0;

	private StatusMessageEventMulticaster multicaster;
	
	private ActionListener backListener;
	
	public TabbedPaneView(JFrame j) {
		parent = j;
		init();
	}

	private void init() {
		multicaster = StatusMessageEventMulticaster.getInstance();
		setTabPlacement(JTabbedPane.TOP);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		addChangeListener(new TabListener());

		// Tab Produktions Programm
		tab01 = new SellWishTab(2);
		tab01.addButtonListener(new ButtonListener());
		tab01.addChangeListener(new ProdProgChangeListener());
		addTab("Vertriebswunsch", getTitleIcon(ICON01), tab01);
		;

		// Sicherheitsbestand
		tab02 = new SafetyStockTab(3);
		tab02.addButtonListener(new ButtonListener());
		tab02.addChangeListener(new SafetyStockChangeListener());
		addTab("Sicherheitsbestand", getTitleIcon(ICON02), tab02);

		// Einstellungen
		tab03 = new SettingsTab(3);
		tab03.addButtonListener(new ButtonListener());
		addTab("Einstellungen", getTitleIcon(ICON03), tab03);

		// Bestellungen
		tab04 = new OrderTab(3);
		tab04.addButtonListener(new ButtonListener());
		addTab("Bestellungen", tab04);

		// Kapazitaet
		tab05 = new CapacityTab(3);
		tab05.addButtonListener(new ButtonListener());
		add("Kapazität", tab05);

		// Produktion
		tab06 = new ProductionTab(3);
		tab06.addButtonListener(new ButtonListener());
		add("Produktion", tab06);

		// Uebersicht
		tab07 = new OverviewTab(1);
		tab07.addButtonListener(new ButtonListener());
		add("Übersicht", tab07);
	}
	public void addBackListener(ActionListener l)
	{
		tab01.addButtonListener(l);
	}
	
	private void checkSellWisch() {
		Repository repo = Repository.getInstance();
		StatusSingleton stat = StatusSingleton.get();
		Map<Integer, SellWish> sellwish = repo.getSellWishAll();

		for (Integer i : sellwish.keySet()) {
			SellWish s = sellwish.get(i);
			if (s.getN() == 0 || s.getN1() == 0 || s.getN2() == 0
					|| s.getN3() == 0) {
				setIconAt(0, getTitleIcon(ICON01));
				stat.setSellwischOk(false);
				return;
			}
		}
		stat.setSellwischOk(true);
		setIconAt(0, getTitleDoneIcon(ICON01));
	}

	private void checkSafetyStock() {
		Repository repo = Repository.getInstance();
		StatusSingleton stat = StatusSingleton.get();
		Map<Integer, Integer> saftystock = repo.getStafetyStockAll();

		for (Map.Entry<Integer, Integer> e : saftystock.entrySet()) {
			if (e.getValue() < 0) {
				setIconAt(1, getTitleIcon(ICON02));
				stat.setSafetyStockOk(false);
				return;
			}
		}
		setIconAt(1, getTitleDoneIcon(ICON02));
		stat.setSafetyStockOk(true);
	}

	private ImageIcon getTitleIcon(String path) {
		URL url = this.getClass().getResource(path);
		return new ImageIcon(url);

	}

	private ImageIcon getTitleDoneIcon(String path) {

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
			BufferedImage combined = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_ARGB);

			// paint both images, preserving the alpha channels
			Graphics g = combined.getGraphics();
			g.drawImage(image, 0, 0, null);
			g.drawImage(overlay, 0, 0, null);

			return new ImageIcon(combined);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Focus Listener f�r die Textfields
	 * 
	 * @author haeff
	 * 
	 */
	class ProdProgChangeListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// not used
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getSource() instanceof NTextField) {
				NTextField txt = (NTextField) e.getSource();

				String key = tab01.getNTextFieldKey(txt);
				String[] arr = key.split("_");

				int product = Integer.valueOf(arr[0]);
				int periode = Integer.valueOf(arr[1]);

				if (txt.getText().matches("[0-9]+")) {
					int value = Integer.parseInt(txt.getText());
					Repository.getInstance().setSellWish(product, periode,
							value);
				} else {
					Repository.getInstance().setSellWish(product, periode, 0);
				}
			}
		}
	}

	class SafetyStockChangeListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// not used

		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getSource() instanceof NTextField) {
				NTextField txt = (NTextField) e.getSource();

				String strkey = tab02.getNTextFieldKey(txt);
				int key = Integer.parseInt(strkey.substring(1));
				if (txt.getText().matches("[0-9]+")) {
					int value = Integer.parseInt(txt.getText());
					Repository.getInstance().setSafetyStock(key, value);
				} else {
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
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "EXP") {
				ExportXmlController controller = new ExportXmlController(parent);
				controller.openDialog();
			} else {
				int index = getSelectedIndex();
				switch (e.getActionCommand()) {
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

	class TabListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			StatusSingleton stat = StatusSingleton.get();

			if (activeIndex == 0) {
				checkSellWisch();
				if(!stat.isInputSet())
				{
					if(getSelectedIndex() >2)
					{
						setSelectedIndex(0);
						multicaster.setStatusMessage(new StatusMessageEvent(this, "Benutzereingaben nicht vollständig"));
					}
				}
			}
			
			
			//beim Wechsel von Sicherheistbestand nach irgendwo
			if(activeIndex == 1)
			{	
				multicaster.setStatusMessage(new StatusMessageEvent(this, ""));
				checkSafetyStock();

				DispositionService disServ = new DispositionService();
				disServ.QueueInput1();
				disServ.QueueInput2();
				disServ.QueueInput3();

				disServ.prodProgramm();
				
				if(!stat.isInputSet())
				{
					if(getSelectedIndex() >2)
					{
						setSelectedIndex(1);
						multicaster.setStatusMessage(new StatusMessageEvent(this, "Benutzereingaben nicht vollständig"));
					}
				}				

			}

			if (activeIndex == 2) {
				multicaster.setStatusMessage(new StatusMessageEvent(this, ""));
				tab04.refresh();
				tab05.refresh();
				tab06.refresh();
				tab07.refresh();
				stat.setRiskOk(true);
				setIconAt(2, getTitleDoneIcon(ICON03));
				if(!stat.isInputSet())
				{
					if(getSelectedIndex() >2)
					{
						setSelectedIndex(2);
						multicaster.setStatusMessage(new StatusMessageEvent(this, "Benutzereingaben nicht vollständig"));
					}
				}
			}
			if (activeIndex == 4) {
				multicaster.setStatusMessage(new StatusMessageEvent(this, ""));
			}
			if (activeIndex == 5) {
				multicaster.setStatusMessage(new StatusMessageEvent(this, ""));
			}
			if (activeIndex == 6) {
				multicaster.setStatusMessage(new StatusMessageEvent(this, ""));
			}
			activeIndex = getSelectedIndex();

		}

	}
}
