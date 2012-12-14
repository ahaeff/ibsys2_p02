/**
 * 
 */
package scstool.obj;

import java.util.List;

/**
 * @author reinhold
 *
 */
public class WorkPlan {

	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the setup time
	 */
	private Integer setupTime;
	/**
	 * the prodcution time
	 */
	private Integer productionTime;
	
	private List<BillOfMaterial> billsOfMaterial;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the setupTime
	 */
	public Integer getSetupTime() {
		return setupTime;
	}
	/**
	 * @param setupTime the setupTime to set
	 */
	public void setSetupTime(Integer setupTime) {
		this.setupTime = setupTime;
	}
	/**
	 * @return the productionTime
	 */
	public Integer getProductionTime() {
		return productionTime;
	}
	/**
	 * @param productionTime the productionTime to set
	 */
	public void setProductionTime(Integer productionTime) {
		this.productionTime = productionTime;
	}
}
