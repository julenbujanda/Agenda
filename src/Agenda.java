import java.util.Collections;
import java.util.LinkedList;

public class Agenda<Contacto> extends LinkedList {

    @Override
    public boolean add(Object o) {
        boolean resultado = super.add(o);
        Collections.sort(this);
        return resultado;
    }
}
