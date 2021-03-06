package scstool.obj;

public class WaitingList {

	private Workplace workplace;
	
	private Material material;
	
	private Integer amount;
	
	private Integer timeneed;

	@Override
	public String toString() {
		return "WaitingList [material=" + material + ", amount=" + amount
				+ ", timeneed=" + timeneed + "]";
	}

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTimeneed() {
		return timeneed;
	}

	public void setTimeneed(Integer timeneed) {
		this.timeneed = timeneed;
	}

	
	
}
