import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {

    private String cod;
    private String titulo;
    private Enums.Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String cod, String titulo, Enums.Genero genero) {
        this.cod = cod;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.isAlquilada = false;
        this.fechaBaja = null;
        this.fechaAlquiler = null;
    }

    public String getCod() {
        return cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public Enums.Genero getGenero() {
        return genero;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public void setAlquilada(boolean alquilada) {
        this.isAlquilada = alquilada;
    }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void mostrarInfoPelicula() {
        System.out.println("Código: " + cod);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Fecha registro: " + fechaRegistro);
        System.out.println("Fecha baja: " + fechaBaja);
        System.out.println("¿Alquilada?: " + (isAlquilada ? "Sí" : "No"));
        System.out.println("Fecha alquiler: " + fechaAlquiler);
        System.out.println("-------------------------------");
    }
}