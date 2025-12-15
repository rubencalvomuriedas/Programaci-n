import java.util.ArrayList;
import java.util.List;

public class Planeta extends Astro {

    private double distanciaAlSol;
    private List<Satelite> satelites;

    public Planeta(String nombre, double masa, double diametro,
                   double periodoRotacion, double periodoTraslacion,
                   double distanciaAlSol) {
        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion);
        this.distanciaAlSol = distanciaAlSol;
        this.satelites = new ArrayList<>();
    }

    public void agregarSatelite(Satelite s) {
        satelites.add(s);
    }

    @Override
    public void muestra() {
        System.out.println("PLANETA: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Periodo de rotación: " + periodoRotacion);
        System.out.println("Periodo de traslación: " + periodoTraslacion);
        System.out.println("Distancia al Sol: " + distanciaAlSol);

        if (satelites.isEmpty()) {
            System.out.println("No tiene satélites.");
        } else {
            System.out.println("Satélites:");
            for (Satelite s : satelites) {
                System.out.println(" - " + s.getNombre());
            }
        }
        System.out.println();
    }
}
