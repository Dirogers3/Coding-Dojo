
public class Human {

	public int strength, stealth, intelligence, health;
	
	public Human() {
		strength = 3;
		stealth = 3;
		intelligence = 3;
		health = 100;
	}
	
	
	public void attack(Human x) {
		x.health = x.health - strength;
	}
	
	public void getHealth() {
		System.out.println(health);
	}
	
}
