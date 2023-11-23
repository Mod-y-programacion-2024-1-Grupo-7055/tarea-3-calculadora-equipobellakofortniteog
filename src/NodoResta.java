

/**
 * 
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */

/**
 * Clase que representa el nodo de la operación resta en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoResta extends NodoOperador {

    /**
     * Constructor para crear un nodo de la resta.
     * Inicia el nodo con los operandos izquierdo y derecho.
     * @param izq El nodo izquierdo que representa el primer operando de la resta.
     * @param der El nodo derecho que representa el segundo operando de la resta.
     */
    public NodoResta(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=0;
    }

    /**
     * Evalúa la operación resta del nodo.
     * Resta los valores evaluados de los nodos izquierdo y derecho.
     * @return El resultado de restar los valores de los nodos
     */
    @Override
    public double evalua() {
        if (izq != null) {
            return izq.evalua() - der.evalua();
        }
        return -der.evalua();
    }
}//fin de la clase NodoResta
