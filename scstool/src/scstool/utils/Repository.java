package scstool.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import scstool.obj.Order;
import scstool.obj.SellWish;
import scstool.obj.WaitingList;
import scstool.proc.InputContentHandler;

/**
 * @author haeff
 *
 *	Dient als Repository aller Daten
 */
public class Repository 
{	
	private static Repository instance;
	
	// Produktionsprgramm und Prognosen
	private static Map<Integer,SellWish> sellwish;
	//Sticherheitsbestand <matnr,menge>
	private static Map<Integer,Integer> safetyStock;
	// Integer[0] ist das Material und Integer[1] für die Menge
	private static List<Integer[]> productionProgram;
	// die angekommenen Bestellungen
	private static List<Order> arrivals;
	// die Bestellungen die noch ausstehen
	private static List<Order> futureArrivals;
	
	private static List<WaitingList> inWork;
	private static List<WaitingList> waiting;
	
	
	public static Repository getInstance()
	{
		if(instance == null)
		{
			instance = new Repository();
			init();
		}
		return instance;
	}
	
	private static void init()
	{
		sellwish = new HashMap<Integer,SellWish>();
		sellwish.put(1,new SellWish(1, 0, 0, 0, 0));
		sellwish.put(2,new SellWish(2, 0, 0, 0, 0));
		sellwish.put(3,new SellWish(3, 0, 0, 0, 0));
		
		safetyStock = new HashMap<Integer,Integer>();
		productionProgram = new LinkedList<>();

	}
	
	/**
	 * Liefert den kompletten Sicherheitsbestand als Map
	 * 
	 * @return Sicherheitsbestand
	 */
	public Map<Integer, Integer> getStafetyStockAll()
	{
		return safetyStock;
	}
	
	
	/**
	 * Liefert die Menge des Sicherheitsbestand fuer ein Material
	 * 
	 * @param Materialnummer
	 * @return Menge
	 */
	public int getStafetyStock(int key)
	{
		return safetyStock.get(key);
	}
	
	
	/**
	 * Setzt den Sicherheitsbestand
	 * 
	 * @param Materialnummer
	 * @param Menge
	 */
	public void setSafetyStock(int key, int value)
	{
		safetyStock.put(key, value);
	}
	
	/**
	 * Liefert ein Objekt Sellwish fuer ein Produkt zurueck
	 * 
	 * @param Produkt (1,2 oder 3)
	 * @return Sellwish
	 */
	public SellWish getSellWish(int key)
	{
		return  sellwish.get(key);
	}
	
	
	/**
	 * Liefert den kompletten Vertriebswunsch als Map zurueck
	 * 
	 * @return
	 */
	public Map<Integer,SellWish> getSellWishAll() 
	{
		return sellwish;
	}

	
	
	/**
	 * Setzt den Vertriebswunsch pro Periode
	 * 
	 * @param Materialnummer
	 * @param Periode
	 * @param Menge
	 */
	public void setSellWish(int product, int periode, int value)
	{
		SellWish p = sellwish.get(product);
		switch(periode)
		{
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
	}
	
	/**
	 * @return Integer der Menge, eines Artikels, dass noch in Bearbeitung ist (Auftr�ge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getAmountOfMaterialInWork(Integer materialID){
				
		for(WaitingList wl : inWork) 
		{
			if (wl.getMaterial().getId().equals(materialID)){
				materialID = wl.getAmount();	
			}
		}

		return materialID;
	}
	
	/**
	 * @return Material, dass noch in der Warteschlange ist (Auftr�ge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getAmountOfWaitingMaterial(Integer materialID){
		
		for(WaitingList wl : waiting) 
		{
			if (wl.getMaterial().getId().equals(materialID)){
				materialID = wl.getAmount();	
			}
		}
		return materialID;
	}
}
