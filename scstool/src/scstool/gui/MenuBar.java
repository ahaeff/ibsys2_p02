package scstool.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import scstool.proc.ProcImportXml;
import scstool.utils.Dic;

public class MenuBar extends JMenuBar{

    private JMenu file;
    private JMenu hilfe;
    
    
    private JMenuItem importXML;
    private JMenuItem exit;
    
	
	public MenuBar()
	{
		
		init();
		add(file);
		
		
	}
	
	
	private void init()
	{
		//Menu Datei
		file = new JMenu(Dic.getValue("menu.1", "File"));
		importXML = new  JMenuItem(Dic.getValue("menu.1.1","Import XML"));
		importXML.addActionListener(new MenuListener());   //TODO evtl. nicht jedesmal den listener neu erstellen
		file.add(importXML);

		
		
		exit = new  JMenuItem(Dic.getValue("menu.1.5","Exit"));
		exit.addActionListener(new MenuListener());
		file.add(exit);
		
		//file.addActionListener(new MenuListener());
	}
	
	private  class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == exit )
			{
				System.exit(0);
			}
			else if (e.getSource() == importXML)
			{
				ProcImportXml proc = new ProcImportXml();
				proc.openDialog();
			}
		}

	}

}
