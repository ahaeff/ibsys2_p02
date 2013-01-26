/**
 * 
 */
package scstool.proc;

/**
 * @author reinhold
 *
 */
public class StatusSingleton {

	
	
	private static StatusSingleton entity = null;
	private boolean inputXmlLoaded = false;
	private boolean sellwischOk = false;
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
		return sellwischOk;
	}

	public void setSellwischOk(boolean sellwischOk) {
		this.sellwischOk = sellwischOk;
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
	
	
}
