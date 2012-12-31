package scstool.proc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import scstool.gui.MainMenu;
import scstool.gui.MainView;
import scstool.obj.ProductionProg;
import scstool.utils.IController;
import scstool.utils.Repository;

public class GuiController implements IController
{

	private MainView view;
	private Vector<ProductionProg> prog;
	private Repository repo;
	
	public GuiController()
	{
		init();
	}
	
	private void init()
	{
		view = new MainView();
		view.setMenuListener(new MenuListener());
		
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
					ProdProgrammController pco = new ProdProgrammController();
					addContent(pco.getView());
					break;
			}
		}
		
	}


}
