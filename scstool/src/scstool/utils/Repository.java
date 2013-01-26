package scstool.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import scstool.obj.Disposition;
import scstool.obj.Material;
import scstool.obj.Order;
import scstool.obj.SellWish;
import scstool.obj.WaitingList;
import scstool.proc.InputContentHandler;
import scstool.proc.WarehouseService;

/**
 * @author haeff
 * 
 *         Dient als Repository aller Daten
 */
public class Repository {
	private static Repository instance;

	// Verkaufswunsch
	private Map<Integer, SellWish> sellwish;
	// Produktionsprgramm und Prognosen
	private Map<Integer, SellWish> prodForecast;
	// Sticherheitsbestand <matnr,menge>
	private Map<Integer, Integer> safetyStock;
	// Integer[0] ist das Material und Integer[1] für die Menge
	private List<Integer[]> productionProgram;
	// die angekommenen Bestellungen
	private List<Order> arrivals;
	// die Bestellungen die noch ausstehen
	private List<Order> futureArrivals;
	// Material in Bearbeitung
	private List<WaitingList> inWork;
	// Material in der Warteschlange
	private List<WaitingList> waiting;
	private Integer lastPeriod;
	private List<Order> orders;
	//Lagerwert aller Materialien
	private Double warehouseStock;

	// Wert fuer Bestell Risiko
	private int riskPercent;

	// Ueberstunden ja oder nein
	private boolean overtime;

	// Disposition
	private Map<Integer, Map<Integer, Disposition>> dispositon;

	/**
	 * private Constructor
	 */
	private Repository() {
		super();
		init();
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}

	private void init() {
		sellwish = new HashMap<Integer, SellWish>();
		sellwish.put(1, new SellWish(1, 0, 0, 0, 0));
		sellwish.put(2, new SellWish(2, 0, 0, 0, 0));
		sellwish.put(3, new SellWish(3, 0, 0, 0, 0));

		safetyStock = new HashMap<Integer, Integer>();
		setProductionProgram(new LinkedList<Integer[]>());

		// TODO evtl. nicht noetig
		waiting = new ArrayList<WaitingList>();
		inWork = new ArrayList<WaitingList>();

	}

	/**
	 * Liefert den kompletten Sicherheitsbestand als Map
	 * 
	 * @return Sicherheitsbestand
	 */
	public Map<Integer, Integer> getStafetyStockAll() {
		return safetyStock;
	}

	/**
	 * Liefert die Menge des Sicherheitsbestand fuer ein Material
	 * 
	 * @param Materialnummer
	 * @return Menge
	 */
	public int getStafetyStock(int key) {
		return safetyStock.get(key);
	}

	/**
	 * Setzt den Sicherheitsbestand
	 * 
	 * @param Materialnummer
	 * @param Menge
	 */
	public void setSafetyStock(int key, int value) {
		safetyStock.put(key, value);
	}

	/**
	 * Liefert ein Objekt Sellwish fuer ein Produkt zurueck
	 * 
	 * @param Produkt
	 *            (1,2 oder 3)
	 * @return Sellwish
	 */
	public SellWish getSellWish(int key) {
		return sellwish.get(key);
	}

	/**
	 * Liefert den kompletten Vertriebswunsch als Map zurueck
	 * 
	 * @return
	 */
	public Map<Integer, SellWish> getSellWishAll() {
		return sellwish;
	}

	/**
	 * Setzt den Vertriebswunsch pro Periode
	 * 
	 * @param Materialnummer
	 * @param Periode
	 * @param Menge
	 */
	public void setSellWish(int product, int periode, int value) {
		SellWish p = sellwish.get(product);
		switch (periode) {
		case 0:
			p.setN(value);
			break;
		case 1:
			p.setN1(value);
			break;
		case 2:
			p.setN2(value);
			break;
		case 3:
			p.setN3(value);
			break;
		}
	}

	public void extractData(InputContentHandler contentHandler) {
		arrivals = contentHandler.getInwardStockMovement();
		futureArrivals = contentHandler.getFutureInwardStockMovement();

		inWork = contentHandler.getAlleWLinWork();
		waiting = contentHandler.getAlleWL();

		lastPeriod = contentHandler.getLastPeriod();
	}

	/**
	 * @return the inWork
	 */
	public List<WaitingList> getInWork() {
		return inWork;
	}

	/**
	 * @param inWork
	 *            the inWork to set
	 */
	public void setInWork(List<WaitingList> inWork) {
		this.inWork = inWork;
	}

	/**
	 * @return the waiting
	 */
	public List<WaitingList> getWaiting() {
		return waiting;
	}

	/**
	 * @param waiting
	 *            the waiting to set
	 */
	public void setWaiting(List<WaitingList> waiting) {
		this.waiting = waiting;
	}

	/**
	 * @return Integer der Menge, eines Artikels, dass noch in Bearbeitung ist
	 *         (Auftr�ge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getAmountOfMaterialInWork(Integer materialID) {
		Integer result = 0;
		
		for (WaitingList wl : inWork) {
			if (wl.getMaterial().getId().equals(materialID)) {
				result = wl.getAmount();
			}
		}

		return result;
	}

	/**
	 * @return Material, dass noch in der Warteschlange ist (Auftr�ge in
	 *         Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getAmountOfWaitingMaterial(Integer materialID) {
		Integer result = 0;
		for (WaitingList wl : waiting) {
			if (wl.getMaterial().getId().equals(materialID)) {
				result = wl.getAmount();
			}
		}
		return result;
	}

	/*
	 * public Map<Integer, Disposition> getDispositon() { return dispositon; }
	 * 
	 * public void setDispositon(Map<Integer, Disposition> dispositon) {
	 * this.dispositon = dispositon; }
	 */

	/**
	 * Liste der gesamten Disposition
	 * 
	 * @param P
	 *            -Material (P1,P2,P3)
	 * @param P
	 *            -Material, E-Material
	 * @param Dispoition
	 */
	public void addDispoistion(int produkt, int material, Disposition dis) {
		if (this.dispositon == null) {
			this.dispositon = new HashMap<Integer, Map<Integer, Disposition>>();
		}

		Map<Integer, Disposition> m = this.dispositon.get(produkt);
		if (m == null) {
			m = new HashMap<Integer, Disposition>();
			this.dispositon.put(produkt, m);
		}

		m.put(material, dis);

	}

	public Disposition getDispoitionByMaterial(Integer product, Integer material) {
		return this.dispositon.get(product).get(material);

	}

	public Map<Integer, Disposition> getDispoitionByProduct(Integer product) {
		return this.dispositon.get(product);

	}

	/**
	 * Errechnet die Menge eines Materials,<br/>
	 * dass in der n-ten Periode kommt.
	 * 
	 * @param mat
	 *            das Material
	 * @param forPeriod
	 *            die nächste Periode wäre 1
	 * @return die Menge des Materials
	 */
	public Integer getArrivalAmountOfMaterial(Material mat, Integer forPeriod) {
		Integer result = 0;

		for (Order order : futureArrivals) {
			if (order.getMaterial().equals(mat)) {
				if (order.getDeliveryDate().getPeriod() == lastPeriod
						+ forPeriod) {
					result += order.getAmount();
				}
			}
		}

		return result;
	}

	public int getRiskPercente() {
		return riskPercent;
	}

	public void setRiskPercente(int riskPercente) {
		this.riskPercent = riskPercente;
	}

	public boolean isOvertime() {
		return overtime;
	}

	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}

	/**
	 * @return the productionProgram
	 */
	public List<Integer[]> getProductionProgram() {
		return productionProgram;
	}

	/**
	 * @param productionProgram
	 *            the productionProgram to set
	 */
	public void setProductionProgram(List<Integer[]> productionProgram) {
		this.productionProgram = productionProgram;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Double getWarehouseStock() {
		WarehouseService whs = new WarehouseService();
		warehouseStock = whs.getWarehouseStockAll();
		return warehouseStock;
	}

	public void setWarehouseStock(Double warehouseStock) {
		this.warehouseStock = warehouseStock;
	}

}
