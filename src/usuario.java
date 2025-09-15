/**2.Registrar usuarios (lectores) con nombre, número de identificación y libros prestados. */

/**Requisitos técnicos

Uso de POO (clases Libro, Usuario, Biblioteca, Main).

Uso de colecciones en Java (ArrayList, HashMap o similares).

Manejo de archivos (FileReader, FileWriter, o BufferedReader/BufferedWriter).

Uso de menú interactivo en consola con opciones numéricas.

Validaciones de entrada (por ejemplo, que no se pueda prestar un libro ya prestado).

División de funcionalidades por módulos (métodos bien definidos). */

import java.util.ArrayList;

/**----------------------------------------------------------------------------------------------------- */
public class usuario {

    private String nombre;
    private String Id;
    private ArrayList<libro> librosPrestados;


    public usuario(String nombre, String Id) {
        this.nombre = nombre;
        this.Id = Id;
        this.librosPrestados = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return Id;
    }

    public ArrayList<libro> getLibrosPrestados() {
         return librosPrestados; }

    public void mostrarInfo() {
        System.out.println("Usuario: " + nombre + " (ID: " + Id + ")");
    }

    public void prestarLibro(libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(libro libro) {
        librosPrestados.remove(libro);
    }
}

