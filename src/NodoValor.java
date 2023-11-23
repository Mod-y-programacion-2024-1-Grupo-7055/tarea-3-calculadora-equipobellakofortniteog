/**
 * Clase que nos modelará a los nodos que tienen un valor aritmético.
 * Usamos composite para construir estructuras de árboles para representar expresiones aritméticas.
 */
public class NodoValor implements CompositeEA {

    double valor; // Variable para guardar el valor numérico del nodo.

    /**
     *
     * @param valor
     * Constructor para crear un nodo de valor.
     */
    public NodoValor(double valor) {
        this.valor = valor;
    }

    /**
     * La evaluación de estos nodos comprende en únicamente devolver el valor
     * que guardan.
     * Es decir, devuelve el valor numérico almacenado.
     * @return el valor del nodo.
     */
    @Override
    public double evalua() {
        return valor;
    }

    /**
     * Regresa una representación en forma de cadena del valor del nodo.
     * @return Una cadena que representa el valor numérico del nodo.
     */
    @Override
    public String toString() {
        return valor + "";
    }

}//fin de la clase NodoValor
