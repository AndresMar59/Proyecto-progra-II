import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    // ---- MÉTODO DE LISTADO FILTRADO ----
    public void listarLibros(String genero, String autor, Boolean disponibilidad) {
        System.out.println("---- Libros filtrados ----");
        for (Libro libro : libros) {
            boolean coincide = true;

            if (genero != null && !genero.isEmpty()) {
                coincide &= libro.getGenero().equalsIgnoreCase(genero);
            }
            if (autor != null && !autor.isEmpty()) {
                coincide &= libro.getAutor().equalsIgnoreCase(autor);
            }
            if (disponibilidad != null) {
                coincide &= (libro.isDisponible() == disponibilidad);
            }

            if (coincide) {
                System.out.println(libro);
            }
        }
    }
}

