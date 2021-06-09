
public class Bat extends Mammal {

public void fly() {
	minusEnergy(50);
	System.out.println("FLAP FLAP FLAP");
}

public void eatHumans() {
	addEnergy(25);
}

public void AttackTown() {
	minusEnergy(100);
}
}
