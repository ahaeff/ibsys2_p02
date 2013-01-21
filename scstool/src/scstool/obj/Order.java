/**
 * 
 */
package scstool.obj;

import java.security.InvalidParameterException;

import scstool.utils.PeriodDate;

/**
 * @author reinhold
 *
 */
public class Order {

	public enum Mode{
		NORMAL(5),
		EIL(4);
		
		/**
		 * the letter in the simulation to categorize the ordermode
		 */
		private Integer mark;
		
		/**
		 * Constructor
		 * @param letter
		 */
		Mode(Integer letter){
			this.mark = letter;
		}
		/**
		 * @return the mark
		 */
		public Integer getMark() {
			return mark;
		}
	}

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
	
	private Double ordercosts;
	
	private Double piececosts;
	
	private Double entirecosts;
	
	private Mode mode;
	
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
	public Double getOrdercosts() {
		return ordercosts;
	}
	public void setOrdercosts(Double ordercosts) {
		this.ordercosts = ordercosts;
	}
	public Double getPiececosts() {
		return piececosts;
	}
	public void setPiececosts(Double piececosts) {
		this.piececosts = piececosts;
	}
	public Double getEntirecosts() {
		return entirecosts;
	}
	public void setEntirecosts(Double entirecosts) {
		this.entirecosts = entirecosts;
	}
	
	/**
	 * @param name the name to set
	 */	
	public void setMode(Integer mode) {
		//if(mode.length() > 1) throw new InvalidParameterException("Parameter must be p, e or k");
		if(mode.equals(Mode.NORMAL.getMark())){
			this.mode = Mode.NORMAL;
		} else if(mode.equals(Mode.EIL.getMark())){
			this.mode = Mode.EIL;
		} else{
			throw new InvalidParameterException("Parameter must be 4 or 5");
		}
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", finished="
				+ finished + ", mode=" + mode + ", ordercosts="
				+ ordercosts + ", piececosts=" + piececosts + ", entirecosts="
				+ entirecosts + ", material=" + material + "]";
	}
	/**
	 * @return the partType
	*/
	public Mode getMode() {
		return mode;
	}
	/**
	 *  orderperiod (in welcher Periode kommt der Artikel)
	 *  mode (bestelltyp, Eil/Normal)
	 *  article (material)
	 *  amount (menge)
	 *  time	(zeitstempel --> Wochentag) -->Lieferdatum
	 *  materialcosts (kosten f���r das Material)
	 *  ordercosts (bestellkosten)
	 *  entirecosts (bestellkosten gesamt)
	 *  piececosts (st���ckkosten)
	 *  -----------------------------------------------------
	 *  Lieferdatum 		--> time
	 *  bestelldatum		--> not
	 *  menge				--> amount
	 *  beendet				--> not
	 *  bestellart			--> mode
	 *  Artikel_ID			--> article
	 *  
	 */
	

	/**
	 * Berechnet den Lieferzeitpunkt
	 * 
	 * @return der Lieferzeitpunkt als PeriodDate
	 */
	public PeriodDate calculateDeliveryDate() {
		// ordered material
		Material mat = this.material;
		// materiallieferzeit + abweichung
		// TODO Risiko miteinberechnen
		PeriodDate deliveryTime = mat.getDeliveryTime().add(mat.getDeliveryAberation());
		return this.orderDate.add(deliveryTime);
	}

	
}
