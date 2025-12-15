import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Mascotas {

    protected String nombre;
    protected int edad;
    protected Estado estado;
    protected LocalDate fechaNacimiento;

    protected Tipo tipo;

    public static int contadorAnimales = 0;

    public Mascotas(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = LocalDate.now();
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mascotas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estado=" + estado +
                ", fechaNacimiento=" + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", tipo= " + tipo;
    }

    protected void cumpleanios(){
        if(fechaNacimiento == getFechaNacimiento().plusYears(1)){
            System.out.println("Feliz cumpleanios " + this.nombre);
        }
    }

    protected void morir(){
        System.out.println("RIP " + this.nombre);
        this.estado = Estado.MUERTO;
    }

    protected abstract String habla();
}
