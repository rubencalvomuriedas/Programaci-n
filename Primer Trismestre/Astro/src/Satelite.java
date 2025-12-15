public class Satelite extends Astro {

    private double distanciaAlPlaneta;
    private Planeta planeta;

    public Satelite(String nombre, double masa, double diametro,
                    double periodoRotacion, double periodoTraslacion,
                    double distanciaAlPlaneta, Planeta planeta) {
        super(nombre, masa, diametro, periodoRotacion, periodoTraslacion);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.planeta = planeta;
    }

    @Override
    public void muestra() {
        System.out.println("SATÉLITE: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Periodo de rotación: " + periodoRotacion);
        System.out.println("Periodo de traslación: " + periodoTraslacion);
        System.out.println("Distancia al planeta: " + distanciaAlPlaneta);
        System.out.println("Planeta al que pertenece: " + planeta.getNombre());
        System.out.println();
    }
}
