import java.sql.*;
import java.sql.PreparedStatement ;
import java.util.logging.Level;
import java.util.logging. Logger;

public class JdbcInsert {

    public JdbcInsert(String message,String DB) {

        String url = "jdbc:mysql://localhost:3306/product_sales_"+DB;
        String user = "root";
        String password = "98821616Oo";

        String sql = "INSERT INTO sales (Date, Region, Product, Qty, Cost, Amount, Tax, Total) VALUES(?,?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             ) {
            data d = data.toData(message);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,  d.date);
            pst.setString(2,d.Region);
            pst.setString(3,d.Product);
            pst.setInt(4,d.Qty);
            pst.setDouble(5,d.Cost);
            pst.setDouble(6,d.Amount);
            pst.setDouble(7,d.Tax);
            pst.setDouble(8,d.Total);

            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcInsert.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    public JdbcInsert(data message,String DB) {

        String url = "jdbc:mysql://localhost:3306/product_sales_"+DB;
        String user = "root";
        String password = "root";

        String sql = "INSERT INTO sales (Date, Region, Product, Qty, Cost, Amount, Tax, Total) VALUES(?,?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
        ) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,  message.date);
            pst.setString(2,message.Region);
            pst.setString(3,message.Product);
            pst.setInt(4,message.Qty);
            pst.setDouble(5,message.Cost);
            pst.setDouble(6,message.Amount);
            pst.setDouble(7,message.Tax);
            pst.setDouble(8,message.Total);

            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcInsert.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}