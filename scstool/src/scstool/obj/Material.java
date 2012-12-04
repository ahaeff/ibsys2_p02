package scstool.obj;

import java.util.List;

public class Material {
	
	/**
	 * @author reinhold
	 *
	 */
	public enum PartTypes{
		PRODUCT('p'),
		SUBASSEMBLY('e'),
		PURCHASE('k');
		
		/**
		 * the letter in the simulation to categorize the material
		 */
		private char mark;
		
		/**
		 * Constructor
		 * @param letter
		 */
		PartTypes(char letter){
			this.mark = letter;
		}
		/**
		 * @return the mark
		 */
		public char getMark() {
			return mark;
		}
	}
	
	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the name of the material
	 */
	private String name;
	/**
	 * the type of the material
	 */
	private PartTypes partType;
	/**
	 * the delivery time of the material
	 */
	private Double deliveryTime;
	/**
	 * the abberation of the delivery time
	 */
	private Double deliveryAbberation;
	/**
	 * the costs of one order
	 */
	private Double orderCosts;
	/**
	 * the discount amount for orders
	 */
	private Integer discountAmount;
	/**
	 * TODO wie soll das gelšst werden?
	 */
	private String usedIn;
	/**
	 * the material history to check the amount in the stock
	 */
	private List<MaterialHistory> materialHistory;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the partType
	 */
	public PartTypes getPartType() {
		return partType;
	}
	/**
	 * @param partType the partType to set
	 */
	public void setPartType(PartTypes partType) {
		this.partType = partType;
	}
	/**
	 * @return the deliveryTime
	 */
	public Double getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(Double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/**
	 * @return the deliveryAbberation
	 */
	public Double getDeliveryAbberation() {
		return deliveryAbberation;
	}
	/**
	 * @param deliveryAbberation the deliveryAbberation to set
	 */
	public void setDeliveryAbberation(Double deliveryAbberation) {
		this.deliveryAbberation = deliveryAbberation;
	}
	/**
	 * @return the orderCosts
	 */
	public Double getOrderCosts() {
		return orderCosts;
	}
	/**
	 * @param orderCosts the orderCosts to set
	 */
	public void setOrderCosts(Double orderCosts) {
		this.orderCosts = orderCosts;
	}
	/**
	 * @return the discountAmount
	 */
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}
	/**
	 * @return the used
	 */
	public String getUsed() {
		return usedIn;
	}
	/**
	 * @param used the used to set
	 */
	public void setUsed(String used) {
		this.usedIn = used;
	}
	/**
	 * @return the materialHistory
	 */
	public List<MaterialHistory> getMaterialHistory() {
		return materialHistory;
	}
	/**
	 * @param materialHistory the materialHistory to set
	 */
	public void setMaterialHistory(List<MaterialHistory> materialHistory) {
		this.materialHistory = materialHistory;
	}
	
	
	
}
