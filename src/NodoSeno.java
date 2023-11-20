public class NodoSeno extends NodoOperador {

    public NodoSeno(CompositeEA der) {
        super(null, der);
        precedence = 3; // Puedes ajustar la precedencia según sea necesario
    }

    @Override
    public double evalua() {
        return Math.sin(Math.toRadians(der.evalua()));
    }
}

