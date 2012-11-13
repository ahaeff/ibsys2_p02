package scstool.utils;

import java.util.ResourceBundle;

/**
 * @author haeff
 *
 */
public final class Dic {

	private final static String DEFAULT_VALUE = "<VALUE>";
	
	/**
	 * Liefert einen Nachrichtentext entsprechend dem key
	 * 
	 * @param key: Key des Nachrichttextes
	 * @return
	 */
	public static String getValue(String key) {
		return getValue(key, DEFAULT_VALUE);
	}
	
	/**
	 * Liefert einen Nachrichtentext entsprechend dem key
	 * 
	 * @param key: Key des Nachrichttextes
	 * @param def: Standardwert, wird gezogen wenn der Key nicht gefunden wurde
	 * @return
	 */
	public static String getValue(String key, String def) {
		ResourceBundle res = Preference.getInstance().getMessageBundle("dic");
		if (res != null) {
			if (res.containsKey(key) && !res.getString(key).isEmpty()) {
				return res.getString(key);
			} else {
				return def;
			}
		}
		return def;
	}
}
