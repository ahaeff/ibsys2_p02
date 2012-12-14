package scstool.obj;

import java.security.InvalidParameterException;
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
	
	public enum UsedIn{
		KINDER("K"),
		HERREN("H"),
		DAMEN("D"),
		ALLE("KDH");
		
		
		/**
		 * the letter in the simulation to categorize the material
		 */
		private String mark;
		
		/**
		 * Constructor
		 * @param letter
		 */
		UsedIn(String letter){
			this.mark = letter;
		}
		/**
		 * @return the mark
		 */
		public String getMark() {
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
	 * the marker where the material is used
	 */
	private UsedIn usedIn;
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
	 * @param partType a String with value p, e or k
	 */
	public void setPartType(String partType) {
		if(partType.length() > 1) throw new InvalidParameterException("Parameter must be p, e or k");
		if(partType.toLowerCase().equals(PartTypes.PRODUCT.getMark())){
			this.partType = PartTypes.PRODUCT;
		} else if(partType.toLowerCase().equals(PartTypes.PURCHASE.getMark())){
			this.partType = PartTypes.PURCHASE;
		}else if(partType.toLowerCase().equals(PartTypes.SUBASSEMBLY.getMark())){
			this.partType = PartTypes.SUBASSEMBLY;
		} else{
			throw new InvalidParameterException("Parameter must be p, e or k");
		}
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
	public UsedIn getUsedIn() {
		return usedIn;
	}
	/**
	 * @param used the used to set
	 */
	public void setUsedIn(String used) {
		if(used.toUpperCase().equals(UsedIn.ALLE.getMark())){
			this.usedIn = UsedIn.ALLE;
		} else if(used.toUpperCase().equals(UsedIn.DAMEN.getMark())){
			this.usedIn = UsedIn.DAMEN;
		}else if(used.toUpperCase().equals(UsedIn.HERREN.getMark())){
			this.usedIn =UsedIn.HERREN;
		}else if(used.toUpperCase().equals(UsedIn.KINDER.getMark())){
			this.usedIn =UsedIn.KINDER;
		} else{
			throw new InvalidParameterException("Parameter must be  k, d, h or kdh");
		}
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
