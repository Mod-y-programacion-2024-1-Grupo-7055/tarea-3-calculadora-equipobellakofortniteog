/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Clase que representa el nodo de la operación suma en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */


/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoSuma extends NodoOperador {

    /**
     * Constructor para crear un nodo de la operación suma.
     * Inicia el nodo con los operandos izquierdo y derecho.
     * @param izq El nodo izquierdo que representa el primer operando de la suma.
     * @param der El nodo derecho que representa el segundo operando de la suma.
     */
    public NodoSuma(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=0;
    }

    /**
     * Evalúa la operación suma del nodo.
     * Suma los valores evaluados de los nodos izquierdo y derecho
     * @return El resultado de sumar
     */
    @Override
    public double evalua() {
        return izq.evalua() + der.evalua();
    }
}//fin de la clase NodoSuma
