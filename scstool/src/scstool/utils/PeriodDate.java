/**
 * 
 */
package scstool.utils;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

/**
 * @author reinhold
 *
 */
public class PeriodDate {

	private static final int WORKDAYS = 5;
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
	
	public PeriodDate(Double period){
		super();
		this.setPeriod((int) MyMath.round(period,0,BigDecimal.ROUND_DOWN));
		int day2 = (int) MyMath.round(WORKDAYS*(period-this.period),2,BigDecimal.ROUND_HALF_UP);
		this.setDay(day2);
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
		if(day < 0 || day > 5) throw new InvalidParameterException("Must between 0 and 5");
		this.day = day;
	}

	/**
	 * Einem Datum ein anderes hinzuf�gen
	 * 
	 * @param toAdd
	 * @return
	 */
	public PeriodDate add(PeriodDate toAdd){
		int period = this.period+toAdd.period;
		int day = this.day+toAdd.day;
		return new PeriodDate(period, day);
	}
	
	/**
	 * Einem Datum ein anderes abziehen
	 * 
	 * @param toSub
	 * @return
	 */
	public PeriodDate sub(PeriodDate toSub){
		int period = this.period-toSub.period;
		int day = this.day-toSub.day;
		return new PeriodDate(period, day);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  period + "-" + day + "-0";
	}
	
}
