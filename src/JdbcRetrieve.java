import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql. SQLException;
import java.util. logging.Level;
import java.util. logging. Logger;

public class JdbcRetrieve {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/product_sales";
        String user = "root";
        String password = "98821616Oo";

        String query = "SELECT * FROM sales";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getDate(2));
                System.out.print(" : ");
                System.out.print(rs.getString(3));
                System.out.print(" : ");
                System.out.print(rs.getString(4));
                System.out.print(" : ");
                System.out.print(rs.getInt(5));
                System.out.print(" : ");
                System.out.print(rs.getFloat(6));
                System.out.print(" : ");
                System.out.print(rs.getFloat(7));
                System.out.print(" : ");
                System.out.print(rs.getFloat(8));
                System.out.print(" : ");
                System.out.print(rs.getFloat(9));
                System.out.print("\n");

            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(JdbcRetrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}