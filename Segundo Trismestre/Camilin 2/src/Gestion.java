import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Gestion implements Serializable {

    private Map<String, Vehiculo> nuevosVehiculos = new HashMap<>();

    public void registrarVehiculo(Vehiculo v) {
        nuevosVehiculos.put(v.getId(), v);
    }

    public void verFlota() {
        if (nuevosVehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos.");
        } else {
            System.out.println("\nVehículos registrados:");
            for (Vehiculo v : nuevosVehiculos.values()) {
                System.out.println(v);
            }
        }
    }

    public void mostrarDisponibles() {
        if (nuevosVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            System.out.println("Vehiculos disponibles:");
            for (Vehiculo v : nuevosVehiculos.values()) {
                if (v.isDisponible()) {
                    System.out.println(v);
                }
            }
        }
    }
    public void mostrarnodelosId() {

        if (nuevosVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        int i = 1;

        for (Vehiculo v : nuevosVehiculos.values()) {
            System.out.println(i + ". " + v.getId() + " - " + v.getModelo());
            i++;
        }
    }

    public Vehiculo obtenerVehiculoPorNumero(int numero) {

        int i = 1;

        for (Vehiculo v : nuevosVehiculos.values()) {
            if (i == numero) {
                return v;
            }
            i++;
        }

        return null;
    }

    public Vehiculo buscarVehiculo(String id) {
        for (Vehiculo v : nuevosVehiculos.values()) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public boolean alquilarVehiculo(String id) {
        Vehiculo v = buscarVehiculo(id);
        if (v == null) {
            System.out.println("No existe el vehiculo");
            return false;
        }
        v.alquilar(LocalDate.now().plusDays(7));
        return true;
    }


    public boolean devolverVehiculo(String id) {
        Vehiculo v = buscarVehiculo(id);
        if (v == null) {
            System.out.println("Ese vehiculo no existe");
            return false;
        }
        if (v.isDisponible()) {
            System.out.println("El vehiculo se devolvio");
            return false;
        }
        v.devolver();

        return true;
    }

    public boolean eliminarVehiculo(String id) {

        if (nuevosVehiculos.containsKey(id)) {
            nuevosVehiculos.remove(id);
            return true;
        }

        return false;
    }

    public void cargarDatos() {

        File file = new File("src/Ficheros.dat");

        if (!file.exists()) {
            return;
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
             nuevosVehiculos = (HashMap<String, Vehiculo>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error al leer datos");
        }
    }

    public void guardarDatos() {
        File file = new File("src/Ficheros.dat");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(nuevosVehiculos);

            System.out.println("Datos guardados correctamente");
        }  catch (Exception e) {
            System.out.println("Error al guardar datos");
        }
    }
}

