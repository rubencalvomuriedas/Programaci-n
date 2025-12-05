import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private ArrayList<Pelicula> peliculasAlquiladas;

    public Cliente(String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento) {

        if (!MiUtils.validarDNI(dni)) {
            System.out.println("AVISO: DNI no válido.");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasAlquiladas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumSocio() {
        return numSocio;
    }
    public void setNumSocio(String numSocio) {
        this.numSocio = numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public ArrayList<Pelicula> getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public void addPelicula(Pelicula p) {
        peliculasAlquiladas.add(p);
    }

    public void devolverPelicula(Pelicula p) {
        peliculasAlquiladas.remove(p);
    }

    public void mostrarInfoCliente() {
        System.out.println("=== CLIENTE ===");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Socio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha nacimiento: " + fechaNacimiento);
        System.out.println("Fecha baja: " + fechaBaja);
        System.out.println("================");
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas alquiladas por " + nombre + ":");
        for (Pelicula p : peliculasAlquiladas) {
            System.out.println("- " + p.getCod());
        }
    }
}
