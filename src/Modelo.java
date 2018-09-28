import java.io.*;
import java.util.TreeMap;

public class Modelo {

    private TreeMap<String, Long> agenda;
    private File archivo;

    public Modelo() {
        agenda = new TreeMap<>();
        archivo = new File("agenda.csv");
        try {
            archivo.createNewFile();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datosLinea = linea.split(";");
                agenda.put(datosLinea[0], Long.parseLong(datosLinea[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarContacto(String nombre, long numero) {
        agenda.put(nombre, numero);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));
            for (String nombres : agenda.keySet()) {
                bufferedWriter.append(nombres + ";" + agenda.get(nombres) + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TreeMap<String, Long> getAgenda() {
        return agenda;
    }
}
