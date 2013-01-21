package scstool.proc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import scstool.obj.Material;
import scstool.obj.Material.PartTypes;
import scstool.obj.Order;
import scstool.utils.PeriodDate;
import scstool.utils.Repository;

/**
 * @author Alexander
 * 
 *         �berlegungen : Risiko einbinden Listen haben keine Ids! Hoffen dass
 *         sie in der richtigen Reihenfolge sind?!
 * 
 * 
 * 
 */
public class OrderService {
	public DatabaseContentHandler dbch = DatabaseContentHandler.get();
	/**
	 * Liste der (K) Material Objekte
	 */
	private List<Material> purchaseGoods = dbch.getPurchaseGoods();

	/**
	 * Liste der eingehenden und offenen Bestellungen
	 */
	private List<Order> listOfOrder = new ArrayList<Order>();
	// TODO Wie werden einzelne Periden abgebildet

	/**
	 * Liste des Bedarfs (Matrix-Ergebnisse)
	 */
	private LinkedHashMap<Material, List<Integer>> needs;

	/**
	 * Durchschnitt des Periodenbedarfs
	 */
	private LinkedHashMap<Material, Double> averageNeeds;

	/**
	 * Reichweite
	 */
	private LinkedHashMap<Material, Double> coverage;

	/**
	 * Reichweitensicherung
	 */
	private LinkedHashMap<Material, Double> timeMaterialCoverage;

	private LinkedHashMap<Material, List<Integer>> calculatedStock;

	// TODO Bedarfsliste n�tig

	public LinkedHashMap<Material, Double> getAverageNeeds() {
		return averageNeeds;
	}

	public void setAverageNeeds(LinkedHashMap<Material, Double> averageNeeds) {
		this.averageNeeds = averageNeeds;
	}

	/**
	 * Neubestellung notwendig
	 */
	private boolean order;

	/**
	 * Bestellmenge
	 */
	private int amount;

	public OrderService() {
		super();
		try {
			needs = MatrixMultiplication();
			averageNeeds = calculateAverageNeeds();
			coverage = calculateCoverage();
			timeMaterialCoverage = calculateTimeMaterialCoverage();
			calculatedStock = calculateStockForNextPeriods();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<Material> getListOfMaterial() {
		return purchaseGoods;
	}

	public void setListOfMaterial(List<Material> listOfMaterial) {
		this.purchaseGoods = listOfMaterial;
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

	public LinkedHashMap<Material, List<Integer>> MatrixMultiplication() {
		LinkedHashMap<Material, List<Integer>> result = new LinkedHashMap<>();
		LinkedHashMap<Material, int[]> usage = fillUsage();

		// TODO Durch Inputvariablen ersetzen
		int[][] forcast = { { 70, 150, 150, 150 }, { 190, 150, 150, 150 },
				{ 110, 150, 170, 180 } };

		for (Material mat : usage.keySet()) {
			List<Integer> resultRow = new ArrayList<>();
			for (int column = 0; column < forcast[0].length; ++column) {
				int consum = 0;
				for (int row = 0; row < usage.get(mat).length; ++row) {
					consum += (usage.get(mat)[row] * forcast[row][column]);
				}
				resultRow.add(consum);
			}
			result.put(mat, resultRow);
		}

		return result;
	}

	/**
	 * Verlinkt das Material mit der Verwendung<br/>
	 * sortiert nach den {@link PartTypes}.PRODUCT: P1,P2,P3
	 * 
	 * @return
	 */
	private LinkedHashMap<Material, int[]> fillUsage() {
		LinkedHashMap<Material, int[]> result = new LinkedHashMap<>();
		final int[][] usage = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 },
				{ 7, 7, 7 }, { 4, 4, 4 }, { 2, 2, 2 }, { 4, 5, 6 },
				{ 3, 3, 3 }, { 0, 0, 2 }, { 0, 0, 72 }, { 4, 4, 4 },
				{ 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 2, 2, 2 },
				{ 1, 1, 1 }, { 1, 1, 1 }, { 2, 2, 2 }, { 1, 1, 1 },
				{ 3, 3, 3 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
				{ 2, 2, 2 }, { 2, 0, 0 }, { 72, 0, 0 }, { 0, 2, 0 },
				{ 0, 72, 0 }, { 2, 2, 2 } };

		for (int i = 0; i < usage.length; ++i) {
			result.put(purchaseGoods.get(i), usage[i]);
		}

		return result;
	}

	public LinkedHashMap<Material, Double> calculateAverageNeeds() {
		LinkedHashMap<Material, Double> average = new LinkedHashMap<>();

		for (Material mat : needs.keySet()) {
			double var = 0;
			List<Integer> integerList = needs.get(mat);
			for (int j = 0; j < integerList.size(); j++) {
				var += integerList.get(j);
			}
			average.put(mat, var / 4);
		}

		return average;
	}

	public LinkedHashMap<Material, Double> calculateCoverage() {
		LinkedHashMap<Material, Double> coverage = new LinkedHashMap<Material, Double>();

		for (Material mat : needs.keySet()) {
			Repository repo = Repository.getInstance();
			// Menge im Lager + Menge die in der Planperiode kommt
			Integer AmountThisPeriod = dbch.findMaterial(mat.getId())
					.getAmount() + repo.getArrivalAmountOfMaterial(mat, 1);
			// Menge in dieser Periode / Durchschnittsverbrauch
			Double value = AmountThisPeriod / averageNeeds.get(mat);
			coverage.put(mat, value);
		}

		return coverage;

	}

	public LinkedHashMap<Material, Double> calculateTimeMaterialCoverage() {
		LinkedHashMap<Material, Double> times = new LinkedHashMap<Material, Double>();

		for (Material mat : coverage.keySet()) {
			PeriodDate date = mat.getDeliveryTime().add(
					mat.getDeliveryAberation());

			Double time;
			if (date.getDay() < 3) {
				time = averageNeeds.get(mat) / date.getPeriod();
			} else {
				time = averageNeeds.get(mat) / (date.getPeriod() + 1);
			}

			// Reichweitensicherung
			times.put(mat, time);
		}

		return times;
	}

	private LinkedHashMap<Material, List<Integer>> calculateStockForNextPeriods() {
		LinkedHashMap<Material, List<Integer>> stockNextPeriodsWithMat = new LinkedHashMap<Material, List<Integer>>();
		Repository repo = Repository.getInstance();

		List<Integer> stockNextPeriods = new ArrayList<>();
		for (Material mat : needs.keySet()) {
			Integer amountThisPeriod = dbch.findMaterial(mat.getId())
					.getAmount() + repo.getArrivalAmountOfMaterial(mat, 1);
			// Errechneter Bestand Planperiode
			stockNextPeriods.add(amountThisPeriod - needs.get(mat).get(0));
			// Errechneter Bestand Planperiode + 1
			stockNextPeriods.add(stockNextPeriods.get(0)
					- needs.get(mat).get(1));
			// Errechneter Bestand Planperiode + 2
			stockNextPeriods.add(stockNextPeriods.get(1)
					- needs.get(mat).get(2));
			// Errechneter Bestand Planperiode + 3
			stockNextPeriods.add(stockNextPeriods.get(2)
					- needs.get(mat).get(3));

			stockNextPeriodsWithMat.put(mat, stockNextPeriods);
		}

		return stockNextPeriodsWithMat;
	}
}
