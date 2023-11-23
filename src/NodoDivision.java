/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
/**
 * Clase que representa el nodo de la operación división en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoDivision extends NodoOperador {
    /**
     * Constructor para crear un nodo de la operación división.
     * Inicia el nodo con los operandos izquierdo y derecho.
     * @param izq El nodo izquierdo que representa el dividendo de la división.
     * @param der El nodo derecho que representa el divisor de la división.
     */
    public NodoDivision(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=1;
    }

    /**
     * Evalúa la operación división del nodo.
     * Divide el valor evaluado del nodo izquierdo por el valor evaluado del nodo derecho.
     * Si el divisor es cero, lanza una excepción
     * @return El resultado de dividir.
     * @throws ArithmeticException Si el divisor (valor del nodo derecho) es cero.
     */
    @Override
    public double evalua() {
        double d = der.evalua();
        if (Double.compare(0, d) == 0) {
            throw new ArithmeticException("No puedes dividir entre cero");
        }
        return izq.evalua() / d;
    }
}//fin de la clase NodoDivisión
