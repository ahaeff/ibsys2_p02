package scstool.proc;


import java.util.ArrayList;
import java.util.List;

import scstool.obj.Material;
import scstool.obj.Order;


/**
 * @author Alexander
 *
 *Überlegungen :
 *Risiko einbinden
 *Listen haben keine Ids! Hoffen dass sie in der richtigen Reihenfolge sind?!
 *
 *
 *
 */
public class OrderService {
	public DatabaseContentHandler dbch = DatabaseContentHandler.get();
	/**
	 * Liste der (K) Material Objekte
	 */
	private List<Material> listOfMaterial = dbch.getKTeile();
	
	
	/**
	 * Liste der eingehenden und offenen Bestellungen
	 */
	private List<Order> listOfOrder = new ArrayList<Order>();
	//TODO Wie werden einzelne Periden abgebildet
	
	/**
	 * Liste des Bedarfs (Matrix-Ergebnisse)
	 */
	private int[][] needs = MatrixMultiplication();
	
	/**
	 * Durchschnitt des Periodenbedarfs
	 */
	private List<Double> averageNeeds = calculateAverageNeeds();
	
	/**
	 * Reichweitensicherung
	 */
	//TODO Bedarfsliste nötig
	
	public List<Double> getAverageNeeds() {
		return averageNeeds;
	}

	public void setAverageNeeds(List<Double> averageNeeds) {
		this.averageNeeds = averageNeeds;
	}

	/**
	 * Neubestellung notwendig
	 */
	private boolean order;
	
	public int[][] getNeeds() {
		return needs;
	}

	public void setNeeds(int[][] needs) {
		this.needs = needs;
	}

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
	
	public int[][] MatrixMultiplication(){
		int[][] result = new int[23][4];
		
		//TODO Durch Inputvariablen ersetzen
		int[][] forcast = {
	            {70, 150, 150, 150},
	            {190, 150, 150, 150},
	            {110, 150, 170, 180}
	            };

		int[][] usage = {
	            {1, 0, 0},
	            {0, 1, 0},
	            {0, 0, 1},
	            {7, 7, 7},
	            {4, 4, 4},
	            {2, 2, 2},
	            {4, 5, 6},
	            {3, 3, 3},
	            {0, 0, 2},
	            {0, 0, 72},
	            {4, 4, 4},
	            {1, 1, 1},
	            {1, 1, 1},
	            {1, 1, 1},
	            {2, 2, 2},
	            {1, 1, 1},
	            {1, 1, 1},
	            {2, 2, 2},
	            {1, 1, 1},
	            {3, 3, 3},
	            {1, 1, 1},
	            {1, 1, 1},
	            {1, 1, 1},
	            {2, 2, 2},
	            {2, 0, 0},
	            {72, 0, 0},
	            {0, 2, 0},
	            {0, 72, 0},
	            {2, 2, 2}
	            };
		
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[i].length;j++){	
				int v= 0;
				for (int n=0; n < forcast.length; n++){
					v += usage[i][n]*forcast[n][j];
				}
				result[i][j]= v;
			}
		}
		return result;
	}
	
	public List<Double> calculateAverageNeeds(){
		List <Double> average = new ArrayList<Double>();
		
		for(int i=0; i<needs.length; i++){
			double var = 0;
			for(int j=0; j< needs[i].length; j++){
				var += needs[i][j];
			}
			average.add(var/4);
		}
		
		
		return average;
	}
	
	//TODO Reichweitensicherung berechnen
	public List<Integer> calculateCoverage(){
		List <Integer> coverage = new ArrayList<Integer>();
		
		
		
		return coverage;
		
	}
	
}
