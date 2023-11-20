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
 * Clase para manejar excepciones de sintaxis específicas en la calculadora.
 */
public class ErrorDeSintaxisException extends Exception {

    /**
     * Constructor que recibe un mensaje de error específico.
     * @param error El mensaje detallado del error de sintaxis.
     */
    public ErrorDeSintaxisException(String error) {
        super("Error de sintaxis: " + error);
    }

    /**
     * Método estático para generar un error de paréntesis desbalanceados.
     * @return ErrorDeSintaxisException con el mensaje específico para paréntesis desbalanceados.
     */
    public static ErrorDeSintaxisException parentesisDesbalanceados() {
        return new ErrorDeSintaxisException("Paréntesis desbalanceados.");
    }

    /**
     * Método estático para generar un error de operador no esperado.
     * @return ErrorDeSintaxisException con el mensaje específico para operador no esperado.
     */
    public static ErrorDeSintaxisException operadorNoEsperado() {
        return new ErrorDeSintaxisException("Operador no esperado en la expresión.");
    }
}

