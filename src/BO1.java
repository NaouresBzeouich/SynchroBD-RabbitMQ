import javax.swing.*;

public class BO1  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BO bo = new BO("BO1");
            bo.setVisible(true);
        });
    }


}
