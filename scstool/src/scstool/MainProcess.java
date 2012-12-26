package scstool;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import scstool.proc.GuiController;

public class MainProcess {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) 
		{
	
			e.printStackTrace();
		}
		
		//GuiManager.getInstance();
		GuiController controller = new GuiController();
		controller.showView();
		
	}

}
