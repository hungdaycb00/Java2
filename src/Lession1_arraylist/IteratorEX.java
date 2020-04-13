package Lession1_arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class IteratorEX {
    public static void main(String[] args) {
        List<String> kenh = new ArrayList<>();
        kenh.add("Breaking Bad");
        kenh.add("Game Of Throne");
        kenh.add("Friends");
        kenh.add("Prison break");

        kenh.removeIf(a -> a.startsWith("B"));
        System.out.println(kenh);


    }
}
