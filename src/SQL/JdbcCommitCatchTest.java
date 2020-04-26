package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCommitCatchTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            try {
                //Disable auto-commit
                conn.setAutoCommit(false);

                // issue two insert statements
                stmt.executeUpdate("insert into books values (4001, 'Paul Chan', 'Mahjong 101','novel', 4.4, 4,'2020/2/3')");
                // Deplicate primary key, which triggers a SQLException
                stmt.executeUpdate("insert into books values(4002, 'Peter Chan', 'Majong 102','novel', 4.4, 4,'2020/2/3')");
                conn.commit();
            } catch (SQLException ex) {
                System.out.println("-- Rolling back changes --");
                conn.rollback();
                ex.printStackTrace();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
