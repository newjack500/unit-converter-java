import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverterGUI extends JFrame implements ActionListener {


    JComboBox<String> conversionType;
    JTextField inputField;
    JLabel resultLabel;
    JButton convertButton;

    public UnitConverterGUI() {
        setTitle("Unit Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));

        String[] options = {
                "Meters to Feet",
                "Feet to Meters",
                "Kilograms to Pounds",
                "Pounds to Kilograms",
                "Celsius to Fahrenheit",
                "Fahrenheit to Celsius"
        };

        conversionType = new JComboBox<>(options);
        inputField = new JTextField();
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ", JLabel.CENTER);

        add(new JLabel("Select Conversion Type:", JLabel.CENTER));
        add(conversionType);
        add(new JLabel("Enter Value:", JLabel.CENTER));
        add(inputField);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double input = Double.parseDouble(inputField.getText());
            double result = 0;
            String selected = (String) conversionType.getSelectedItem();

            assert selected != null;
            result = switch (selected) {
                case "Meters to Feet" -> input * 3.28084;
                case "Feet to Meters" -> input / 3.28084;
                case "Kilograms to Pounds" -> input * 2.20462;
                case "Pounds to Kilograms" -> input / 2.20462;
                case "Celsius to Fahrenheit" -> (input * 9 / 5) + 32;
                case "Fahrenheit to Celsius" -> (input - 32) * 5 / 9;
                default -> result;
            };

            resultLabel.setText("Result:  " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new UnitConverterGUI();
    }
}
