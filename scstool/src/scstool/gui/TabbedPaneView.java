package scstool.gui;

import javax.swing.JTabbedPane;

import scstool.gui.tab.ProdProgram;

public class TabbedPaneView extends JTabbedPane
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TabbedPaneView()
		{
			setTabPlacement(JTabbedPane.TOP);
			setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			add("Blub",new ProdProgram());
		}
}
