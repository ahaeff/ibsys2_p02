/**
 * 
 */
package scstool.utils;

/**
 * @author reinhold
 *
 */
public class PeriodDate {

	/**
	 * the period
	 */
	private Integer period;
	/**
	 * the day in the period
	 * could be 1-5
	 */
	private Integer day;
	/**
	 * @param period
	 * @param day
	 */
	public PeriodDate(Integer period, Integer day) {
		super();
		this.period = period;
		this.day = day;
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
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(Integer day) {
		this.day = day;
	}
	
}
