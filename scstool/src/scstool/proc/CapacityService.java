/**
 * 
 */
package scstool.proc;

import java.util.ArrayList;
import java.util.List;

import scstool.obj.BillOfMaterial;
import scstool.obj.Material;
import scstool.obj.WaitingList;
import scstool.obj.WorkPlan;
import scstool.obj.Workplace;
import scstool.utils.Repository;

/**
 * Kapazitätenplanung
 * 
 * @author reinhold
 * 
 */
public class CapacityService {

	/**
	 * Kalkuliert die benötigte Kapzität für einen Arbeitsplatz ohne die
	 * Materialien in der Warteschlange.
	 * 
	 * @param workplace
	 *            der Arbeitsplatz
	 * @param productionProgram
	 *            das Produktionsprogramm als Integer Array
	 * @return die benötigte Kapazität in Minuten mit Rüstzeit
	 */
	public static Integer calculateWorkplaceCapacity(Workplace workplace,
			List<Integer[]> productionProgram) {

		List<Material> done = new ArrayList<>();
		Integer result = 0;

		// suche in dem Produktionsprogramm
		for (Integer[] prodMat : productionProgram) {

			// suche in den Arbeitsplänen für einen Arbeitsplatz
			for (WorkPlan plan : workplace.getWorkplan()) {

				// suche in den Stücklisteneinträgen in den Arbeitsplänen
				for (BillOfMaterial bom : plan.getBillOfMaterial()) {
					// nach dem zu fertigenden Material
					Material component = bom.getComponent();
					// wenn das fertigende Material in der Liste enthalten ist
					// wurde es schon hinzugefügt
					if (!done.contains(component)) {
						// wenn das Material im Produktionsprogramm gleich sind
						if (prodMat[0] == component.getId()) {
							// addiere die produzierende Zeit
							result += (plan.getProductionTime() * prodMat[1]);
							// addiere die Rüstzeit
							result += plan.getSetupTime();
							done.add(component);
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Rechnet die noch einzurechnende Kapazität für einen Arbeitsplatz.
	 * 
	 * @param workplace
	 * @return
	 */
	public static Integer calculateWaitingListCapacity(Workplace workplace) {

		Integer result = 0;
		Repository repo = Repository.getInstance();
		for (WaitingList wl : repo.getInWork()) {
			result += wl.getTimeneed();
		}

		return result;
	}
	
	//TODO Schichtenberechnung

}
