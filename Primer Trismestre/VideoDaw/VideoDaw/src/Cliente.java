import java.awt.font.NumericShaper;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombre;
    private String NumSocio;
    private String direccion;
    private LocalDate FechaNacimiento;
    private LocalDate FechaBaja;
    private ArrayList<Pelicula> peliculasAlquiladas;

    public Cliente(String dni, String nombre, String NumSocio, String direccion, LocalDate FechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        this.NumSocio = NumSocio;
        this.direccion = direccion;
        this.FechaNacimiento = FechaNacimiento;
        this.peliculasAlquiladas = new ArrayList<>();
    }

    public String getNumSocio() {
        return NumSocio;
    }
    public String getDni() {
        return dni;
    }
    public ArrayList<Pelicula> getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }
    public void agregarPelicula(Pelicula p) {
        peliculasAlquiladas.add(p);
    }
    public void eliminarPelicula(Pelicula p) {
        peliculasAlquiladas.remove(p);
    }
    public void mostrarInfoCliente() {
        System.out.println("------------");
        System.out.println("--- Cliente ---");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número socio: " + NumSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha nacimiento: " + FechaNacimiento);
        System.out.println("------------");
    }
    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas alquiladas por " + nombre + ":");
        for (Pelicula p : peliculasAlquiladas) {
            System.out.println(" - " + p.getCod());
        }
        System.out.println();
    }
    public void addPelicula(Pelicula p) {
        peliculasAlquiladas.add(p);
    }
    public void removePelicula(Pelicula p) {
        peliculasAlquiladas.remove(p);
    }

    public void setFechaBaja(LocalDate d) {
        this.FechaBaja = d;
    }
}
