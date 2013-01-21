package scstool.gui;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainView extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private MainMenu menu;
	
	private JLabel lbl_img;
	
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
		
		//Icon / Bild
		URL url;
		Image image;
		try {
			url= this.getClass().getResource("/icon/logo.png");
			image = ImageIO.read(url);
			setIconImage(image);
			
			url= this.getClass().getResource("/pic/background.jpg");
			image = ImageIO.read(url);
			lbl_img = new JLabel(new ImageIcon(image));
			add(lbl_img);
			
		} catch (IOException e) {
			throw new RuntimeException("Can't find Logo.");
		}


	}
	
	public void setMenuListener(ActionListener l)
	{
		menu.setMenuListener(l);
	}
	

	public void removeImage()
	{
		this.remove(lbl_img);
	}
}
