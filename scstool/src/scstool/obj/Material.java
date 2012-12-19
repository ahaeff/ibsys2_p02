package scstool.obj;

import java.security.InvalidParameterException;

import scstool.utils.PeriodDate;

public class Material {
	
	/**
	 * @author reinhold
	 *
	 */
	public enum PartTypes{
		PRODUCT("P"),
		SUBASSEMBLY("E"),
		PURCHASE("K");
		
		/**
		 * the letter in the simulation to categorize the material
		 */
		private String mark;
		
		/**
		 * Constructor
		 * @param letter
		 */
		PartTypes(String letter){
			this.mark = letter;
		}
		/**
		 * @return the mark
		 */
		public String getMark() {
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
	private PeriodDate deliveryTime;
	/**
	 * the aberation of the delivery time
	 */
	private PeriodDate deliveryAberation;
	/**
	 * the costs of one order
	 */
	private Integer orderCosts;
	/**
	 * the discount amount for orders
	 */
	private Integer discountAmount;
	/**
	 *  "TeileVerwendung"
	 */
	private UsedIn usedIn;
	/**
	 * Menge im Lager bei Periode 0
	 */
	private Integer startamount;
	
	/**
	 * Menge im Lager der aktuellen(eingelesenen) Periode
	 */
	private Integer amount;
	
	/**
	 * Prozentuale Menge vom Startwert --> amount/startamount = pct
	 */
	private Double pct;
	
	/**
	 * Preis der aktuellen (eingelesenen) Periode
	 */
	private Double price;
	
	/**
	 * Preis der aktuellen (eingelesenen) Periode
	 */
	private Double stockvalue;
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
		if(partType.toUpperCase().equals(PartTypes.PRODUCT.getMark())){
			this.partType = PartTypes.PRODUCT;
		} else if(partType.toUpperCase().equals(PartTypes.PURCHASE.getMark())){
			this.partType = PartTypes.PURCHASE;
		}else if(partType.toUpperCase().equals(PartTypes.SUBASSEMBLY.getMark())){
			this.partType = PartTypes.SUBASSEMBLY;
		} else{
			throw new InvalidParameterException("Parameter must be p, e or k");
		}
	}

	/**
	 * @return the deliveryTime
	 */
	public PeriodDate getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(PeriodDate deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/**
	 * @return the deliveryAbberation
	 */
	public PeriodDate getDeliveryAberation() {
		return deliveryAberation;
	}
	/**
	 * @param deliveryAberation the deliveryAberation to set
	 */
	public void setDeliveryAberation(PeriodDate deliveryAberation) {
		this.deliveryAberation = deliveryAberation;
	}
	/**
	 * @return the orderCosts
	 */
	public Integer getOrderCosts() {
		return orderCosts;
	}
	/**
	 * @param orderCosts the orderCosts to set
	 */
	public void setOrderCosts(Integer orderCosts) {
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
	
	public Integer getStartamount() {
		return startamount;
	}
	public void setStartamount(Integer startamount) {
		this.startamount = startamount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getPct() {
		return pct;
	}
	public void setPct(Double pct) {
		this.pct = pct;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getStockvalue() {
		return stockvalue;
	}
	public void setStockvalue(Double stockvalue) {
		this.stockvalue = stockvalue;
	}

	
	/**
	 * @return the materialHistory
	 
	public List<MaterialHistory> getMaterialHistory() {
		return materialHistory;
	}
	/**
	 * @param materialHistory the materialHistory to set
	 
	public void setMaterialHistory(List<MaterialHistory> materialHistory) {
		this.materialHistory = materialHistory;
	}
	*/
	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", partType="
				+ partType + ", deliveryTime=" + deliveryTime
				+ ", deliveryAberation=" + deliveryAberation + ", orderCosts="
				+ orderCosts + ", discountAmount=" + discountAmount
				+ ", usedIn=" + usedIn + ", startamount=" + startamount
				+ ", amount=" + amount + ", pct=" + pct + ", price=" + price
				+ ", stockvalue=" + stockvalue + "]";
	}

	
}
