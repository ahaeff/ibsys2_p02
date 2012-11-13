package scstool.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Preference {

	private static Preference instance;
	private HashMap<String, ResourceBundle> map;
	
	
	private Preference() {
		map = new HashMap<String, ResourceBundle>();
		init();
	}
	
	public static Preference getInstance(){
		if(instance == null)
		{
			instance = new Preference();
		}
		return instance;
	}
	
	private void init()
	{
		loadPref("config");
		loadPref("dic", getLocale());
		
	}
	
	private Locale getLocale()
	{
		String language = map.get("config").getString("language");
		String country = map.get("config").getString("country");
		if(language.isEmpty() || country.isEmpty())
		{
			return new Locale("de","DE");
		} 
		return new Locale(language,country);
	}
	
	private void loadPref(String url, Locale locale)
	{
		
		ResourceBundle res = ResourceBundle.getBundle(url,locale);
		map.put(url, res);
	}
	
	private void loadPref(String url )
	{
		ResourceBundle res = ResourceBundle.getBundle(url);
		map.put(url, res);
		
	}
	
	
	public ResourceBundle getMessageBundle(String key)
	{
		return map.get(key);
	}

}