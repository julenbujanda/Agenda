/**
 * Clase principal
 *
 * @author Julen Bujanda
 */
public class Main {

    /**
     * Método main que inicia la aplicación
     *
     * @param args
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        while (interfaz.mostrarMenu() != 4) ;
    }

}
