import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class HO extends JFrame  {
    public static void main(String[] args) {
        try {
            Receive receiver = new Receive("BO1");
        } catch (Exception et) {
            et.printStackTrace();
        }
        try {
            Receive receiver = new Receive("BO2");
        } catch (Exception et) {
            et.printStackTrace();
        }
    }
}
