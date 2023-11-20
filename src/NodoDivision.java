/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Clase que representa el nodo de división en la estructura de la calculadora.
 * Extiende de NodoOperador.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoDivision extends NodoOperador {

    /**
     * Constructor que recibe los nodos izquierdo y derecho.
     *
     * @param izq El nodo operador izquierdo.
     * @param der El nodo operador derecho.
     */
    public NodoDivision(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        this.precedence = 1; // Precedencia para la división
    }

    /**
     * Evalúa el nodo, divide la evaluación de los hijos izquierdo y derecho.
     * Maneja el caso de división por cero.
     *
     * @return el resultado de la división del hijo izquierdo entre el hijo derecho.
     * @throws ArithmeticException si se intenta dividir por cero.
     */
    @Override
    public double evalua() {
        double divisor = der.evalua();
        if (Double.compare(divisor, 0) == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return izq.evalua() / divisor;
    }
}

