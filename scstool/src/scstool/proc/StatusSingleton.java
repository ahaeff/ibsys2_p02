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
	
}
