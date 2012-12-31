package scstool.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import scstool.obj.ProductionProg;

/**
 * @author haeff
 *
 *	Dient als Repository aller Daten
 */
public class Repository 
{
	private static Repository instance;
	
	/** Produktionsprgramm und Prognosen*/
	private static Map<Integer,ProductionProg> prodProg;

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
		prodProg = new HashMap<Integer,ProductionProg>();
		prodProg.put(1,new ProductionProg(1, 0, 0, 0, 0));
		prodProg.put(2,new ProductionProg(2, 0, 0, 0, 0));
		prodProg.put(3,new ProductionProg(3, 0, 0, 0, 0));
	}
	
	
	public Map<Integer,ProductionProg> getProdProg() 
	{
		return prodProg;
	}

/*	public void setProdProg(Vector<ProductionProg> p) 
	{
		//prodProg = p;
	}*/
	
	public void setProdProg(int product, int periode, int value)
	{
		ProductionProg p = prodProg.get(product);
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
