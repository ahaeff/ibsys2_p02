package scstool.gui.tab;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import scstool.gui.comp.ButtonPane;



/**
 * Eingabe des Sicherheitsbestands
 * @author haeff
 *
 */
public class SafetyStockTab extends JPanel 
{

	private static final long serialVersionUID = 1L;

	public SafetyStockTab()
	{
		init();
	}
	
	private void init()
	{
		setLayout(new BorderLayout());
		
		buildSouth();
	}
	
	private void buildSouth()
	{
		add(new ButtonPane(1),BorderLayout.PAGE_END);
	}
}
