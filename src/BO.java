import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class BO extends JFrame {
    String bo;
    private JPanel homePanel, formPanel, tablePanel;
    private CardLayout cardLayout;
    public JButton formButton = new JButton("Add new sale");
    public JButton tableButton = new JButton("See all sales");
    public JButton validateButton = new JButton("Validate");
    public JButton rtnButton = new JButton("return to main");

    public JButton sendButton = new JButton("send ");
    public JButton returnButton = new JButton("return to main");

    String[] columnNames = {"Date", "Region", "Product", "Qty", "Cost", "Amount", "Tax", "Total"};
    JLabel[] labels = new JLabel[8];
    JTextField[] textFields = new JTextField[8];

    Vector<data> d =new Vector<data>(10);
    Object[][] dd  ;
    JdbcRetrieve R = new JdbcRetrieve();



    public BO(String  bo) {
        this.bo = bo ;
        setTitle(bo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Adjusted size for demonstration
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create panels
        homePanel = new JPanel();
        formPanel = new JPanel();
        tablePanel = new JPanel(new BorderLayout()); // Use BorderLayout for tablePanel
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Home Panel

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(formButton);
        buttonPanel.add(tableButton);

        homePanel.add(buttonPanel);
        homePanel.setLayout(new GridLayout(1, 1)); // 1 row, 1 column for buttonPanel
        homePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adjust margins

        formButton.setPreferredSize(new Dimension(200, 50)); // Consistent size
        tableButton.setPreferredSize(formButton.getPreferredSize()); // Same size for both buttons


        // Form Panel
        formPanel.setLayout(new GridLayout(8, 1)); // Separate labels and text fields on separate lines
        for (int i = 0; i < 8; i++) {
            labels[i] = new JLabel(columnNames[i]);
            textFields[i] = new JTextField(10);
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.add(labels[i]);
            panel.add(textFields[i]);
            formPanel.add(panel);
        }

        // Table Panel
        d = R.Retrieve(bo);
        //System.out.println(d.toString());
        dd = data.dataToTable( d );
        JTable table = new JTable(dd, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel btnPanel = new JPanel();
        btnPanel.add(sendButton);
        btnPanel.add(returnButton);

        tablePanel.add(btnPanel, BorderLayout.NORTH); // Buttons at the top
        tablePanel.add(scrollPane, BorderLayout.CENTER); // Table at the center


        JPanel formbuttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formbuttonPanel.add(rtnButton);
        formbuttonPanel.add(validateButton);

        formPanel.add(formbuttonPanel);
        formPanel.setLayout(new GridLayout(10, 4)); // 1 row, 1 column for buttonPanel
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adjust margins

        formButton.setPreferredSize(new Dimension(200, 50)); // Consistent size
        tableButton.setPreferredSize(formButton.getPreferredSize()); // Same size for both buttons


        // Add panels to the frame
        add(homePanel, "home");
        add(formPanel, "form");
        add(tablePanel, "table");

        // Action Listeners
        formButton.addActionListener(e -> cardLayout.show(getContentPane(), "form"));
        rtnButton.addActionListener(e -> cardLayout.show(getContentPane(), "home"));
        returnButton.addActionListener(e -> cardLayout.show(getContentPane(), "home"));
        tableButton.addActionListener(e -> {
            tablePanel.removeAll();
            d = R.Retrieve(bo);
            dd = data.dataToTable( d );

            JTable table1 = new JTable(dd, columnNames);
            JScrollPane scrollPane1 = new JScrollPane(table1);

            JPanel btnPanel1 = new JPanel();
            btnPanel1.add(sendButton);
            btnPanel1.add(returnButton);

            tablePanel.add(btnPanel1, BorderLayout.NORTH); // Buttons at the top
            tablePanel.add(scrollPane1, BorderLayout.CENTER); // Table at the center

            tablePanel.revalidate();
            tablePanel.repaint();
            cardLayout.show(getContentPane(), "table");
        });

        validateButton.addActionListener(e ->{
                    String Date = textFields[0].getText();
                    String Region = textFields[1].getText();
                    String Product = textFields[2].getText();
                    String StringQty = textFields[3].getText();
                    String StringCost = textFields[4].getText();
                    String stringAmount = textFields[5].getText();
                    String stringTax = textFields[6].getText();
                    String stringTotal = textFields[7].getText();
                    int Qty ;
                    double Cost , Amount , Tax , Total ;
                    try {
                        Qty = Integer.parseInt(StringQty); // Attempt to convert to integer
                        Cost = Double.parseDouble(StringCost); // Attempt to convert to double
                        Amount = Double.parseDouble(stringAmount);
                        Tax = Double.parseDouble(stringTax);
                        Total = Double.parseDouble(stringTotal);
                    } catch (NumberFormatException et) {
                        System.err.println("Error: Invalid txtfield entered. Please enter a number or a float .");
                        Qty = -1; Cost = -1 ; Amount =-1 ; Tax = -1; Total = -1 ;
                    }
                    data d = new data(Date,Region,Product,Qty,Cost,Amount,Tax,Total);
                    JdbcInsert j = new JdbcInsert(d,bo);

                    cardLayout.show(getContentPane(), "home");
                }
        );

        sendButton.addActionListener(e -> {
            try {
                send s = new send(bo);
                JdbcDelete d = new JdbcDelete();
                d.deleteSales(bo);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            cardLayout.show(getContentPane(), "home");
        });

    }

}
