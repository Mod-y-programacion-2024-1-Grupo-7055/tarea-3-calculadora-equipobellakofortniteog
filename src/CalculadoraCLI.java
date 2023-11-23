import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

/**
 * Clase que implementa una interfaz gráfica para una calculadora.
 * Hereda de JFrame para crear una ventana de aplicación.
 */
public class CalculadoraCLI extends JFrame {
    private JTextField textField;
    private Compilador compilador;

    /**
     * Constructor de la clase CalculadoraCLI.
     * Inicializa el compilador y la interfaz gráfica.
     */
    public CalculadoraCLI() {
        compilador = new Compilador();
        initialize();
    }

    /**
     * Inicializa la interfaz gráfica de la calculadora.
     * Configura el layout, los botones y el campo de texto.
     */
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

        // Agrega botones a la interfaz
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

    /**
     * Añade un botón al panel con un texto.
     * @param panel Panel donde se añadirá el botón.
     * @param text Texto del botón.
     */
    private void addButton(JPanel panel, String text) {
        addButton(panel, text, e -> textField.setText(textField.getText() + text));
    }

    /**
     * Añade un botón al panel con un texto y una acción específica.
     * @param panel Panel donde se añadirá el botón.
     * @param buttonText Texto del botón.
     */
    private void addButton(JPanel panel, String buttonText, String textToAdd) {
        JButton button = new JButton(buttonText);
        button.addActionListener(e -> textField.setText(textField.getText() + textToAdd));
        panel.add(button);
    }

    /**
     * Añade un botón al panel con un texto y una acción específica.
     * @param panel Panel donde se añadirá el botón.
     * @param action Acción que realizará el botón.
     */
    private void addButton(JPanel panel, String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        panel.add(button);
    }

    /**
     * Procesa la expresión ingresada en el campo de texto y muestra el resultado.
     */
    private void calcular() {
        try {
            StringTokenizer tokenizer = compilador.analisisLexico(textField.getText());
            CompositeEA resultado = compilador.arbolDeAnalisisSintactico(tokenizer);
            textField.setText(String.valueOf(resultado.evalua()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Punto de entrada principal para la aplicación.
     * @param args (No usado)
     */
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
}//fin de la clase Calculadora

