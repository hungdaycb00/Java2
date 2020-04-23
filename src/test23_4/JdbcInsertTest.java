package test23_4;

import com.mysql.cj.util.EscapeTokenizer;

import java.sql.*;
import java.util.Scanner;

public class JdbcInsertTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (
                //Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                //Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
                ){
            //Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate()
            // which return an int indicating the number of rows affected.

            //DELETE records with id >= 3000 and id < 4000
            book book1 = new book();

            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted. \n");

            // Insert a record
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            book1.setId(id);
            System.out.println("Enter title: ");
            String title = scanner.nextLine();
            title = scanner.nextLine();
            book1.setTitle(title);
            System.out.println("Enter author: ");
            String author = scanner.nextLine();
            book1.setAuthor(author);
            System.out.println("Enter category: ");
            String category = scanner.nextLine();
            book1.setCategory(category);
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();
            book1.setPrice(price);
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            book1.setQty(qty);
            System.out.println("Enter current date: ");
            String date = scanner.nextLine();
            date = scanner.nextLine();
            book1.setDate(date);
            String sqlInsert = "insert into books values (" + id + ", '" + title  + "', '" + author  + "', '" + category + "', " + price + ", " + qty + ", '" + date + "'" + ")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted. \n");


//            //Issue a Select to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                + rset.getString("author") + ", "
                + rset.getString("title") + ", "
                + rset.getDouble("price") + ", "
                + rset.getInt("qty"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
