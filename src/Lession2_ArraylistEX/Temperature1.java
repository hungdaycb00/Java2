package Lession2_ArraylistEX;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Temperature1 {

    public static void main(String[] args) {
        System.out.println("Enter your days: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] intArray = new int[n];
        for(int i = 0; i < n; i++){
            intArray[i] = scanner.nextInt();
        }
        int count = 0;
        while (count < n){
            System.out.println("Element " + count + ", typed value was " + intArray[count]);
            count++;
        }
        System.out.println(Arrays.toString(intArray));
    }
}
