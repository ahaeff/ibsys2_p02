/**
 * 
 */
package scstool.proc;

import scstool.obj.SellWish;

/**
 * @author reinhold
 *
 */
public class StatusSingleton {

	
	
	private static StatusSingleton entity = null;
	private boolean inputXmlLoaded = false;
	private boolean sellwishOk = false;
	private boolean safetyStockOk = false;
	private boolean riskOk = false;
	private StatusSingleton() {
		super();
	}
	
	/**
	 * Singleton Klasse 
	 * 
	 * @return das {@link DatabaseContentHandler} objekt
	 */
	public static StatusSingleton get() {
		if (entity == null)
			entity = new StatusSingleton();
		return entity;
	}

	/**
	 * @return the inputXmlLoaded
	 */
	public boolean isInputXmlLoaded() {
		return inputXmlLoaded;
	}

	/**
	 * @param inputXmlLoaded the inputXmlLoaded to set
	 */
	public void setInputXmlLoaded(boolean inputXmlLoaded) {
		this.inputXmlLoaded = inputXmlLoaded;
	}

	public boolean isSellwischOk() {
		return sellwishOk;
	}

	public void setSellwischOk(boolean sellwischOk) {
		this.sellwishOk = sellwischOk;
	}

	public boolean isSafetyStockOk() {
		return safetyStockOk;
	}

	public void setSafetyStockOk(boolean safetyStockOk) {
		this.safetyStockOk = safetyStockOk;
	}

	public boolean isRiskOk() {
		return riskOk;
	}

	public void setRiskOk(boolean riskOk) {
		this.riskOk = riskOk;
	}
	
	public boolean isInputSet()
	{
		if(!sellwishOk)
		{
			return false;
		}
		if(!safetyStockOk)
		{
			return false;
		}
		if(!riskOk)
		{
			return false;
		}
		return true;
	}
	public void resetAll()
	{
		inputXmlLoaded = false;
		sellwishOk = false;
		safetyStockOk = false;
		riskOk = false;
	}
}
