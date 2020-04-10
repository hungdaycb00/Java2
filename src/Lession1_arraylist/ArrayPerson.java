package Lession1_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayPerson {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Shachin", 47));
        people.add(new Person("Chris", 34));
        people.add(new Person("Rajeev", 25));
        people.add(new Person("David", 31));

        System.out.println("Person list: " + people);
        people.sort((person1, person2) -> {
            return person1.getAge() - person2.getAge();
        });

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Sorted Person List by Age: " + people);

        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("Sorted Person List by Name: " + people);
    }
}
