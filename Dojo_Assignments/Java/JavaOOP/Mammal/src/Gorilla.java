public class Gorilla extends Mammal{
    Mammal m = new Mammal();
    public void throwSomething(){
        System.out.println("Threw Something");
        minusEnergy(5);
    }
    public void eatBananas(){
        System.out.println("Yummy");
        addEnergy(10);
    }
    public void climb(){
        System.out.println("Climbing up a tree");
        minusEnergy(10);
    }
}
