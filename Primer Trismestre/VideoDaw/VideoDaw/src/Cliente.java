import java.time.LocalDate;

public class Cliente {

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;

    public Cliente(String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Pelicula[10];
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getNumSocio() { return numSocio; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public LocalDate getFechaBaja() { return fechaBaja; }
    public Pelicula[] getPeliculasAlquiladas() { return peliculasAlquiladas; }

    public void setFechaBaja(LocalDate fechaBaja) { this.fechaBaja = fechaBaja; }

    public void mostrarInfoCliente() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número socio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha nacimiento: " + fechaNacimiento);
        System.out.println("Fecha baja: " + fechaBaja);
        System.out.println("-------------------------------");
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas alquiladas por " + nombre + ":");
        for (Pelicula p : peliculasAlquiladas) {
            if (p != null) {
                System.out.println("- " + p.getTitulo());
            }
        }
        System.out.println("-------------------------------");
    }

    public boolean addPelicula(Pelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) {
                peliculasAlquiladas[i] = p;
                return true;
            }
        }
        return false;
    }

    public boolean removePelicula(Pelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] != null && peliculasAlquiladas[i].equals(p)) {
                peliculasAlquiladas[i] = null;
                return true;
            }
        }
        return false;
    }

}
