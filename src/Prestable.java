// Interfaz que define el comportamiento de un recurso prestable
// Todos los recursos (Libros, Revistas, DVDs) deben implementar estos métodos
public interface Prestable {
    void prestar();
    void devolver();
    boolean estaPrestado();
}
