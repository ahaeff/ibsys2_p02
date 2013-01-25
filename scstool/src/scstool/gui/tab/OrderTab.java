package scstool.gui.tab;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.obj.Material;
import scstool.obj.Order;
import scstool.proc.DatabaseContentHandler;
import scstool.proc.OrderService;
import scstool.proc.StatusSingleton;

public class OrderTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private int bnt_var;
	private OrderService service;

	private Map<String, JTextField> txtfields;

	// Button Panel
	private ButtonPane bnt_pane;

	private JTextField t;

	public OrderTab(int bnt_var) {
		this.bnt_var = bnt_var;
		init();
	}

	private void init() {

		txtfields = new HashMap<String, JTextField>();
		service = new OrderService();
		buildGui();

	}

	private void buildGui() {
		int rows = 3;
		int column = 3;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;

		// Platzhalter 1. Zeile
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = column;
		c.weightx = 0.0;
		c.weighty = 0.0;
		add(getTopRow(), c);

		// Platzhalter links
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		add(getLeft(), c);

		// Content mitte
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTHWEST;
		add(getContent(), c);

		// Platzhalter rechts
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		add(getRight(), c);

		// Letzte Zeile
		c.gridx = 0;
		c.gridy = rows - 1;
		c.gridwidth = column;
		c.weightx = 0.0;
		c.weighty = 0.0;
		bnt_pane = new ButtonPane(this.bnt_var);
		add(bnt_pane, c);
		// add(getBottomRow(),c);

	}

	/**
	 * Erstellt den Inhalt des Platzhalters ersten Zeile
	 * 
	 * @return
	 */
	private JPanel getTopRow() {
		int width = 0;
		int height = 50;

		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width, height));

		// fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());

		return pane;
	}

	/**
	 * Erstellt den Inhalt des Platzhalters letzte Zeile
	 * 
	 * @return
	 */
	/*
	 * private JPanel getBottomRow() { int width = 0; int height = 50;
	 * 
	 * JPanel pane = new JPanel(); pane.setPreferredSize(new
	 * Dimension(width,height));
	 * 
	 * //fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
	 * pane.setMinimumSize(pane.getPreferredSize());
	 * 
	 * return pane;
	 * 
	 * }
	 */

	/**
	 * Erstellt den Inhalt des Platzhalters links vom Content
	 * 
	 * @return
	 */
	private JPanel getLeft() {
		int width = 100;
		int height = 0;

		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width, height));

		// fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());

		return pane;
	}

	/**
	 * Erstellt den Inhalt des Platzhalters rechts vom Content
	 * 
	 * @return
	 */
	private JPanel getRight() {
		int width = 100;
		int height = 0;

		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(width, height));

		// fix fuer einen BUG bezueglich der Breite/Hoehe in einem GribagLayout
		pane.setMinimumSize(pane.getPreferredSize());

		return pane;
	}

	/**
	 * Erstellt den Inhalt des Content
	 * 
	 * @return
	 */
	private JPanel getContent() {

		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		NTextField ntxt;
		JTextField txt;

		c.insets = new Insets(10, 5, 0, 5);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridy = 0;
		c.gridx = 0;
		pane.add(new CustLabel("Artikel"), c);

		c.gridx = 1;
		pane.add(new CustLabel("Menge"), c);

		c.gridx = 2;
		pane.add(new CustLabel("Modus"), c);

		c.gridx = 3;
		c.insets.left = 30;
		pane.add(new CustLabel("Artikel"), c);

		c.gridx = 4;
		c.insets.left = 5;
		pane.add(new CustLabel("Menge"), c);

		c.gridx = 5;
		pane.add(new CustLabel("Modus"), c);

		if (StatusSingleton.get().isInputXmlLoaded()) {
			List<Order> orders = service.ordering();
			int i = 0;

			c.gridy = 1;
			for (Material mat : DatabaseContentHandler.get().getPurchaseGoods()) {
				c.gridx = i;
				String id = mat.getId().toString();
				txt = new JTextField();
				txt.setText(id);
				txt.setEditable(false);
				txtfields.put(id + "_id", txt);
				pane.add(txt, c);

				Order order = findOrder(mat, orders);
				
				c.gridx = i + 1;
				c.insets.left = 5;
				txt = new JTextField();
				txt.setText(order.getAmount().toString());
				txt.setEditable(false);
				txtfields.put(id + "_amount", txt);
				pane.add(txt, c);

				c.gridx = i + 2;
				txt = new JTextField();
				txt.setText(order.getMode().toString());
				txt.setEditable(false);
				txtfields.put(id + "_mode", txt);
				pane.add(txt, c);

				if (i != 3) {
					i = 3;
					c.insets.left = 30;
				} else {
					c.gridy++;
					i = 0;
				}

			}
		}
		return pane;
	}

	private Order findOrder(Material mat, List<Order> orders) {
		for (Order or : orders) {
			if (or.getMaterial().equals(mat)) {
				return or;
			}
		}
		Order order = new Order();
		order.setAmount(0);
		order.setMode(Order.Mode.NORMAL.getMark());
		return order;
	}

	/**
	 * Gibt den Buttonlistener an das ButtonPanel weiter
	 * 
	 * @param l
	 *            : Actionlistener
	 */
	public void addButtonListener(ActionListener l) {
		bnt_pane.addButtonListener(l);
	}

	public void refresh() {
		service = new OrderService();
		List<Order> orders = service.ordering();
		for (Order o : orders) {
			String id = o.getMaterial().getId().toString();
			if (o == null || o.getAmount() == null) {
				System.out.println(o.getId());
			}
			txtfields.get(id + "_amount").setText(o.getAmount().toString());
			txtfields.get(id + "_mode").setText(o.getMode().toString());
		}

	}
}
