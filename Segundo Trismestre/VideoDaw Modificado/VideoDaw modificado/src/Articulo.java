import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public abstract class Articulo implements Serializable {

    private String cod;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;

    private DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter date1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Articulo(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now();
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}