public class NodoRaizCuadrada extends NodoOperador {

    public NodoRaizCuadrada(CompositeEA der) {
        super(null, der);
        precedence = 3; // Puedes ajustar la precedencia según sea necesario
    }

    @Override
    public double evalua() {
        return Math.sqrt(der.evalua());
    }
}
