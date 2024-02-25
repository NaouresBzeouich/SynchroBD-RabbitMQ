import java.sql.*;
import java.util.logging.Level;
import java.util.logging. Logger;

public class JdbcPreparedTesting {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/product_sales";
        String user = "root";
        String password = "98821616Oo";

        String sql = "INSERT INTO sales (Date, Region, Product, Qty, Cost, Amount, Tax, Total) VALUES('2024-04-01', 'West', 'Paper', 73, 12.95, 945.35, 66.17, 1011.52)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement pst = con.createStatement()) {
            pst.execute(sql);
            pst.close();


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcPreparedTesting.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}