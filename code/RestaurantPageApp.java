import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantPageApp extends JFrame {

    public RestaurantPageApp() {
        super("Restaurant Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar();
        createUI();

        pack();
        setLocationRelativeTo(null);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void createUI() {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel menuPanel = createMenuPanel();
        JPanel reservationsPanel = createReservationsPanel();
        JPanel reviewsPanel = createReviewsPanel();

        tabbedPane.addTab("Menu", menuPanel);
        tabbedPane.addTab("Reservations", reservationsPanel);
        tabbedPane.addTab("Reviews", reviewsPanel);

        getContentPane().add(tabbedPane);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel dishLabel = new JLabel("Dish:");
        JTextField dishField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JButton addToMenuButton = new JButton("Add to Menu");
        addToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dish = dishField.getText();
                String price = priceField.getText();

                JOptionPane.showMessageDialog(RestaurantPageApp.this,
                        "Added to Menu: " + dish + " - $" + price,
                        "Menu Update",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(dishLabel);
        panel.add(dishField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(new JLabel()); 
        panel.add(addToMenuButton);

        return panel;
    }

    private JPanel createReservationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea reservationsInfoTextArea = new JTextArea("Try making a reservation at our place");
        reservationsInfoTextArea.setEditable(false);
        panel.add(new JScrollPane(reservationsInfoTextArea), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReviewsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea reviewsInfoTextArea = new JTextArea("Read reviews");
        reviewsInfoTextArea.setEditable(false);
        panel.add(new JScrollPane(reviewsInfoTextArea), BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantPageApp().setVisible(true);
            }
        });
    }
}
