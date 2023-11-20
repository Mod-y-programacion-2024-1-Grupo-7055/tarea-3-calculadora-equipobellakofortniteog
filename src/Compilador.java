import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Compilador {
    public StringTokenizer analisisLexico(String cadena) throws ErrorDeSintaxisException {
        if (cadena == null || cadena.isEmpty()) {
            throw new ErrorDeSintaxisException("La cadena de entrada es nula o vacía.");
        }
        cadena = cadena.replace(" ", "");
        // Agregar espacios alrededor de los operadores unarios
        String[] operadoresUnarios = {"sqrt", "sin", "cos", "tan"};
        for (String op : operadoresUnarios) {
            cadena = cadena.replaceAll(op + "\\(", " " + op + " (");
        }
        StringTokenizer tokenizer = new StringTokenizer(cadena, " ()\\+\\*\\-\\/", true);

        // Impresiones de depuración para verificar los tokens generados
        System.out.println("Tokens generados:");
        StringTokenizer copyForDebugging = new StringTokenizer(cadena, " ()\\+\\*\\-\\/", true);
        while (copyForDebugging.hasMoreTokens()) {
            System.out.println("'" + copyForDebugging.nextToken() + "'");
        }

        return tokenizer;
    }

    public CompositeEA arbolDeAnalisisSintactico(StringTokenizer tokenizer) throws ErrorDeSintaxisException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            throw new ErrorDeSintaxisException("Tokenizador vacío o nulo.");
        }

        Stack<NodoOperador> operadores = new Stack<>();
        Stack<CompositeEA> salida = new Stack<>();
        boolean anteriorEsOperador = true;

        while (tokenizer.hasMoreTokens()) {
            String actual = tokenizer.nextToken().trim();

            if (actual.equals("(")) {
                operadores.push(new NodoParentesis());
                anteriorEsOperador = true;
            } else if (actual.equals(")")) {
                casoParentesisDerecho(operadores, salida);
                anteriorEsOperador = false;
            } else if (esOperadorUnario(actual)) {
                // Manejo de operadores unarios
                if (!tokenizer.hasMoreTokens()) {
                    throw new ErrorDeSintaxisException("Falta operando para operador unario.");
                }
                String siguienteToken = tokenizer.nextToken().trim();
                CompositeEA siguienteValor;
                if (siguienteToken.equals("(")) {
                    // Manejar expresiones entre paréntesis para operadores unarios
                    siguienteValor = arbolDeAnalisisSintactico(new StringTokenizer(extraerSubcadena(tokenizer), " ()\\+\\*\\-\\/", true));
                } else {
                    try {
                        siguienteValor = new NodoValor(Double.parseDouble(siguienteToken));
                    } catch (NumberFormatException e) {
                        throw new ErrorDeSintaxisException("Operando inválido para operador unario.");
                    }
                }
                double resultado = aplicarFuncionUnaria(actual, siguienteValor.evalua());
                salida.push(new NodoValor(resultado));
                anteriorEsOperador = false;
            } else {
                try {
                    double valor = Double.parseDouble(actual);
                    salida.push(new NodoValor(valor));
                    anteriorEsOperador = false;
                } catch (NumberFormatException nfe) {
                    NodoOperador no = NodoOperador.factoryMethodOperadorNuevo(actual, anteriorEsOperador);
                    casoOperador(operadores, salida, no);
                    anteriorEsOperador = true;
                }
            }
        }

        popRemainingOperators(operadores, salida);
        if (salida.size() != 1) {
            throw new ErrorDeSintaxisException("Expresión mal formada.");
        }
        return salida.pop();
    }

    private void casoOperador(Stack<NodoOperador> operadores, Stack<CompositeEA> salida, NodoOperador no) throws ErrorDeSintaxisException {
        while (!operadores.empty()) {
            NodoOperador top = operadores.peek();
            if (top.getPrecedence() < no.getPrecedence() || top instanceof NodoParentesis) {
                break;
            } else {
                operadores.pop();
                popIntoOutput(top, salida);
            }
        }
        operadores.push(no);
    }

    private void popIntoOutput(NodoOperador op, Stack<CompositeEA> salida) throws ErrorDeSintaxisException {
        try {
            CompositeEA der = salida.pop();
            op.setDer(der);

            if (!esOperadorUnario(String.valueOf(op))) {
                CompositeEA izq = salida.pop();
                op.setIzq(izq);
            }

            salida.push(op);
        } catch (EmptyStackException ese) {
            throw new ErrorDeSintaxisException("Falta de operando");
        }
    }

    private void casoParentesisDerecho(Stack<NodoOperador> operadores, Stack<CompositeEA> salida) throws ErrorDeSintaxisException {
        boolean parentesisIzquierdoEncontrado = false;

        while (!operadores.empty()) {
            NodoOperador top = operadores.pop();
            if (top instanceof NodoParentesis) {
                parentesisIzquierdoEncontrado = true;
                break;
            } else {
                popIntoOutput(top, salida);
            }
        }

        if (!parentesisIzquierdoEncontrado) {
            throw new ErrorDeSintaxisException("Error en el balanceo de paréntesis");
        }
    }

    private void popRemainingOperators(Stack<NodoOperador> operadores, Stack<CompositeEA> salida) throws ErrorDeSintaxisException {
        while (!operadores.empty()) {
            NodoOperador top = operadores.pop();
            if (top instanceof NodoParentesis) {
                throw new ErrorDeSintaxisException("Error en el balanceo de paréntesis");
            } else {
                popIntoOutput(top, salida);
            }
        }
    }

    private boolean esOperadorUnario(String operador) {
        return operador.equals("sin") || operador.equals("cos") || operador.equals("tan") || operador.equals("sqrt");
    }

    private double aplicarFuncionUnaria(String operador, double valor) {
        switch (operador) {
            case "sin":
                return Math.sin(Math.toRadians(valor));
            case "cos":
                return Math.cos(Math.toRadians(valor));
            case "tan":
                return Math.tan(Math.toRadians(valor));
            case "sqrt":
                return Math.sqrt(valor);
            default:
                throw new IllegalArgumentException("Operador unario desconocido: " + operador);
        }
    }

    private String extraerSubcadena(StringTokenizer tokenizer) {
        StringBuilder sb = new StringBuilder();
        int parentesisAbiertos = 1;
        while (tokenizer.hasMoreTokens() && parentesisAbiertos > 0) {
            String token = tokenizer.nextToken();
            if (token.equals("(")) {
                parentesisAbiertos++;
            } else if (token.equals(")")) {
                parentesisAbiertos--;
            }
            if (parentesisAbiertos > 0) {
                sb.append(token);
            }
        }
        return sb.toString();
    }
}







