public class libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible; 

    // Constructor
    public libro(String titulo, String autor, int anioPublicacion, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = true;
    }

    // Getters y Setters

    public String getTitulo() {
         return titulo; }


    public String getAutor() {
         return autor; }


    public int getAnio() { 
        return anioPublicacion; }

    public String getGenero() { 
        return genero; }

    public boolean estaDisponible() { 
        return disponible; }


    public void setDisponible(boolean disponible) {
         this.disponible = disponible; }


   

    // Método para mostrar la información del libro
    public void mostrarInfo() {
        System.out.println("----- Información del Libro -----");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + anioPublicacion);
        System.out.println("Género: " + genero);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
        System.out.println("--------------------------------");
    }
}