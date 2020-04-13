package Lession2_ArraylistEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class initArray{
    public void initArray(int size, List<Integer> arr){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < size; i++){
            System.out.println("Enter number: " + i);
            arr.add(scanner.nextInt());
        }
    }
    public double getAverage(int size, List<Integer> arr){
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < size; i++){
            sum += arr.get(i);
        }
        return (double)sum/size;
    }
}


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> mang = new ArrayList<>();
        initArray array = new initArray();
        int size = scanner.nextInt();
        array.initArray(size, mang);
        System.out.println(mang);
        double trungbinh = array.getAverage(size,mang);
        System.out.println(trungbinh);

    }
}

