public class NodoRaizCuadrada extends NodoOperador {
    public NodoRaizCuadrada() {
        // La precedencia ya está configurada en factoryMethodOperadorNuevo
    }

    @Override
    public double evalua() {
        // Asegurarse de que 'der' no sea nulo
        if (this.der == null) {
            throw new IllegalStateException("El operando derecho no puede ser nulo.");
        }
        double valor = this.der.evalua();
        // Realizar la operación específica
        return Math.sqrt(valor);
    }
}



