package scstool.proc;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import scstool.obj.BillOfMaterial;
import scstool.obj.Material;
import scstool.obj.Order;
import scstool.obj.Salary;
import scstool.obj.WorkPlan;
import scstool.obj.Workplace;
import scstool.utils.PeriodDate;

public class InputContentHandler implements ContentHandler {

  private String currentValue;
  private WarehouseService warehousestock = new WarehouseService();

  private List<Material> allesMaterial = new ArrayList<Material>();
  private Material material;
  
  private List<Salary> alleLoehne = new ArrayList<Salary>();
  private Salary salary;
  
  private Workplace workplace;
  private List<Workplace> allePlaetze = new ArrayList<Workplace>();

  private WorkPlan workplan;
  private List<WorkPlan> workplanList;
  private List<WorkPlan> allePlaene = new ArrayList<WorkPlan>();

  private BillOfMaterial billofmaterial;
  private List<BillOfMaterial> alleBOM = new ArrayList<BillOfMaterial>();
  
  private Order order;
  private List<Order> alleOrder = new ArrayList<Order>();

  
  
   // Aktuelle Zeichen die gelesen werden, werden in eine Zwischenvariable
  // gespeichert
  public void characters(char[] ch, int start, int length)
      throws SAXException {
    currentValue = new String(ch, start, length);
  }
  // Methode wird aufgerufen wenn der Parser zu einem Start-Tag kommt
  public void startElement(String uri, String localName, String qName,
      Attributes atts) throws SAXException {
    
	/*-------------- Das ist die einzulesende Datei  -------------------------------------------*/
	
	 if (localName.equals("material")) {
	      // Neue Person erzeugen
		 material = findMaterial(Integer.parseInt(atts.getValue("id")));
	
		 material.setAmount(Integer.parseInt(atts.getValue("amount")));
		 material.setPct(Double.parseDouble(atts.getValue("pct")));
		 material.setPrice(Double.parseDouble(atts.getValue("price")));
		 material.setStockvalue(Double.parseDouble(atts.getValue("stockvalue")));
		
		 warehousestock.calcWarehouseStock(material);
	  }
	 
	 /*-------------------------------------*/
	 
	 if (localName.equals("order")) {
	    order = new Order();

		 
	    if (atts.getValue("time") != null) {
	    	order.setFinished(true);
			//order.setOrderDate(orderDate) --> time
	  // wann es gekommen ist, ist egal .. es ist nur von Bedeutung, DASS es gekommen ist (wenn �berhaupt)  	
			//order.setDeliveryDate(new PeriodDate(Double.parseDouble(atts.getValue("deliveryTime"))));
	    	order.setEntirecosts(Double.parseDouble(atts.getValue("entirecosts")));
	    	order.setPiececosts(Double.parseDouble(atts.getValue("piececosts")));
		}
	    else
	    {
	    	order.setFinished(false);
	    }
		
	    order.setId(Integer.parseInt(atts.getValue("id")));
		order.setAmount(Integer.parseInt(atts.getValue("amount")));
		order.setMaterial(findMaterial(Integer.parseInt(atts.getValue("article"))));
		order.setMode(Integer.parseInt(atts.getValue("mode")));
	 }
	 

    
  }
  
  // Methode wird aufgerufen wenn der Parser zu einem End-Tag kommt
  public void endElement(String uri, String localName, String qName)
      throws SAXException {
	 
    // Person in Personenliste abspeichern falls Person End-Tag erreicht
    // wurde.
    if (localName.equals("material")) {
      allesMaterial.add(material);
      System.out.println(material);
    }
    
    if (localName.equals("salary")) {
        alleLoehne.add(salary);
        System.out.println(salary);
      }
  
    if (localName.equals("workplace")) {
        allePlaetze.add(workplace);
        System.out.println(workplace);
      }
    
    if (localName.equals("workplan")) {
        allePlaene.add(workplan);
        System.out.println(workplan);
      }

    if (localName.equals("billofmaterial")) {
    	alleBOM.add(billofmaterial);
        System.out.println(billofmaterial);
      }
	
    if (localName.equals("order")) {
    	alleOrder.add(order);
        System.out.println(order);
      }

  }

  public void endDocument() throws SAXException {}
  public void endPrefixMapping(String prefix) throws SAXException {}
  public void ignorableWhitespace(char[] ch, int start, int length)
      throws SAXException {}
  public void processingInstruction(String target, String data)
      throws SAXException {}
  public void setDocumentLocator(Locator locator) {  }
  public void skippedEntity(String name) throws SAXException {}
  public void startDocument() throws SAXException {}
  public void startPrefixMapping(String prefix, String uri)
    throws SAXException {}

  public Double getWarehouseStock() {
	  return warehousestock.getWarehouseStock();
  }
  
  public List<Workplace> getAllWorkplaces() {
	  return allePlaetze;
  }
  
  public List<Material> getAllMaterial() {
	  return allesMaterial;
  }
  
  public Material findMaterial(int id){
	  
	  int xmlID = id - 1;
	  material = allesMaterial.get(xmlID);
	  
	  return material;
  }

}
