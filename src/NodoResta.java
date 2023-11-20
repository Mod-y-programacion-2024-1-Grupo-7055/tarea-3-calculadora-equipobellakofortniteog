/**
 * Nodo que representa la operación de resta en la calculadora.
 * Extiende de NodoOperador.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoResta extends NodoOperador {

    /**
     * Constructor que recibe los nodos izquierdo y derecho.
     * @param izq El nodo operador izquierdo.
     * @param der El nodo operador derecho.
     */
    public NodoResta(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        // La precedencia es 0 para operaciones binarias y 3 para unarias (negación)
        this.precedence = (izq == null) ? 3 : 0;
    }

    /**
     * La evaluación del nodo, resta la evaluación de los hijos izquierdo y derecho.
     * Maneja posibles casos de nodos nulos.
     * @return El resultado de la resta.
     * @throws NullPointerException si alguno de los hijos (especialmente el derecho) es nulo.
     */
    @Override
    public double evalua() {
        // Manejo de la resta como negación si solo hay nodo derecho
        if (izq == null) {
            return -der.evalua();
        }
        // Manejo normal de la resta para dos operandos
        return izq.evalua() - der.evalua();
    }
}

