
public class Ninja extends Human {
	public static int ninjacount;
	public Ninja() {
		this.stealth = 10;
		ninjacount++;
		
	}
	
	public void steal(Human x) {
		x.health =- this.stealth;
		this.health =+ this.stealth;
		
	}
	
	public void runaway() {
		this.health =- 10;
	}

}
