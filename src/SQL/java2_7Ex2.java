package SQL;

import java.sql.*;
import java.util.Scanner;

public class java2_7Ex2 {
    private static Scanner scanner = new Scanner(System.in);
    private static String string;
    public static void main(String[] args) {
//        UpdateCategory();
//        UpdateCustomer();
//        UpdateOrder();
        UpdateProduct();
    }
    public static void UpdateCategory(){
        try (
                //Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ){
            String sqlUpdate = "update categories set CategoryName = 'SeaFood VN' where CategoryName = 'Seafood'";
            System.out.println("The SQl statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate);

            String sqlSelect = "Select * from categories where CategoryName = 'SeaFood VN'";
            System.out.println("The SQl statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                System.out.println(rset.getInt("CategoryID") + ", " + rset.getString("CategoryName") + ", " +rset.getString("Description"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void UpdateCustomer(){
        try (
                //Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ){
            String sqlUpdate = "update customers set Address = '1A Yet Kieu - Ha Noi' where CustomerID = 'FRANK'";
            System.out.println("The SQl statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate);

            String sqlSelect = "Select * from customers where CustomerID = 'FRANK'";
            System.out.println("The SQl statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                System.out.println(rset.getString("CustomerID") + ", " + rset.getString("CompanyName") + ", " +rset.getString("Address"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void UpdateProduct(){
        try (
                //Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ){
            String sqlUpdate = "update products set UnitPrice = UnitPrice * 1.1 where CategoryID in (5,7,8)";
            System.out.println("The SQl statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate);

            String sqlSelect = "Select * from products where CategoryID in (5,7,8)";
            System.out.println("The SQl statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                System.out.println(rset.getInt("CategoryID") + ", " + rset.getString("ProductName") + ", " +rset.getFloat("UnitPrice"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void UpdateOrder(){
        try (
                //Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ){
            String sqlUpdate = "update orders set ShipVia = 3 where OrderID = 10248";
            System.out.println("The SQl statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate);

            String sqlSelect = "Select * from orders where OrderID = 10248";
            System.out.println("The SQl statement is: " + sqlSelect);
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                System.out.println(rset.getString("CustomerID") + ", " + rset.getString("ShipName") + ", " +rset.getFloat("ShipVia"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
