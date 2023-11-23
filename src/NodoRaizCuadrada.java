/**
 * Clase que representa el nodo de la operación raíz cuadrada en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoRaizCuadrada extends NodoOperador {

    /**
     * Constructor para crear un nodo de raíz cuadrada.
     * La raíz cuadrada solo necesita un operando (el derecho), mientras que el izquierdo se establece como null.
     * @param der El nodo derecho
     */
    public NodoRaizCuadrada(CompositeEA der) {
        super(null, der);
        precedence = 3;
    }

    /**
     * Evalúa la operación raíz cuadrada
     * Calcula la raíz cuadrada del valor evaluado del nodo derecho.
     * @return El resultado
     */
    @Override
    public double evalua() {
        return Math.sqrt(der.evalua());
    }
}//fin de la clase NodoRaízCuadrada
