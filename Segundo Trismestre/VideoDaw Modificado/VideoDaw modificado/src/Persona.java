import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {

    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}