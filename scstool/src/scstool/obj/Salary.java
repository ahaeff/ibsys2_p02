/**
 * 
 */
package scstool.obj;

/**
 * @author reinhold
 *
 */
public class Salary {
	
	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * TODO what is this?
	 */
	private String description;
	/**
	 * the amount of the salary
	 */
	private Double amount;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Salary [id=" + id + ", description=" + description
				+ ", amount=" + amount + "]";
	}
	

}
