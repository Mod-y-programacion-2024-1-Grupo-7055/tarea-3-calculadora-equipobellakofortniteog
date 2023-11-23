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
 * Clase que representa una excepción de error aritmético.
 * Esta excepción se lanza cuando se encuentra un error aritmético.
 */
public class ErrorAritmeticoException extends Exception{

    /**
     * Clase que representa una excepción de error aritmético.
     * Esta excepción se lanza cuando se encuentra un error aritmético
     */
    public ErrorAritmeticoException(String error) {
        super("Error aritmético: " + error);
    }
    
    
}//fin de la clase ErrorAritmeticoException
