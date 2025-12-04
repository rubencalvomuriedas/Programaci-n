import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class VideoDaw {

        private String cif;
        private String direccion;
        private LocalDate fechaAlta;

        public ArrayList<Pelicula> peliculasRegistradas;
        public ArrayList<Cliente> clientesRegistrados;

        public VideoDaw(String cif, String direccion) {
            if (!cif.matches("[A-Z]{1}\\d{8}"))
                throw new IllegalArgumentException("CIF no válido.");

            this.cif = cif;
            this.direccion = direccion;
            this.fechaAlta = LocalDate.now();
            this.peliculasRegistradas = new ArrayList<>();
            this.clientesRegistrados = new ArrayList<>();
        }

        public boolean registrarCliente(Cliente c) {
            for (Cliente cli : clientesRegistrados) {
                if (cli.getDni().equals(c.getDni())) {
                    System.out.println("El cliente ya está registrado.");
                    return false;
                }
            }

            clientesRegistrados.add(c);
            return true;
        }

        public boolean registrarPelicula(Pelicula p) {
            for (Pelicula pl : peliculasRegistradas) {
                if (pl.getCod().equals(p.getCod())) {
                    System.out.println("La película ya está registrada.");
                    return false;
                }
            }

            peliculasRegistradas.add(p);
            return true;
        }

        public void mostrarInfoVideoClub() {
            System.out.println("\n=== INFO VIDEODAW ===");
            System.out.println("CIF: " + cif);
            System.out.println("Dirección: " + direccion);
            System.out.println("Fecha alta: " + fechaAlta);
            System.out.println("Películas registradas: " + peliculasRegistradas.size());
            System.out.println("Clientes registrados: " + clientesRegistrados.size());
        }

        public void mostrarPeliculasRegistradas() {
            System.out.println("\n=== PELÍCULAS REGISTRADAS ===");
            for (Pelicula p : peliculasRegistradas) {
                System.out.println(p.getCod() + " - " + p.getTitulo());
            }
        }

        public void mostrarClientesRegistrados() {
            System.out.println("\n=== CLIENTES REGISTRADOS ===");
            for (Cliente c : clientesRegistrados) {
                System.out.println(c.getNumSocio() + " - " + c.getDni());
            }
        }

        // ------------------------------
        // ALQUILERES
        // ------------------------------

        public boolean alquilarPelicula(Pelicula p, Cliente c) {
            if (p.getIsAlquilada()) {
                System.out.println("La película ya está alquilada.");
                return false;
            }

            p.setIsAlquilada(true);
            p.setFechaAlquiler(LocalDateTime.now());
            c.addPelicula(p);

            return true;
        }

        public boolean devolverPelicula(Pelicula p, Cliente c) {

            if (!p.getIsAlquilada()) {
                System.out.println("La película no estaba alquilada.");
                return false;
            }

            // Control 48h
            long horas = ChronoUnit.HOURS.between(p.getFechaAlquiler(), LocalDateTime.now());
            if (horas > 48) {
                System.out.println("Película devuelta fuera de plazo (" + horas + "h).");
            }

            p.setIsAlquilada(false);
            p.setFechaAlquiler(null);
            c.removePelicula(p);
            return true;
        }

        // ------------------------------
        // BAJAS
        // ------------------------------

        public boolean darBajaCliente(Cliente c) {
            if (!c.getPeliculasAlquiladas().isEmpty()) {
                System.out.println("No se puede dar de baja: el cliente tiene películas alquiladas.");
                return false;
            }
            c.setFechaBaja(LocalDate.now());
            return true;
        }

        public boolean darBajaPelicula(Pelicula p) {
            if (p.getIsAlquilada()) {
                System.out.println("No se puede dar de baja: la película está alquilada.");
                return false;
            }

            p.setFechaBaja(LocalDate.now());
            return true;
        }



}
