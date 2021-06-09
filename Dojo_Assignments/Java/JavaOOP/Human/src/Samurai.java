
public class Samurai extends Human {
	public Samurai() {
		this.health = 200;
	}
	
	
	public void deathBlow(Human x) {
		x.health = x.health/2;
	}
	
	public void meditate() {
		this.health = this.health*2;
	}
	
	public void howMany() {
		System.out.println(Ninja.ninjacount);
	}
}

