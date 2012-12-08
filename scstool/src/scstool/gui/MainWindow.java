package scstool.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import scstool.utils.Dic;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MainWindow()
	{
		setSize(1024, 768);
		setTitle("SCS-Tool");
		
		//Noetig damit sich der GUI auch wirklich beendet
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		
		setJMenuBar(new MenuBar());

		
		
		this.setVisible(true);
		
	}
	
	private void init()
	{
		
		
		
	}
	
	
}
