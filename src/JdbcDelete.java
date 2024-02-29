import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDelete {

    public boolean deleteSales(String BO) {
        String url = "jdbc:mysql://localhost:3306/product_sales_" + BO;
        String user = "root";
        String password = "root";
        String query = "DELETE FROM sales";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            int rowsAffected = stmt.executeUpdate(query);
            return (rowsAffected > 0);

        } catch (SQLException ex) {
            Logger.getLogger(JdbcDelete.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            return false; // Return false on error
        }
    }
}
