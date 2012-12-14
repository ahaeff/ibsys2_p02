/**
 * 
 */
package scstool.utils;

import java.math.BigDecimal;

/**
 * Container für mathematische Funktionen.
 * Nur static erlaubt :D
 * 
 * @author reinhold
 *
 */
public class MyMath {

	/**
	 * Eine Rundungsfunktion
	 * 
	 * @param unrounded die ungerundete Zahl
	 * @param precision die Genauigkeit 
	 * @param roundingMode die Rundungsmethoden in BigDecimal
	 * @return
	 */
	public static double round(double unrounded, int precision, int roundingMode)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
}
