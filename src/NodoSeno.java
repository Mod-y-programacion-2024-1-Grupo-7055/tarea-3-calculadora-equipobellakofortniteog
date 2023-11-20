public class NodoSeno extends NodoOperador {

    public NodoSeno() {
        // La precedencia ya está configurada en factoryMethodOperadorNuevo
    }

    @Override
    public double evalua() {
        // Asegurarse de que 'der' no sea nulo
        if (this.der == null) {
            throw new IllegalStateException("El operando derecho no puede ser nulo en NodoSeno.");
        }
        try {
            // Convertir el valor a radianes antes de calcular el seno
            return Math.sin(Math.toRadians(this.der.evalua()));
        } catch (ArithmeticException e) {
            // Manejar excepciones específicas o errores de evaluación
            throw new ArithmeticException("Error al evaluar el nodo en operación seno: " + e.getMessage());
        }
    }
}



