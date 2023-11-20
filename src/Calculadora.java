import java.util.StringTokenizer;


/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class Calculadora {
    static Compilador comp;

    public static void main(String[] args) {
        try {
            String cadena = "(5-4)*3--2";
            comp = new Compilador();
            StringTokenizer lexemas = comp.analisisLexico(cadena);
            CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
            System.out.println("Expresión: " + nodo);
            System.out.println("Resultado: " + nodo.evalua());
        } catch (ErrorDeSintaxisException e) {
            System.out.println("Se ha detectado un error de sintaxis: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
