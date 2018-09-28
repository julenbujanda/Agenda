import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Agenda<E> extends LinkedList {

    @Override
    public boolean add(Object o) {
        boolean resultado = super.add(o);
        Collections.sort(this, new Comparator<Contacto>() {
            @Override
            public int compare(Contacto o1, Contacto o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        return resultado;
    }
}
