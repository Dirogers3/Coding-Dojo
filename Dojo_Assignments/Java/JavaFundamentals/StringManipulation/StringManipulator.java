import java.io.LineNumberInputStream;

public class StringManipulator {
    public String trimAndConcat(String a, String b){
        String stuff =(a.trim().concat(b.trim()));
        return stuff;
    }
    public Integer getIndexOrNull(String word, char letter) {
        int a = word.indexOf(letter);
        if (a > 0) {
            return a;
        } else {
            return null;
        }
    }
    
    public Integer getIndexOrNull(String word, String substring) {
        int a = word.indexOf(substring);
        if (a > 0) {
            return a;
        } else {
            return null;
        }
    }

    public String concatSubstring(String word1, int a, int b, String word2){
        String temp = word1.substring(a,b);
        String result = temp.concat(word2);
        return result;
    }
}
