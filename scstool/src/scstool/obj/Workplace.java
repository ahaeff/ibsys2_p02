/**
 * 
 */
package scstool.obj;

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

}
