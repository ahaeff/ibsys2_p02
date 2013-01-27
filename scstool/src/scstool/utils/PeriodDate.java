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
	 * the day in the period could be 1-5
	 */
	private Integer day;
	
	private Double inFloat;

	/**
	 * @param period
	 * @param day
	 */
	public PeriodDate(Integer period, Integer day) {
		super();
		this.setPeriod(period);
		this.setDay(day);
	}

	public PeriodDate(Double period) {
		super();
		inFloat = period;
		this.setPeriod((int) MyMath.round(period, 0, BigDecimal.ROUND_DOWN));
		int day2 = (int) MyMath.round(WORKDAYS * (period - this.period), 0,BigDecimal.ROUND_HALF_UP);
		Double dayDouble = (period - this.period);
		
		if(dayDouble >= 0.8){
			day2 = 5;
		}	
		this.setDay(day2);
	}

	/**
	 * @return the period
	 */
	public Integer getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
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
	 * @param day
	 *            the day to set
	 */
	public void setDay(Integer day) {
		if (day < 0 || day > 5)
			throw new InvalidParameterException("Must between 0 and 5");
		this.day = day;
	}

	/**
	 * Einem Datum ein anderes hinzufügen
	 * 
	 * @param toAdd
	 * @return
	 */
	public PeriodDate add(PeriodDate toAdd) {
		if(toAdd==null){
			return new PeriodDate(0.0);
		}
		int period = this.period + toAdd.period;
		int day = this.day + toAdd.day;
		while (day > 5) {
			if (day > 5) {
				period++;
				day = day - 5;
			}
		}
		return new PeriodDate(period, day);
	}
	
	/**
	 * Einem Datum ein anderes hinzufügen
	 * 
	 * @param toAdd
	 * @param risk
	 * @return
	 */
	public PeriodDate add(PeriodDate toAdd, Integer risk) {
		Double r = (new Double(risk)/100);
		int period = (int) ((this.period + (toAdd.getPeriod()*r)));
		int day = (int) ((this.day + (toAdd.getDay()*r)));
		while (day > 5) {
			if (day > 5) {
				period++;
				day = day - 5;
			}
		}
		return new PeriodDate(period, day);
	}
	
	public static void main(String[] args) {
		PeriodDate p1 = new PeriodDate(1.7).add(new PeriodDate(0.4), 50);
		PeriodDate p2 = new PeriodDate(1.8).add(new PeriodDate(0.4), 50);
		PeriodDate base = new PeriodDate(1.8);
		PeriodDate add = new PeriodDate(0.4);
		PeriodDate p3 = base.add(add, 50);
		System.out.println();
	}

	/**
	 * Einem Datum ein anderes abziehen
	 * 
	 * @param toSub
	 * @return
	 */
	public PeriodDate sub(PeriodDate toSub) {
		int period = this.period - toSub.period;
		int day = this.day - toSub.day;
		if(day<0){
			period--;
			day += 5;
		}
		if(period < 0){
			throw new InvalidParameterException("result negativ");
		}
		return new PeriodDate(period, day);
	}
	
	public PeriodDate half(){
		Double period = new Double(this.period)/2;
		Double day = new Double(this.day)/2/5;
		return new PeriodDate(period+day);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return period + "-" + day + "-0";
	}

}
