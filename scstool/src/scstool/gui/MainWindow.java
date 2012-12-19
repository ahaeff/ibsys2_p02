package scstool.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel content;
	
	public MainWindow()
	{
		setSize(1024, 768);
		setTitle("SCS-Tool");
		
		//Noetig damit sich der GUI auch wirklich beendet
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		content = new JPanel();
		add(content);
	}
	
	public void clear()
	{
		content.removeAll();
	}
	

	public void addContent(JComponent c)
	{
		content.add(c);
	}
	
	
	
	

}
