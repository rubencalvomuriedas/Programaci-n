import java.io.Serializable;

public abstract class Articulo implements Serializable {

    private static final long serialVersionUID = -3295958626808680394L;

    protected String id;
    protected String titulo;
    protected boolean disponible;

    public Articulo(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract double calcularPrecioAlquiler(int dias);

    @Override
    public String toString() {
        return "ID: " + id + " | Titulo: " + titulo + " | Disponible: " + disponible;
    }
}