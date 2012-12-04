package scstool.obj;

/**
 * @author reinhold
 *
 */
class MaterialHistory{
	
	/**
	 * the unique id
	 */
	private Integer id;
	/**
	 * the period
	 */
	private Integer period;
	/**
	 * the price
	 */
	private Double price;
	/**
	 * the amount
	 */
	private Integer amount;
	/**
	 * the material
	 */
	private Material material;
	
	/**
	 * Default Constructor
	 * 
	 * @param period
	 * @param price
	 * @param amount
	 */
	public MaterialHistory(Integer period, Double price, Integer amount) {
		super();
		this.period = period;
		this.price = price;
		this.amount = amount;
	}

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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
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
}