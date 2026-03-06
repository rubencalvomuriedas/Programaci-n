import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Persona implements Serializable {

    private String numSocio;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio) {

        super(dni, nombre, direccion, fechaNacimiento);

        this.numSocio = numSocio;

    }

    public String getNumSocio() {
        return numSocio;
    }

    @Override
    public String toString() {

        return "Socio: " + numSocio +
                " Nombre: " + getNombre() +
                " DNI: " + getDni();

    }

}