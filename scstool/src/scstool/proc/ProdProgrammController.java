package scstool.proc;

import javax.swing.JTabbedPane;

import scstool.gui.MainView;
import scstool.gui.TabbedPaneView;

public class ProdProgrammController 
{
	private TabbedPaneView view;
	
	public static int VAR_PRODPROG = 1;
	public static int VAR_CAPACITY = 2;
	
	
	
	public ProdProgrammController()
	{
		init();
	}
	
	private void init()
	{
		this.view = new TabbedPaneView(VAR_PRODPROG);
		
	}
	public void showView() 
	{
		this.view.setVisible(true);	
	}
	
	public TabbedPaneView getView()
	{
		return this.view;
	}
	
	
}
