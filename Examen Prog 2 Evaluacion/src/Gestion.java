import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Gestion implements Serializable {

    private static final long serialVersionUID = -8219365666092906555L;
    private static Map<String, Persona> nuevaPersona = new HashMap<>();

    public static void registrarPersona(Persona p) {
        nuevaPersona.put(p.getNombre(), p);
    }


    public static void verInformacionGeneral() {
        if (nuevaPersona.isEmpty()) {
            System.out.println("\nNo hay Informacion");
            return;

        }
        int i = 1;

        for (Persona p : nuevaPersona.values()) {
            System.out.println(i + "-" + p.getDni());

            i++;
        }
    }

    public static void verOrganigrama() {
        if (nuevaPersona.isEmpty()) {
            System.out.println("\nNo hay personas.");
        } else {
            System.out.println("\nOrganigrama :");
            for (Persona p : nuevaPersona.values()) {
                System.out.println(p);
            }
        }
    }


    public static boolean eliminarPersona(String dni) {

        if (nuevaPersona.containsKey(dni)) {
            nuevaPersona.remove(dni);
            return true;
        }

        return false;
    }

    public static boolean VerPersonaporDni(int Dni) {

        int i = 1;

        for (Persona p : nuevaPersona.values()) {
            if (i == Dni) {
                return false;
            }
            i++;
        }

        return Boolean.parseBoolean(null);
    }

    public static void cargarDatos() {

        File file = new File("src/Empresa.dat");

        if (!file.exists()) {
            return;
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            nuevaPersona = (HashMap<String, Persona>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error al leer datos");
        }
    }

    public static void guardarDatos() {
        File file = new File("src/Empresa.dat");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(nuevaPersona);

            System.out.println("Datos guardados correctamente");
        }  catch (Exception e) {
            System.out.println("Error al guardar datos");
        }
    }
}







