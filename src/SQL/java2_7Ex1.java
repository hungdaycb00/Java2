package SQL;

import java.sql.*;

public class java2_7Ex1 {
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
            String sqlUpdate = "update books set price = 1.6 * price where title ='Java Tutorial'";
            System.out.println("The SQL statement is: " + sqlUpdate);
            int countUpdate = stmt.executeUpdate(sqlUpdate);
            String sqlSelect = "select * from books where title ='Java Tutorial'";
            ResultSet rset = stmt.executeQuery(sqlSelect);
            System.out.println(sqlUpdate + " records deleted.");
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
