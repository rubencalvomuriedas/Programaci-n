import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {

    private static final long serialVersionUID = -231232323L;

    private String isbn;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public Libro(String isbn, String titulo, String autor, LocalDate fechaPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                " | Título: " + titulo +
                " | Autor: " + autor +
                " | Fecha: " + fechaPublicacion;
    }
}
