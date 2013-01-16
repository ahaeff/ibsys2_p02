package scstool.proc;

import scstool.gui.TabbedPaneView;

/**
 * Controller f�r die Steuerung der Benutzer Eingaben
 * 
 * @author haeff
 *
 */
public class UserInputController 
{
	private TabbedPaneView view;
	
	
	public UserInputController()
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
