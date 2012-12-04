/**
 * 
 */
package scstool.obj;

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
	}
	
	/**
	 * the materials and the amount of them to create an other material
	 * you know minecraft ;) 
	 */
	private List<MaterialAmount> materials;
	/**
	 * the material to create
	 */
	private Material toCreate;
	
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
	/**
	 * @return the toCreate
	 */
	public Material getToCreate() {
		return toCreate;
	}
	/**
	 * @param toCreate the toCreate to set
	 */
	public void setToCreate(Material toCreate) {
		this.toCreate = toCreate;
	}

}
