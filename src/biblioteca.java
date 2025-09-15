import java.util.ArrayList;
import java.util.List;
import java.io.*; //Para manero de ingreso y salida de datos para el literal 5

public class biblioteca {

    private List<libro> libros;
    private ArrayList<usuario> usuarios;

    public biblioteca() {

        usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();

    }

    //Registro de libros
    public void registrarLibro(String titulo, String autor, int anioPublicacion, String genero) {
        libros.add(new libro(titulo, autor, anioPublicacion, genero, true));
    }

    public void listarLibros(String filtro, String valor) {
    System.out.println("--- Resultados de búsqueda ---");
    boolean encontrado = false;

    for (libro libro : libros) {
        switch (filtro.toLowerCase()) {
            case "titulo":
                if (libro.getTitulo().equalsIgnoreCase(valor)) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
                break;
            case "autor":
                if (libro.getAutor().equalsIgnoreCase(valor)) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
                break;
            case "genero":
                if (libro.getGenero().equalsIgnoreCase(valor)) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
                break;
            case "anio":
                if (Integer.toString(libro.getAnio()).equals(valor)) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
                break;
            case "disponibilidad":
                boolean disponible = valor.equalsIgnoreCase("disponible");
                if (libro.estaDisponible() == disponible) {
                    libro.mostrarInfo();
                    encontrado = true;
                }
                break;
            default:
                System.out.println("Filtro no válido. Usa: titulo, autor, genero, anio o disponibilidad.");
                System.out.println("-------------------------------------------------------");

                return;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron libros con ese criterio.");
        System.out.println("-------------------------------------------------------");

    
    }
}


    //Busqueda de libros
    public libro buscarLibro(String titulo) {
        for (libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Retorna null si no se encuentra el libro
    }

    //Prestamo de libro
    public void prestarLibro(String idUsuario, String tituloLibro) {
        usuario usuario = buscarUsuario(idUsuario);
        libro libro = buscarLibro(tituloLibro);

        if (usuario != null && libro != null && libro.estaDisponible()) {
            libro.setDisponible(false);
            usuario.prestarLibro(libro);
            System.out.println("Libro prestado: " + tituloLibro + " a " + usuario.getNombre());
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("No se puede realizar el préstamo.");
        }
    }

    //Devolver
    public void devolverLibro(String idUsuario, String tituloLibro) {
        usuario usuario = buscarUsuario(idUsuario);
        libro libro = buscarLibro(tituloLibro);

        if (usuario != null && libro != null && usuario.getLibrosPrestados().contains(libro)) {
            libro.setDisponible(true);
            usuario.devolverLibro(libro);
            System.out.println("Libro devuelto: " + tituloLibro);
            System.out.println("-------------------------------------------------------");
            
        } else {
            System.out.println("No se puede devolver el libro.");
            System.out.println("-------------------------------------------------------");
        }
    }

    //Guardar libros
    public void guardarLibros(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (libro libro : libros) {
                bw.write(libro.getTitulo() + ";" + libro.getAutor() + ";" + libro.getAnio() + ";" + libro.getGenero() + ";" + libro.estaDisponible());
                bw.newLine();
            }
            System.out.println("Libros guardados en el archivo " + archivo);
            System.out.println("-------------------------------------------------------");
        
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
            System.out.println("-------------------------------------------------------");
    
        }
    }

    //Cargar libros
    public void cargarLibros(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 5) {
                    String titulo = data[0];
                    String autor = data[1];
                    int anio = Integer.parseInt(data[2]);
                    String genero = data[3];
                    boolean disponible = Boolean.parseBoolean(data[4]);
                    libros.add(new libro(titulo, autor, anio, genero, disponible));
                }
            }
            System.out.println("Libros cargados desde el archivo " + archivo);
            System.out.println("-------------------------------------------------------");
        } catch (IOException e) {
            System.out.println("Error al cargar libros: " + e.getMessage());
            System.out.println("-------------------------------------------------------");
        }
    }


    //Registro de usuarios

    public void registrarUsuario(String nombre, String Id) {
        usuarios.add(new usuario(nombre,Id));
    }

    public void guardarUsuario(String archivo) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            for (usuario u : usuarios) {
                bw.write(u.getId() + ";" + u.getNombre());
                bw.newLine();
            }

            System.out.println("Usuario guardado. en documento " + archivo);
            System.out.println("-------------------------------------------------------");
        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
            System.out.println("-------------------------------------------------------");
        }
    }

    //Cargar Usuario
    public void cargarUsuario(String archivo) {
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null){
            String[] data = line.split(";");
            if(data.length == 2){
                usuarios.add(new usuario(data[1],data[0]));
            }
        }
            System.out.println("Usuario cargado en documento " + archivo);
            System.out.println("-------------------------------------------------------");
    }catch (IOException e){
            System.out.println("Error" + e.getMessage());
            System.out.println("-------------------------------------------------------");
        }
}

private usuario buscarUsuario(String id) {
        for (usuario u : usuarios) 
            if (u.getId().equals(id)) return u;
        return null;
    }

}
