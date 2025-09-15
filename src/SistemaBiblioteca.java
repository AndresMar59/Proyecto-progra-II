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
        biblio.cargarUsuario("usuarios.txt");

        Scanner getinfo = new Scanner(System.in);
        int opcion = -1;

        // Bloque de prueba inicial
        Libros l1 = new Libros("El Quijote", "Cervantes", 1605);
        Revista r1 = new Revista("National Geographic", "Varios", 2023);
        DVD d1 = new DVD("Inception", "Christopher Nolan", 2010);

        System.out.println("\n*** Pruebas de préstamos y devoluciones ***");
        l1.prestar();
        l1.prestar(); // Intento doble
        l1.devolver();
        r1.prestar();
        d1.prestar();
        d1.devolver();
        System.out.println("-------------------------------------------------------");


        while (true) {
            /**Menu*/
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Realizar préstamo/devolución");
            System.out.println("4. Listado de Libros");
            System.out.println("5. Salir");
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
                case 1:
                    System.out.println("Ha seleccionado 1");
                    return;
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
                    System.out.println("Ha seleccionado 3: Realizar préstamo/devolución");

                    // Ejemplo sencillo: crea un libro para prestar/devolver
                    Libros libroPrueba = new Libros("Cien Años de Soledad", "Gabriel García Márquez", 1967);

                    System.out.println("¿Qué desea hacer con el libro '" + libroPrueba.getTitulo() + "'?");
                    System.out.println("1. Prestar");
                    System.out.println("2. Devolver");
                    System.out.print("Opcion: "); opcion = getinfo.nextInt();
                    int accion = getinfo.nextInt();

                    if (accion == 1) {
                        libroPrueba.prestar();
                    } else if (accion == 2) {
                        libroPrueba.devolver();
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 4: //Cesar
                    System.out.println("Ha seleccionado 4");
                    return;
                case 5:
                        return;
                default:
                    System.out.println("**Opcion invalida** Seleccione de nuevo!");
                    System.out.println("-------------------------------------------------------");
            }

        }

    }
}