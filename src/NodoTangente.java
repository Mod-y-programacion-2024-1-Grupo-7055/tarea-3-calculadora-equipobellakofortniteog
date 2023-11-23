/**
 * Clase que representa el nodo de la operación tangente en una expresión aritmética.
 * Es una extensión de NodoOperador y forma parte del patrón de diseño Composite
 */
public class NodoTangente extends NodoOperador {

    /**
     * Constructor para crear un nodo de la operación tangente.
     * La tangente solo necesita un operando (el derecho), mientras que el izquierdo se establece como null.
     * @param der El nodo derecho que representa el operando de la operación tangente.
     */
    public NodoTangente(CompositeEA der) {
        super(null, der);
        precedence = 3;
    }//fin de NodoTangente

    /**
     * Evalúa la operación tangente del nodo.
     * Calcula la tangente, y convirtiendo primero el valor a radianes.
     * @return El resultado de aplicar la operación tangente
     */
    @Override
    public double evalua() {
        return Math.tan(Math.toRadians(der.evalua()));
    }
}//fin de la clase NodoTangente

