package scstool.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander
 *
 */

/**
 *
 */
public class Disposition {
	
	/**
	 * 	Vertriebswunsch
	 */
	private Integer salesOrders;
	/**
	 *	Aufträge in der Warteschlange des übergeordneten Bauteil 
	 */
	private Integer waitingQueue1;
	/**
	 *	Sicherheitsbestand
	 */
	private Integer safetyWarehousestock;
	/**
	 *	Lagerbestand am Ende der Vorperiode
	 */	
	private Integer warehousestockPassedPeriod;
	/**
	 *	Aufträge in der Warteschlange	
	 */
	private Integer waitingQueue2;
	/**
	 *	Aufträge in Bearbeitung
	 */
	private Integer ordersInProgress;
	/**
	 *	Produktionsaufträge (geplante Aufträge)
	 */
	private Integer orders;
	
	private List<Disposition> dispositionen = new ArrayList<Disposition>();

	
	public Disposition() {
		super();
	}

	public Integer getSalesOrders() {
		return salesOrders;
	}

	public void setSalesOrders(Integer salesOrders) {
		this.salesOrders = salesOrders;
	}

	public Integer getWaitingQueue1() {
		return waitingQueue1;
	}

	public void setWaitingQueue1(Integer waitingQueue1) {
		this.waitingQueue1 = waitingQueue1;
	}

	public Integer getSafetyWarehousestock() {
		return safetyWarehousestock;
	}

	public void setSafetyWarehousestock(Integer safetyWarehousestock) {
		this.safetyWarehousestock = safetyWarehousestock;
	}

	public Integer getWarehousestockPassedPeriod() {
		return warehousestockPassedPeriod;
	}

	public void setWarehousestockPassedPeriod(Integer warehousestockPassedPeriod) {
		this.warehousestockPassedPeriod = warehousestockPassedPeriod;
	}

	public Integer getWaitingQueue2() {
		return waitingQueue2;
	}

	public void setWaitingQueue2(Integer waitingQueue2) {
		this.waitingQueue2 = waitingQueue2;
	}

	public Integer getOrdersInProgress() {
		return ordersInProgress;
	}

	public void setOrdersInProgress(Integer ordersInProgress) {
		this.ordersInProgress = ordersInProgress;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public List<Disposition> getDispositionen() {
		return dispositionen;
	}

	public void setDispositionen(List<Disposition> dispositionen) {
		this.dispositionen = dispositionen;
	}
	
	public void createP1(){
		Disposition e26 = new Disposition();
		dispositionen.add(e26);
		Disposition e51 = new Disposition();
		dispositionen.add(e51);
		Disposition e16 = new Disposition();
		dispositionen.add(e16);
		Disposition e17 = new Disposition();
		dispositionen.add(e17);
		Disposition e50 = new Disposition();
		dispositionen.add(e50);
		Disposition e4 = new Disposition();
		dispositionen.add(e4);
		Disposition e10 = new Disposition();
		dispositionen.add(e10);
		Disposition e49 = new Disposition();
		dispositionen.add(e49);
		Disposition e7 = new Disposition();
		dispositionen.add(e7);
		Disposition e13 = new Disposition();
		dispositionen.add(e13);
		Disposition e18 = new Disposition();
		dispositionen.add(e18);
	}
	
	public void createP2(){
		Disposition e26 = new Disposition();
		dispositionen.add(e26);
		Disposition e56 = new Disposition();
		dispositionen.add(e56);
		Disposition e16 = new Disposition();
		dispositionen.add(e16);
		Disposition e17 = new Disposition();
		dispositionen.add(e17);
		Disposition e55 = new Disposition();
		dispositionen.add(e55);
		Disposition e5 = new Disposition();
		dispositionen.add(e5);
		Disposition e11 = new Disposition();
		dispositionen.add(e11);
		Disposition e54 = new Disposition();
		dispositionen.add(e54);
		Disposition e8 = new Disposition();
		dispositionen.add(e8);
		Disposition e14 = new Disposition();
		dispositionen.add(e14);
		Disposition e19 = new Disposition();
		dispositionen.add(e19);
	}
	
	public void createP3(){
		Disposition e26 = new Disposition();
		dispositionen.add(e26);
		Disposition e31 = new Disposition();
		dispositionen.add(e31);
		Disposition e16 = new Disposition();
		dispositionen.add(e16);
		Disposition e17 = new Disposition();
		dispositionen.add(e17);
		Disposition e30 = new Disposition();
		dispositionen.add(e30);
		Disposition e6 = new Disposition();
		dispositionen.add(e6);
		Disposition e12 = new Disposition();
		dispositionen.add(e12);
		Disposition e29 = new Disposition();
		dispositionen.add(e29);
		Disposition e9 = new Disposition();
		dispositionen.add(e9);
		Disposition e15 = new Disposition();
		dispositionen.add(e15);
		Disposition e20 = new Disposition();
		dispositionen.add(e20);
	}		
}
