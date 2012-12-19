package scstool.proc;

import scstool.gui.GuiManager;
import scstool.gui.ImportXMLDialog;

/**
 * Diese Klasse beinhaltet die Funltionalitaet zum Import von XML Dateien und deren Verarbeitung.
 * 
 * @author haeff
 *
 */
public class ProcImportXml 
{
	/**
	 * Startet den Datei oeffnen Dialog
	 */
	public void openDialog()
	{
		
		GuiManager gm = GuiManager.getInstance();
		ImportXMLDialog dia = new ImportXMLDialog();
		
		dia.showOpenDialog(gm.getMainWindow()); 
	}
	
}
