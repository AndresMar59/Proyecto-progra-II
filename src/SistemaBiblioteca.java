import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // Libros de prueba
        miBiblioteca.agregarLibro(new Libro("El Quijote", "Cervantes", 1605, "Novela", true));
        miBiblioteca.agregarLibro(new Libro("Cien años de soledad", "García Márquez", 1967, "Realismo mágico", false));
        miBiblioteca.agregarLibro(new Libro("Clean Code", "Robert C. Martin", 2008, "Tecnología", true));

        while (true) {
            /** Menú */
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opción del menú:--");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Ver lista de libros (con filtro)");
            System.out.println("5. Salir");
            System.out.println("-----------------------------------");

            try {
                System.out.print("Opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println("**Opción inválida** Seleccione de nuevo!");
                scanner.nextLine(); // limpiar entrada inválida
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Registrar libro (pendiente implementar)");
                    break;

                case 2:
                    System.out.println("Registrar usuario (pendiente implementar)");
                    break;

                case 3:
                    System.out.println("Realizar préstamo (pendiente implementar)");
                    break;

                case 4:
                    System.out.println("---- Listar libros filtrando ----");
                    System.out.print("Género (dejar vacío si no aplica): ");
                    String genero = scanner.nextLine();
                    System.out.print("Autor (dejar vacío si no aplica): ");
                    String autor = scanner.nextLine();
                    System.out.print("¿Disponible? (true/false o vacío): ");
                    String dispInput = scanner.nextLine();
                    Boolean disponible = null;
                    if (!dispInput.trim().isEmpty()) {
                        disponible = Boolean.parseBoolean(dispInput.trim());
                    }
                    miBiblioteca.listarLibros(genero, autor, disponible);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("**Opción inválida** Seleccione de nuevo!");
                    break;
            }
        }
    }
}
