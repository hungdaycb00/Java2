package SQL;

import java.sql.*;

public class AtomicTransaction {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            conn.setAutoCommit(false);

            ResultSet rset = stmt.executeQuery("select id,title, qty from books limit 10");
            System.out.println("-- Before Update --");
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                int qty = rset.getInt("qty");
                System.out.println(id + "," + title  + ", " + qty);
            }
//            conn.commit(); //commit select
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
            System.out.println("--After Update and commit");
            conn.commit(); //commit update

            rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
            System.out.println("--After update and commit--");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }

            conn.commit();
            stmt.executeUpdate("update books set qty = qty + 99 where id = 1001");
            stmt.executeUpdate("update books set qty = qty + 99 where id = 1002");
            conn.rollback();

            rset = stmt.executeQuery("select id, qty from books where id in (1001, 1002)");
            System.out.println("-- After update and rollback --");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
