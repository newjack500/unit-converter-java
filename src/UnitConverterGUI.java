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

            switch (selected) {
                case "Meters to Feet":
                    result = input * 3.28084;
                    break;
                case "Feet to Meters":
                    result = input / 3.28084;
                    break;
                case "Kilograms to Pounds":
                    result = input * 2.20462;
                    break;
                case "Pounds to Kilograms":
                    result = input / 2.20462;
                    break;
                case "Celsius to Fahrenheit":
                    result = (input * 9 / 5) + 32;
                    break;
                case "Fahrenheit to Celsius":
                    result = (input - 32) * 5 / 9;
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new UnitConverterGUI();
    }
}
