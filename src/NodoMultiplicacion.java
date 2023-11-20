/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Clase que representa la operación de multiplicación en la calculadora.
 * Extiende de NodoOperador.
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class NodoMultiplicacion extends NodoOperador {

    public NodoMultiplicacion(CompositeEA izq, CompositeEA der) {
        super(izq, der);
        precedence = 1; // Adecuada para la operación de multiplicación
    }

    @Override
    public double evalua() {
        double izqVal = izq.evalua();
        double derVal = der.evalua();

        // Verificación adicional para manejar desbordamientos numéricos
        double resultado = izqVal * derVal;
        if (Double.isInfinite(resultado) || Double.isNaN(resultado)) {
            throw new ArithmeticException("Error de cálculo: desbordamiento numérico o resultado indefinido.");
        }

        return resultado;
    }
}


