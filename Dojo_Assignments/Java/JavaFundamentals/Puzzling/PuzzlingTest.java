import java.util.*;
public class PuzzlingTest {
    public static void main(String[] args) {
        //THIS SECTION WILL RUN THE NUMBER ARRAY SUM AND GREATER THAN 10
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> results = Puzzling.problemOne(array);
        System.out.println(results);


        //THIS IS THE SHUFFLE METHOD CALL.
        String[] array2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> results2 = Puzzling.shuffleArray(array2);
        System.out.println(results2);


        //ALPHABET ARRAYS
        String[] array3 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Puzzling.shuffleAlphabet(array3);

        //GENERATE 10 RANDOM NUMBERS BETWEEN 55-100
        ArrayList<Integer> numArray = Puzzling.getRandomNumbers();
        System.out.println(numArray);

        //GENERATE 10 RANDOM NUMBERS BETWEEN 55-100 WITH CONDITIONS
        ArrayList<Integer> numberArray = Puzzling.getSortedRandomNumbers();
        System.out.println(numberArray);
        System.out.println(numberArray.get(0));
        System.out.println(numberArray.get(numberArray.size()-1));

        //GENERATE A 5 CHAR RANDOM STRING
        String[] characters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String word = Puzzling.getFiveChars(characters);
        System.out.println(word);

        //GENERATE AN ARRAY WITH 10, 5 CHAR WORDS
        ArrayList<String> wordArray = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            wordArray.add(Puzzling.getFiveChars(characters));
        }
        System.out.println(wordArray);
    }
}
