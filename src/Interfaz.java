import java.util.Scanner;
import java.util.TreeMap;

public class Interfaz {

    private static Scanner scanner;
    private Modelo modelo;

    public Interfaz() {
        modelo = new Modelo();
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("-----AGENDA-----\n" +
                "1. Insertar contacto\n" +
                "2. Listar contactos\n" +
                "3. Buscar contacto\n" +
                "4. Salir");
        int opcion = Integer.parseInt(scanner.nextLine());
        switch (opcion) {
            case 1:
                insertarContacto();
                break;
            case 2:
                listarContactos();
                break;
            case 3:
                buscarContacto();
                break;
        }
        return opcion;
    }

    public void insertarContacto() {
        System.out.println("Indique el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Indique el número de teléfono: ");
        long telefono = Long.parseLong(scanner.nextLine());
        modelo.guardarContacto(nombre, telefono);
    }

    public void listarContactos() {
        System.out.println("-----LISTA DE CONTACTOS-----");
        TreeMap<String, Long> agenda = modelo.getAgenda();
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre + ": " + agenda.get(nombre));
        }
    }

    public void buscarContacto() {
        System.out.print("-----BUSCAR CONTACTOS-----\n" +
                "Indique el nombre del contacto: ");
        String nombre = scanner.nextLine();
        if (modelo.getAgenda().containsKey(nombre)) {
            System.out.println(nombre + ": " + modelo.getAgenda().get(nombre));
        } else {
            System.out.println("Contacto no encontrado.");
        }

    }

}
