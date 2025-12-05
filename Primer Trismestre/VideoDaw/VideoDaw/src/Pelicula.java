import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {

    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean alquilada;

    public Pelicula(String cod, String titulo, Genero genero) {
        this.cod = cod;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.alquilada = false;
    }

    public String getCod() {
        return cod; }
    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isAlquilada() {
        return alquilada;
    }
    public void setAlquilada(boolean alquilada) {
        this.alquilada = alquilada;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void mostrarInfoPelicula() {
        System.out.println("=== PELÍCULA ===");
        System.out.println("Código: " + cod);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Registrada: " + fechaRegistro);
        System.out.println("Baja: " + fechaBaja);
        System.out.println("Alquilada: " + alquilada);
        System.out.println("================");
    }
}

