import java.util.ArrayList;
import java.io.*; //Para manero de ingreso y salida de datos para el literal 5

public class biblioteca {

    private ArrayList<usuario> usuarios;

    public biblioteca() {

        usuarios = new ArrayList<>();
    }

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
        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
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
    }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
}




}
