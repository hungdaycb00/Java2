package PracArrayList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie{
    public void addMovie(String movie, List<String> movies ){
             movies.add(movie);
    }
    public void editMovies(int index, List<String> movies){
        Scanner input = new Scanner(System.in);
        System.out.print("Name movie what you want change: ");
        String movie = input.nextLine();
        movies.set(index, movie);
    }
    public void deleteMovies(int index, List<String> movies){
        movies.remove(index);
    }
    public void findMovies(String movie, List<String> movies){
        if (movies.contains(movie)){
            System.out.println("Your movie found!");
        } else System.out.println("Your movie not found!");
    }
}

public class MovieList {
    public static void main(String[] args) {
        int choose;
        List<String> movies = new ArrayList<>();
        Movie mov1 = new Movie();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter choose: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 0:
                    break;
                case 1:
                    Scanner input = new Scanner(System.in);
                    System.out.print("Input the movie: ");
                    String movie = input.nextLine();
                    mov1.addMovie(movie, movies);
                    System.out.println("Add favourite movie successfull !");
                    break;
                case 2:
                    System.out.println("Your list movies: " + movies);
                    break;
                case 3:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("enter index:");
                    int index = scanner1.nextInt();
                    mov1.editMovies(index, movies);
                    System.out.println("After edit :" + movies);
                    break;
                case 4:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("enter index:");
                    int index2 = scanner2.nextInt();
                    mov1.deleteMovies(index2, movies);
                    System.out.println("After delete: " + movies);
                case 5:
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Enter your movie what you find: ");
                    String movie2 = input2.nextLine();
                    mov1.findMovies(movie2,movies);
            }
        } while (choose != 0);
    }
}