/**2.Registrar usuarios (lectores) con nombre, número de identificación y libros prestados. */

/**Requisitos técnicos

Uso de POO (clases Libro, Usuario, Biblioteca, Main).

Uso de colecciones en Java (ArrayList, HashMap o similares).

Manejo de archivos (FileReader, FileWriter, o BufferedReader/BufferedWriter).

Uso de menú interactivo en consola con opciones numéricas.

Validaciones de entrada (por ejemplo, que no se pueda prestar un libro ya prestado).

División de funcionalidades por módulos (métodos bien definidos). */

/**----------------------------------------------------------------------------------------------------- */
public class usuario {

    private String nombre;
    private String Id;

    public usuario(String nombre, String Id) {
        this.nombre = nombre;
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return Id;
    }

}
