package SQL;

import java.sql.*;

public class JdbcInsertTest {
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
            //Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate()
            // which return an int indicating the number of rows affected.

            //DELETE records with id >= 3000 and id < 4000
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted. \n");

            // Insert a record
            String sqlInsert = "insert into books values (3001, 'Gone Fishing', 'Kumar','Truyen', 11.11, 11, '2020/1/1')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted. \n");

            // Insert multiple records
            sqlInsert = "insert into books values "
                    + "(3002, 'Gone Fishing 2', 'Kumar','Truyen', 22.22, 22,'2019/2/2'),"
                    + "(3003, 'Gone Fishing 3', 'Kumar','Truyen', 33.33, 33, '2020/6,1')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records intserted. \n");
//
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
