import java.time.LocalDate;

public class Gato extends Mascotas{
    protected String color;
    protected boolean peloLargo;

    public Gato(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento, tipo);
        this.color = color;
        this.peloLargo = peloLargo;
        Mascotas.contadorAnimales++;
    }

    public String getColor() {
        return color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "color='" + color + '\'' +
                ", peloLargo=" + peloLargo +
                "} ";
    }

    @Override
    protected String habla() {
        return this.nombre + " dice: MIAU GRRR";
    }
}
