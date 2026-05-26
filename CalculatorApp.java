import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp {

    JFrame frame;
    JTextField textField;

    double num1, num2, result;
    char operator;

    public CalculatorApp() {

        frame = new JFrame("Calculator");
        frame.setSize(350,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 25));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        String[] buttons = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0","C","=","+"
        };

        for(String text : buttons){

            JButton button = new JButton(text);

            button.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            20
                    )
            );

            button.addActionListener(
                    e -> buttonClick(text)
            );

            panel.add(button);
        }

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buttonClick(String value){

        if(value.matches("[0-9]")){

            textField.setText(
                    textField.getText() + value
            );
        }

        else if(value.matches("[+\\-*/]")){

            num1 = Double.parseDouble(
                    textField.getText()
            );

            operator = value.charAt(0);

            textField.setText("");
        }

        else if(value.equals("=")){

            num2 = Double.parseDouble(
                    textField.getText()
            );

            switch(operator){

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
                    result = num1 / num2;
                    break;
            }

            textField.setText(
                    String.valueOf(result)
            );
        }

        else if(value.equals("C")){

            textField.setText("");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new CalculatorApp()
        );
    }
}