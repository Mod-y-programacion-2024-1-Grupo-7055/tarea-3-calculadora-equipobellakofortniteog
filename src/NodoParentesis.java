/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Clase que representa un nodo de paréntesis en la calculadora.
 * Extiende de NodoOperador.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
/**
 * Clase que representa un nodo de paréntesis en la calculadora.
 * Extiende de NodoOperador.
 */
public class NodoParentesis extends NodoOperador {

    public NodoParentesis() {
        super();
        precedence = 3; // Precedencia más alta para los paréntesis
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar un paréntesis directamente.");
    }
}


