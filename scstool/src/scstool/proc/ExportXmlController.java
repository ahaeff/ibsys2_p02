/**
 * 
 */
package scstool.proc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import scstool.obj.Order;
import scstool.utils.Repository;

/**
 * @author reinhold
 * 
 */
public class ExportXmlController {

	// TODO Muss geändert werden wenn die Daten zum Abruf bereit sind
	List<Order> allOrders = new ArrayList<>();
	List<Integer[]> allProductions = new ArrayList<>();
	List<List<Integer>> allWorkingTime = new ArrayList<>();

	public ExportXmlController() {
		init();
	}

	private void init() {
//		allWorkingTime = Repository.getInstance().get
		allOrders = Repository.getInstance().getOrders();
		allProductions = Repository.getInstance().getProductionProgram();
	}

	public void export(DatabaseContentHandler db, String file) {
		try {
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = factory
					.createXMLStreamWriter(new FileOutputStream(file));

			writer.writeStartDocument();
			writer.writeStartElement("input");

			// Qualitycontrol
			writer.writeEmptyElement("qualitycontrol");
			writer.writeAttribute("type", "no");
			writer.writeAttribute("losequantity", "0");
			writer.writeAttribute("delay", "0");

			// Sellwish
			writer.writeStartElement("sellwish");
			for (int i = 1; i <= 3; ++i) {
				writer.writeEmptyElement("item");
				writer.writeAttribute("article", String.valueOf(i));
				// TODO Sellwish
				writer.writeAttribute("quantity", "1");
			}
			writer.writeEndElement();

			// Selldirect
			writer.writeStartElement("selldirect");
			for (int i = 1; i <= 3; ++i) {
				writer.writeEmptyElement("item");
				writer.writeAttribute("article", String.valueOf(i));
				writer.writeAttribute("quantity", "1");
				writer.writeAttribute("price", "1");
				writer.writeAttribute("penalty", "1");
			}
			writer.writeEndElement();

			// Orderlist
			writer.writeStartElement("orderlist");
			for (Order order : allOrders) {
				writer.writeEmptyElement("order");
				writer.writeAttribute("article",
						String.valueOf(order.getMaterial().getId()));
				writer.writeAttribute("quantity",
						String.valueOf(order.getAmount()));
				writer.writeAttribute("modus",
						String.valueOf(order.getMode().getMark()));
			}
			writer.writeEndElement();

			// Productionlist
			writer.writeStartElement("productionlist");
			for (Integer[] dataset : allProductions) {
				writer.writeEmptyElement("production");
				writer.writeAttribute("article", String.valueOf(dataset[0]));
				writer.writeAttribute("quantity",
						String.valueOf(dataset[1]));
			}
			writer.writeEndElement();

			// Workingtimelist
			writer.writeStartElement("workingtimelist");
			for (List<Integer> dataset : allWorkingTime) {
				writer.writeEmptyElement("workingtime");
				writer.writeAttribute("station", String.valueOf(dataset.get(0)));
				writer.writeAttribute("shift", String.valueOf(dataset.get(1)));
				writer.writeAttribute("overtime",
						String.valueOf(dataset.get(2)));
			}
			writer.writeEndElement();

			writer.writeEndElement();
			writer.writeEndDocument();
			writer.close();

		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
