// Clase concreta que representa un Libro en la biblioteca
// Extiende RecursoBiblioteca e implementa la interfaz Prestable
public class Libros extends RecursoBiblioteca implements Prestable {

    public Libros(String titulo, String autor, int anio) {
        super(titulo, autor, anio);
    }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' ya estaba prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El libro '" + titulo + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + titulo + "' no estaba prestado.");
        }
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}
