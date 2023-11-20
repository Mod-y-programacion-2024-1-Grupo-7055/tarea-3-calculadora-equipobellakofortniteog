public class NodoCoseno extends NodoOperador {

    public NodoCoseno(CompositeEA der) {
        super(null, der);
        precedence = 3; // Puedes ajustar la precedencia según sea necesario
    }

    @Override
    public double evalua() {
        return Math.cos(Math.toRadians(der.evalua()));
    }
}

