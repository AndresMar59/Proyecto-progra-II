public abstract class RecursoBiblioteca {
    protected String titulo;
    protected String autor;
    protected boolean prestado;

    public RecursoBiblioteca(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + (prestado ? " (Prestado)" : " (Disponible)");
    }
}