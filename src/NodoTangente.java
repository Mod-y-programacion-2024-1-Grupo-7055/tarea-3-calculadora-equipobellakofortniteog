public class NodoTangente extends NodoOperador {

    public NodoTangente() {
        // La precedencia ya está configurada en factoryMethodOperadorNuevo
    }

    @Override
    public double evalua() {
        // Asegurarse de que 'der' no sea nulo
        if (this.der == null) {
            throw new IllegalStateException("El operando derecho no puede ser nulo en NodoTangente.");
        }
        double valorEnGrados = Math.toRadians(this.der.evalua());

        // Verifica si el valor está cerca de 90 grados o un múltiplo impar de 90 grados
        // donde la tangente no está definida (tiende a infinito).
        if (Math.abs(Math.cos(valorEnGrados)) < 1E-10) {
            throw new ArithmeticException("Tangente indefinida en este ángulo");
        }

        return Math.tan(valorEnGrados);
    }
}


