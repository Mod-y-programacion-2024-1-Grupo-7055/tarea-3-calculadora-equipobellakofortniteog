public class NodoRaizCuadrada extends NodoOperador {

    public NodoRaizCuadrada(CompositeEA der) {
        super(null, der);
        precedence = 3;
    }

    @Override
    public double evalua() {
        return Math.sqrt(der.evalua());
    }
}
