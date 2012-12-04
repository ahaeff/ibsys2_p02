/**
 * 
 */
package scstool.obj;

/**
 * @author reinhold
 *
 */
public class ProductionOrder {
	
	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the period where it was proceed
	 */
	private Integer period;
	/**
	 * the batch size
	 */
	private Integer batch;
	/**
	 * the whole amount
	 */
	private Integer amount;
	/**
	 * the time needed to process
	 */
	private Integer timeNeed;
	/**
	 * indicator of status
	 */
	private boolean finished;
	/**
	 * the material to process
	 */
	private Material material;
	/**
	 * the workplace
	 */
	private Workplace workplace;
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
	 * @return the period
	 */
	public Integer getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(Integer period) {
		this.period = period;
	}
	/**
	 * @return the batch
	 */
	public Integer getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * @return the timeNeed
	 */
	public Integer getTimeNeed() {
		return timeNeed;
	}
	/**
	 * @param timeNeed the timeNeed to set
	 */
	public void setTimeNeed(Integer timeNeed) {
		this.timeNeed = timeNeed;
	}
	/**
	 * @return the finished
	 */
	public boolean isFinished() {
		return finished;
	}
	/**
	 * @param finished the finished to set
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
