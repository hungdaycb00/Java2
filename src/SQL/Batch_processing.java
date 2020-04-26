package SQL;

import javax.swing.*;
import java.sql.*;

public class Batch_processing {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books values (?, ?, ?, ?, ?, ?, ?)");
        ){
            conn.setAutoCommit(false);

            pstmt.setInt(1, 5004);
            pstmt.setString(2, "MaMa 3");
            pstmt.setString(3, "Kumar");
            pstmt.setString(4, "Novel");
            pstmt.setDouble(5, 10.11);
            pstmt.setInt(6, 100);
            pstmt.setString(7, "2020/1/19");
            pstmt.addBatch();

            pstmt.setInt(1, 5005);
            pstmt.setString(2, "MaMa 4");

            pstmt.addBatch();
            int[] returnCodes = pstmt.executeBatch();

            System.out.println("Return codes are: ");
            for(int code : returnCodes){
                System.out.println(code + ", ");
            }
            System.out.println();
            conn.commit();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void test1(){
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            conn.setAutoCommit(false);

            stmt.addBatch("insert into books values (8005, 'Java ABC 3', 'Kevin Jones', 'Machine learning', 10.98,11,'2019/10/1')");
            stmt.addBatch("insert into books values (8006, 'Java ABC 4', 'Kevin Jones', 'Machine learning', 10.99,11,'2020/10/1')");
            stmt.addBatch("update books set price = 11.11 where id = 8005 or id = 8006");
            int[] returnCodes = stmt.executeBatch();

            System.out.println("Return codes are: ");
            for(int code: returnCodes){
                System.out.println(code + ", ");
            }
            System.out.println();
            conn.commit();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
