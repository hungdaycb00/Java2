package Lession1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> programingLanguages = new ArrayList<>();
        programingLanguages.add("C");
        programingLanguages.add("C++");
        programingLanguages.add("Java");
        programingLanguages.add("Kotlin");
        programingLanguages.add("Python");
        programingLanguages.add("Perl");
        programingLanguages.add("Ruby");

        System.out.println("Initial List: " + programingLanguages);

        programingLanguages.remove(5);
        System.out.println("After remove(5): " + programingLanguages);

        boolean isRemoved = programingLanguages.remove("Kotlin");
        System.out.println("After remove /kotlin/: " + programingLanguages);

        List<String> scriptingLangues = new ArrayList<>();
        scriptingLangues.add("Python");
        scriptingLangues.add("Ruby");
        scriptingLangues.add("Perl");
        programingLanguages.removeAll(scriptingLangues);
        System.out.println("After removeAll: " + programingLanguages);

        programingLanguages.removeIf(p ->(p.charAt(0) == 'C'));
        System.out.println("After removing all elements that start with /C/: " + programingLanguages);
        programingLanguages.clear();
        System.out.println("After clear(): " + programingLanguages);

    }
}
