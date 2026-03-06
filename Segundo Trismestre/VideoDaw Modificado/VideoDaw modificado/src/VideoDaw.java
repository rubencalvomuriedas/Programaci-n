import java.io.*;
import java.util.ArrayList;

public class VideoDaw implements Serializable {

    private String cif;
    private String direccion;

    private ArrayList<Articulo> articulos;
    private ArrayList<Cliente> clientes;

    private int contadorPeliculas = 1;
    private int contadorVideojuegos = 1;

    private static final String FICHERO = "videodaw.dat";

    public VideoDaw(String cif, String direccion) {

        this.cif = cif;
        this.direccion = direccion;

        articulos = new ArrayList<>();
        clientes = new ArrayList<>();

    }

    public String generarCodigoPelicula() {

        String cod = String.format("P-%04d", contadorPeliculas);
        contadorPeliculas++;

        return cod;

    }

    public String generarCodigoVideojuego() {

        String cod = String.format("V-%04d", contadorVideojuegos);
        contadorVideojuegos++;

        return cod;

    }

    public void registrarArticulo(Articulo a) {

        articulos.add(a);

    }

    public void registrarCliente(Cliente c) throws ClienteDuplicadoException {

        for (Cliente cli : clientes) {

            if (cli.getNumSocio().equals(c.getNumSocio())) {

                throw new ClienteDuplicadoException("Cliente duplicado");

            }

        }

        clientes.add(c);

    }

    public Cliente buscarCliente(String numSocio) {

        for (Cliente c : clientes) {

            if (c.getNumSocio().equals(numSocio)) {

                return c;

            }

        }

        return null;

    }

    public Articulo buscarArticulo(String cod) {

        for (Articulo a : articulos) {

            if (a.getCod().equals(cod)) {

                return a;

            }

        }

        return null;

    }

    public void alquilar(String cod, String numSocio) {

        Articulo a = buscarArticulo(cod);

        if (a instanceof Pelicula) {

            Pelicula p = (Pelicula) a;
            p.setAlquilada(true);

        }

        else if (a instanceof Videojuego) {

            Videojuego v = (Videojuego) a;
            v.alquilar();

        }

    }

    public void devolver(String cod, String numSocio) throws TiempoAlquilerExcedidoException {

        Articulo a = buscarArticulo(cod);

        if (a instanceof Pelicula) {

            Pelicula p = (Pelicula) a;
            p.setAlquilada(false);

        }

        else if (a instanceof Videojuego) {

            Videojuego v = (Videojuego) a;
            v.devolver();

        }

    }

    public void darBajaCliente(Cliente c) {

        clientes.remove(c);

    }

    public void mostrarArticulosRegistrados() {

        for (Articulo a : articulos) {

            System.out.println(a);

        }

    }

    public void mostrarClientesRegistrados() {

        for (Cliente c : clientes) {

            System.out.println(c);

        }

    }

    public void guardarDatos() {

        try {

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FICHERO));

            oos.writeObject(this);

            oos.close();

        } catch (IOException e) {

            System.out.println("Error guardando datos");

        }

    }

    public static VideoDaw cargarDatos() {

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FICHERO));

            VideoDaw v = (VideoDaw) ois.readObject();

            ois.close();

            return v;

        } catch (Exception e) {

            return null;

        }

    }

}