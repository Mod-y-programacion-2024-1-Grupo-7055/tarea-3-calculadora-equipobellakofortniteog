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
 * Clase que representa el nodo de la operación multiplicación en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoMultiplicacion extends NodoOperador {

    /**
     * Constructor para crear un nodo de la operación multiplicación.
     * Inicia el nodo con los operandos izquierdo y derecho.
     * @param izq El nodo izquierdo que representa el primer operando de la multiplicación.
     * @param der El nodo derecho que representa el segundo operando de la multiplicación.
     */
    public NodoMultiplicacion(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence=1;
    }

    /**
     * Evalúa la operación multiplicación del nodo.
     * Multiplica los valores evaluados de los nodos izquierdo y derecho.
     * @return El resultado de multiplicar.
     */
    @Override
    public double evalua() {
        return izq.evalua() * der.evalua();
    }

}//fin de la clase NodoMultiplicación
