import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {
    static ArrayList<Libro> listaLibros = new ArrayList<>();
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = -1;
        Scanner eleccion = new Scanner(System.in);

        while (true) {
            /**Menu*/
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Realizar prestamo (pendiente)");
            System.out.println("4. Ver lista de libros");
            System.out.println("5. Guardar y mostrar datos en archivo .txt");
            System.out.println("6. Salir");
            System.out.println("-------------------------------------------------------");

            try {
                System.out.print("Opcion: "); 
                opcion = eleccion.nextInt();
                eleccion.nextLine(); // limpiar buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("**Opcion invalida** Seleccione de nuevo!");
                System.out.println("-------------------------------------------------------");
                eleccion.next();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el titulo del libro:");
                    String titulo = eleccion.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autor = eleccion.nextLine();
                    listaLibros.add(new Libro(titulo, autor));
                    System.out.println("Libro registrado con exito.");
                    break;
                case 2:
                    System.out.println("Ingrese el ID del usuario:");
                    String id = eleccion.nextLine();
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombre = eleccion.nextLine();
                    listaUsuarios.add(new Usuario(nombre, id));
                    System.out.println("Usuario registrado con exito.");
                    break;
                case 3:
                    System.out.println("Funcionalidad de préstamo aún no implementada.");
                    break;
                case 4:
                    System.out.println("Lista de libros registrados:");
                    for (Libro l : listaLibros) {
                        System.out.println("- " + l);
                    }
                    break;
                case 5:
                    guardarYMostrarDatos();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("**Opcion invalida** Seleccione de nuevo!");
                    System.out.println("-------------------------------------------------------");
            }
        }
    }

    // Método para guardar y mostrar datos en un archivo .txt
    public static void guardarYMostrarDatos() {
        String archivo = "biblioteca.txt";

        try {
            FileWriter writer = new FileWriter(archivo, false); // false = sobrescribir
            writer.write("=== Lista de Libros ===\n");
            for (Libro l : listaLibros) {
                writer.write(l.toString() + "\n");
            }

            writer.write("\n=== Lista de Usuarios ===\n");
            for (Usuario u : listaUsuarios) {
                writer.write(u.toString() + "\n");
            }

            writer.close();
            System.out.println("Datos guardados correctamente en " + archivo);

            // Leer y mostrar datos
            System.out.println("\nContenido del archivo:");
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
}