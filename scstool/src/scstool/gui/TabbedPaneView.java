package scstool.gui;

import javax.swing.JTabbedPane;

import scstool.gui.tab.ProdProgrammTab;
import scstool.proc.ProdProgrammController;

public class TabbedPaneView extends JTabbedPane
{


	
	private int variant;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TabbedPaneView(int variant)
		{
			this.variant = variant;
			init();
		}
		
		private void init()
		{
			
			setTabPlacement(JTabbedPane.TOP);
			setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);			
			

			if(this.variant == ProdProgrammController.VAR_PRODPROG)
			{
				add("Produktions Programm",new ProdProgrammTab());				
			}
			else if(this.variant == ProdProgrammController.VAR_CAPACITY)
			{
				
			}
			
			}
}
