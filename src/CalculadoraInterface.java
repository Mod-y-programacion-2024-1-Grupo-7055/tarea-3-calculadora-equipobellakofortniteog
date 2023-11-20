import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculadoraInterface {
    private Compilador compilador;
    private JFrame frame;
    private JTextField textField;
    private JPanel panel;

    public CalculadoraInterface() {
        compilador = new Compilador();
        crearInterfaz();
    }

    private void crearInterfaz() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        textField = new JTextField();
        textField.setFont(new Font("SansSerif", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel = new JPanel();

        panel.setLayout(new GridLayout(0, 5));
        agregarBotones(panel);

        frame.getContentPane().add(BorderLayout.NORTH, textField);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setVisible(true);
    }

    private void agregarBotones(JPanel panel) {
        String[] botones = {
                "7", "8", "9", "/", "+","4", "5", "6", "(", ")", "1", "2", "3", "*", "-", "tan", "0", "sqrt", ".", "sin", "cos", "C", "CE", "Salir", "="
        };

        for (String boton : botones) {
            JButton btn = new JButton(boton);
            btn.setFont(new Font("SansSerif", Font.BOLD, 20));
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonText = btn.getText();
                    switch (buttonText) {
                        case "=":
                            calcularResultado();
                            break;
                        case "C":
                            borrarUltimoCaracter();
                            break;
                        case "CE":
                            limpiarTodo();
                            break;
                        case "Salir":
                            System.exit(0);
                            break;
                        case "sqrt":
                        case "sin":
                        case "cos":
                        case "tan":
                            textField.setText(textField.getText() + buttonText + "(");
                            break;
                        default:
                            textField.setText(textField.getText() + buttonText);
                            break;
                    }
                }
            });
            panel.add(btn);
        }
    }

    private void calcularResultado() {
        String input = textField.getText();
        // Agregar depuración para imprimir la cadena enviada al compilador
        System.out.println("Cadena enviada al compilador: '" + input + "'");
        try {
            StringTokenizer tokens = compilador.analisisLexico(input);
            CompositeEA raiz = compilador.arbolDeAnalisisSintactico(tokens);
            double resultado = raiz.evalua();
            textField.setText(String.valueOf(resultado));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error de Cálculo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarUltimoCaracter() {
        String text = textField.getText();
        if (!text.isEmpty()) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    private void limpiarTodo() {
        textField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraInterface();
            }
        });
    }
}







