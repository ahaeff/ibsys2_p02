package scstool.proc;

import scstool.obj.Disposition;
import scstool.obj.ProductionProg;

/**
 * @Autor Alexander
 * 
 */
public class DispositionService {
	
	public void QueueInput1(Disposition disposition, ProductionProg productionProg){
		
		/**
		 *  Lagerhandler initialisieren
		 */
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		
		/**
		 *  Dispositionswerte P1 setzten
		 */
		//Vertertriebswunsch
		disposition.setSalesOrders(productionProg.getN());
		// Aufträge in der Warteschlange (untergeordnet) immer fixer Wert für erste Position
		disposition.setWaitingQueue1(0);
		//TODO Input Sicherheitsbestand fehlt
		//Lagerbestand geplant
		disposition.setSafetyWarehousestock(30);
		//Lagerbestand Vorperiode
		disposition.setWarehousestockPassedPeriod(dbch.findMaterial(1).getAmount());
		//TODO @Daniel Funktionen liefern
		// Warteschlange (uebergeordnet)
		disposition.setWaitingQueue2(0);
		//TODO @Daniel Funktionen liefern
		// Auftraege in Bearbeitung
		disposition.setOrdersInProgress(0);
		// Produktionsauftraege kommende Periode
		disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
		
		/**
		 *  Dispositionswerte der Komponenten von P1 setzten
		 */
		/**
		 *  E26 und E51
		 */
		disposition.getDispositionen().get(0).setSalesOrders(disposition.getOrders());
		disposition.getDispositionen().get(1).setSalesOrders(disposition.getOrders());
		
		disposition.getDispositionen().get(0).setWaitingQueue2(disposition.getWaitingQueue2());
		disposition.getDispositionen().get(1).setWaitingQueue2(disposition.getWaitingQueue2());
		//TODO Input Sicherheitsbestand
		disposition.getDispositionen().get(0).setSafetyWarehousestock(50);
		disposition.getDispositionen().get(1).setSafetyWarehousestock(50);
		
		disposition.getDispositionen().get(0).setWarehousestockPassedPeriod(dbch.findMaterial(26).getAmount());
		disposition.getDispositionen().get(1).setWarehousestockPassedPeriod(dbch.findMaterial(51).getAmount());
		
		//TODO @Daniel Funktionen liefern
		disposition.getDispositionen().get(0).setWaitingQueue2(0);
		disposition.getDispositionen().get(1).setWaitingQueue2(100);
		
		//TODO @Daniel Funktionen liefern
		disposition.getDispositionen().get(0).setOrdersInProgress(0);
		disposition.getDispositionen().get(1).setOrdersInProgress(0);
		
		disposition.getDispositionen().get(0).setOrders(disposition.getDispositionen().get(0).getSalesOrders() + disposition.getDispositionen().get(0).getWaitingQueue2() + disposition.getDispositionen().get(0).getSafetyWarehousestock() - disposition.getDispositionen().get(0).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(0).getWaitingQueue2() - disposition.getDispositionen().get(0).getOrdersInProgress());
		disposition.getDispositionen().get(1).setOrders(disposition.getDispositionen().get(1).getSalesOrders() + disposition.getDispositionen().get(1).getWaitingQueue2() + disposition.getDispositionen().get(1).getSafetyWarehousestock() - disposition.getDispositionen().get(1).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(1).getWaitingQueue2() - disposition.getDispositionen().get(1).getOrdersInProgress());
		
		/**
		 *  E16, E17 und E50
		 */
		disposition.getDispositionen().get(2).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		disposition.getDispositionen().get(3).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		disposition.getDispositionen().get(4).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		
	}

}
