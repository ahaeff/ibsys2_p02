/**
 * 
 */
package scstool.obj;

import java.util.ArrayList;
import java.util.List;

import scstool.obj.BillOfMaterial;

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
	
	private List<BillOfMaterial> billOfMaterial = new ArrayList<BillOfMaterial>();
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
	public List<BillOfMaterial> getBillOfMaterial() {
		return billOfMaterial;
	}
	public void setBillsOfMaterial(ArrayList<BillOfMaterial> billOfMaterial) {
		this.billOfMaterial = billOfMaterial;
	}
	
	public void addBoM(BillOfMaterial billOfMaterial){
		this.billOfMaterial.add(billOfMaterial);
	}
	@Override
	public String toString() {
		return "WorkPlan [id=" + id + ", setupTime=" + setupTime
				+ ", productionTime=" + productionTime + ", billOfMaterial="
				+ billOfMaterial + "]";
	}
	
}