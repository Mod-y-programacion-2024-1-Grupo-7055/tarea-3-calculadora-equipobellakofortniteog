public class NodoNegativo extends NodoOperador {

    public NodoNegativo() {
        super(null, null); // Inicialmente, ambos nodos hijo son nulos
        this.precedence = 3; // La precedencia alta es típica para operadores unarios
    }

    @Override
    public double evalua() {
        // Asegúrate de que 'der' no sea nulo antes de evaluar
        if (this.der == null) {
            throw new IllegalStateException("Operando derecho no puede ser nulo en NodoNegativo.");
        }
        return -this.der.evalua(); // Cambia el signo del resultado del operando derecho
    }

    @Override
    public String toString() {
        return "-" + (der == null ? "null" : der.toString());
    }
}

