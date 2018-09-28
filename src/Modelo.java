import java.io.*;
import java.util.Iterator;

public class Modelo {

    private Agenda<Contacto> agenda;
    private File archivo;

    public Modelo() {
        agenda = new Agenda<>();
        archivo = new File("agenda.csv");
        try {
            archivo.createNewFile();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datosLinea = linea.split(";");
                agenda.add(new Contacto(datosLinea[0], Long.parseLong(datosLinea[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
