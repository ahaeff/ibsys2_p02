package scstool.proc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import scstool.gui.ImportDialogView;



public class ImportXmlController 
{
	private static final String DATABASEXML = "/database.xml";

	private ImportDialogView view;
	private JFrame parent;
	
	public ImportXmlController(JFrame j)
	{
		this.parent = j;
		init();
	}
	
	private void init()
	{
		try {
			URL url = this.getClass().getResource(DATABASEXML);
			readXml(new File(url.getFile()), DatabaseContentHandler.get());
		} catch (SAXException | IOException e) {
			throw new RuntimeException("Can't find Database.xml.");
		}
	}
	
	public void openDialog()
	{
		//GuiManager gm = GuiManager.getInstance();
		ImportDialogView dia = new ImportDialogView();
		//ImportXMLDialog dia = new ImportXMLDialog();

		//int dialogResult = dia.showOpenDialog(gm.getMainWindow());
		int dialogResult = dia.showOpenDialog(parent);
		switch (dialogResult) {
		case ImportDialogView.APPROVE_OPTION:
			try {
				File selectedFile = dia.getSelectedFile();
				InputContentHandler contentHandler = new InputContentHandler();
				readXml(selectedFile, contentHandler);

				// List<Material> materialListe =
				// contentHandler.getAllMaterial();
				// System.out.println("Main: Material = " + materialListe);
				//
				// Material material = contentHandler.findMaterial(40);
				// System.out.println("Main: Material ID 40 = " +
				// material.getId());
				//
				//
				// contentHandler.getWarehouseStock();
				// System.out.println("Main: Warehousestock = " +
				// contentHandler.getWarehouseStock());
				//
				// contentHandler.getAllWorkplaces();
				// System.out.println("Main: Workplaces = " +
				// contentHandler.getAllWorkplaces());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
			break;
		case ImportDialogView.CANCEL_OPTION:
			break;
		case ImportDialogView.ERROR:
			break;
		default:
			break;
		}

	}
	
	/**
	 * @param selectedFile
	 * @param contentHandler
	 * @return
	 * @throws SAXException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readXml(File selectedFile, ContentHandler contentHandler)
			throws SAXException, FileNotFoundException, IOException {
		// XMLReader erzeugen
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();

		// Pfad zur XML Datei
		FileReader reader = new FileReader(selectedFile);

		// FileReader reader = new
		// FileReader("C:\\wamp\\www\\SAX_Bsp\\personen.xml");
		InputSource inputSource = new InputSource(reader);

		// ContentHandler wird �bergeben
		xmlReader.setContentHandler(contentHandler);

		// Parsen wird gestartet
		xmlReader.parse(inputSource);
	}
}

