
/**
 * Clase abstracta que modela a los nodos que contienen operadores aritméticos
 * y paréntesis izquierdos. La clase no puede ser concreta porque la
 * evaluación de cada nodo depende del operador de cada nodo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public abstract class NodoOperador implements CompositeEA{

    /**
     * Los hijos izquierdo (izq) y derecho (der) que cada operador podría tener.
     */
    protected CompositeEA izq, der;

    /**
     * La precedencia en la jerarquía de operadores.
     */
    protected int precedence;
    
    /**
     * Constructor por omisión.
     */
    public NodoOperador(){
        izq=null;
        der=null;
    }

    /**
     * Constructor que recibe nodos hijos izquierdo y derecho.
     * @param izq El nodo hijo izquierdo.
     * @param der El nodo hijo derecho.
     *
     */
    public NodoOperador(CompositeEA izq, CompositeEA der) {
        this.izq=izq;
        this.der=der;
    }
    
    /**
     * Constructor copia
     * @param n El NodoOperador a copiar.
     */
    public NodoOperador(NodoOperador n){
        izq=n.izq;
        der=n.der;
    }
    
    /**
     * Establece el nodo hijo izquierdo.
     * @param izq
     */
    public void setIzq(CompositeEA izq){
        this.izq=izq;
    }
    
    /**
     * Establece el nodo hijo derecho
     * @param der
     */
    public void setDer(CompositeEA der){
        this.der=der;
    }

    /**
     * Obtiene la precedencia del operador.
     * @return La precedencia del operador.
     */
    public int getPrecedence(){
        return precedence;
    }
    
    /**
     * Método que se encarga de la represencación en una cadena de los nodos.
     * Este método se implementa en esta clase abstracta para evitar repetir el
     * código en las clases concretas.
     * @return Una representación en cadena del nodo operador y sus hijos.
     */
    @Override
    public String toString() {
        String operador = this instanceof NodoSuma ? " + "
                        : this instanceof NodoResta ? " - "
                        : this instanceof NodoMultiplicacion ? " * " : " / ";

        if (izq != null) {
            return "(" + izq + operador + der + ")";
        }
        return  "("+ operador + der + ")";

    }
    
    /**
     * Método estático que genera una instancia de {@link NodoOperador}, dependiendo
     * del operando que representa.
     * @param s El token con el operador.
     * @param anteriorEsOperador Nos dice si el token anterior también fue operador
     * (es necesario para el caso en el que la resta opera como operador unario).
     * @return Un nodo concreto, dependiendo del operador <code>s</code>
     * @throws ErrorDeSintaxisException En caso de recibir caracteres extraños.
     */
    public static NodoOperador factoryMethodOperadorNuevo(String s,
            boolean anteriorEsOperador) throws ErrorDeSintaxisException{
        switch (s) {
                case "+":
                    return new NodoSuma(null,null);
                case "-":
                    NodoOperador o = new NodoResta(null,null);
                    o.precedence=anteriorEsOperador? 3:0;
                    return o;
                case "*":
                    return new NodoMultiplicacion(null,null);
                case "/":
                    return new NodoDivision(null,null);
                case "(":
                    return new NodoParentesis();
            case "q":
                return new NodoRaizCuadrada(null);
            case "s":
                return new NodoSeno(null);
            case "c":
                return new NodoCoseno(null);
            case "t":
                return new NodoTangente(null);
                default:
                    throw new ErrorDeSintaxisException("Error de Sintáxis");
            }
    }
    
}//fin de la clase NodoOperador