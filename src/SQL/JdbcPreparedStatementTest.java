package SQL;

import java.sql.*;

public class JdbcPreparedStatementTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                PreparedStatement pstm = conn.prepareStatement(
                        "insert into books values (?,?,?,?,?,?,?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from books");
        ) {
            pstm.setInt(1, 5002);
            pstm.setString(2, "MaMa");
            pstm.setString(3, "Kumar");
            pstm.setString(4, "Novel");
            pstm.setDouble(5, 10.11);
            pstm.setInt(6, 100);
            pstm.setString(7, "2020/1/19");

            int rowsInserted = pstm.executeUpdate();
            System.out.println(rowsInserted + "rows affected");

            pstm.setInt(1, 5003);
            pstm.setString(2,"MaMa 2");
            //No change in values for parameters 3 to 5
            rowsInserted = pstm.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");

            //Issue a Select to check the changes

            ResultSet rset = pstmtSelect.executeQuery();
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            for(int i = 1; i <= numColumns; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();
            while (rset.next()){
                for(int i = 1; i <= numColumns; i++){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }

        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
