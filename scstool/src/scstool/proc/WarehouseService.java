package scstool.proc;

import scstool.obj.Material;

public class WarehouseService {
	
	private Double warehouseStock = 0.0;
	
	public Double calcWarehouseStock(Material material){
		
		warehouseStock = warehouseStock + material.getAmount() * material.getPrice();
		
		return warehouseStock;
	}

	
	public Double getWarehouseStock() {
		return warehouseStock;
	}

	public void setWarehouseStock(Double warehouseStock) {
		this.warehouseStock = warehouseStock;
	}

}
