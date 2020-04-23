package SQL.giftcontroller;

import SQL.giftmodel.Gift;


import java.sql.*;
import java.util.Scanner;

public class GiftController extends Gift {
    private static Scanner scanner = new Scanner(System.in);
    public static void SelectBook(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            String sqlSelect = "select * from giftlist";
            System.out.println("The SQL statement is: " + sqlSelect + "\n");
            ResultSet rset = stmt.executeQuery(sqlSelect);
            int count = 0;
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("name") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
                count++;
            }
            System.out.println("Total number of record are: " + count);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void InsertBook(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            Gift g1 = new Gift();
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            g1.setID(id);
            System.out.println("Enter name: ");
            String name = scanner.next();
            name = scanner.nextLine();
            g1.setName(name);
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();
            g1.setPrice(price);
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            g1.setQty(qty);
            String sqlInsert = "insert into giftlist values (" + g1.getID() + ", '" + g1.getName()
                    + "', " + g1.getPrice() + ", "
                    + g1.getQty() + ")";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records inserted.");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void DeleteBookById(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter id gift want to delete: ");
            int number = scanner.nextInt();
            String sqlDelete = "delete from giftlist where id ='" + number + "'";
            System.out.println("The SQL statement is: " + sqlDelete);
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " records deleted.");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
