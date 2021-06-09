
public class Wizard extends Human{
	
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal(Human x) {
		x.health =+ intelligence;
	}
	
	public void fireball(Human x) {
		x.health =- intelligence*3;
	}
}
