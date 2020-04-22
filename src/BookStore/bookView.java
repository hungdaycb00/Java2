package BookStore;

import java.sql.*;
import java.util.Scanner;

public class bookView {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        System.out.println("Select your choose: ");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                View10NewBooks();
                break;
            case 2:
                BestSeller100();
                break;
            case 3:
                FindBookByCategory();
                break;
            case 4:
                FindBookByAuthor();
                break;
            case 5:
                ViewDetailBook();
                break;
        }
    }

    public static void menu(){
        System.out.println("1. Xem toàn bộ 10 cuốn sách mới nhất\n2. Xem 100 cuốn sách bán chạy nhất\n3. Tìm sách theo tên tác giả\n4. Tìm sách theo thể loại \n5. Xem chi tiết về cuốn sách\n");
    }
    public static void View10NewBooks(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from books order by importDate DESC Limit 10";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String category = rset.getString("category");
                Float price = rset.getFloat("price");
                int qty = rset.getInt("qty");
                String date = rset.getString("importDate");
                System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + author + ", " + category + ", " + price
                        + ", " + qty + ", " + date + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void BestSeller100(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
                ){
            String strSelect = "select books.id, books.title, books.category, sum(orderQty) from orderdetail\n" +
                    "Join books on   orderdetail.Bookid = books.id\n" +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID\n" +
                    "and o.statusID = 1\n" +
                    "group by id limit 100";
            System.out.println("The stetament SQL is : "+ strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records select are: ");
            int rowCount = 0;
            while (rset.next()){
                int id = rset.getInt("books.id");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int qty = rset.getInt("orderQty");
                System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + category + ", "  + qty + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
    public static void FindBookByCategory(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter category: ");
            String type = scanner.nextLine();
            type = scanner.nextLine();
            String strSelect = "select * from books where category = '" + type + "'";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String category = rset.getString("category");
                Float price = rset.getFloat("price");
                int qty = rset.getInt("qty");
                String date = rset.getString("importDate");
                System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + author + ", " + category + ", " + price
                        + ", " + qty + ", " + date + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void FindBookByAuthor(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter author name: ");
            String name = scanner.nextLine();
            name = scanner.nextLine();
            String strSelect = "select * from books where category = '" + name + "'";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String category = rset.getString("category");
                Float price = rset.getFloat("price");
                int qty = rset.getInt("qty");
                String date = rset.getString("importDate");
                System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + author + ", " + category + ", " + price
                        + ", " + qty + ", " + date + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewDetailBook(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter book ID: ");
            int bookid = scanner.nextInt();
            String strSelect = "select * from books where id = " + bookid;
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String category = rset.getString("category");
                Float price = rset.getFloat("price");
                int qty = rset.getInt("qty");
                String date = rset.getString("importDate");
                System.out.println("STT " + (rowCount+ 1) + "-" + id + ", " + title + ", " + author + ", " + category + ", " + price
                        + ", " + qty + ", " + date + "\n");
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
