/**
 * 
 */
package scstool.obj;

import scstool.utils.PeriodDate;

/**
 * @author reinhold
 *
 */
public class Order {

	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the excpected delivery date
	 */
	private PeriodDate deliveryDate;
	/**
	 * the order date
	 */
	private PeriodDate orderDate;
	/**
	 * the amout of material
	 */
	private Integer amount;
	/**
	 * is order finished
	 */
	private boolean finished;
	/**
	 * the material ordered
	 */
	private Material material;
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
	 * @return the deliveryDate
	 */
	public PeriodDate getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(PeriodDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * @return the orderDate
	 */
	public PeriodDate getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(PeriodDate orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
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
