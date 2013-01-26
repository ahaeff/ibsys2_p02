package scstool.proc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import scstool.obj.Material;
import scstool.obj.Material.PartTypes;
import scstool.obj.Order;
import scstool.obj.Order.Mode;
import scstool.obj.SellWish;
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

	/**
	 * Errechneter Bestand mit Bestellungen abzüglich Bedarf am Ende der Periode
	 */
	private LinkedHashMap<Material, List<Integer>> calculatedStock;

	public OrderService() {
		super();
		try {
			needs = MatrixMultiplication();
			Repository.getInstance().setUsage(needs);
			averageNeeds = calculateAverageNeeds();
			coverage = calculateCoverage();
			timeMaterialCoverage = calculateTimeMaterialCoverage();
			calculatedStock = calculateStockForNextPeriods();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private LinkedHashMap<Material, List<Integer>> MatrixMultiplication() {
		LinkedHashMap<Material, List<Integer>> result = new LinkedHashMap<>();
		LinkedHashMap<Material, int[]> usage = fillUsage();
		
		int[][] forcast = extractForecasts();

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

	private int[][] extractForecasts() {
		int[][] result = new int[3][4];
		for (Integer[] integer : Repository.getInstance()
				.getProductionProgram()) {
			switch (integer[0]) {
			case 1:
				result[0] = forecasts(1, integer[1]);
				break;
			case 2:
				result[1] = forecasts(2, integer[1]);
				break;
			case 3:
				result[2] = forecasts(3, integer[1]);
				break;
			}
		}

		return result;
	}

	private int[] forecasts(int index, int firstValue) {
		int[] result = new int[4];
		SellWish sellwish = Repository.getInstance().getSellWish(index);
		int safetyStock = Repository.getInstance().getStafetyStock(index);
		result[0] = firstValue;
		result[1] = sellwish.getN1()
				- ((sellwish.getN1() / sellwish.getN()) * safetyStock)
				+ safetyStock;
		result[2] = sellwish.getN2()
				- ((sellwish.getN2() / sellwish.getN1()) * safetyStock)
				+ safetyStock;
		result[3] = sellwish.getN3()
				- ((sellwish.getN3() / sellwish.getN2()) * safetyStock)
				+ safetyStock;
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

	private LinkedHashMap<Material, Double> calculateAverageNeeds() {
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

	private LinkedHashMap<Material, Double> calculateCoverage() {
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

	private LinkedHashMap<Material, Double> calculateTimeMaterialCoverage() {
		LinkedHashMap<Material, Double> times = new LinkedHashMap<Material, Double>();

		for (Material mat : coverage.keySet()) {
			// Reichweitensicherung
			Integer roundDeliveryPeriod = roundDeliveryPeriod(mat);
			if (roundDeliveryPeriod == 0) {
				roundDeliveryPeriod = 1;
			}
			Double time = averageNeeds.get(mat) * roundDeliveryPeriod;
			times.put(mat, time);
		}

		return times;
	}

	private Integer roundDeliveryPeriod(Material mat) {
		Repository repo = Repository.getInstance();
		PeriodDate date = mat.getDeliveryTime().add(mat.getDeliveryAberation(),repo.getRiskPercente());

		if (date.getDay() < 3) {
			return date.getPeriod();
		} else {
			return (date.getPeriod() + 1);
		}
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

	private boolean newOrderRequired(Material mat) {
		Integer roundDeliveryPeriod = roundDeliveryPeriod(mat);
		if (mat.getAmount() < calculatedStock.get(mat).get(roundDeliveryPeriod)) {
			return false;
		}
		return true;
	}

	private Mode chooseOrderMode(Material mat) {
		Integer roundDeliveryPeriod = roundDeliveryPeriod(mat);
		if (calculatedStock.get(mat).get(roundDeliveryPeriod) < 0) {
			return Mode.EIL;
		}
		return Mode.NORMAL;

	}

	private Order calculateOrderSize(Material mat) {
		Integer resultAmount = null;
		Mode resultMode = null;

		if (newOrderRequired(mat)) {
			Mode mode = chooseOrderMode(mat);
			Integer roundDeliveryPeriod = 0;
			switch (mode) {
			case NORMAL:
				roundDeliveryPeriod = roundDeliveryPeriod(mat);
				resultMode = Mode.NORMAL;
				break;

			case EIL:
				roundDeliveryPeriod = (int) Math.floor(mat.getDeliveryTime()
						.getPeriod() / 2);
				resultMode = Mode.EIL;
				break;

			}
			resultAmount = (int) (timeMaterialCoverage.get(mat) - calculatedStock
					.get(mat).get(roundDeliveryPeriod));
		}
		Order result = new Order();
		result.setMaterial(mat);
		if (resultAmount != null && resultMode != null) {
			result.setAmount(resultAmount);
			result.setMode(resultMode.getMark());
		}
		return result;
	}

	public List<Order> ordering() {
		List<Order> result = new ArrayList<>();
		for (Material mat : purchaseGoods) {
			Order newOrder = calculateOrderSize(mat);
			if (newOrder.getAmount() > 0) {
				result.add(newOrder);
			}
		}
		return result;

	}
}
