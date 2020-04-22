package BookStore;

import java.sql.*;
import java.util.Scanner;

public class orderView {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        queryList();
        System.out.println("Select your choose: ");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                System.out.println("1.1 Hiển thị đơn hàng theo mã khách hàng\n1.2 Hiển thị trạng thái đơn hàng theo mã đơn hàng\n1.3 Hiển thị thông tin chi tiết của một đơn hàng theo mã đơn được nhập vào \n");
               action = scanner.nextInt();
               switch (action){
                   case 1:
                       ViewOrderByCustomerID();
                       break;
                   case 2:
                       ViewStatusOderByOrderID();
                       break;
                   case 3:
                       ViewDetailOrderByOderID();
                       break;
               }
            case 2:
                ViewOrderPending();
                break;
            case 3:
                ViewOderBoxed();
                break;
            case 4:
                ViewOrderTransported();
                break;
            case 6:
                ViewOrderCancelled();
                break;
            case 5:
                ViewOrderSuccessed();
                break;

        }
    }
    public static void queryList(){
        System.out.println("Chọn truy vấn: \n1. Hiển thị 30 đơn hàng mới tiếp nhận\n2. Hiển thị những đơn hàng đang chờ xử lý\n3. Hiển thị những đơn hàng đã đóng gói\n4. Hiển thị những đơn hàng đã gửi vận chuyển\n5. Hiển thị những đơn hàng đã giao thành công\n6. Hiển thị những đơn hàng bị khách hàng hủy");
    }
    public static void ViewOrderByCustomerID(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
                ){
            System.out.println("Enter customer ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title, books.category, sum(orderQty) as countbook from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "where o.statusID = 0 " +  "and o.customerID = '" + number +  "'"+
                    "group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");

                System.out.println(  title + ", " + category + ", " + countbook );
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewStatusOderByOrderID(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 0 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewDetailOrderByOderID(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 0 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewOrderPending(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 1 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewOderBoxed(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 2 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewOrderTransported(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 3 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewOrderSuccessed(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 5 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void ViewOrderCancelled(){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            System.out.println("Enter order ID: ");
            int number = scanner.nextInt();
            String strSelect = "select books.id, books.title,orderdetail.orderID, books.category, sum(orderQty) as countbook, s.statusCmt from orderdetail " +
                    "Join books on orderdetail.Bookid = books.id " +
                    "JOIN orderproduct o on orderdetail.orderID = o.orderID " +
                    "join statusview s on o.statusID = s.statusID " +
                    "where o.statusID = 5 " +
                    "and orderdetail.orderID = " + number +
                    " group by id " +
                    "order by countbook desc limit 30";
            System.out.println("The statement SQL is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("The records select are: ");
            while (rset.next()){
                int id = rset.getInt("books.id");
                int orderID = rset.getInt("orderdetail.orderID");
                String title = rset.getString("books.title");
                String category = rset.getString("books.category");
                int countbook = rset.getInt("countbook");
                String status = rset.getString("s.statusCmt");

                System.out.println(orderID  + ", " + id + ", " + title + ", " + category +", " + countbook +", " + status);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
