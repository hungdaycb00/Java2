package SQL;

import java.sql.*;

public class JdbcUpdateTest {
    public static void main(String[] args) {
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
            String sqlUpdate = "update books set price = price*0.7, qty = qty + 1 where id = 1001";
            System.out.println("The SQL statement is: " + sqlUpdate + "\n");
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate + " records affected. \n");

            String sqlSelect = "select * from books where id = 1001";
            System.out.println("The SQL statement is: " + sqlSelect + "\n");
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
