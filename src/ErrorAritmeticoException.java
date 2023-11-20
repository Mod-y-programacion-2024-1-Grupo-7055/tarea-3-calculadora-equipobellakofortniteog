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
 * Clase para manejar excepciones aritméticas específicas en la calculadora.
 */
public class ErrorAritmeticoException extends Exception {

    /**
     * Constructor que recibe un mensaje de error específico.
     * @param error El mensaje detallado del error aritmético.
     */
    public ErrorAritmeticoException(String error) {
        super("Error aritmético: " + error);
    }

    /**
     * Método estático para generar un error de división por cero.
     * @return ErrorAritmeticoException con el mensaje específico para división por cero.
     */
    public static ErrorAritmeticoException divisionPorCero() {
        return new ErrorAritmeticoException("División por cero no permitida.");
    }

    /**
     * Método estático para generar un error de valor matemático no definido.
     * @return ErrorAritmeticoException con el mensaje específico para valores matemáticos no definidos.
     */
    public static ErrorAritmeticoException valorNoDefinido() {
        return new ErrorAritmeticoException("Valor matemático no definido.");
    }

}

