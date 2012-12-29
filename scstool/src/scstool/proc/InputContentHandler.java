package scstool.proc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import scstool.obj.BillOfMaterial;
import scstool.obj.Material;
import scstool.obj.Order;
import scstool.obj.Salary;
import scstool.obj.WaitingList;
import scstool.obj.WorkPlan;
import scstool.obj.Workplace;
import scstool.utils.MyMath;

public class InputContentHandler implements ContentHandler {

	private static 	String[] KPI = {
		"capacity",
		"possiblecapacity",
		"relpossiblenormalcapacity",
		"productivetime",
		"effiency",
		"sellwish",
		"salesquantity",
		"deliveryreliability",
		"idletime",
		"idletimecosts",
		"storevalue",
		"storagecosts",
		"quantity",
		"costs",
		"salesprice",
		"profit",
		"profitperunit",
		"contractpenalty"
	};
	private Map<String, List<String>> kpiValues = new HashMap<String, List<String>>();
	
	private String currentValue;
	
	private List<Material> allesMaterial = new ArrayList<Material>();

	private Order order;
	private List<Order> alleOrder = new ArrayList<Order>();
	
	private WaitingList waitinglist;
	private List<WaitingList> alleWL = new ArrayList<WaitingList>();

	DatabaseContentHandler dbch = DatabaseContentHandler.get();
	
	private Workplace workplace;
	private Workplace workplaceInWork; // Auftraege in Bearbeitung (Excelsheet und SCSim)
	private WaitingList waitinglistInWork;
	private List<WaitingList> alleWLinWork = new ArrayList<WaitingList>();

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

		
		if (localName.equals("article")) {
			Material material = DatabaseContentHandler.get().findMaterial(Integer.parseInt(atts.getValue("id")));

			material.setAmount(Integer.parseInt(atts.getValue("amount")));
			material.setPct(MyMath.parseDouble(atts.getValue("pct")));
			material.setPrice(MyMath.parseDouble(atts.getValue("price")));
			material.setStockvalue(MyMath.parseDouble(atts
					.getValue("stockvalue")));
			
		}

		/*-------------------------------------*/

		if (localName.equals("waitinglist")) {

			waitinglist = new WaitingList();

			waitinglist.setMaterial(dbch.findMaterial(Integer.parseInt(atts.getValue("item"))));
			waitinglist.setAmount(Integer.parseInt(atts.getValue("amount")));
			waitinglist.setTimeneed(Integer.parseInt(atts.getValue("timeneed")));

			workplace.addWaitingList(waitinglist);
			alleWL.add(waitinglist);

		}

		/*--------------Aufträge in der Warteschlange-----------------------*/
		
		if (localName.equals("workplace")) {
			if (atts.getValue("batch") == null || atts.getValue("setupevents") == null || atts.getValue("ageidletimecosts") == null) {
				workplace = dbch.findWorkplace(Integer.parseInt(atts.getValue("id")));
				//System.out.println(atts.getValue("timeneed") + "+*Workplace*****");
			}
			System.out.println(atts.getValue("id") + "+*++waitinglist+-/-/" + atts.getValue("wagecosts"));
			/*------------------Aufträge in Bearbeitung-------------------*/

			if (atts.getValue("id") != null && atts.getValue("period") != null && atts.getValue("order") != null && atts.getValue("batch") != null && atts.getValue("item") != null && atts.getValue("amount") != null && atts.getValue("timeneed") != null) {

				waitinglistInWork = new WaitingList();
	
				waitinglistInWork.setMaterial(dbch.findMaterial(Integer.parseInt(atts.getValue("item"))));
				waitinglistInWork.setAmount(Integer.parseInt(atts.getValue("amount")));
				waitinglistInWork.setTimeneed(Integer.parseInt(atts.getValue("timeneed")));
				System.out.println("#12345# " + waitinglistInWork);
				alleWLinWork.add(waitinglistInWork);
			}

		}

		/*-------------------------------------*/

		if (localName.equals("order")) {
							
			if (atts.getValue("averageunitcosts") == null || atts.getValue("cycletimefactor") == null) {

				try{
				Integer amount = Integer.parseInt(atts.getValue("amount"));
				order = new Order();
	
				if (atts.getValue("time") != null) {
					order.setFinished(true);
					// order.setOrderDate(orderDate) --> time
					// wann es gekommen ist, ist egal .. es ist nur von Bedeutung,
					// DASS es gekommen ist (wenn ï¿½berhaupt)
					// order.setDeliveryDate(new
					// PeriodDate(Double.parseDouble(atts.getValue("deliveryTime"))));
					order.setOrdercosts(MyMath.parseDouble(atts
							.getValue("ordercosts")));
					order.setEntirecosts(MyMath.parseDouble(atts
							.getValue("entirecosts")));
					order.setPiececosts(MyMath.parseDouble(atts
							.getValue("piececosts")));
				} else {
					order.setFinished(false);
				}
	
				order.setId(Integer.parseInt(atts.getValue("id")));
				order.setAmount(amount);
				order.setMaterial(DatabaseContentHandler.get().findMaterial(Integer.parseInt(atts
						.getValue("article"))));
				order.setMode(Integer.parseInt(atts.getValue("mode")));
				alleOrder.add(order);

			} catch(NumberFormatException ex){
			}
			}
				else{
			}

			if (isKPI(localName)) {
				List<String> values = new ArrayList<>();
				values.add(atts.getValue("current"));
				values.add(atts.getValue("average"));
				values.add(atts.getValue("all"));
				kpiValues.put(localName, values);
			}
			
		}
	}

	/**
	 * Prï¿½ft ob es ein KPI ist.
	 * 
	 * @param localName der Tag
	 * @return Wenn es in KPI enthalten ist dann true
	 */
	private boolean isKPI(String localName) {
		HashSet<String> kpis = new HashSet<String>(Arrays.asList(KPI));
		return kpis.contains(localName);
	}

	// Methode wird aufgerufen wenn der Parser zu einem End-Tag kommt
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// Person in Personenliste abspeichern falls Person End-Tag erreicht
		// wurde.
//		if (localName.equals("order")) {
//			alleOrder.add(order);
//			System.out.println("#++++++#" + order);
//		}
//		
//		if (localName.equals("waitinglist")) {
//			alleWL.add(waitinglist);
//			System.out.println("#!!!!!!#" + workplace);
//		}

	}

	public void endDocument() throws SAXException {
	}

	public void endPrefixMapping(String prefix) throws SAXException {
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	public void setDocumentLocator(Locator locator) {
	}

	public void skippedEntity(String name) throws SAXException {
	}

	public void startDocument() throws SAXException {
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
	}
	
	public List<Order> getAllOrders() {
		return alleOrder;
	}

	public List<Order> getFutureInwardStockMovement(){
		
		List<Order> allFISM = new ArrayList<Order>();
		
		for( int i = 0, n = alleOrder.size(); i<n; i++ ){
			if(getAllOrders().get(i).getOrdercosts().equals(null)){
				allFISM.add(getAllOrders().get(i));
			}
		}

		return allFISM;
	}

	public List<Order> getInwardStockMovement(){
		
		List<Order> allFISM = new ArrayList<Order>();
		
		for( int i = 0, n = alleOrder.size(); i<n; i++ ){
			if(!getAllOrders().get(i).getOrdercosts().equals(null)){
				allFISM.add(getAllOrders().get(i));
			}
		}

		return allFISM;
	}
	
	/**
	 * @return Materialliste, dass noch in der Warteschlange ist (Warteliste Arbeitsplatz)
	 */
	public List<Material> getWaitingMaterial(){
		
		List<Material> waitingMaterial = new ArrayList<Material>();
		
		
		for(WaitingList wl : alleWL) 
		{
			waitingMaterial.add(wl.getMaterial());
		}

		return waitingMaterial;
	}
	
	/**
	 * @return Material, dass noch in der Warteschlange ist (Warteliste Arbeitsplatz im SCSim) (Aufträge in der Warteschlange im Excelsheet)
	 * @param 
	 */

	public Material findWaitingMaterial(Integer id){
		
		List<Material> waitingMaterial = getWaitingMaterial();
		Material mat = new Material();
		
		for(Material m : waitingMaterial) 
		{
			if (m.getId().equals(id)){
				mat = m;	
			}
		}
		return mat;
	}
	
	/**
	 * @return Material, dass noch in der Warteschlange ist (Aufträge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getWaitingMaterialWert(Integer materialID){
		
		for(WaitingList wl : alleWLinWork) 
		{
			if (wl.getMaterial().getId().equals(materialID)){
				materialID = wl.getAmount();	
			}
		}
		return materialID;
	}
	

 //--------------------------------------
	/**
	 * @return Materialliste, dass noch in Bearbeitung ist (Aufträge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public List<Material> getMaterialinWork(){
		
		List<Material> waitingMaterial = new ArrayList<Material>();
		
		for(WaitingList wl : alleWLinWork) 
		{
			waitingMaterial.add(wl.getMaterial());
		}

		return waitingMaterial;
	}
	
	/**
	 * @return Material, dass noch in Bearbeitung ist (Aufträge in Bearbeitung im SCSim und im Excelsheet)
	 * @param 
	 */

	public Material findMaterialinWork(Integer id){
		
		List<Material> waitingMaterial = getMaterialinWork();
		Material mat = new Material();
				
		for(Material m : waitingMaterial) 
		{
			if (m.getId().equals(id)){
				mat = m;	
			}
		}
		return mat;
	}
	/**
	 * @return Integer der Menge, eines Artikels, dass noch in Bearbeitung ist (Aufträge in Bearbeitung im SCSim und im Excelsheet)
	 */
	public Integer getMaterialinWorkWert(Integer materialID){
				
		for(WaitingList wl : alleWLinWork) 
		{
			if (wl.getMaterial().getId().equals(materialID)){
				materialID = wl.getAmount();	
			}
		}

		return materialID;
	}
	
}
