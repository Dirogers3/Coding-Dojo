public class PythagoreanTheoremTest {
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        Pythagorean pyth = new Pythagorean();
        double hypotenuse = pyth.calculateHypotenuse(a,b);
        System.out.println("Hypotenuse: " + hypotenuse);
    }
}
