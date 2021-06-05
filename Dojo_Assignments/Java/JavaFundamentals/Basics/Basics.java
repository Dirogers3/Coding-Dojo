import java.util.Arrays;
import java.util.ArrayList;
public class Basics {
    public static void main(String[] args) {
        // Print 1-255
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
        // Print odd numbers between 1-255
        for (int i = 0; i <= 255; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
        // Print Sum from 1 -255
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum = sum + i;
        }
        System.out.println("This is the sum: " +sum);
        // Iterating through an array  
        int[] x = {1, 3, 5, 7, 9, 13};
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        //Call find max Method and pass in the array
        int[] x1 = { -4, -1, 9, 0, 4, 7 };
        findMax(x1);

        int[] x2 = {2, 10, 3};
        getAverage(x2);

        addOddToArray();

        int[] x3 ={1, 3, 5, 7, 14, 1, 3, 4, 5};
        greaterThanY(x3);

        int[] x4 = {1, 2, 4, 5, 6, 7};
        squareTheValues(x4);

        int[] x5 = {1, 5, 10, -2};
        eleminateNegatives(x5);

        int[] x6 = { 1, 5, 10, -2 };
        mMA(x6);

        int[] x7 = {1, 5, 10, 7, -2};
        shifting(x7);

        }

        // Find Max
        static void findMax(int[] x1) {
            int max = 0;
            for (int i = 0; i < x1.length; i++) {
                if (x1[i]> max) {
                    max = x1[i];
                }
            }
            System.out.println("This is the Max of the given array: " + max);
        }

        // Get average
        static void getAverage(int[] x2) {
            int sum = 0;
            for (int i = 0; i < x2.length; i++) {
                sum = sum + x2[i];
            }
            int average = (sum / x2.length);
            System.out.println("The average of the Array is: " + average);
            }

        //Array with Odd Numbers
        static void addOddToArray() {
            ArrayList<Integer> array = new ArrayList<Integer>();
            int i = 1;
            while (i <= 255) {
                array.add(i);

                i = i + 2;
            }

            System.out.println(array);
        }

        //Greater Than Y
        static void greaterThanY(int[]x3) {
            int y = 3;
            int count = 0;
            for (int i = 0; i < x3.length; i++) {
                if (x3[i] > y) {
                    count++;
                }
            }
            System.out.println(count);
        }

        // Square the values
        static void squareTheValues(int[] x4) {
            for (int i = 0; i < x4.length; i++) {
                int squared = x4[i] * x4[i];
                x4[i] = squared;
            }
            System.out.println(Arrays.toString(x4));
        }

        //Eliminate Negative Numbers
        static void eleminateNegatives(int[] x5) {
            for (int i = 0; i < x5.length; i++) {
                if (x5[i] < 0) {
                    x5[i] = 0;
                }
            }
            System.out.println(Arrays.toString(x5));
        }

        //Max, Min, Average
        static void mMA(int[] x6){
            int max = 0;
            int min = 0;
            int sum = 0;
            for (int i = 0; i < x6.length; i++) {
                if (x6[i] > max) {
                    max = x6[i];
                }
                if (x6[i] < min) {
                    min = x6[i];
                }
                sum = sum + x6[i];
            }
            int avg = sum / x6.length;
            int[] arr = {max, min, avg};
            System.out.println(Arrays.toString(arr));
        }

        // Shifting the values in an Array
        static void shifting(int[] x7) {
            for (int i = 0; i < x7.length-1; i++) {
                x7[i] = x7[i+1];
            }
            x7[x7.length - 1] = 0;
            System.out.println(Arrays.toString(x7));
        }



    
}
