package scstool.proc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

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
