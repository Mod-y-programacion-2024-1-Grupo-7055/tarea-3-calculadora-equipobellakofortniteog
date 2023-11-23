/**
 * Clase que representa el nodo de la operación seno en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoSeno extends NodoOperador {

    /**
     * Constructor para crear un nodo de la operación seno.
     * El seno solo necesita un operando (el derecho), mientras que el izquierdo se establece como null.
     * @param der El nodo derecho que representa la operación seno.
     */
    public NodoSeno(CompositeEA der) {
        super(null, der);
        precedence = 3;
    }


    /**
     * Evalúa la operación seno del nodo.
     * Calcula el seno, y convierte primero el valor a radianes.
     * @return El resultado de aplicar la operación seno al valor del nodo derecho.
     */
    @Override
    public double evalua() {
        return Math.sin(Math.toRadians(der.evalua()));
    }
}//fin de la clase NodoSeno

