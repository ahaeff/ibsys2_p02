
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
	 * WaitingList Workplace (last period)
	 */
	private List<WaitingList> waitingList = new ArrayList<WaitingList>();

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
	
	public List<WaitingList> getWaitingList() {
		return waitingList;
	}
	public void setWaitingList(List<WaitingList> wl) {
		this.waitingList = wl;
	}
	
	public void addWaitingList(WaitingList wl) {
		this.waitingList.add(wl);
	}

	@Override
	public String toString() {
		return "Workplace [id=" + id + ", workplan=" + workplan + ", Waitinglist=" + waitingList + "]";
	}
	
	public boolean isComponentMadeHere(Material mat){
		for(WorkPlan plan : workplan){
			for(BillOfMaterial bom : plan.getBillOfMaterial()){
				if(bom.getComponent().getId()==mat.getId()){
					return true;
				}
			}
		}
		
		return false;
	}

}
