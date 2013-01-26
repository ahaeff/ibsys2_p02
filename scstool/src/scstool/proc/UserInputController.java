package scstool.proc;

import javax.swing.JFrame;

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
	
	
	public UserInputController(JFrame j)
	{
		init(j);
	}
	
	private void init(JFrame j)
	{
		this.view = new TabbedPaneView(j);
		
		
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
