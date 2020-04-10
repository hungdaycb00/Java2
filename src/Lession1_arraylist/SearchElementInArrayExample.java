package Lession1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class SearchElementInArrayExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Steve");
        names.add("John");
        names.add("Steve");
        names.add("Maria");

        System.out.println("Does names array contain \"Bob\": " + names.contains("Bob"));

        System.out.println("IndexOf /Steve/: " + names.indexOf("Steve"));
        System.out.println("IndexOf /Mark/: " + names.indexOf("Mark"));

        System.out.println("lastIndexOf \"John\" : " + names.lastIndexOf("John"));
        System.out.println("lastIndexOf \"Bill\": " + names.lastIndexOf("Bill"));
    }
}
