package scstool.proc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import scstool.gui.GuiManager;
import scstool.gui.ImportXMLDialog;
import scstool.obj.Material;

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
		
	    try {
	        // XMLReader erzeugen
	        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
	        
	        // Pfad zur XML Datei
	        FileReader reader = new FileReader("C:\\wamp\\www\\SAX_Bsp\\personen.xml");
	        InputSource inputSource = new InputSource(reader);

	        // DTD kann optional �bergeben werden
	        // inputSource.setSystemId("X:\\personen.dtd");

	        // PersonenContentHandler wird �bergeben
	        DatabaseContentHandler databaseContentHandler = new DatabaseContentHandler();
	        xmlReader.setContentHandler(databaseContentHandler);
	       
	        
	        // Parsen wird gestartet
	        xmlReader.parse(inputSource);
	        
	        List<Material> materialListe = databaseContentHandler.getAllMaterial();
	        System.out.println("Main: Material = " + materialListe);
	        
	        Material material = databaseContentHandler.findMaterial(40);
	        System.out.println("Main: Material ID 40 = " + material.getId());


	        databaseContentHandler.getWarehouseStock();
	        System.out.println("Main: Warehousestock = " + databaseContentHandler.getWarehouseStock());
	        
	        databaseContentHandler.getAllWorkplaces();
	        System.out.println("Main: Workplaces = " + databaseContentHandler.getAllWorkplaces());
	        

	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      } catch (SAXException e) {
	        e.printStackTrace();
	      }
	    
	}
	
}
