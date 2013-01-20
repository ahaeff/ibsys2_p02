package scstool.gui.tab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import scstool.gui.comp.ButtonPane;
import scstool.gui.comp.CustLabel;
import scstool.gui.comp.NTextField;
import scstool.utils.Repository;

/**
 * Eingabe des Produktionsprogramms, Prognosen und Direktverkaeufe
 * 
 * @author haeff
 * 
 */
public class SellWishTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private int bnt_var;

	private Map<NTextField, String> txtfields;
	private FocusListener changeListener;

	// Keys die fur die Auswertung des Focuslistner benoetigt werden
	private final static String P1_PREFIX = "1";
	private final static String P2_PREFIX = "2";
	private final static String P3_PREFIX = "3";

	private final static String PERIOD_0 = "_0";
	private final static String PERIOD_1 = "_1";
	private final static String PERIOD_2 = "_2";
	private final static String PERIOD_3 = "_3";

	private final static String DIRECT = "_D";
	// Button Panel
	private ButtonPane bnt_pane;

	public SellWishTab(int bnt_var) {
		this.bnt_var = bnt_var;
		init();
	}

	private void init() {

		setLayout(new BorderLayout());
		txtfields = new HashMap<NTextField, String>();
		buildGui();
		setTestData();
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

	/**
	 * Registiert den Foculistener bei den Textfeldern
	 * 
	 * @param l
	 *            : Focuslistener
	 */
	public void addChangeListener(FocusListener l) {
		this.changeListener = l;
		registerChangeListener();
	}

	/**
	 * Alle textfelder erhalten einen Actionlistener
	 */
	private void registerChangeListener() {
		if (this.changeListener != null) {
			for (NTextField key : txtfields.keySet()) {
				key.addFocusListener(this.changeListener);
			}
		}
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

		c.insets = new Insets(10, 10, 0, 10);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.ipadx = 10;

		// 1. Zeile
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 5;
		pane.add(new CustLabel("Verkaufswunsch und Prognosen:"), c);

		NTextField txt;

		// 2. Zeile
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		pane.add(new CustLabel(""), c);

		c.gridx = 1;
		pane.add(new CustLabel("Aufträge"), c);

		c.gridx = 2;
		pane.add(new CustLabel("Prognose 1"), c);

		c.gridx = 3;
		pane.add(new CustLabel("Prognose 2"), c);

		c.gridx = 4;
		pane.add(new CustLabel("Prognose 3"), c);

		// 3. Zeile
		c.gridy = 2;
		c.gridx = 0;
		pane.add(new CustLabel("P1"), c);

		c.gridx = 1;
		txt = new NTextField();
		txtfields.put(txt, P1_PREFIX + PERIOD_0);
		pane.add(txt, c);

		c.gridx = 2;
		txt = new NTextField();

		txtfields.put(txt, P1_PREFIX + PERIOD_1);
		pane.add(txt, c);

		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt, P1_PREFIX + PERIOD_2);
		pane.add(txt, c);

		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt, P1_PREFIX + PERIOD_3);
		pane.add(txt, c);

		// 4. Zeile
		c.gridy = 3;
		c.gridx = 0;
		pane.add(new CustLabel("P2"), c);

		c.gridx = 1;
		txt = new NTextField();
		txtfields.put(txt, P2_PREFIX + PERIOD_0);
		pane.add(txt, c);

		c.gridx = 2;
		txt = new NTextField();
		txtfields.put(txt, P2_PREFIX + PERIOD_1);
		pane.add(txt, c);

		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt, P2_PREFIX + PERIOD_2);
		pane.add(txt, c);

		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt, P2_PREFIX + PERIOD_3);
		pane.add(txt, c);

		// 5. Zeile
		c.gridy = 4;
		c.gridx = 0;
		pane.add(new CustLabel("P3"), c);

		c.gridx = 1;
		txt = new NTextField();
		txtfields.put(txt, P3_PREFIX + PERIOD_0);
		pane.add(txt, c);

		c.gridx = 2;
		txt = new NTextField();
		txtfields.put(txt, P3_PREFIX + PERIOD_1);
		pane.add(txt, c);

		c.gridx = 3;
		txt = new NTextField();
		txtfields.put(txt, P3_PREFIX + PERIOD_2);
		pane.add(txt, c);

		c.gridx = 4;
		txt = new NTextField();
		txtfields.put(txt, P3_PREFIX + PERIOD_3);
		pane.add(txt, c);

		// Direktverkauf
		// 6.Zeile
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 5;
		c.insets.top = 30;
		pane.add(new CustLabel("Direktverkauf:"), c);

		// 7. Zeile
		c.insets.top = 10;
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 1;
		pane.add(new CustLabel("P1"), c);

		
		//TODO Direktverkauf einbinden!
		c.gridx = 1;
		txt = new NTextField();
		//txtfields.put(txt, P1_PREFIX + DIRECT);
		pane.add(txt, c);

		// 8. Zeile
		c.gridy = 7;
		c.gridx = 0;
		pane.add(new CustLabel("P2"), c);

		c.gridx = 1;
		txt = new NTextField();
		//txtfields.put(txt, P2_PREFIX + DIRECT);
		pane.add(txt, c);

		// 8. Zeile
		c.gridy = 8;
		c.gridx = 0;
		pane.add(new CustLabel("P3"), c);

		c.gridx = 1;
		txt = new NTextField();
		//txtfields.put(txt, P3_PREFIX + DIRECT);
		pane.add(txt, c);

		return pane;

	}

	private void setTestData() {
		Repository repo = Repository.getInstance();
		int value = 200;

		for (Map.Entry<NTextField, String> e : txtfields.entrySet()) {

			String key = e.getValue();

			if ("D".equals(key.substring(2))) {
				//e.getKey().setText(String.valueOf(value));
				//int matnr = Integer.parseInt(key.substring(0, 1));

			} else {
				e.getKey().setText(String.valueOf(value));
				int matnr = Integer.parseInt(key.substring(0, 1));
				String str = e.getValue().substring(2);
				int period = Integer.parseInt(str);
				repo.setSellWish(matnr, period, value);
			}

		}
	}

	public String getNTextFieldKey(NTextField txt) {
		return txtfields.get(txt);
	}

}
