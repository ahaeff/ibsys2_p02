package scstool.proc;

import java.util.List;

import scstool.obj.Material;
import scstool.obj.Material.PartTypes;
import scstool.utils.Repository;

public class WarehouseService {

	// Lagerwert dieses Artikels
	private Double warehouseStock = 0.0;
	// Lagerwert gesamt (aller Materialien)
	private Double warehouseStockAll = 0.0;

	public Double calcWarehouseStock(Material material) {

		warehouseStock = warehouseStock + material.getAmount()
				* material.getPrice();

		return warehouseStock;
	}

	public Double getWarehouseStock() {
		return warehouseStock;
	}

	public void setWarehouseStock(Double warehouseStock) {
		this.warehouseStock = warehouseStock;
	}

	public void setWarehouseStockAll(Double warehouseStockAll) {
		this.warehouseStockAll = warehouseStockAll;
	}

	public Double getfutureWarehouseStock() {
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		List<Material> allesMaterial = dbch.getAllMaterial();
		for (Material m : allesMaterial) {
			int amount = 0;
			if (PartTypes.PRODUCT.equals(m.getPartType())
					|| PartTypes.SUBASSEMBLY.equals(m.getPartType())) {
				// Sicherheitsbestand am Ende
				amount += Repository.getInstance().getStafetyStock(m.getId());
			} else {
				// Eingehende Bestellungen
				amount += Repository.getInstance().getArrivalAmountOfMaterial(
						m, 1);
				// Lagermenge
				amount += m.getAmount();
				// Bedarfsmenge
				amount -= Repository.getInstance().getNeeds(m, 0);
			}
			warehouseStockAll = warehouseStockAll + amount * m.getPrice();
		}
		return warehouseStockAll;
	}

}
