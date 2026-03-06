import java.io.Serializable;

public class Pelicula extends Articulo implements Serializable {

    private static final long serialVersionUID = 5376647474802106345L;
    private GeneroPelicula genero;
    private boolean alquilada;

    public Pelicula(String cod, String titulo, GeneroPelicula genero) {

        super(cod, titulo);

        this.genero = genero;
        this.alquilada = false;

    }

    public GeneroPelicula getGenero() {
        return genero;
    }

    public boolean isAlquilada() {
        return alquilada;
    }

    public void setAlquilada(boolean alquilada) {
        this.alquilada = alquilada;
    }

    @Override
    public String toString() {

        return super.toString() +
                " Género: " + genero +
                " Alquilada: " + alquilada;

    }

}