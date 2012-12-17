/**
 * 
 */
package scstool.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reinhold
 *
 */
public class BillOfMaterial {
	
	/**
	 * @author reinhold
	 *
	 */
	class MaterialAmount{
		/**
		 * the amount of the material used
		 */
		private Integer amount;
		/**
		 * TODO was ist das? Baugruppe?
		 */
		private boolean assembly;
		/**
		 * the material used
		 */
		private Material material;
		/**
		 * @return the material
		 */
		public Material getMaterial() {
			return material;
		}
		/**
		 * @param material the material to set
		 */
		public void setMaterial(Material material) {
			this.material = material;
		}
		/**
		 * @return the amount
		 */
		public Integer getAmount() {
			return amount;
		}
		/**
		 * @param amount the amount to set
		 */
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		
		@Override
		public String toString() {
			return "MaterialAmount [amount=" + amount + ", assembly="
					+ assembly + ", material=" + material + "]";
		}
		
	}

	/**
	 * the unique id
	 */
	private Integer id;

	/**
	 * the materials and the amount of them to create an other material
	 * you know minecraft ;) 
	 */
	private List<MaterialAmount> materials = new ArrayList<>();
	/**
	 * the material to create
	 */
	private Material component;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the materials
	 */
	public List<MaterialAmount> getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(List<MaterialAmount> materials) {
		this.materials = materials;
	}
	
	public void addMaterials(MaterialAmount materialAmount){
        this.materials.add(materialAmount);
	}
	
	public MaterialAmount createMaterialAmount(Integer amount, Boolean assembly,
			Material materialMaterial) {
		
		MaterialAmount ma = new MaterialAmount();
		
		ma.amount = amount;
		ma.assembly = assembly;
		ma.material = materialMaterial;
		
        return ma;
        
	}

	/**
	 * @return the toCreate
	 */
	public Material getComponent() {
		return component;
	}
	/**
	 * @param toCreate the toCreate to set
	 */
	public void setComponent(Material component) {
		this.component = component;
	}
	
	@Override
	public String toString() {
		return "BillOfMaterial [id=" + id + ", materials=" + materials
				+ ", component=" + component + "]";
	}

}
