import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Main p = new Main();
        p.DBConnexion();
        System.out.println("Hello world!");
    }

    void DBConnexion(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_sales","root","98821616Oo");
            System.out.println("connexion succes !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;
    }
}