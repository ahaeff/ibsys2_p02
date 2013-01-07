package scstool.proc;

import scstool.obj.Disposition;

/**
 * @Autor Alexander
 * 
 */
public class DispositionService {
//	
//	public void QueueInput1(Disposition disposition, ProductionProg productionProg){
//		
//		/**
//		 *  Lagerhandler initialisieren
//		 */
//		DatabaseContentHandler dbch = DatabaseContentHandler.get();
//		InputContentHandler ich = new InputContentHandler();
//		
//		/**
//		 *  Dispositionswerte P1 setzten
//		 */
//		//Vertertriebswunsch
//		disposition.setSalesOrders(productionProg.getN());
//		// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
//		disposition.setWaitingQueue1(0);
//		//TODO Input Sicherheitsbestand fehlt
//		//Lagerbestand geplant
//		disposition.setSafetyWarehousestock(30);
//		//Lagerbestand Vorperiode
//		disposition.setWarehousestockPassedPeriod(dbch.findMaterial(1).getAmount());
//		//TODO @Daniel Funktionen liefern
//		// Warteschlange (uebergeordnet)
//		disposition.setWaitingQueue2(ich.getWaitingMaterialWert(1));
//		//TODO @Daniel Funktionen liefern
//		// Auftraege in Bearbeitung
//		disposition.setOrdersInProgress(ich.getMaterialinWorkWert(1));
//		// Produktionsauftraege kommende Periode
//		disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
//		
//		/**
//		 *  Dispositionswerte der Komponenten von P1 setzten
//		 */
//		/**
//		 *  E26 und E51
//		 */
//		disposition.getDispositionen().get(0).setSalesOrders(disposition.getOrders());
//		disposition.getDispositionen().get(1).setSalesOrders(disposition.getOrders());
//		
//		disposition.getDispositionen().get(0).setWaitingQueue1(disposition.getWaitingQueue2());
//		disposition.getDispositionen().get(1).setWaitingQueue1(disposition.getWaitingQueue2());
//		//TODO Input Sicherheitsbestand
//		disposition.getDispositionen().get(0).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(1).setSafetyWarehousestock(50);
//		
//		disposition.getDispositionen().get(0).setWarehousestockPassedPeriod(dbch.findMaterial(26).getAmount());
//		disposition.getDispositionen().get(1).setWarehousestockPassedPeriod(dbch.findMaterial(51).getAmount());
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(0).setWaitingQueue2(0);
//		disposition.getDispositionen().get(1).setWaitingQueue2(100);
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(0).setOrdersInProgress(0);
//		disposition.getDispositionen().get(1).setOrdersInProgress(0);
//		
//		disposition.getDispositionen().get(0).setOrders(disposition.getDispositionen().get(0).getSalesOrders() + disposition.getDispositionen().get(0).getWaitingQueue1() + disposition.getDispositionen().get(0).getSafetyWarehousestock() - disposition.getDispositionen().get(0).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(0).getWaitingQueue2() - disposition.getDispositionen().get(0).getOrdersInProgress());
//		disposition.getDispositionen().get(1).setOrders(disposition.getDispositionen().get(1).getSalesOrders() + disposition.getDispositionen().get(1).getWaitingQueue1() + disposition.getDispositionen().get(1).getSafetyWarehousestock() - disposition.getDispositionen().get(1).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(1).getWaitingQueue2() - disposition.getDispositionen().get(1).getOrdersInProgress());
//		
//		/**
//		 *  E16, E17 und E50
//		 */
//		disposition.getDispositionen().get(2).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
//		disposition.getDispositionen().get(3).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
//		disposition.getDispositionen().get(4).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
//		
//		disposition.getDispositionen().get(2).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
//		disposition.getDispositionen().get(3).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
//		disposition.getDispositionen().get(4).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
//		
//		//TODO Input Sicherheitsbestand
//		disposition.getDispositionen().get(2).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(3).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(4).setSafetyWarehousestock(50);
//				
//		disposition.getDispositionen().get(2).setWarehousestockPassedPeriod(dbch.findMaterial(16).getAmount());
//		disposition.getDispositionen().get(3).setWarehousestockPassedPeriod(dbch.findMaterial(17).getAmount());
//		disposition.getDispositionen().get(4).setWarehousestockPassedPeriod(dbch.findMaterial(50).getAmount());
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(2).setWaitingQueue2(0);
//		disposition.getDispositionen().get(3).setWaitingQueue2(0);
//		disposition.getDispositionen().get(4).setWaitingQueue2(0);
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(2).setOrdersInProgress(0);
//		disposition.getDispositionen().get(3).setOrdersInProgress(0);
//		disposition.getDispositionen().get(4).setOrdersInProgress(0);
//		
//		disposition.getDispositionen().get(2).setOrders(disposition.getDispositionen().get(2).getSalesOrders() + disposition.getDispositionen().get(2).getWaitingQueue1() + disposition.getDispositionen().get(2).getSafetyWarehousestock() - disposition.getDispositionen().get(2).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(2).getWaitingQueue2() - disposition.getDispositionen().get(2).getOrdersInProgress());
//		disposition.getDispositionen().get(3).setOrders(disposition.getDispositionen().get(3).getSalesOrders() + disposition.getDispositionen().get(3).getWaitingQueue1() + disposition.getDispositionen().get(3).getSafetyWarehousestock() - disposition.getDispositionen().get(3).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(3).getWaitingQueue2() - disposition.getDispositionen().get(3).getOrdersInProgress());
//		disposition.getDispositionen().get(4).setOrders(disposition.getDispositionen().get(4).getSalesOrders() + disposition.getDispositionen().get(4).getWaitingQueue1() + disposition.getDispositionen().get(2).getSafetyWarehousestock() - disposition.getDispositionen().get(4).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(4).getWaitingQueue2() - disposition.getDispositionen().get(4).getOrdersInProgress());
//	
//		/**
//		 *  E4, E10 und E49
//		 */
//		disposition.getDispositionen().get(5).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
//		disposition.getDispositionen().get(6).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
//		disposition.getDispositionen().get(7).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
//		
//		disposition.getDispositionen().get(5).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
//		disposition.getDispositionen().get(6).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
//		disposition.getDispositionen().get(7).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
//		
//		//TODO Input Sicherheitsbestand
//		disposition.getDispositionen().get(5).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(6).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(7).setSafetyWarehousestock(50);
//		
//		disposition.getDispositionen().get(5).setWarehousestockPassedPeriod(dbch.findMaterial(4).getAmount());
//		disposition.getDispositionen().get(6).setWarehousestockPassedPeriod(dbch.findMaterial(10).getAmount());
//		disposition.getDispositionen().get(7).setWarehousestockPassedPeriod(dbch.findMaterial(49).getAmount());
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(5).setWaitingQueue2(0);
//		disposition.getDispositionen().get(6).setWaitingQueue2(0);
//		disposition.getDispositionen().get(7).setWaitingQueue2(0);
//				
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(5).setOrdersInProgress(0);
//		disposition.getDispositionen().get(6).setOrdersInProgress(0);
//		disposition.getDispositionen().get(7).setOrdersInProgress(0);
//		
//		disposition.getDispositionen().get(5).setOrders(disposition.getDispositionen().get(5).getSalesOrders() + disposition.getDispositionen().get(5).getWaitingQueue1() + disposition.getDispositionen().get(5).getSafetyWarehousestock() - disposition.getDispositionen().get(5).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(5).getWaitingQueue2() - disposition.getDispositionen().get(5).getOrdersInProgress());
//		disposition.getDispositionen().get(6).setOrders(disposition.getDispositionen().get(6).getSalesOrders() + disposition.getDispositionen().get(6).getWaitingQueue1() + disposition.getDispositionen().get(6).getSafetyWarehousestock() - disposition.getDispositionen().get(6).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(6).getWaitingQueue2() - disposition.getDispositionen().get(6).getOrdersInProgress());
//		disposition.getDispositionen().get(7).setOrders(disposition.getDispositionen().get(7).getSalesOrders() + disposition.getDispositionen().get(7).getWaitingQueue1() + disposition.getDispositionen().get(7).getSafetyWarehousestock() - disposition.getDispositionen().get(7).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(7).getWaitingQueue2() - disposition.getDispositionen().get(7).getOrdersInProgress());
//	
//		/**
//		 *  E47, E13 und E18
//		 */
//		disposition.getDispositionen().get(8).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
//		disposition.getDispositionen().get(9).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
//		disposition.getDispositionen().get(10).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
//		
//		disposition.getDispositionen().get(8).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
//		disposition.getDispositionen().get(9).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
//		disposition.getDispositionen().get(10).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
//		
//		//TODO Input Sicherheitsbestand
//		disposition.getDispositionen().get(8).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(9).setSafetyWarehousestock(50);
//		disposition.getDispositionen().get(10).setSafetyWarehousestock(50);
//		
//		disposition.getDispositionen().get(8).setWarehousestockPassedPeriod(dbch.findMaterial(7).getAmount());
//		disposition.getDispositionen().get(9).setWarehousestockPassedPeriod(dbch.findMaterial(13).getAmount());
//		disposition.getDispositionen().get(10).setWarehousestockPassedPeriod(dbch.findMaterial(18).getAmount());
//		
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(8).setWaitingQueue2(0);
//		disposition.getDispositionen().get(9).setWaitingQueue2(0);
//		disposition.getDispositionen().get(10).setWaitingQueue2(0);
//				
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(8).setOrdersInProgress(0);
//		disposition.getDispositionen().get(9).setOrdersInProgress(0);
//		disposition.getDispositionen().get(10).setOrdersInProgress(0);
//		
//		disposition.getDispositionen().get(8).setOrders(disposition.getDispositionen().get(8).getSalesOrders() + disposition.getDispositionen().get(8).getWaitingQueue1() + disposition.getDispositionen().get(8).getSafetyWarehousestock() - disposition.getDispositionen().get(8).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(8).getWaitingQueue2() - disposition.getDispositionen().get(8).getOrdersInProgress());
//		disposition.getDispositionen().get(9).setOrders(disposition.getDispositionen().get(9).getSalesOrders() + disposition.getDispositionen().get(9).getWaitingQueue1() + disposition.getDispositionen().get(9).getSafetyWarehousestock() - disposition.getDispositionen().get(9).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(9).getWaitingQueue2() - disposition.getDispositionen().get(9).getOrdersInProgress());
//		disposition.getDispositionen().get(10).setOrders(disposition.getDispositionen().get(10).getSalesOrders() + disposition.getDispositionen().get(10).getWaitingQueue1() + disposition.getDispositionen().get(10).getSafetyWarehousestock() - disposition.getDispositionen().get(10).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(10).getWaitingQueue2() - disposition.getDispositionen().get(10).getOrdersInProgress());
//	}
//	
//	public void QueueInput2(Disposition disposition, ProductionProg productionProg){
//		
//		/**
//		 *  Lagerhandler initialisieren
//		 */
//		DatabaseContentHandler dbch = DatabaseContentHandler.get();
//		
//		//Vertertriebswunsch
//				disposition.setSalesOrders(productionProg.getN());
//				// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
//				disposition.setWaitingQueue1(0);
//				//TODO Input Sicherheitsbestand fehlt
//				//Lagerbestand geplant
//				disposition.setSafetyWarehousestock(30);
//				//Lagerbestand Vorperiode
//				disposition.setWarehousestockPassedPeriod(dbch.findMaterial(2).getAmount());
//				//TODO @Daniel Funktionen liefern
//				// Warteschlange (uebergeordnet)
//				disposition.setWaitingQueue2(0);
//				//TODO @Daniel Funktionen liefern
//				// Auftraege in Bearbeitung
//				disposition.setOrdersInProgress(0);
//				// Produktionsauftraege kommende Periode
//				disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
//				
//				/**
//				 *  Dispositionswerte der Komponenten von P2 setzten
//				 */
//				setValueFirstPack(disposition, dbch, 0, 26);
//				setValueFirstPack(disposition, dbch, 1, 56);
//				
//				setValueOtherPack(disposition, dbch, 2, 16, 1);
//				setValueOtherPack(disposition, dbch, 3, 17, 1);
//				setValueOtherPack(disposition, dbch, 4, 55, 1);
//				
//				setValueOtherPack(disposition, dbch, 5,  5, 4);
//				setValueOtherPack(disposition, dbch, 6, 11, 4);
//				setValueOtherPack(disposition, dbch, 7, 54, 4);
//				
//				setValueOtherPack(disposition, dbch, 8,   8, 7);
//				setValueOtherPack(disposition, dbch, 9,  14, 7);
//				setValueOtherPack(disposition, dbch, 10, 19, 7);
//				
//	}
//	
//	public void QueueInput3(Disposition disposition, ProductionProg productionProg){
//		
//
//		/**
//		 *  Lagerhandler initialisieren
//		 */
//		DatabaseContentHandler dbch = DatabaseContentHandler.get();
//		
//		//Vertertriebswunsch
//				disposition.setSalesOrders(productionProg.getN());
//				// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
//				disposition.setWaitingQueue1(0);
//				//TODO Input Sicherheitsbestand fehlt
//				//Lagerbestand geplant
//				disposition.setSafetyWarehousestock(30);
//				//Lagerbestand Vorperiode
//				disposition.setWarehousestockPassedPeriod(dbch.findMaterial(3).getAmount());
//				//TODO @Daniel Funktionen liefern
//				// Warteschlange (uebergeordnet)
//				disposition.setWaitingQueue2(0);
//				//TODO @Daniel Funktionen liefern
//				// Auftraege in Bearbeitung
//				disposition.setOrdersInProgress(0);
//				// Produktionsauftraege kommende Periode
//				disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
//	
//				/**
//				 *  Dispositionswerte der Komponenten von P3 setzten
//				 */
//				setValueFirstPack(disposition, dbch, 0, 26);
//				setValueFirstPack(disposition, dbch, 1, 31);
//				
//				setValueOtherPack(disposition, dbch, 2, 16, 1);
//				setValueOtherPack(disposition, dbch, 3, 17, 1);
//				setValueOtherPack(disposition, dbch, 4, 30, 1);
//				
//				setValueOtherPack(disposition, dbch, 5,  6, 4);
//				setValueOtherPack(disposition, dbch, 6, 12, 4);
//				setValueOtherPack(disposition, dbch, 7, 29, 4);
//				
//				setValueOtherPack(disposition, dbch, 8,   9, 7);
//				setValueOtherPack(disposition, dbch, 9,  15, 7);
//				setValueOtherPack(disposition, dbch, 10, 20, 7);
//	}
//	
//
//	/**
//	 *  Dispositions Zuordnungsfunktion
//	 *  a=Listenindex b=Bauteilnummer
//	 */
//	public void setValueFirstPack(Disposition disposition, DatabaseContentHandler dbch, int a, int b) {
//		
//			disposition.getDispositionen().get(a).setSalesOrders(disposition.getOrders());
//			disposition.getDispositionen().get(a).setWaitingQueue1(disposition.getWaitingQueue2());
//			//TODO Input Sicherheitsbestand
//			disposition.getDispositionen().get(a).setSafetyWarehousestock(50);
//			disposition.getDispositionen().get(a).setWarehousestockPassedPeriod(dbch.findMaterial(b).getAmount());			
//			//TODO @Daniel Funktionen liefern
//			disposition.getDispositionen().get(a).setWaitingQueue2(0);			
//			//TODO @Daniel Funktionen liefern
//			disposition.getDispositionen().get(a).setOrdersInProgress(0);						
//			disposition.getDispositionen().get(a).setOrders(disposition.getDispositionen().get(a).getSalesOrders() + disposition.getDispositionen().get(a).getWaitingQueue1() + disposition.getDispositionen().get(a).getSafetyWarehousestock() - disposition.getDispositionen().get(a).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(a).getWaitingQueue2() - disposition.getDispositionen().get(a).getOrdersInProgress());	
//	}
//	
//	/**
//	 *  Dispositions Zuordnungsfunktion
//	 *  a=Listenindex b=Bauteilnummer c=IndexVorgaenger
//	 */
//	public void setValueOtherPack(Disposition disposition, DatabaseContentHandler dbch, int a, int b, int c) {
//		
//		disposition.getDispositionen().get(a).setSalesOrders(disposition.getDispositionen().get(c).getOrders());				
//		disposition.getDispositionen().get(a).setWaitingQueue1(disposition.getDispositionen().get(c).getWaitingQueue2());		
//		//TODO Input Sicherheitsbestand
//		disposition.getDispositionen().get(a).setSafetyWarehousestock(50);						
//		disposition.getDispositionen().get(a).setWarehousestockPassedPeriod(dbch.findMaterial(b).getAmount());				
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(a).setWaitingQueue2(0);				
//		//TODO @Daniel Funktionen liefern
//		disposition.getDispositionen().get(a).setOrdersInProgress(0);			
//		disposition.getDispositionen().get(a).setOrders(disposition.getDispositionen().get(a).getSalesOrders() + disposition.getDispositionen().get(a).getWaitingQueue1() + disposition.getDispositionen().get(a).getSafetyWarehousestock() - disposition.getDispositionen().get(a).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(a).getWaitingQueue2() - disposition.getDispositionen().get(a).getOrdersInProgress());
//	}
	

}
