package scstool.utils;

import java.util.HashMap;
import java.util.Map;


import scstool.obj.SellWish;

/**
 * @author haeff
 *
 *	Dient als Repository aller Daten
 */
public class Repository 
{
	private static Repository instance;
	
	/** Produktionsprgramm und Prognosen*/
	private static Map<Integer,SellWish> sellwish;
	//<matnr,menge>
	private static Map<Integer,Integer> safetyStock;
	
	
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
	}
	
	public Map<Integer, Integer> getStafetyStockAll()
	{
		return safetyStock;
	}
	
	public int getStafetyStock(int key)
	{
		return safetyStock.get(key);
	}
	
	public void setSafetyStock(int key, int value)
	{
		safetyStock.put(key, value);
	}
	
	/**
	 * Liefert ein Objekt Sellwish fuer ein Produkt zurueck
	 * @param Produkt (1,2 oder 3)
	 * @return
	 */
	public SellWish getSellWish(int key)
	{
		return  sellwish.get(key);
	}
	
	
	public Map<Integer,SellWish> getSellWishAll() 
	{
		return sellwish;
	}

	
	
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
}
