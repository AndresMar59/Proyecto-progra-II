// Clase abstracta que define atributos comunes para todos los recursos
// No se puede instanciar directamente, pero sirve como base para Libros, Revista y DVD
public abstract class RecursoBiblioteca {
    protected String titulo;
    protected String autor;
    protected int anio;
    protected boolean prestado;

    public RecursoBiblioteca(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isPrestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anio + ") " + (prestado ? "[Prestado]" : "[Disponible]");
    }
}