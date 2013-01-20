package scstool.proc;

import scstool.obj.Disposition;
import scstool.obj.SellWish;
import scstool.utils.Repository;
/**
 * @Autor Alexander
 * 
 */
/**
 * @author haeff
 *
 */
public class DispositionService {
	
	//Disposition P1
/*	public void QueueInput1(Disposition disposition, Repository repository, SellWish sellWish){
		
		*//**
		 *  Lagerhandler initialisieren
		 *//*
		DatabaseContentHandler dbch = DatabaseContentHandler.get();		
		Repository repo = Repository.getInstance();		
				
		
		*//**
		 *  Dispositionswerte P1 setzten
		 *//*
		//Vertertriebswunsch
		disposition.setSalesOrders(sellWish.getN());
		// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
		disposition.setWaitingQueue1(0);
		//Lagerbestand geplant
		disposition.setSafetyWarehousestock(repo.getStafetyStock(1));
		//Lagerbestand Vorperiode
		disposition.setWarehousestockPassedPeriod(dbch.findMaterial(1).getAmount());
		// Warteschlange (uebergeordnet)
		disposition.setWaitingQueue2(repo.getAmountOfWaitingMaterial(1));
		// Auftraege in Bearbeitung
		disposition.setOrdersInProgress(repo.getAmountOfMaterialInWork(1));
		// Produktionsauftraege kommende Periode
		disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
		
		*//**
		 *  Dispositionswerte der Komponenten von P1 setzten
		 *//*
		*//**
		 *  E26 und E51
		 *//*
		disposition.getDispositionen().get(0).setSalesOrders(disposition.getOrders());
		disposition.getDispositionen().get(1).setSalesOrders(disposition.getOrders());
		
		disposition.getDispositionen().get(0).setWaitingQueue1(disposition.getWaitingQueue2());
		disposition.getDispositionen().get(1).setWaitingQueue1(disposition.getWaitingQueue2());
	
		disposition.getDispositionen().get(0).setSafetyWarehousestock(repo.getStafetyStock(26));
		disposition.getDispositionen().get(1).setSafetyWarehousestock(repo.getStafetyStock(51));
		
		disposition.getDispositionen().get(0).setWarehousestockPassedPeriod(dbch.findMaterial(26).getAmount());
		disposition.getDispositionen().get(1).setWarehousestockPassedPeriod(dbch.findMaterial(51).getAmount());
		
		disposition.getDispositionen().get(0).setWaitingQueue2(repo.getAmountOfWaitingMaterial(26));
		disposition.getDispositionen().get(1).setWaitingQueue2(repo.getAmountOfWaitingMaterial(51));
		
		disposition.getDispositionen().get(0).setOrdersInProgress(repo.getAmountOfMaterialInWork(26));
		disposition.getDispositionen().get(1).setOrdersInProgress(repo.getAmountOfMaterialInWork(51));
		
		disposition.getDispositionen().get(0).setOrders(disposition.getDispositionen().get(0).getSalesOrders() + disposition.getDispositionen().get(0).getWaitingQueue1() + disposition.getDispositionen().get(0).getSafetyWarehousestock() - disposition.getDispositionen().get(0).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(0).getWaitingQueue2() - disposition.getDispositionen().get(0).getOrdersInProgress());
		disposition.getDispositionen().get(1).setOrders(disposition.getDispositionen().get(1).getSalesOrders() + disposition.getDispositionen().get(1).getWaitingQueue1() + disposition.getDispositionen().get(1).getSafetyWarehousestock() - disposition.getDispositionen().get(1).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(1).getWaitingQueue2() - disposition.getDispositionen().get(1).getOrdersInProgress());
		
		*//**
		 *  E16, E17 und E50
		 *//*
		disposition.getDispositionen().get(2).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		disposition.getDispositionen().get(3).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		disposition.getDispositionen().get(4).setSalesOrders(disposition.getDispositionen().get(1).getOrders());
		
		disposition.getDispositionen().get(2).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
		disposition.getDispositionen().get(3).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
		disposition.getDispositionen().get(4).setWaitingQueue1(disposition.getDispositionen().get(1).getWaitingQueue2());
		
		disposition.getDispositionen().get(2).setSafetyWarehousestock(repo.getStafetyStock(16));
		disposition.getDispositionen().get(3).setSafetyWarehousestock(repo.getStafetyStock(17));
		disposition.getDispositionen().get(4).setSafetyWarehousestock(repo.getStafetyStock(50));
				
		disposition.getDispositionen().get(2).setWarehousestockPassedPeriod(dbch.findMaterial(16).getAmount());
		disposition.getDispositionen().get(3).setWarehousestockPassedPeriod(dbch.findMaterial(17).getAmount());
		disposition.getDispositionen().get(4).setWarehousestockPassedPeriod(dbch.findMaterial(50).getAmount());
		
		disposition.getDispositionen().get(2).setWaitingQueue2(repo.getAmountOfWaitingMaterial(16));
		disposition.getDispositionen().get(3).setWaitingQueue2(repo.getAmountOfWaitingMaterial(17));
		disposition.getDispositionen().get(4).setWaitingQueue2(repo.getAmountOfWaitingMaterial(50));
		
		disposition.getDispositionen().get(2).setOrdersInProgress(repo.getAmountOfMaterialInWork(16));
		disposition.getDispositionen().get(3).setOrdersInProgress(repo.getAmountOfMaterialInWork(17));
		disposition.getDispositionen().get(4).setOrdersInProgress(repo.getAmountOfMaterialInWork(50));
		
		disposition.getDispositionen().get(2).setOrders(disposition.getDispositionen().get(2).getSalesOrders() + disposition.getDispositionen().get(2).getWaitingQueue1() + disposition.getDispositionen().get(2).getSafetyWarehousestock() - disposition.getDispositionen().get(2).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(2).getWaitingQueue2() - disposition.getDispositionen().get(2).getOrdersInProgress());
		disposition.getDispositionen().get(3).setOrders(disposition.getDispositionen().get(3).getSalesOrders() + disposition.getDispositionen().get(3).getWaitingQueue1() + disposition.getDispositionen().get(3).getSafetyWarehousestock() - disposition.getDispositionen().get(3).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(3).getWaitingQueue2() - disposition.getDispositionen().get(3).getOrdersInProgress());
		disposition.getDispositionen().get(4).setOrders(disposition.getDispositionen().get(4).getSalesOrders() + disposition.getDispositionen().get(4).getWaitingQueue1() + disposition.getDispositionen().get(2).getSafetyWarehousestock() - disposition.getDispositionen().get(4).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(4).getWaitingQueue2() - disposition.getDispositionen().get(4).getOrdersInProgress());
	
		*//**
		 *  E4, E10 und E49
		 *//*
		disposition.getDispositionen().get(5).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
		disposition.getDispositionen().get(6).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
		disposition.getDispositionen().get(7).setSalesOrders(disposition.getDispositionen().get(4).getOrders());
		
		disposition.getDispositionen().get(5).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
		disposition.getDispositionen().get(6).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
		disposition.getDispositionen().get(7).setWaitingQueue1(disposition.getDispositionen().get(4).getWaitingQueue2());
		
		disposition.getDispositionen().get(5).setSafetyWarehousestock(repo.getStafetyStock(4));
		disposition.getDispositionen().get(6).setSafetyWarehousestock(repo.getStafetyStock(10));
		disposition.getDispositionen().get(7).setSafetyWarehousestock(repo.getStafetyStock(49));
		
		disposition.getDispositionen().get(5).setWarehousestockPassedPeriod(dbch.findMaterial(4).getAmount());
		disposition.getDispositionen().get(6).setWarehousestockPassedPeriod(dbch.findMaterial(10).getAmount());
		disposition.getDispositionen().get(7).setWarehousestockPassedPeriod(dbch.findMaterial(49).getAmount());
		
		disposition.getDispositionen().get(5).setWaitingQueue2(repo.getAmountOfWaitingMaterial(4));
		disposition.getDispositionen().get(6).setWaitingQueue2(repo.getAmountOfWaitingMaterial(10));
		disposition.getDispositionen().get(7).setWaitingQueue2(repo.getAmountOfWaitingMaterial(49));
				
		disposition.getDispositionen().get(5).setOrdersInProgress(repo.getAmountOfMaterialInWork(4));
		disposition.getDispositionen().get(6).setOrdersInProgress(repo.getAmountOfMaterialInWork(10));
		disposition.getDispositionen().get(7).setOrdersInProgress(repo.getAmountOfMaterialInWork(49));
		
		disposition.getDispositionen().get(5).setOrders(disposition.getDispositionen().get(5).getSalesOrders() + disposition.getDispositionen().get(5).getWaitingQueue1() + disposition.getDispositionen().get(5).getSafetyWarehousestock() - disposition.getDispositionen().get(5).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(5).getWaitingQueue2() - disposition.getDispositionen().get(5).getOrdersInProgress());
		disposition.getDispositionen().get(6).setOrders(disposition.getDispositionen().get(6).getSalesOrders() + disposition.getDispositionen().get(6).getWaitingQueue1() + disposition.getDispositionen().get(6).getSafetyWarehousestock() - disposition.getDispositionen().get(6).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(6).getWaitingQueue2() - disposition.getDispositionen().get(6).getOrdersInProgress());
		disposition.getDispositionen().get(7).setOrders(disposition.getDispositionen().get(7).getSalesOrders() + disposition.getDispositionen().get(7).getWaitingQueue1() + disposition.getDispositionen().get(7).getSafetyWarehousestock() - disposition.getDispositionen().get(7).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(7).getWaitingQueue2() - disposition.getDispositionen().get(7).getOrdersInProgress());
	
		*//**
		 *  E47, E13 und E18
		 *//*
		disposition.getDispositionen().get(8).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
		disposition.getDispositionen().get(9).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
		disposition.getDispositionen().get(10).setSalesOrders(disposition.getDispositionen().get(7).getOrders());
		
		disposition.getDispositionen().get(8).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
		disposition.getDispositionen().get(9).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
		disposition.getDispositionen().get(10).setWaitingQueue1(disposition.getDispositionen().get(7).getWaitingQueue2());
		
		disposition.getDispositionen().get(8).setSafetyWarehousestock(repo.getStafetyStock(47));
		disposition.getDispositionen().get(9).setSafetyWarehousestock(repo.getStafetyStock(13));
		disposition.getDispositionen().get(10).setSafetyWarehousestock(repo.getStafetyStock(18));
		
		disposition.getDispositionen().get(8).setWarehousestockPassedPeriod(dbch.findMaterial(7).getAmount());
		disposition.getDispositionen().get(9).setWarehousestockPassedPeriod(dbch.findMaterial(13).getAmount());
		disposition.getDispositionen().get(10).setWarehousestockPassedPeriod(dbch.findMaterial(18).getAmount());
		
		disposition.getDispositionen().get(8).setWaitingQueue2(repo.getAmountOfWaitingMaterial(47));
		disposition.getDispositionen().get(9).setWaitingQueue2(repo.getAmountOfWaitingMaterial(13));
		disposition.getDispositionen().get(10).setWaitingQueue2(repo.getAmountOfWaitingMaterial(18));
				
		disposition.getDispositionen().get(8).setOrdersInProgress(repo.getAmountOfMaterialInWork(47));
		disposition.getDispositionen().get(9).setOrdersInProgress(repo.getAmountOfMaterialInWork(13));
		disposition.getDispositionen().get(10).setOrdersInProgress(repo.getAmountOfMaterialInWork(18));
		
		disposition.getDispositionen().get(8).setOrders(disposition.getDispositionen().get(8).getSalesOrders() + disposition.getDispositionen().get(8).getWaitingQueue1() + disposition.getDispositionen().get(8).getSafetyWarehousestock() - disposition.getDispositionen().get(8).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(8).getWaitingQueue2() - disposition.getDispositionen().get(8).getOrdersInProgress());
		disposition.getDispositionen().get(9).setOrders(disposition.getDispositionen().get(9).getSalesOrders() + disposition.getDispositionen().get(9).getWaitingQueue1() + disposition.getDispositionen().get(9).getSafetyWarehousestock() - disposition.getDispositionen().get(9).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(9).getWaitingQueue2() - disposition.getDispositionen().get(9).getOrdersInProgress());
		disposition.getDispositionen().get(10).setOrders(disposition.getDispositionen().get(10).getSalesOrders() + disposition.getDispositionen().get(10).getWaitingQueue1() + disposition.getDispositionen().get(10).getSafetyWarehousestock() - disposition.getDispositionen().get(10).getWarehousestockPassedPeriod() - disposition.getDispositionen().get(10).getWaitingQueue2() - disposition.getDispositionen().get(10).getOrdersInProgress());
	}
	*/
	//Disposition P2
	public void QueueInput2(){
		
		/**
		 *  Lagerhandler initialisieren
		 */
		
		//P1
		setPMaterialDispo(1, 1);
		
		//E26
		setEMaterialDispo(1, 26, 1);
		
		//E56
		setEMaterialDispo(1, 56, 1);
		
		
/*		//Vertertriebswunsch
		disposition.setSalesOrders(sellWish.getN());
		// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
		disposition.setWaitingQueue1(0);
		//Lagerbestand geplant
		disposition.setSafetyWarehousestock(repo.getStafetyStock(2));
		//Lagerbestand Vorperiode
		//disposition.setWarehousestockPassedPeriod(dbch.findMaterial(2).getAmount());
		disposition.setWarehousestockPassedPeriod(0);
		// Warteschlange (uebergeordnet)
		disposition.setWaitingQueue2(repo.getAmountOfWaitingMaterial(2));
		// Auftraege in Bearbeitung
		disposition.setOrdersInProgress(repo.getAmountOfMaterialInWork(2));
		// Produktionsauftraege kommende Periode
		disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());*/
		
		
				/**
				 *  Dispositionswerte der Komponenten von P2 setzten
				 */
/*				setValueFirstPack(disposition, repo, dbch, 0, 26);
				setValueFirstPack(disposition, repo, dbch, 1, 56);
				
				setValueOtherPack(disposition, repo, dbch, 2, 16, 1);
				setValueOtherPack(disposition, repo,  dbch, 3, 17, 1);
				setValueOtherPack(disposition, repo, dbch, 4, 55, 1);
				
				setValueOtherPack(disposition, repo, dbch, 5,  5, 4);
				setValueOtherPack(disposition, repo, dbch, 6, 11, 4);
				setValueOtherPack(disposition, repo, dbch, 7, 54, 4);
				
				setValueOtherPack(disposition, repo, dbch, 8,   8, 7);
				setValueOtherPack(disposition, repo, dbch, 9,  14, 7);
				setValueOtherPack(disposition, repo, dbch, 10, 19, 7);*/
				
				
				//repo.addDispoistion(2, disposition);
				
	}
	
	//Disposition P3
/*	public void QueueInput3(Disposition disposition, Repository repository, SellWish sellWish){
		

		*//**
		 *  Lagerhandler initialisieren
		 *//*
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		
		Repository repo = Repository.getInstance();
		
		//Vertertriebswunsch
				disposition.setSalesOrders(sellWish.getN());
				// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
				disposition.setWaitingQueue1(0);
				//Lagerbestand geplant
				disposition.setSafetyWarehousestock(repo.getStafetyStock(3));
				//Lagerbestand Vorperiode
				disposition.setWarehousestockPassedPeriod(dbch.findMaterial(3).getAmount());
				// Warteschlange (uebergeordnet)
				disposition.setWaitingQueue2(repo.getAmountOfWaitingMaterial(3));
				// Auftraege in Bearbeitung
				disposition.setOrdersInProgress(repo.getAmountOfMaterialInWork(3));
				// Produktionsauftraege kommende Periode
				disposition.setOrders(disposition.getSalesOrders() + disposition.getWaitingQueue1() + disposition.getSafetyWarehousestock() - disposition.getWarehousestockPassedPeriod() - disposition.getWaitingQueue2() - disposition.getOrdersInProgress());
	
				*//**
				 *  Dispositionswerte der Komponenten von P3 setzten
				 *//*
				setValueFirstPack(disposition, repo,  dbch, 0, 26);
				setValueFirstPack(disposition, repo,  dbch, 1, 31);
				
				setValueOtherPack(disposition, repo, dbch, 2, 16, 1);
				setValueOtherPack(disposition, repo,  dbch, 3, 17, 1);
				setValueOtherPack(disposition, repo,  dbch, 4, 30, 1);
				
				setValueOtherPack(disposition, repo, dbch, 5,  6, 4);
				setValueOtherPack(disposition, repo, dbch, 6, 12, 4);
				setValueOtherPack(disposition, repo, dbch, 7, 29, 4);
				
				setValueOtherPack(disposition, repo, dbch, 8,   9, 7);
				setValueOtherPack(disposition, repo, dbch, 9,  15, 7);
				setValueOtherPack(disposition, repo, dbch, 10, 20, 7);
	}*/
	

	/**
	 * Setzt die Dispoition des P-Materials
	 * 
	 * @param P-Material fuer Stueckliste
	 * @param P-Material,E-Material fuer das einzele Material selbst
	 */
	private void setPMaterialDispo(int product, int material)
	{
		Repository repo = Repository.getInstance();
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		
		
		SellWish sellWish = repo.getSellWish(2);
		
		Disposition disposition = new Disposition();
		
		//Vertertriebswunsch
		disposition.setSalesOrders(sellWish.getN());
		
		// Auftr�ge in der Warteschlange (untergeordnet) immer fixer Wert f�r erste Position
		disposition.setWaitingQueue1(0);
		
		//Lagerbestand geplant
		disposition.setSafetyWarehousestock(repo.getStafetyStock(material));
		
		//Lagerbestand Vorperiode
		//disposition.setWarehousestockPassedPeriod(dbch.findMaterial(2).getAmount());
		disposition.setWarehousestockPassedPeriod(0);
		
		// Warteschlange (uebergeordnet)
		disposition.setWaitingQueue2(repo.getAmountOfWaitingMaterial(2));
		
		// Auftraege in Bearbeitung
		disposition.setOrdersInProgress(repo.getAmountOfMaterialInWork(2));
		
		// Produktionsauftraege kommende Periode
		int count = disposition.getSalesOrders() + 
				    disposition.getWaitingQueue1() + 
				    disposition.getSafetyWarehousestock() - 
				    disposition.getWarehousestockPassedPeriod() - 
				    disposition.getWaitingQueue2() - 
				    disposition.getOrdersInProgress();
		disposition.setOrders(count);
		
		repo.addDispoistion(product, material, disposition);
		
	}
	
	/**
	 * Setzt die Dispoition des E-Materials
	 * 
	 * @param P-Material fuer Stueckliste
	 * @param P-Material,E-Material fuer das einzele Material selbst
	 * @param E-Material -> Uebergeortnetes Material
	 */
	private void setEMaterialDispo(int product, int material, int preMaterial)
	{
		Repository repo = Repository.getInstance();
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		
		Disposition disposition = new Disposition();
		Disposition preDisposition = repo.getDispoitionByMaterial(product,preMaterial);
		
		disposition.setSalesOrders(preDisposition.getOrders());
		
		disposition.setWaitingQueue1(preDisposition.getWaitingQueue2());
		
		//Lagerbestand geplant
		disposition.setSafetyWarehousestock(repo.getStafetyStock(material));
		
		//Lagerbestand Vorperiode
		//TODO 0 durch Database-Wert ersetzen
		disposition.setWarehousestockPassedPeriod(0);
		
		// Warteschlange (uebergeordnet)
		disposition.setWaitingQueue2(repo.getAmountOfWaitingMaterial(material));
		
		disposition.setOrdersInProgress(repo.getAmountOfMaterialInWork(material));
		
		// Produktionsauftraege kommende Periode
		int count = disposition.getSalesOrders() + 
					disposition.getWaitingQueue1() + 
					disposition.getSafetyWarehousestock() - 
					disposition.getWarehousestockPassedPeriod() - 
					disposition.getWaitingQueue2() - 
					disposition.getOrdersInProgress();	
		
		disposition.setOrders(count);
		
		repo.addDispoistion(product, material, disposition);
	}
	
	
/*	*//**
	 *  Dispositions Zuordnungsfunktion
	 *  a=Listenindex b=Bauteilnummer
	 *//*
	public return setValueFirstPack(Disposition disposition, Repository repo, DatabaseContentHandler dbch, int a, int b) {
		
			Disposition materialA = disposition.getDispositionen().get(a);
			
			materialA.setSalesOrders(disposition.getOrders());
			materialA.setWaitingQueue1(disposition.getWaitingQueue2());
			materialA.setSafetyWarehousestock(repo.getStafetyStock(b));
			materialA.setWarehousestockPassedPeriod(dbch.findMaterial(b).getAmount());			
			materialA.setWaitingQueue2(repo.getAmountOfWaitingMaterial(b));			
			materialA.setOrdersInProgress(repo.getAmountOfMaterialInWork(b));						
			materialA.setOrders(materialA.getSalesOrders() + materialA.getWaitingQueue1() + materialA.getSafetyWarehousestock() - materialA.getWarehousestockPassedPeriod() - materialA.getWaitingQueue2() - materialA.getOrdersInProgress());	
	}
	
	*//**
	 *  Dispositions Zuordnungsfunktion
	 *  a=Listenindex b=Bauteilnummer c=IndexVorgaenger
	 *//*
	public void setValueOtherPack(Disposition disposition, Repository repo, DatabaseContentHandler dbch, int a, int b, int c) {
			
		Disposition materialA = disposition.getDispositionen().get(a);
		Disposition materialC = disposition.getDispositionen().get(c);
		
		materialA.setSalesOrders(materialC.getOrders());				
		materialA.setWaitingQueue1(materialC.getWaitingQueue2());		
		materialA.setSafetyWarehousestock(repo.getStafetyStock(b));						
		materialA.setWarehousestockPassedPeriod(dbch.findMaterial(b).getAmount());				
		materialA.setWaitingQueue2(repo.getAmountOfWaitingMaterial(b));				
		materialA.setOrdersInProgress(repo.getAmountOfMaterialInWork(b));			
		materialA.setOrders(materialA.getSalesOrders() + materialA.getWaitingQueue1() + materialA.getSafetyWarehousestock() - materialA.getWarehousestockPassedPeriod() - materialA.getWaitingQueue2() - materialA.getOrdersInProgress());
	}*/
}
