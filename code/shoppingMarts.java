import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shoppingMarts {

    private JFrame frame;
    private JComboBox<String> areaComboBox;
    private JComboBox<String> martTypeComboBox;
    private JLabel resultLabel;

    public shoppingMarts() {
        frame = new JFrame("Shopping Mart");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Select Area:"));
        areaComboBox = new JComboBox<>(new String[]{"None","North Bengaluru",  "South Bengaluru", "East Bengaluru", "West bengaluru"});
        frame.add(areaComboBox);

        frame.add(new JLabel("Select Mart Type:"));
        martTypeComboBox = new JComboBox<>(new String[]{"Grocery Store", "Electronics Store"});
        frame.add(martTypeComboBox);

        JButton searchButton = new JButton("Search Mart");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMart();
            }
        });
        frame.add(searchButton);

        resultLabel = new JLabel();
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void searchMart() {
        String area = (String) areaComboBox.getSelectedItem();
        String martType = (String) martTypeComboBox.getSelectedItem();

       
        resultLabel.setText("Searching for " + martType + " in " + area + " area...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new shoppingMarts();
            }
        });
    }
}
