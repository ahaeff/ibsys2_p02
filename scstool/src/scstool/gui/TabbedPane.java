package scstool.gui;

import javax.swing.JTabbedPane;

import scstool.gui.tab.ProdProgram;

public class TabbedPane extends JTabbedPane
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TabbedPane()
		{
			setTabPlacement(JTabbedPane.TOP);
			setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			add("Blub",new ProdProgram());
		}
}
