import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion implements Serializable {

    private List<Cliente> GestionClientes = new ArrayList<Cliente>();
    private List<Articulo> GestionArticulos = new ArrayList<Articulo>();

    public Gestion() {
        ArrayList<Object> listaClientes = new ArrayList<>();
        ArrayList<Object> listaArticulos = new ArrayList<>();
    }
    public void agregarArticulo (Articulo art) {
        GestionArticulos.add(art);
    }
    public void agregarCliente (Cliente nuevoCliente) {
        GestionClientes.add(nuevoCliente);
    }
    public void mostrarArticulo() {
        for (Articulo a : GestionArticulos) {
            System.out.println(a);
        }
    }
    public void mostrarCliente () {
        if (GestionClientes.isEmpty()) {
            System.out.println("Lista vacia");
        }
        for (Cliente cliente : GestionClientes) {
            System.out.println(cliente);
        }

        // FICHEROS

    }

    // BUSCAR Y BORRAR

    public Cliente buscarCliente (String dni) {
        for (Cliente cliente : GestionClientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean eliminarCliente (String dni) {
        Cliente cli = buscarCliente(dni);

        if (cli == null) {
            System.out.println("El articulo no existe");
            return false;
        }
        GestionClientes.remove(cli);
        System.out.println("El articulo se elimino");
        return true;
    }

    public Articulo buscarArticulo (String id) {
        for (Articulo a : GestionArticulos) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public boolean eliminarArticulo (String id) {
        Articulo articulo = buscarArticulo(id);
        if (articulo == null) {
            System.out.println("El articulo no existe");
            return false;
        }
        if (GestionArticulos.remove(articulo)) {
            System.out.println("El articulo se elimino");
            return true;
        }
        return false;
    }



    public void cargarDatos () {

        File archivo = new File("src/recursos/tumadreGorda.dat");

        if (!archivo.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))) {

            GestionClientes = (List<Cliente>) ois.readObject();
            GestionArticulos = (List<Articulo>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
    public void guardarDatos () {
        try (FileOutputStream fos = new FileOutputStream("src/recursos/tumadreGorda.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(GestionClientes);
            oos.writeObject(GestionArticulos);

            System.out.println("Datos escritos correctamente en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al escribir los datos: " + e.getMessage());
        }
    }
}


