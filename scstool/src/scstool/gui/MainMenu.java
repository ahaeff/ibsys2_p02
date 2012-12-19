package scstool.gui;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
    private ActionListener lissi;
    
    public static final String MENU_IMPORTXML = "IMPORTXML";
    public static final String MENU_EXIT = "EXIT";
    public static final String MENU_USER_INPUT = "USERINPUT";
    
    public MainMenu(ActionListener lissi)
	{
		this.lissi = lissi;
		init();
		
		add(file);
		
		
	}
	
	
	private void init()
	{
		menuitems = new HashMap<>();
		
		JMenuItem mitem = new  JMenuItem(Dic.getValue("menu.1.1","Import XML"));
		mitem.addActionListener(lissi);
		menuitems.put(MENU_IMPORTXML, mitem);
		
		mitem = new  JMenuItem(Dic.getValue("menu.1.2","User Input"));
		mitem.addActionListener(lissi);
		menuitems.put(MENU_USER_INPUT, mitem);
		
		mitem = new  JMenuItem(Dic.getValue("menu.1.5","Exit"));
		mitem.addActionListener(lissi);
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
	
}
