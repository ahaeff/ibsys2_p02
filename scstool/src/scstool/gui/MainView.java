package scstool.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class MainView extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private MainMenu menu;
	private JPanel panel = new JPanel();
	private JButton btnImport;
	
	public MainView()
	{
		getContentPane().setBackground(Color.WHITE);
		init();		
		
	}
	
	private void init()
	{
		setSize(1024, 768);
		setTitle("SCS-Tool");

		//Noetig damit sich der GUI auch wirklich beendet
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.menu = new MainMenu();
	//	setJMenuBar(this.menu);
		
		//Icon / Bild
		URL url;
		Image image;
		try {
			url= this.getClass().getResource("/icon/logo.png");
			image = ImageIO.read(url);
			setIconImage(image);
			
			
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 1008, 709);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel welcome = new JLabel("Herzlich Willkommen beim SCS-Tool");
			welcome.setBounds(0, 32, 998, 29);
			panel.add(welcome);
			welcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
			welcome.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel iconBicycle = new JLabel("");
			iconBicycle.setBounds(10, 99, 988, 258);
			panel.add(iconBicycle);
			iconBicycle.setHorizontalAlignment(SwingConstants.CENTER);
			iconBicycle.setIcon(new ImageIcon(MainView.class.getResource("/pic/data.jpg")));
			
			JTextPane txtpnDasProduktionstoolUntersttzt = new JTextPane();
			txtpnDasProduktionstoolUntersttzt.setBounds(315, 402, 661, 169);
			panel.add(txtpnDasProduktionstoolUntersttzt);
			txtpnDasProduktionstoolUntersttzt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtpnDasProduktionstoolUntersttzt.setText("Das Produktionstool unterstützt Sie, in Form eines Wizards, bei Ihrer Produktionsplanung.\r\nIn wenigen Schritten wird mit Hilfe Ihrer Eingaben ein fertiger XML-Produktionsplan erstellt.\r\n\r\nEs ermöglicht Ihnen mit Parametern zu spielen, um so Ihr gewünschtes Ziel zu erreichen.\r\n\r\nUm Ihre aktuellen Lagebestände, Fehlteile, Bestellungen und Warteschlangen einzulesen, drücken Sie bitte den Import-Button.");
			
			btnImport = new JButton("Import");
			btnImport.setBounds(875, 600, 101, 39);
			btnImport.setActionCommand("IMP");
			panel.add(btnImport);
			btnImport.setIcon(new ImageIcon(MainView.class.getResource("/icon/ImportXMLFile-24.png")));
			
			JLabel lblVertriebswunsch = new JLabel("Vertriebswunsch");
			lblVertriebswunsch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblVertriebswunsch.setIcon(new ImageIcon(MainView.class.getResource("/icon/tab/num1_22x16.png")));
			lblVertriebswunsch.setBounds(37, 402, 177, 26);
			panel.add(lblVertriebswunsch);
			
			JLabel lblNewLabel = new JLabel("Sicherheitbestand");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/icon/tab/num2_22x16.png")));
			lblNewLabel.setBounds(37, 439, 177, 29);
			panel.add(lblNewLabel);
			
			JLabel lblEinstellungen = new JLabel("Einstellungen");
			lblEinstellungen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEinstellungen.setIcon(new ImageIcon(MainView.class.getResource("/icon/tab/num3_22x16.png")));
			lblEinstellungen.setBounds(38, 479, 176, 26);
			panel.add(lblEinstellungen);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBackground(Color.BLACK);
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(234, 402, 10, 239);
			panel.add(separator);
			
			
		} catch (IOException e) {
			throw new RuntimeException("Can't find Logo.");
		}
	}
	
	public void setMenuListener(ActionListener l)
	{
		menu.setMenuListener(l);
	}
	

	public void addPanel()
	{
		getContentPane().add(panel);

	}
	public void removePanel()
	{
		this.remove(panel);

	}
	public void setButtonListener(ActionListener l)
	{
		btnImport.addActionListener(l);
	}
}


