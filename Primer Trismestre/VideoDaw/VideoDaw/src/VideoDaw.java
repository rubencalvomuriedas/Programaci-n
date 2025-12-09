import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;

    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.peliculasRegistradas = new Pelicula[200];
        this.clientesRegistrados = new Cliente[200];
    }

    public void mostrarInfoVideoClub() {
        System.out.println("CIF: " + cif);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha alta: " + fechaAlta);
    }

    public boolean registrarCliente(Cliente c) {
        for (Cliente cli : clientesRegistrados) {
            if (cli != null && cli.getDni().equals(c.getDni())) {
                System.out.println("ERROR: Cliente ya registrado.");
                return false;
            }
        }
        for (int i = 0; i < clientesRegistrados.length; i++) {
            if (clientesRegistrados[i] == null) {
                clientesRegistrados[i] = c;
                return true;
            }
        }
        return false;
    }

    public boolean darBajaCliente(Cliente c) {
        for (Cliente cli : clientesRegistrados) {
            if (cli != null && cli.equals(c)) {
                cli.setFechaBaja(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    public boolean registrarPelicula(Pelicula p) {
        for (int i = 0; i < peliculasRegistradas.length; i++) {
            if (peliculasRegistradas[i] == null) {
                peliculasRegistradas[i] = p;
                return true;
            }
        }
        return false;
    }


    public boolean darBajaPelicula(Pelicula p) {
        p.setFechaBaja(LocalDate.now());
        return true;
    }

    public void mostrarPeliculasRegistradas() {
        for (Pelicula p : peliculasRegistradas) {
            if (p != null) p.mostrarInfoPelicula();
        }
    }

    public void mostrarClientesRegistrados() {
        for (Cliente c : clientesRegistrados) {
            if (c != null) c.mostrarInfoCliente();
        }
    }

    // Alquilar película
    public boolean alquilarPelicula(Pelicula p, Cliente c) {
        if (p.isAlquilada()) {
            System.out.println("La película ya está alquilada.");
            return false;
        }

        p.setAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());

        return c.addPelicula(p);
    }

    public boolean devolverPelicula(Pelicula p, Cliente c) {
        if (!p.isAlquilada()) {
            System.out.println("La película no está alquilada.");
            return false;
        }

        if (p.getFechaAlquiler().plusHours(48).isBefore(LocalDateTime.now())) {
            System.out.println("⚠ Advertencia: Película devuelta fuera de plazo (+48h).");
        }

        p.setAlquilada(false);
        p.setFechaAlquiler(null);

        return c.removePelicula(p);
    }

    public Pelicula[] getPeliculas() { return peliculasRegistradas; }
    public Cliente[] getClientes() { return clientesRegistrados; }

}