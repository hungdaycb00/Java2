package BookStore;

import java.sql.*;
import java.util.Scanner;

public class user {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Login\n2. Sign Up");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                LogIn();
                break;
            case 2:
                InsertUser();
                break;
        }
    }
    public static void InsertUser(){
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
            System.out.println("Enter new username: ");
            String name = scanner.next();
            System.out.println("Enter new password: ");
            String pass = scanner.next();
            System.out.println("Enter role: ");
            int role = scanner.nextInt();

            String sqlInsert = "insert into user(username, password, role) values ('"
                    + name + "','" + pass + "','" + role + "')";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records inserted.");
            String sqlSelect = "select * from user where username = '" + name + "'";
            System.out.println("The SQL statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            System.out.println("The records are: ");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getString("username") + ", " + rset.getString("password") + ", " + rset.getInt("role"));
            }
            System.out.println("You successfully registered!");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static boolean LogIn(){
        boolean login = true;
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
            System.out.println("Enter username: ");
            String name = scanner.next();
            System.out.println("Enter password: ");
            String pass = scanner.next();
            String sqlSelect = "select * from user where username ='"
                    + name + "' and password = '" + pass + "'";
            System.out.println("The SQL statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            int rowCount = 0;
            while (rset.next()){
                System.out.println(rset.getString("username"));
                rowCount++;
            }
            if(rowCount > 0){
                System.out.println("Login successfully");
                login = true;
            }else{
                System.out.println("Invalid login!!!");
                login = false;
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return login;
    }
}
