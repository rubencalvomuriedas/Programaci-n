import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private static final long serialVersionUID = -8524492927701179334L;

    private String dni;
    private String nombre;
    private ArrayList<Articulo> articulosAlquilados;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.articulosAlquilados = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }

    public boolean alquilarArticulo(Articulo articulo) {
        if (articulosAlquilados.size() >= 3) {
            return false;
        }
        articulosAlquilados.add(articulo);
        articulo.setDisponible(false);
        return true;
    }

    public void devolverArticulo(Articulo articulo) {
        articulosAlquilados.remove(articulo);
        articulo.setDisponible(true);
    }

    @Override
    public String toString() {
        return "DNI: " + dni +
                " | Nombre: " + nombre +
                " | Articulos alquilados: " + articulosAlquilados.size();
    }
}
