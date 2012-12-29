package scstool.obj;

/**
 * @author haeff
 *
 * Stellt den Produktionswunsch und Prognose pro Produkt dar
 *
 */
public class ProductionProg 
{
	//Produkt 1,2 oder 3
	private int p;
	
	// Absatz + Prognose Zahlen in den Perioden n,n+1,n+2...
	private int n;
	private int n1;
	private int n2;
	private int n3;
		
	public ProductionProg(int p, int n, int n1, int n2, int n3) 
	{
		super();
		this.p = p;
		this.n = n;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
	
	public int getP() 
	{
		return p;
	}
	
	public void setP(int p) 
	{
		this.n = p;
	}
		
	public int getN() 
	{
		return n;
	}
	
	public void setN(int n) 
	{
		this.n = n;
	}
	
	public int getN1() 
	{
		return n1;
	}
	
	public void setN1(int n1) 
	{
		this.n1 = n1;
	}
	
	public int getN2() {
		return n2;
	}
	
	public void setN2(int n2) 
	{
		this.n2 = n2;
	}
	
	public int getN3() 
	{
		return n3;
	}
	
	public void setN3(int n3) 
	{
		this.n3 = n3;
	}
	
	
	
	

	
	
}
