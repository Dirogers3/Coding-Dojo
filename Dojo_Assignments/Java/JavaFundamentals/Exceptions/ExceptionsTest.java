import java.util.*;
public class ExceptionsTest {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                System.out.println("THE TRY IS WORKING");
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("VALUE MOVED CORRECTLY");
                
            } catch (Exception e) {
                System.out.println("THE CATCH IS WORKING");
                String castedValue = (String) myList.get(i);
            }
            
        }

    }
}
