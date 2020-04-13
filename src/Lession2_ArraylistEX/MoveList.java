package Lession2_ArraylistEX;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MoveList {
    public static void main(String[] args) {
        List<String> movieName = new ArrayList<>();
        movieName.add("Avata");
        movieName.add("Chicken Egg");
        movieName.add("Lengendary");
        movieName.add("Harry Potter");
        movieName.add("New Genaration");

        System.out.println("1. Add movie\n2. Print list of movie\n3. Edit movie name\n4. Delete a movie\n5. Find the movie by name");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("Your new movie is: ");
                movieName.add(scanner.nextLine());
                break;
            case 2:
                System.out.println("List of movie: ");
                movieName.forEach(movie -> {
                    System.out.println(movie);
                });
                break;
            case 3:
                System.out.println("Enter your name of movie you want to edit: ");
                String name = scanner.nextLine();
                name = scanner.nextLine();

                if (movieName.contains(name) == true) {
                    System.out.println("Enter your movie name: ");
                    movieName.add(scanner.nextLine());

                    movieName.forEach(movie -> {
                        System.out.println(movie);
                    });
                } else {
                    System.out.println("Invalid name");
                }
                break;
            case 4:
                System.out.println("Enter your name of movie you want to remove: ");
                name = scanner.nextLine();

                if (movieName.contains(name) == true) {
                    movieName.remove(name);
                    System.out.println(movieName);
                } else {
                    System.out.println("Invalid name");
                }
                break;
            case 5:
                System.out.println("Enter your name of movie you want to find:");
                name = scanner.nextLine();
                name = scanner.nextLine();
                break;


        }
    }
}

