import java.time.LocalDateTime;

public class Videojuego extends Articulo {

    private static final long serialVersionUID = 7635770824707583177L;

    private GeneroVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilado;

    public Videojuego(String cod, String titulo, GeneroVideojuego genero) {
        super(cod, titulo);
        this.genero = genero;
        this.isAlquilado = false;
    }

    public GeneroVideojuego getGenero() {
        return genero;
    }

    public boolean isAlquilado() {
        return isAlquilado;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void alquilar() {
        isAlquilado = true;
        fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        isAlquilado = false;
        fechaAlquiler = null;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Género: " + genero +
                " | Alquilado: " + isAlquilado;
    }
}
