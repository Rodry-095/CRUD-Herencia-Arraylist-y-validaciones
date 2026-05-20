import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    //lista donde se almacenan estudiantes y docentes
    static ArrayList<Persona> lista = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    //metodo principal que muestra el menú interactivo
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n1. Registrar persona");
            System.out.println("2. Mostrar registros");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());


                switch (opcion) {
                    case 1 -> registrar();
                    case 2 -> mostrar();
                    case 3 -> actualizar();
                    case 4 -> eliminar();
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Error: opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar solo números.");
                opcion = 0;
            }
        } while (opcion != 5);
    }


    //registra un nuevo estudiante o docente
    public static void registrar() {

        System.out.println("1. Estudiante");
        System.out.println("2. Docente");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        if (tipo == 1) {
            System.out.print("Carrera: ");
            String carrera = sc.nextLine();
            lista.add(new Estudiante(cedula, nombre, edad, carrera));
        }else if (tipo == 2){
            System.out.print("Asignatura: ");
            String asignatura = sc.nextLine();
            lista.add(new Docente(cedula, nombre, edad, asignatura));
        }
        System.out.println("Registro agregado correctamente.");
    }

    //muestra toda la informacion almacenada
    public static void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nRegistro " + i);
            lista.get(i).mostrarDatos();
        }
    }

    //actualiza la información de un registro existente
    public static void actualizar() {
        mostrar();
        System.out.print("Posición a actualizar: ");
        int pos = Integer.parseInt(sc.nextLine());

        if (pos >= 0 && pos < lista.size()) {

            System.out.print("Nuevo nombre: ");
            lista.get(pos).setNombreCompleto(sc.nextLine());

            System.out.println("Actualizado.");

        }else{
            System.out.println("Registro no encontrado.");
        }
    }

    //elimina un registro seleccionado
    public static void eliminar() {
        mostrar();

        System.out.print("Posición a eliminar: ");
        int pos = Integer.parseInt(sc.nextLine());

        if (pos >= 0 && pos < lista.size()) {

            lista.remove(pos);
            System.out.println("Eliminado.");
        }else{
            System.out.println("Registro no encontrado.");
        }
    }
}
