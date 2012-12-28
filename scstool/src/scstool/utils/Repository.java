package scstool.utils;

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
	private static Vector<ProductionProg> prodProg;

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
		prodProg = new Vector<ProductionProg>();
		prodProg.add(new ProductionProg(0, 0, 0, 0));
		prodProg.add(new ProductionProg(0, 0, 0, 0));
		prodProg.add(new ProductionProg(0, 0, 0, 0));
	}
	
	
	public Vector<ProductionProg> getProdProg() 
	{
		return prodProg;
	}

	public void setProdProg(Vector<ProductionProg> p) 
	{
		prodProg = p;
	}
	
}
