import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelPageApp extends JFrame {

    public HotelPageApp() {
        super("Hotel Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar();
        createUI();

        pack();
        setLocationRelativeTo(null); // Center the frame
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

        JPanel roomsPanel = createRoomsPanel();
        JPanel amenitiesPanel = createAmenitiesPanel();
        JPanel reservationsPanel = createReservationsPanel();

        tabbedPane.addTab("Rooms", roomsPanel);
        tabbedPane.addTab("Amenities", amenitiesPanel);
        tabbedPane.addTab("Reservations", reservationsPanel);

        getContentPane().add(tabbedPane);
    }

    private JPanel createRoomsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel occupancyLabel = new JLabel("Occupancy:");
        JTextField occupancyField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupancy = occupancyField.getText();

                // Process the form data (you can add your logic here)
                JOptionPane.showMessageDialog(HotelPageApp.this,
                        "Room Name: " + name + "\nOccupancy: " + occupancy,
                        "Form Submission",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(occupancyLabel);
        panel.add(occupancyField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(submitButton);

        return panel;
    }

    private JPanel createAmenitiesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea amenitiesInfoTextArea = new JTextArea("Discover our top-notch amenities, including a spa, fitness center, and fine dining restaurants.");
        amenitiesInfoTextArea.setEditable(false);
        panel.add(new JScrollPane(amenitiesInfoTextArea), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReservationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea reservationsInfoTextArea = new JTextArea("Plan your stay with us! Make a reservation to experience luxury and comfort.");
        reservationsInfoTextArea.setEditable(false);
        panel.add(new JScrollPane(reservationsInfoTextArea), BorderLayout.CENTER);

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
                new HotelPageApp().setVisible(true);
            }
        });
    }
}
