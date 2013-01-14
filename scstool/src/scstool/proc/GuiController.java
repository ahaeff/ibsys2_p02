package scstool.proc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JComponent;

import org.xml.sax.SAXException;

import scstool.gui.MainMenu;
import scstool.gui.MainView;
import scstool.obj.SellWish;
import scstool.utils.IController;
import scstool.utils.Repository;

public class GuiController implements IController
{
	private static final String DATABASEXML = "/database.xml";

	private MainView view;
	private Vector<SellWish> prog;
	private Repository repo;
	
	public GuiController()
	{
		init();
	}
	
	private void init()
	{
		view = new MainView();
		view.setMenuListener(new MenuListener());
		
		try {
			URL url = this.getClass().getResource(DATABASEXML);
			ImportXmlController.readXml(new File(url.getFile()), DatabaseContentHandler.get());
		} catch (SAXException | IOException e) {
			throw new RuntimeException("Can't find Database.xml.");
		}
		
		//int data containers
		repo = Repository.getInstance();
	
	}
	
	
	@Override
	public void addListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showView() 
	{
		this.view.setVisible(true);	
	}
	
	public MainView getView()
	{
		return this.view;
	}
	
	
	
	
	public void addContent(JComponent c)
	{
		view.add(c);
		view.invalidate();
		view.validate();
	}
	
	class MenuListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
				case MainMenu.MENU_EXIT:
					System.exit(0);
					break;
				case MainMenu.MENU_IMPORTXML:
					ImportXmlController ico = new ImportXmlController(view);
					ico.openDialog();
					break;
				case MainMenu.MENU_USER_INPUT:
					UserInputController pco = new UserInputController();
					addContent(pco.getView());
					break;
			}
		}
		
	}


}
