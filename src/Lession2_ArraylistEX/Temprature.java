package Lession2_ArraylistEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temprature {
    public static void main(String[] args) {
        List<Integer> temparature = new ArrayList<>();
        System.out.println("Enter 5 integer value: ");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (count < 5){
            temparature.add(scanner.nextInt());
            count++;
        }
        double sum = 0;
        for (int i = 0; i < temparature.size(); i++){
            System.out.println("Element " + i + " , typed value was " + temparature.get(i));
            sum += temparature.get(i);
        }
        System.out.println("Average: " + sum/temparature.size());
        int n = 0;
        for(Integer x : temparature){
            if(x > sum/temparature.size()){
            n++;
            }
        }
        System.out.println("Have " + n + " day higher average temparature.");

    }
}
