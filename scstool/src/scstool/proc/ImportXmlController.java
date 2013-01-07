package scstool.proc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import scstool.gui.ImportDialogView;



public class ImportXmlController 
{
	private ImportDialogView view;
	private JFrame parent;
	
	public ImportXmlController(JFrame j)
	{
		this.parent = j;
		init();
	}
	
	private void init()
	{

	}
	
	public void openDialog()
	{
		ImportDialogView dia = new ImportDialogView();

		int dialogResult = dia.showOpenDialog(parent);
		switch (dialogResult) {
		case ImportDialogView.APPROVE_OPTION:
			try {
				File selectedFile = dia.getSelectedFile();
				InputContentHandler contentHandler = new InputContentHandler();
				readXml(selectedFile, contentHandler);

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
	public static void readXml(File selectedFile, ContentHandler contentHandler)
			throws SAXException, FileNotFoundException, IOException {
		// XMLReader erzeugen
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();

		// Pfad zur XML Datei
		FileReader reader = new FileReader(selectedFile);

		// FileReader reader = new
		// FileReader("C:\\wamp\\www\\SAX_Bsp\\personen.xml");
		InputSource inputSource = new InputSource(reader);

		// ContentHandler wird ���bergeben
		xmlReader.setContentHandler(contentHandler);

		// Parsen wird gestartet
		xmlReader.parse(inputSource);
	}
}

