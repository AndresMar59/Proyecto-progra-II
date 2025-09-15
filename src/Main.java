public class Main {
    public static void main(String[] args) {
        // Crear un libro
        libro libro1 = new libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true);

        // Mostrar información
        libro1.mostrarInfo();

        // Cambiar disponibilidad
        libro1.setDisponible(false);
        System.out.println("\nDespués de prestar el libro:");
        libro1.mostrarInfo();
    }
}
