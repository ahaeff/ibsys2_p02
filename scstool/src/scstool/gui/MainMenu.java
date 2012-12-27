package scstool.gui;

import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import scstool.utils.Dic;

public class MainMenu extends JMenuBar{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu file;
    
    private Map<String,JMenuItem> menuitems;
    private ActionListener mnuListener;
    
    public static final String MENU_IMPORTXML = "IMPORTXML";
    public static final String MENU_EXIT = "EXIT";
    public static final String MENU_USER_INPUT = "USERINPUT";
    
    public MainMenu()
    {
    	init();
    	add(file);
    }
	
	private void init()
	{
		menuitems = new HashMap<>();
		
		JMenuItem mitem = new  JMenuItem(Dic.getValue("menu.1.1","Import XML"));
		mitem.setActionCommand(MENU_IMPORTXML);
		mitem.addActionListener(mnuListener);
		menuitems.put(MENU_IMPORTXML, mitem);
		

		mitem = new  JMenuItem(Dic.getValue("menu.1.2","User Input"));
		mitem.setActionCommand(MENU_USER_INPUT);
		mitem.addActionListener(mnuListener);
		menuitems.put(MENU_USER_INPUT, mitem);
		
		mitem = new  JMenuItem(Dic.getValue("menu.1.5","Exit"));
		mitem.setActionCommand(MENU_EXIT);
		mitem.addActionListener(mnuListener);
		menuitems.put(MENU_EXIT, mitem);
		
		
		//Menus bauen
		//Menu Datei
		file = new JMenu(Dic.getValue("menu.1", "File"));
		file.add(menuitems.get(MENU_IMPORTXML));
		file.add(menuitems.get(MENU_USER_INPUT));
		file.add(menuitems.get(MENU_EXIT));	
	}
	
	
	public JMenuItem getMenuItem(String key)
	{
		JMenuItem item = new JMenuItem();
		if(!"".equals(key) && key != null)
		{
			item = menuitems.get(key);
		}
		return item;
	}
	
	public void setMenuListener(ActionListener l)
	{
		this.mnuListener = l;

		for(String key : menuitems.keySet())
		{
			menuitems.get(key).addActionListener(l);	
		}	
	}
	
}
