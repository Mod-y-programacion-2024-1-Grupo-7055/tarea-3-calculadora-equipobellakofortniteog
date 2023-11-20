/**
 * Clase abstracta que modela a los nodos que contienen operadores aritméticos
 * y paréntesis izquierdos. La clase no puede ser concreta porque la
 * evaluación de cada nodo depende del operador de cada nodo.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public abstract class NodoOperador implements CompositeEA {

    protected CompositeEA izq, der;
    protected int precedence;

    public NodoOperador() {
        this.izq = null;
        this.der = null;
    }

    public NodoOperador(CompositeEA izq, CompositeEA der) {
        this.izq = izq;
        this.der = der;
    }

    public void setIzq(CompositeEA izq) {
        this.izq = izq;
    }

    public void setDer(CompositeEA der) {
        this.der = der;
    }

    public int getPrecedence() {
        return precedence;
    }

    @Override
    public String toString() {
        String operador = this instanceof NodoSuma ? " + "
                : this instanceof NodoResta ? " - "
                : this instanceof NodoMultiplicacion ? " * "
                : this instanceof NodoDivision ? " / "
                : this instanceof NodoRaizCuadrada ? " sqrt "
                : this instanceof NodoSeno ? " sin "
                : this instanceof NodoCoseno ? " cos "
                : this instanceof NodoTangente ? " tan "
                : this instanceof NodoNegativo ? " -" : "";

        if (izq != null) {
            return "(" + izq + operador + der + ")";
        } else if (this instanceof NodoNegativo || this instanceof NodoRaizCuadrada ||
                this instanceof NodoSeno || this instanceof NodoCoseno ||
                this instanceof NodoTangente) {
            return "(" + operador + der + ")";
        }
        return "";
    }

    public static NodoOperador factoryMethodOperadorNuevo(String s, boolean anteriorEsOperador) throws ErrorDeSintaxisException {
        System.out.println("Creando operador para token: '" + s + "'");

        switch (s) {
            case "sqrt":
            case "sin":
            case "cos":
            case "tan":
                NodoOperador operador = createUnaryOperator(s);
                operador.precedence = 3;
                return operador;
            case "+":
                return new NodoSuma(null, null);
            case "-":
                if (anteriorEsOperador) {
                    return new NodoNegativo();
                } else {
                    return new NodoResta(null, null);
                }
            case "*":
                return new NodoMultiplicacion(null, null);
            case "/":
                return new NodoDivision(null, null);
            case "(":
                return new NodoParentesis();
            default:
                throw new ErrorDeSintaxisException("Operador desconocido: " + s);
        }
    }

    private static NodoOperador createUnaryOperator(String s) {
        switch (s) {
            case "sqrt": return new NodoRaizCuadrada();
            case "sin": return new NodoSeno();
            case "cos": return new NodoCoseno();
            case "tan": return new NodoTangente();
            default: throw new IllegalArgumentException("Operador unario desconocido: " + s);
        }
    }
}
