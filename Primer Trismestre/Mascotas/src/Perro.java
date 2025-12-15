import java.time.LocalDate;

public class Perro extends Mascotas{
    protected String raza;
    protected boolean pulgas;

    public Perro(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo, String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento, tipo);
        this.raza = raza;
        this.pulgas = pulgas;
        Mascotas.contadorAnimales++;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }

    @Override
    public String toString() {
        return super.toString()+
                "raza='" + raza + '\'' +
                ", pulgas=" + pulgas +
                "} ";
    }

    @Override
    protected String habla() {
        return this.nombre + " dice: GUAU GUAU!";
    }
}
