package Java2_9;

import java.sql.*;

public class ResultSetMetaData11 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {

                ResultSet rset = stmt.executeQuery("select * from books");
                // Get the metadata of the ResultSet
                ResultSetMetaData rserMD = rset.getMetaData();
                int numColumns = rserMD.getColumnCount();
                //print column names - column index begins at 1

                for(int i = 1; i <= numColumns; ++i){
                    System.out.printf("%-30s",
                            "(" + rserMD.getColumnName(i) +")");
                }
                System.out.println();
                while (rset.next()){
                    for (int i = 1; i <= numColumns; ++i){
                        //getString() can be used all column types
                        System.out.printf("%-30s", rset.getString(i));;
                    }
                    System.out.println();
                }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
