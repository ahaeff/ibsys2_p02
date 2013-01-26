/**
 * 
 */
package scstool.proc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import scstool.obj.Order;
import scstool.obj.SellWish;
import scstool.obj.Workplace;
import scstool.utils.Repository;

/**
 * @author reinhold
 * 
 */
public class ExportXmlController {

	List<Order> allOrders = new ArrayList<>();
	List<Integer[]> allProductions = new ArrayList<>();
	LinkedHashMap<Workplace,Integer[]> allWorkingTime = new LinkedHashMap<>();
	private Map<Integer, SellWish> sellWish;

	public ExportXmlController() {
		init();
	}

	private void init() {
		sellWish = Repository.getInstance().getSellWishAll();
		allWorkingTime = Repository.getInstance().getCapacity();
		allOrders = Repository.getInstance().getOrders();
		allProductions = Repository.getInstance().getProductionProgram();
	}

	public void export(String file) {
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
			for (Entry<Integer, SellWish> sell : sellWish.entrySet()) {
				writer.writeEmptyElement("item");
				writer.writeAttribute("article", String.valueOf(sell.getKey()));
				writer.writeAttribute("quantity", String.valueOf(sell.getValue().getN()));
			}
			writer.writeEndElement();

			// Selldirect
			writer.writeStartElement("selldirect");
			for (int i = 1; i <= 3; ++i) {
				writer.writeEmptyElement("item");
				writer.writeAttribute("article", String.valueOf(i));
				writer.writeAttribute("quantity", "0");
				writer.writeAttribute("price", "0.0");
				writer.writeAttribute("penalty", "0.0");
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
			for (Entry<Workplace, Integer[]> dataset : allWorkingTime.entrySet()) {
				writer.writeEmptyElement("workingtime");
				writer.writeAttribute("station", String.valueOf(dataset.getKey().getId()));
				writer.writeAttribute("shift", String.valueOf(dataset.getValue()[0]));
				writer.writeAttribute("overtime",
						String.valueOf(dataset.getValue()[1]));
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
