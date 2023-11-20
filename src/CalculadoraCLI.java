import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculadoraCLI extends JFrame {
    private JTextField textField;
    private Compilador compilador;

    public CalculadoraCLI() {
        compilador = new Compilador();
        initialize();
    }

    private void initialize() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 4, 5, 5));

        textField = new JTextField();
        getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        // Agregando botones
        addButton(panel, "7");
        addButton(panel, "8");
        addButton(panel, "9");
        addButton(panel, "/");

        addButton(panel, "4");
        addButton(panel, "5");
        addButton(panel, "6");
        addButton(panel, "*");

        addButton(panel, "1");
        addButton(panel, "2");
        addButton(panel, "3");
        addButton(panel, "-");

        addButton(panel, "0");
        addButton(panel, ".");
        addButton(panel, "(");
        addButton(panel, ")");

        // Botones con texto personalizado
        addButton(panel, "sin", "sin");
        addButton(panel, "cos", "cos");
        addButton(panel, "tan", "tan");
        addButton(panel, "√", "√");

        addButton(panel, "+");
        addButton(panel, "C", e -> textField.setText(""));
        addButton(panel, "CE", e -> textField.setText(textField.getText().substring(0, textField.getText().length() - 1)));
        addButton(panel, "=", e -> calcular());

        // Botón de salida
        addButton(panel, "Salir", e -> System.exit(0));

        pack();
    }

    private void addButton(JPanel panel, String text) {
        addButton(panel, text, e -> textField.setText(textField.getText() + text));
    }

    private void addButton(JPanel panel, String buttonText, String textToAdd) {
        JButton button = new JButton(buttonText);
        button.addActionListener(e -> textField.setText(textField.getText() + textToAdd));
        panel.add(button);
    }

    private void addButton(JPanel panel, String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        panel.add(button);
    }

    private void calcular() {
        try {
            StringTokenizer tokenizer = compilador.analisisLexico(textField.getText());
            CompositeEA resultado = compilador.arbolDeAnalisisSintactico(tokenizer);
            textField.setText(String.valueOf(resultado.evalua()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalculadoraCLI frame = new CalculadoraCLI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

