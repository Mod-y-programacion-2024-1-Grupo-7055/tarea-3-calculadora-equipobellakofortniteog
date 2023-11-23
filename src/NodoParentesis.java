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
 * Clase que representa un nodo especial para manejar paréntesis en una expresión aritmética.
 * Este nodo es una extensión de NodoOperador y forma parte del patrón de diseño Composite,
 */
public class NodoParentesis extends NodoOperador {

    /**
     * Constructor para crear un nodo de paréntesis.
     * Establece la precedencia de los paréntesis en la expresión.
     */
    public NodoParentesis() {
        super();
        precedence = 2;
    }

    /**
     * Evalúa el nodo de paréntesis.
     * Lanzar una excepción porque los paréntesis no se pueden evaluar directamente.
     * @return No retorna nada porque lanza una excepción.
     * @throws UnsupportedOperationException Si se intenta evaluar un nodo de paréntesis.
     */
    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar un parentesis"); //To change body of generated methods, choose Tools | Templates.
    }

}//fin de la clase NodoParentesis
