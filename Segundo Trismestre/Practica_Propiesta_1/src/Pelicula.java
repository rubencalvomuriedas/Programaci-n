public class Pelicula extends Articulo {

    private int duracion;
    private Genero genero;
    private final double PRECIO_DIA = 2.5;

    public Pelicula(String id, String titulo, int duracion, Genero genero) {
        super(id, titulo);
        this.duracion = duracion;
        this.genero = genero;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return dias * PRECIO_DIA;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Duracion: " + duracion +
                " min | Genero: " + genero +
                " | Tipo: Pelicula";
    }
}