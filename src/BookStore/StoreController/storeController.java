package BookStore.StoreController;

import BookStore.Model.Book;

import java.sql.*;
import java.util.Scanner;

public class storeController {
    private static Scanner scanner = new Scanner(System.in);

    public static void SelectBook() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "select * from books";
            System.out.println("The SQL statement is: " + sqlSelect + "\n");
            ResultSet rset = stmt.executeQuery(sqlSelect);
            int count = 0;
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("title") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("category") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty") + ", "
                        + rset.getString("importDate"));
                count++;
            }
            System.out.println("Total number of record are: " + count);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void InsertBook() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ) {
            Book book = new Book();
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            book.setId(id);
            System.out.println("Enter title: ");
            String name = scanner.next();
            name = scanner.nextLine();
            book.setTitle(name);
            System.out.println("Enter author: ");
            String author = scanner.next();
            author = scanner.nextLine();
            book.setAuthor(author);
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();
            book.setPrice(price);
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            book.setQty(qty);
            System.out.println("Enter importdate: ");
            String date = scanner.next();
            date = scanner.nextLine();
            book.setImportdate(date);
            String sqlInsert = "insert into books values (" + book.getId() + ",'" + book.getTitle()
                    + "', '" + book.getAuthor() + "', '" + book.getCategory() + "', " + book.getPrice() + ", "
                    + book.getQty() + ",'" + book.getImportdate() + "')";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records inserted.");
            System.out.println("The value is: ");
            System.out.println(book.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void DeleteBookById() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("Enter id book want to delete: ");
            int number = scanner.nextInt();
            String sqlSelect = "select * from orderdetail where Bookid = " + number;
            ResultSet rset = stmt.executeQuery(sqlSelect);
            int count = 0;
            while (rset.next()) {
                rset.getInt("Bookid");
                count++;
            }
            if (count < 1) {
                String sqlDelete = "delete from books where id =" + number + "";
                System.out.println("The SQL statement is: " + sqlDelete);
                int countDelete = stmt.executeUpdate(sqlDelete);
                System.out.println(countDelete + " records deleted.");
            } else {
                System.out.println("Can't delete\nThis id = " + number + " have order now!!!!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void UpdateBookByID() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ) {
            Book book = new Book();
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            book.setId(id);
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();
            book.setPrice(price);
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            book.setQty(qty);
            String sqlUpdate = "update books set price = " + book.getPrice() + ", qty = " + book.getQty()
                    + " where id = " + book.getId();
            System.out.println("The SQL statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate + " records updated.");
            String sqlSelect = "Select * from books where id = " + book.getId();
            ResultSet rset = stmt.executeQuery(sqlSelect);
            book.setTitle(rset.getString("title"));
            book.setAuthor(rset.getString("author"));
            System.out.println(book.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void BestSeller100() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select books.id, books.title, books.category, sum(orderQty) as sumQty from orderdetail\n" +
                    "Join books on   orderdetail.Bookid = books.id\n" +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID\n" +

                    "group by id" +
                    " order by sumQty DESC limit 100";
            System.out.println("The stetament SQL is : " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records select are: ");
            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("books.id");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int qty = rset.getInt("sumQty");
                System.out.println("STT " + (rowCount + 1) + "-" + id + ", " + title + ", " + category + ", " + qty + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
