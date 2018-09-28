import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Clase agenda que hereda de LinkedList para almacenar los contactos
 *
 * @author Julen Bujanda
 */
public class Agenda<E> extends LinkedList {

    @Override
    /**
     * Sobreescritura del método add para que cada vez que se añada un nuevo
     * contacto se ordene la lista alfabéticamente
     */
    public boolean add(Object o) {
        boolean resultado = super.add(o);
        //Se crea un comparador para poder ordenar alfabéticamente
        Collections.sort(this, (Comparator<Contacto>) (contacto1, contacto2)
                -> contacto1.getNombre().compareToIgnoreCase(contacto2.getNombre()));
        return resultado;
    }
}
