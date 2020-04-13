package Lession2_ArraylistEX;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class intArray {


    public void initArray(int size, List<Integer> Array) {
        for (int i = 0; i < size; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Input number " + (i + 1) + ":");
            int num = input.nextInt();
            Array.add(num);
        }
    }
    public double getAverage ( int size, List<Integer > Array){
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Array.get(i);
        }
        return (double)sum / size;
    }
}

public class Handle {
    public static void main(String[] args) {
        List<Integer> cal = new ArrayList<>();
        initArray array = new initArray();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = input2.nextInt();
        array.initArray(size,cal);
        System.out.println(cal);
        double average = array.getAverage(size,cal);
        System.out.println(average);
    }
}
