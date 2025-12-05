import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Cliente> clientes;

    public VideoDaw(String cif, String direccion) {

        if (!MiUtils.validarCIF(cif)) {
            System.out.println("AVISO: CIF no válido.");
        }

        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();

        peliculas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public ArrayList<Pelicula> getPeliculas() { return peliculas; }
    public ArrayList<Cliente> getClientes() { return clientes; }

    public void registrarPelicula(Pelicula p) {
        peliculas.add(p);
        System.out.println("Película registrada.");
    }

    public void registrarCliente(Cliente c) {
        clientes.add(c);
        System.out.println("Cliente registrado.");
    }

    public void alquilarPelicula(Pelicula p, Cliente c) {

        if (p.isAlquilada()) {
            System.out.println("ERROR: película ya alquilada.");
            return;
        }

        if (c.getFechaBaja() != null) {
            System.out.println("ERROR: cliente dado de baja.");
            return;
        }

        p.setAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());
        c.addPelicula(p);

        System.out.println("Película alquilada.");
    }

    public void devolverPelicula(Pelicula p, Cliente c) {

        if (!p.isAlquilada()) {
            System.out.println("ERROR: la película no está alquilada.");
            return;
        }

        p.setAlquilada(false);
        p.setFechaAlquiler(null);
        c.devolverPelicula(p);

        System.out.println("Película devuelta.");
    }

    public void darDeBajaCliente(Cliente c) {
        c.setFechaBaja(LocalDate.now());
        System.out.println("Cliente dado de baja.");
    }

    public void darDeBajaPelicula(Pelicula p) {
        p.setFechaBaja(LocalDate.now());
        System.out.println("Película dada de baja.");
    }
}
