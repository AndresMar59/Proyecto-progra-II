import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        int opcion = -1;

        // Bloque de prueba inicial
        Libros l1 = new Libros("El Quijote", "Cervantes", 1605);
        Revista r1 = new Revista("National Geographic", "Varios", 2023);
        DVD d1 = new DVD("Inception", "Christopher Nolan", 2010);

        System.out.println("\n*** Pruebas de préstamos y devoluciones ***");
        l1.prestar();
        l1.prestar(); // Intento doble
        l1.devolver();
        r1.prestar();
        d1.prestar();
        d1.devolver();

        // Menú principal
        while (true) {
            System.out.println("\nBienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1.Registrar Libro");
            System.out.println("2.Registrar Usuario");
            System.out.println("3.Realizar préstamo/devolución");
            System.out.println("4. Ver lista de libros");
            System.out.println("5. Salir");
            System.out.println("-------------------------------------------------------");
            Scanner eleccion = new Scanner(System.in);

            try {
                System.out.print("Opcion: "); 
                opcion = eleccion.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("**Opcion invalida** Seleccione de nuevo!");
                System.out.println("-------------------------------------------------------");
                eleccion.next();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado 1");
                    break;
                case 2:
                    System.out.println("Ha seleccionado 2");
                    break;
                case 3:
                    System.out.println("Ha seleccionado 3: Realizar préstamo/devolución");

                    // Ejemplo sencillo: crea un libro para prestar/devolver
                    Libros libroPrueba = new Libros("Cien Años de Soledad", "Gabriel García Márquez", 1967);

                    System.out.println("¿Qué desea hacer con el libro '" + libroPrueba.getTitulo() + "'?");
                    System.out.println("1. Prestar");
                    System.out.println("2. Devolver");
                    int accion = eleccion.nextInt();

                    if (accion == 1) {
                        libroPrueba.prestar();
                    } else if (accion == 2) {
                        libroPrueba.devolver();
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Ha seleccionado 4");
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("**Opcion invalida** Seleccione de nuevo!");
                    System.out.println("-------------------------------------------------------");
            }
        }
    }
}