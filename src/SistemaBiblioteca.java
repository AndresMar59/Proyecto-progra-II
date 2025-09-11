import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        int opcion = -1;

        while (true) {
            /**Menu*/
            System.out.println("Bienvenidos al sistema de biblioteca");
            System.out.println("--Seleccione una opcion del menu:--");
            System.out.println("1.Registrar Libro");
            System.out.println("2.Registrar Usuario");
            System.out.println("3.Realizar prestamo");
            System.out.println("4. Ver lista de libros");
            System.out.println("5. Salir");
            System.out.println("-------------------------------------------------------");
            Scanner eleccion = new Scanner(System.in);

            //System.out.println(opcion); //Verificar que funciona

            try {
                System.out.print("Opcion: "); opcion = eleccion.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("**Opcion invalida** Seleccione de nuevo!");
                System.out.println("-------------------------------------------------------");
                eleccion.next();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado 1");
                    return;
                case 2:
                    System.out.println("Ha seleccionado 2");
                    return;
                case 3:
                    System.out.println("Ha seleccionado 3");
                    return;
                case 4:
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