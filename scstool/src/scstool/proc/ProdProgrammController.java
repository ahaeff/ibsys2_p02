package scstool.proc;

import scstool.gui.TabbedPaneView;

public class ProdProgrammController 
{
	private TabbedPaneView view;
	
	
	public ProdProgrammController()
	{
		init();
	}
	
	private void init()
	{
		this.view = new TabbedPaneView();
		
		
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
