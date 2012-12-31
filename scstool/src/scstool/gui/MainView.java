package scstool.gui;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainView extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private MainMenu menu;
	
	public MainView()
	{
		init();		
	}
	
	private void init()
	{
		setSize(1024, 768);
		setTitle("SCS-Tool");

		//Noetig damit sich der GUI auch wirklich beendet
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.menu = new MainMenu();
		setJMenuBar(this.menu);
	
		
	}
	
	public void setMenuListener(ActionListener l)
	{
		menu.setMenuListener(l);
	}
	

}
