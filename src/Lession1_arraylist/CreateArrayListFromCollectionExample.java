package Lession1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayListFromCollectionExample {
    public static void main(String[] args) {
        List<Integer> firstFiveNumbers = new ArrayList<>();
        firstFiveNumbers.add(2);
        firstFiveNumbers.add(03);
        firstFiveNumbers.add(5);
        firstFiveNumbers.add(7);
        firstFiveNumbers.add(11);

        List<Integer> firstTenNumbers = new ArrayList<>(firstFiveNumbers);

        List<Integer> nextFiveNumber = new ArrayList<>();

        nextFiveNumber.add(13);
        nextFiveNumber.add(17);
        nextFiveNumber.add(19);
        nextFiveNumber.add(23);
        nextFiveNumber.add(29);

        firstTenNumbers.addAll(nextFiveNumber);
        System.out.println(firstTenNumbers);
    }


}
