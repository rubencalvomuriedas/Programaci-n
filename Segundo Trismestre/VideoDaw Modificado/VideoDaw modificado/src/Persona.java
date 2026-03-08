import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona implements Serializable {


    private static final long serialVersionUID = -8047990138226491690L;
    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;

    private static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento.format(date) +
                '}';
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