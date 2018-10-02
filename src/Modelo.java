import java.io.*;
import java.util.Iterator;

/**
 * Clase modelo que se encargará de acceder al archivo para leer
 * y escribir sus datos
 *
 * @author Julen Bujanda
 */
public class Modelo {

    private Agenda<Contacto> agenda;
    private File archivo;

    /**
     * Constructor del modelo que crea el archivo "agenda.csv" si aún no existe
     * y lee sus datos para guardarlos en la variable agenda
     */
    public Modelo() {
        agenda = new Agenda<>();
        archivo = new File("agenda.csv");
        try {
            if (!archivo.createNewFile()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] datosLinea = linea.split(";");
                    agenda.add(new Contacto(datosLinea[0], Long.parseLong(datosLinea[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que guarda el contacto tanto en la variable agenda como
     * en el archivo "agenda.csv"
     *
     * @param nombre Nombre a guardar
     * @param numero Número de teléfono a guardar
     */
    public void guardarContacto(String nombre, long numero) {
        agenda.add(new Contacto(nombre, numero));
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));
            Iterator<Contacto> iterator = agenda.iterator();
            while (iterator.hasNext()) {
                Contacto contacto = iterator.next();
                bufferedWriter.append(contacto.getNombre() + ";" + contacto.getNumero() + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Agenda<Contacto> getAgenda() {
        return agenda;
    }
}
