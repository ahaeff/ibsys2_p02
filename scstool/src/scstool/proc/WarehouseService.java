package scstool.proc;

import java.util.List;

import scstool.obj.Material;
import scstool.obj.SellWish;
import scstool.utils.Repository;

public class WarehouseService {
	
	
	//Lagerwert dieses Artikels
	private Double warehouseStock = 0.0;
	//Lagerwert gesamt (aller Materialien)
	private Double warehouseStockAll = 0.0;

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

	public void setWarehouseStockAll(Double warehouseStockAll) {
		this.warehouseStockAll = warehouseStockAll;
	}
	
	public Double getWarehouseStockAll() {
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		List<Material> allesMaterial = dbch.getAllMaterial();
		for (Material m : allesMaterial) {
			warehouseStockAll = warehouseStockAll + m.getAmount() * m.getPrice();
		}
		return warehouseStockAll;
	}
	
	public Double getProfit()
	{
		Repository repo = Repository.getInstance();
		DatabaseContentHandler dbch = DatabaseContentHandler.get();
		double ret = 0.0;
		for(int i = 0;i<3;i++)
		{
			int sellwish = repo.getSellWish(i+1).getN();
			double p = dbch.getAllMaterial().get(i).getPrice();
			
			ret = ret +((sellwish * 200)-(sellwish * p));	
		}
		
		//Lagerkosten abziehen;
		Double stock = getWarehouseStockAll();
		
		if(stock >= 250000.0)
		{
			ret = ret -((250000.0 * 0.006)+((stock-250000.0)*0.012))-5000;
		}
		else
		{
			ret = ret - stock * 0.006;
		}
		
		return ret;
	}
}
