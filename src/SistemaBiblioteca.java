import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        biblioteca biblio = new biblioteca();

        //Cargar datos al iniciar - Opcion 5
        biblio.cargarUsuario("usuarios.txt");

        Scanner getinfo = new Scanner(System.in);
        int opcion = -1;



        while (true) {
            /**Menu*/
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Realizar prestamo");
            System.out.println("4. Devolver Libro");
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
                case 1:
                    System.out.println("Ha seleccionado 1");
                    return;
                case 2:
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
                case 3:
                    System.out.println("Ha seleccionado 3");
                    return;
                case 4:
                    System.out.println("Ha seleccionado 4");
                    return;
                case 5:
                    System.out.println("Ha seleccionado 5");
                    return;
                case 6:
                        return;
                default:
                    System.out.println("**Opcion invalida** Seleccione de nuevo!");
                    System.out.println("-------------------------------------------------------");
            }

        }

    }
}