/*Partes de la tarea - Biblioteca:
1. Registrar libros - Andres
2. Registrar Usuario - Tannia
3. Realizar prestamos y devo -Francisco
4. Listar libros por filtro -Carlos
5. Guardar y cargar datos - Cesar  */

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        biblioteca biblio = new biblioteca();
    

        //Cargar datos al iniciar - Opcion 5
        biblio.cargarLibros("libros.txt");
        biblio.cargarUsuario("usuarios.txt");

        Scanner getinfo = new Scanner(System.in);
        int opcion = -1;

        while (true) {
            /**Menu*/
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Realizar devolución");
            System.out.println("5. Listado de Libros");
            System.out.println("6. Salir");
            System.out.println("-------------------------------------------------------");

            //System.out.println(opcion); //Verificar que funciona

            try {
                System.out.print("Opcion: "); opcion = getinfo.nextInt();
                getinfo.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("**Opcion invalida** Seleccione de nuevo!");
                System.out.println("-------------------------------------------------------");
                getinfo.next();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1: //Andres
                     System.out.println("Registro de Libros");
                    System.out.print("Titulo:");
                    String titulo = getinfo.nextLine();
                    System.out.print("Autor:");
                    String autor = getinfo.nextLine();
                    System.out.print("Año de Publicacion:");
                    int anio = getinfo.nextInt();
                    getinfo.nextLine(); // Consumir el salto de línea
                    System.out.print("Genero:");
                    String genero = getinfo.nextLine();
                    //Registro en un archivo txt
                    biblio.registrarLibro(titulo, autor, opcion, genero);
                    biblio.guardarLibros("libros.txt");
                    break;
                case 2: //Tanni
                    System.out.println("Registro de Usuario");
                    System.out.print("Ingrese el nombre del usuario:");
                    String nombre = getinfo.nextLine();
                    System.out.print("Ingrese ID:");
                    String Id = getinfo.nextLine();
                    //Prueba
                    //System.out.println("Nombre del usuario: " + nombre + "ID: " + Id);

                    //Registro en un archivo txt
                    biblio.registrarUsuario(nombre, Id);
                    biblio.guardarUsuario("usuarios.txt");


                    break;
                case 3: //Fran
                    System.out.print("ID usuario: ");
                    String idU = getinfo.nextLine();
                    System.out.print("Título libro: ");
                    String tLibro = getinfo.nextLine();
                    biblio.prestarLibro(idU, tLibro);
                    break;
                case 4: 
                System.out.print("ID usuario: ");
                    String idD = getinfo.nextLine();
                    System.out.print("Título libro: ");
                    String tDev = getinfo.nextLine();
                    biblio.devolverLibro(idD, tDev);
                    break;

                case 5: //Cesar
                System.out.println("¿Cómo deseas filtrar? (titulo/autor/genero/anio/disponibilidad)");
                String filtro = getinfo.nextLine();
                System.out.println("Introduce el valor a buscar:");
                String valor = getinfo.nextLine();

                biblio.listarLibros(filtro, valor);

                    break;
                case 6:
                    //Guardar datos al salir - Opcion 5
                    biblio.guardarLibros("libros.txt");
                    biblio.guardarUsuario("usuarios.txt");

                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    getinfo.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("**Opcion invalida** Seleccione de nuevo!");
                    System.out.println("-------------------------------------------------------");
            }

        }

    }
}