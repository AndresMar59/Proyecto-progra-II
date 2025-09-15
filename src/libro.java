public class Libro {
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int anio, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = disponible;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               ", Autor: " + autor +
               ", Año: " + anio +
               ", Género: " + genero +
               ", Disponible: " + (disponible ? "Sí" : "No");
    }
}

