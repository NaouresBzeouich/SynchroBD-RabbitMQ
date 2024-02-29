import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql. SQLException;
import java.util.Vector;
import java.util. logging.Level;
import java.util. logging. Logger;

public class JdbcRetrieve {

    public Vector<data> Retrieve(String BO) {

        String url = "jdbc:mysql://localhost:3306/product_sales_"+BO;
        String user = "root";
        String password = "root";
        String query = "SELECT * FROM sales";
        Vector<data> d = new Vector<data>(1);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                data da = new data(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8) ,
                        rs.getDouble(9)
                        ) ;

                d.add(da);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JdbcRetrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return d;
    }
}