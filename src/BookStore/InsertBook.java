package BookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertBook {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DeleteInsertByID();
        System.out.println("1. Xóa một cuốn sách \n2. Thêm mới một cuốn sách");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                DeleteByID();
                break;
            case 2:
                InsertNewBook();
                break;
        }

    }
    public static void DeleteInsertByID(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            String sqlDelete = "delete from books where id > 8000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " records deleted.");

            String sqlInsert = "insert into books values (8001, 'Java Code', 'Dang Thi Kim Thi', 'Story', 15.55, 55,'2018/1/1'),"
                    + "(8002, 'Java Advaned', 'James Gosling', 'Novel', 15.55, 55,'2009/1/1')";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records insert.");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void DeleteByID(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter Book ID to delete: ");
            int number = scanner.nextInt();
            String sqlDelete = "delete from books where id = '" + number + "'";
            System.out.println("The SQL statement is: " + sqlDelete);
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " records deleted.");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void InsertNewBook(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            System.out.println("Enter title: ");
            String title = scanner.nextLine();
            System.out.println("Enter author: ");
            String author = scanner.nextLine();
            System.out.println("Enter category: ");
            String category = scanner.nextLine();
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            System.out.println("Enter current date: ");
            String date = scanner.nextLine();
            String sqlInsert = "insert into books values" + "(" + id + "," + title  + "," + author  + "," + category + "," + price + "," + qty + "," + date +")";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records insert.");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
