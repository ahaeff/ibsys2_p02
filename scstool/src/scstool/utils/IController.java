package scstool.utils;

import java.awt.event.ActionListener;

public interface IController 
{

	public void showView();
	
	public void addListener(ActionListener l);
	public void removeListener(ActionListener l);

}
