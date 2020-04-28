package BookStore.StoreView;

import java.sql.*;
import java.util.Scanner;

public class BookView2 {
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
                FindBookByAuthor();

                break;
            case 4:
                FindBookByCategory();
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
            ResultSet rset = stmt.executeQuery("select * from books order by importDate DESC Limit 10");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            //print column name
            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            // print columns class name
            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s","(" + rsetMD.getColumnClassName(i) + ")");
            }
            System.out.println();
            int rowCount = 0;
            while (rset.next()){
                for(int i = 1; i <= numColumns; ++i){
                    System.out.printf("%-30s", rset.getString(i));
                }
                rowCount++;
                System.out.println();
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
            String strSelect = "select books.id, books.title, books.category, sum(orderQty) as sumQty from orderdetail\n" +
                    "Join books on   orderdetail.Bookid = books.id\n" +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID\n" +

                    "group by id" +
                    " order by sumQty DESC limit 100";
            System.out.println("The stetament SQL is : "+ strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();

            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            while (rset.next()){
                for (int i = 1; i <= numColumns; ++i){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }

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
            System.out.println("Enter category name: ");
            String type = scanner.nextLine();
            type = scanner.nextLine();
            System.out.println("The records selected are: ");
            ResultSet rset = stmt.executeQuery("select * from books where category = '" + type + "'");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumn = rsetMD.getColumnCount();
            for(int i = 1; i <= numColumn; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            int rowCount = 0;
            while (rset.next()){
                for(int i = 1; i <= numColumn; i++){
                    System.out.printf("%-30s",  rset.getString(i));
                }
                System.out.println();
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
            ResultSet rset = stmt.executeQuery("Select * from books where author = '" + name + "'");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numCount = rsetMD.getColumnCount();

            for(int i = 1; i <= numCount; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            int rowCount = 0;
            while (rset.next()){
                for(int i = 1; i <= numCount; i++){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewDetailBook(){
        System.out.println("Enter book ID: ");
        int booked = scanner.nextInt();
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();

                PreparedStatement pstmt = conn.prepareStatement("select * from books where id = " + booked);
        ){
            ResultSet rset = pstmt.executeQuery();
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            System.out.println("---"+numColumns + "---");

            for(int i = 1; i <= numColumns; ++i){
                System.out.printf("%-30s", "(" + rsetMD.getColumnName(i) + ")");
            }
            System.out.println();

            for(int i = 1; i<= numColumns; i++){
                System.out.printf("%-30s",  rsetMD.getColumnClassName(i));
            }
            System.out.println();
            while (rset.next()){
                for(int i = 1; i<= numColumns; i++){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }


        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
