public class Videojuego extends Articulo {

    private String plataforma;
    private int pegi;
    private final double PRECIO_DIA = 3.5;

    public Videojuego(String id, String titulo, String plataforma, int pegi) {
        super(id, titulo);
        this.plataforma = plataforma;
        this.pegi = pegi;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return dias * PRECIO_DIA;
    }

    @Override
    public String toString() {
        return super.toString() + " | Plataforma: " + plataforma +
                " | PEGI: " + pegi + " | Tipo: Videojuego";
    }
}
