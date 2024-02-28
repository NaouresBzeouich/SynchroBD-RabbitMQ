import javax.swing.*;

public class BO2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BO bo = new BO("BO2");
            bo.setVisible(true);
        });
    }
}
