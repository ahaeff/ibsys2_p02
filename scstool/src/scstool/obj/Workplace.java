/**
 * 
 */
package scstool.obj;

import java.util.ArrayList;
import java.util.List;

import scstool.obj.WorkPlan;

/**
 * @author reinhold
 *
 */
public class Workplace {
	
	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the description of the workplace
	 */
	private String descripton;
	/**
	 * the variable machine costs
	 */
	private Double varMachineCosts;
	/**
	 * the fixed machine costs
	 */
	private Double fixMachineCosts;
	
	private List<WorkPlan> workplan = new ArrayList<WorkPlan>();

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
	 * @return the descripton
	 */
	public String getDescripton() {
		return descripton;
	}
	/**
	 * @param descripton the descripton to set
	 */
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	/**
	 * @return the varMachineCosts
	 */
	public Double getVarMachineCosts() {
		return varMachineCosts;
	}
	/**
	 * @param varMachineCosts the varMachineCosts to set
	 */
	public void setVarMachineCosts(Double varMachineCosts) {
		this.varMachineCosts = varMachineCosts;
	}
	/**
	 * @return the fixMachineCosts
	 */
	public Double getFixMachineCosts() {
		return fixMachineCosts;
	}
	/**
	 * @param fixMachineCosts the fixMachineCosts to set
	 */
	public void setFixMachineCosts(Double fixMachineCosts) {
		this.fixMachineCosts = fixMachineCosts;
	}
	public List<WorkPlan> getWorkplan() {
		return workplan;
	}
	public void setWorkplan(ArrayList<WorkPlan> workplan) {
		this.workplan = workplan;
	}
	
	public void addWorkplan(WorkPlan workplan) {
		this.workplan.add(workplan);
	}
	
	@Override
	public String toString() {
		return "Workplace [id=" + id + ", workplan=" + workplan + "]";
	}

}
