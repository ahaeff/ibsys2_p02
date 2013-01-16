package scstool.gui;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
	
		
		//Icon
		try {
			URL url = this.getClass().getResource("/logo16.png");
			Image image = ImageIO.read(url);
			setIconImage(image);
		} catch (IOException e) {
			throw new RuntimeException("Can't find Logo.");
		}



		
		
		
	}
	
	public void setMenuListener(ActionListener l)
	{
		menu.setMenuListener(l);
	}
	

}
