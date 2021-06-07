import java.util.*;
public class Puzzling {


    public static ArrayList<Integer> problemOne(int[] array) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        int sum = 0;
        for (Integer integer : array) {
            sum = sum + integer;
            if (integer > 10) {
                myArray.add(integer);
            }
        }
        System.out.println(sum);
        return myArray;
    }


    public static ArrayList<String> shuffleArray(String[] array1) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listOverFive = new ArrayList<String>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
            if (array1[i].length() > 5) {
                listOverFive.add(array1[i]);
            }
        }
         Collections.shuffle(list);
        System.out.println(list);
        return listOverFive;
    }

    
    public static void shuffleAlphabet(String[] array3) {
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < array3.length; i++) {
            list2.add(array3[i]);
        }
        Collections.shuffle(list2);
        String first = list2.get(0);
        String last = list2.get(list2.size() - 1);
        if(first == "a" | first == "e" | first == "i" | first == "o" | first == "u") {
            System.out.println("The first letter is a vowel!");
        }
        System.out.println("First letter is:" + first);
        System.out.println("Last letter is:" + last);
    }


    public static ArrayList<Integer> getRandomNumbers(){
        ArrayList<Integer> numArray = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numArray.add(random.nextInt(45)+55);
        }
        return numArray;
    }


    public static ArrayList<Integer> getSortedRandomNumbers(){
        ArrayList<Integer> numberArray = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            numberArray.add(rand.nextInt(45)+55);
        }
        Collections.sort(numberArray);
        return numberArray;
    }


    public static String getFiveChars(String[] characters) {
        String word = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            word = word + characters[random.nextInt(25)];
        }
        return word;
    }
}
