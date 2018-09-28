import java.util.Iterator;
import java.util.Scanner;

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
        Agenda<Contacto> agenda = modelo.getAgenda();
        Iterator<Contacto> iterator = agenda.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            System.out.println(contacto.getNombre() + ": " + contacto.getNumero());
        }
    }

    public void buscarContacto() {
        System.out.print("-----BUSCAR CONTACTOS-----\n" +
                "Indique el nombre del contacto: ");
        String nombre = scanner.nextLine();
        Agenda<Contacto> agenda = modelo.getAgenda();
        Iterator<Contacto> iterator = agenda.iterator();
        Agenda<Contacto> resultados = new Agenda<>();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(contacto);
            }
        }
        System.out.println("Se han encontrado los siguientes contactos:");
        iterator = resultados.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            System.out.println(contacto.getNombre() + ": " + contacto.getNumero());
        }
    }

}
