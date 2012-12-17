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

public class DatabaseContentHandler implements ContentHandler {

 /* private ArrayList<Person> allePersonen = new ArrayList<Person>();
  private String currentValue;
  private Person person;
*/
	
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
    
 /* ------------- Das ist die f�r die Datenbasis (nach unten) ------------------- */
	  
	 
	 if (localName.equals("material")) {
      // Neue Person erzeugen
      material = new Material();

      // Attribut id wird in einen Integer umgewandelt und dann zu der
      // jeweiligen Person gesetzt
      material.setId(Integer.parseInt(atts.getValue("id")));
      material.setStartamount(Integer.parseInt(atts.getValue("startamount")));
      material.setName(atts.getValue("name"));
      material.setPartType(atts.getValue("partType"));
      material.setDeliveryTime(new PeriodDate(Double.parseDouble(atts.getValue("deliveryTime"))));
      material.setDeliveryAberation(new PeriodDate(Double.parseDouble(atts.getValue("deliveryAberation"))));
      material.setOrderCosts(Integer.parseInt(atts.getValue("orderCosts")));
      material.setDiscountAmount(Integer.parseInt(atts.getValue("discountAmount")));
      material.setUsedIn(atts.getValue("usedIn"));
      
    //  warehousestock.calcWarehouseStock(material);
    }
    
    //---------------------------------------------------------

    if (localName.equals("salary")) {
          // Neue Person erzeugen
      salary = new Salary();
      
      salary.setId(Integer.parseInt(atts.getValue("id")));
      salary.setDescription(atts.getValue("descripton"));
      salary.setAmount(Double.parseDouble(atts.getValue("amount")));
    }
    
    //---------------------------------------------------------

    if (localName.equals("workplace")) {
          // Neue Person erzeugen
      workplace = new Workplace();
      
      workplace.setId(Integer.parseInt(atts.getValue("id")));
      workplace.setDescripton(atts.getValue("descripton"));
      workplace.setFixMachineCosts(Double.parseDouble(atts.getValue("fixMachineCosts")));
      workplace.setVarMachineCosts(Double.parseDouble(atts.getValue("varMachineCosts")));
    }
    
    //---------------------------------------------------------
    
    if (localName.equals("workplan")){
    	workplan = new WorkPlan();
    	
    	workplan.setId(Integer.parseInt(atts.getValue("id")));
    	workplan.setProductionTime(Integer.parseInt(atts.getValue("productionTime")));
    	workplan.setSetupTime(Integer.parseInt(atts.getValue("setupTime")));
    	
    	// Hinzuf�gen zur Arbeitsplatz
    	workplace.addWorkplan(workplan);
    }

    //---------------------------------------------------------
    
    if (localName.equals("billofmaterial")){
    	billofmaterial = new BillOfMaterial();
    	
    	billofmaterial.setId(Integer.parseInt(atts.getValue("id")));
      	
       	Integer bomID = (Integer.parseInt(atts.getValue("component")));
       	Material materialComponent = findMaterial(bomID);
       	billofmaterial.setComponent(materialComponent);
      
       	
       	Integer amount = (Integer.parseInt(atts.getValue("amount")));
       	Boolean assambly = (Boolean.parseBoolean(atts.getValue("assembly")));
       	Integer matID = (Integer.parseInt(atts.getValue("material")));
       	Material materialMaterial = findMaterial(matID);
       	billofmaterial.addMaterials(billofmaterial.createMaterialAmount(amount, assambly, materialMaterial));
       	
       	workplan.addBoM(billofmaterial);
    }
    
	/* ------------- Das ist die f�r die Datenbasis (nach oben) ------------------- */

    
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
