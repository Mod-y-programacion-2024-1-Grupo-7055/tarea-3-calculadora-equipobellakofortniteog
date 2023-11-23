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
 * Clase que representa una excepción de error de sintaxis.
 * Esta excepción se lanza cuando se encuentra un error en el análisis sintáctico
 * de una expresión aritmética.
 */
public class ErrorDeSintaxisException extends Exception {

    /**
     * Constructor para crear una excepción de error de sintaxis.
     * @param error El mensaje que describe el error de sintaxis específico.
     */
    public ErrorDeSintaxisException(String error) {
        super("Error de sintaxis: " + error);
    }
    
}//fin de la clase ErrorDeSintaxisException
