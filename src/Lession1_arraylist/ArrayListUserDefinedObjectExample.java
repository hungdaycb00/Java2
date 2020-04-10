package Lession1_arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUserDefinedObjectExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Rajeev", 25));
        users.add(new User("John", 34));
        users.add(new User("Steve", 29));

        users.forEach(user -> {
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        });


    }
}