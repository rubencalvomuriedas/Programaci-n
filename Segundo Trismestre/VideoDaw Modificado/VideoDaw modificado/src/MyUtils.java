import java.io.*;

public class MyUtils {
    public static void guardar(VideoDaw videoDAW) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Recursos/videodaw.dat"))) {

            oos.writeObject(videoDAW); //se escribe toda la clase a la vez
            System.out.println("Sistema guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static VideoDaw cargar() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Recursos/videodaw.dat"))) {

            System.out.println("Se cargó correctamente los datos de la videoteca antigua");

            return (VideoDaw) ois.readObject();//leer objeto videodaw

        } catch (FileNotFoundException e) {
            System.out.println("No hay datos previos.");
            return null;


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return null;

        }
    }
}
