/**
 * Clase que representa el nodo de la operación coseno en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoCoseno extends NodoOperador {

    /**
     * Constructor para crear un nodo de la operación coseno.
     * El coseno solo necesita un operando (el derecho), mientras que el izquierdo se establece como null.
     * @param der El nodo derecho que representa la operación coseno.
     */
    public NodoCoseno(CompositeEA der) {
        super(null, der);
        precedence = 3;
    }

    /**
     * Evalúa la operación coseno del nodo.
     * Calcula el coseno y convirtiendo el valor a radianes.
     * @return El resultado.
     */
    @Override
    public double evalua() {
        return Math.cos(Math.toRadians(der.evalua()));
    }
}//fin de la clase NodoCoseno

