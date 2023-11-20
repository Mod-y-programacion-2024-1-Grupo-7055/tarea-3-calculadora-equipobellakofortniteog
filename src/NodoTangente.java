public class NodoTangente extends NodoOperador {

    public NodoTangente(CompositeEA der) {
        super(null, der);
        precedence = 3; // Puedes ajustar la precedencia según sea necesario
    }

    @Override
    public double evalua() {
        return Math.tan(Math.toRadians(der.evalua()));
    }
}
