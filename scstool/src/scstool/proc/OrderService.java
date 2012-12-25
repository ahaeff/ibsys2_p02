package scstool.proc;


import java.util.ArrayList;
import java.util.List;

import scstool.obj.Material;
import scstool.obj.Order;


/**
 * @author Alexander
 *
 */
public class OrderService {
	
	/**
	 * Liste der (K) Material Objekte
	 */
	private List<Material> listOfMaterial = new ArrayList<Material>();
	//TODO Zuordnung der K-Teile
	
	/**
	 * Liste der eingehenden und offenen Bestellungen
	 */
	private List<Order> listOfOrder = new ArrayList<Order>();
	//TODO Wie werden einzelne Periden abgebildet
	
	/**
	 * Liste des Bedarfs (Matrix-Ergebnisse)
	 */
	//TODO Bedarfsliste fehlt
	
	/**
	 * Durchschnitt des Periodenbedarfs
	 */
	//TODO Bedarfsliste nötig
	
	/**
	 * Reichweitensicherung
	 */
	//TODO Bedarfsliste nötig
	
	/**
	 * Neubestellung notwendig
	 */
	private boolean order;
	
	/**
	 * Bestellmenge
	 */
	private int amount;
	
	/**
	 * Bestellart setzten
	 */
	private void Ordertype(){
		
	}

	public List<Material> getListOfMaterial() {
		return listOfMaterial;
	}

	public void setListOfMaterial(List<Material> listOfMaterial) {
		this.listOfMaterial = listOfMaterial;
	}

	public List<Order> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<Order> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	public boolean isOrder() {
		return order;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
