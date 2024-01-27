package APP;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorUI implements ActionListener {

    JFrame frame;
    JTextField textField;
    JPanel buttonPanel;

    // Variables to store the numbers and operator
    double num1, num2, result;
    char operator;

    public CalculatorUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            button.setFocusPainted(false); // Remove focus border
            buttonPanel.add(button);
            // Add a mouse listener for hover effect
            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(Color.LIGHT_GRAY);
                }

                public void mouseExited(MouseEvent e) {
                    button.setBackground(UIManager.getColor("Button.background"));
                }
            });
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            // Append digits and decimal point to the text field
            textField.setText(textField.getText() + command);
        } else if ("+-*/".contains(command)) {
            // Handle arithmetic operators
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        } else if ("=".equals(command)) {
            // Calculate the result and update the text field
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorUI());
    }
}
