import java.sql.*;
import java.util.Scanner;

public class SelectBooks {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
                ){
            cauTruc();
            String strSelect;
            int rowCount = 0;
            ResultSet rset;
            int action = scanner.nextInt();
            switch (action){
                case 1:
                     strSelect = "select * from books";
                     rset = stmt.executeQuery(strSelect);
                    System.out.println("The SQL statement is: " + strSelect + "\n");
                    System.out.println("The records selected are: ");
                    while(rset.next()){
                        String title = rset.getString("title");
                        double price = rset.getDouble("price");
                        int qty = rset.getInt("qty");
                        System.out.println(title + ", " + price +", " + qty);
                        rowCount++;
                    }
                    System.out.println("Total number of records = " + rowCount);
                    break;
                case 2:
                     strSelect = "select title, price from books WHERE author = 'CodeLean VN'";
                     rset = stmt.executeQuery(strSelect);
                    System.out.println("The SQL statement is: " + strSelect + "\n");
                    System.out.println("The records selects are: ");
                    while (rset.next()){
                        String title = rset.getString("title");
                        double price = rset.getDouble("price");
                        String author = rset.getString("author");
                        rowCount++;
                        System.out.println(title + ", " + price +", " + author);
                    }
                    System.out.println("Total number of records = " + rowCount);
                    break;
                case 3:
                    strSelect = "select * from books where author = 'CodeLean VN' or price >= 30 order by price DESC, id ASC";
                     rset = stmt.executeQuery(strSelect);
                    System.out.println("The SQL tatement is: " + strSelect + "\n");
                    System.out.println("The recode select are: " + strSelect);
                    while (rset.next()){
                        String title = rset.getString("title");
                        double price = rset.getDouble("price");
                        String author = rset.getString("author");
                        int qty = rset.getInt("qty");
                        rowCount++;
                        System.out.println(title + ", "+ author + ", " + price +", " + qty);
                    }
                    System.out.println("Total number of records = " + rowCount);
                    break;
            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void cauTruc(){
        System.out.println("chọn mục muốn truy vấn: ");
        System.out.println("1. Hiển thị tất cả \n2.Hiển thị với tác giả là 'Code Lean'\n3. Hiển thị với tác giả là 'Code Lean VN' hoặc price > 30 ");
    }
}
