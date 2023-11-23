/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Interfaz que nos ayudará a jerarquizar a los nodos que forman el árbol de
 * análisis sintáctico. La operación importante que debe tener cada componente
 * es <code> evalua()<code>, esto nos ayudará a hacer el análisis semántico, 
 * que es la evaluación de cada nodo.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public interface CompositeEA {

    /**
     * Evalúa el nodo actual en el árbol de análisis sintáctico.
     * @return El valor numérico resultante de evaluar el nodo.
     */
    public double evalua();

    /**
     * Proporciona una representación en forma de cadena del nodo.
     * @return Una representación en cadena del nodo.
     */
    @Override
    public String toString();
}//fin de la interfaz CompositeEA
