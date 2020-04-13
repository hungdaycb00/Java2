package Lession2_ArraylistEX;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Calcilator1 {
    public static void main(String[] args) {
        System.out.println("Enter size: ");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int[] List = Array(day);
        int count = 0;
        for(Integer x : List){
            System.out.println("Element " + count + ", typed value was " + List[count]);
            count++;
        }
        double Avg = getAverage(List);
        System.out.println("AVG = " + Avg);

    }
    public static int[] Array(int size){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public static double getAverage(int[] array){
        int sum = 0;
        int count = 0;
        for (Integer x: array){
            sum = sum + x;
            count++;
        }
        return (double) sum/count;
    }
}
