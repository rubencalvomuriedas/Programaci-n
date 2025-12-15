public abstract class Astro {

    protected String nombre;
    protected double masa;
    protected double diametro;
    protected double periodoRotacion;
    protected double periodoTraslacion;

    public Astro(String nombre, double masa, double diametro,
                 double periodoRotacion, double periodoTraslacion) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.periodoTraslacion = periodoTraslacion;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void muestra();
}
