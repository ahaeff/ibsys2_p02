package scstool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * 
 * Hier soll das Verhalten des GUI gesteuert werden
 * 
 * @author haeff
 *
 */
public class GuiManager{

	
	private JFrame mainWindow;
	private JMenuBar menuBar;
	private static GuiManager instance;
	
	private GuiManager()
	{
		mainWindow = new MainWindow();
		menuBar = new MenuBar();
		mainWindow.setJMenuBar(menuBar);
	}
	
	public static GuiManager getInstance(){
		if(instance == null)
		{
			instance = new GuiManager();
		}
		return instance;
	}
	
	
	public JFrame getMainWindow()
	{
		return mainWindow;
	}



	
	

}
