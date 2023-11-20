/**
 * Clase que representa el nodo de suma en la calculadora.
 * Extiende de NodoOperador.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoSuma extends NodoOperador {

    /**
     * Constructor de NodoSuma.
     *
     * @param izq Nodo hijo izquierdo.
     * @param der Nodo hijo derecho.
     */
    public NodoSuma(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 0;
    }

    /**
     * Evalúa la suma de los hijos izquierdo y derecho.
     *
     * @return El resultado de la suma.
     * @throws NullPointerException Si alguno de los nodos hijos es nulo.
     */
    @Override
    public double evalua() {
        if (izq == null || der == null) {
            throw new NullPointerException("Uno de los nodos hijos es nulo.");
        }
        return izq.evalua() + der.evalua();
    }
}
