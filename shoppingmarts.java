import java.awt.*;
import javax.swing.*;

public class ShoppingMartsTab extends JPanel {
    private JLabel typeOfMartLabel, localityLabel;
    private JTextField typeOfMartField, localityField;

    public ShoppingMartsTab() {
        setLayout(new GridLayout(2, 2));
        typeOfMartLabel = new JLabel("Type of Shopping Mart:");
        localityLabel = new JLabel("Locality:");
        typeOfMartField = new JTextField();
        localityField = new JTextField();
        add(typeOfMartLabel);
        add(typeOfMartField);
        add(localityLabel);
        add(localityField);
    }
}
