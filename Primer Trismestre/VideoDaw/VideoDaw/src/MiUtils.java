import java.time.LocalDate;
import java.time.Period;

public class MiUtils {

    public static boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}[A-Za-z]");
    }

    public static boolean validarCIF(String cif) {
        return cif != null && cif.matches("[A-Za-z]\\d{8}");
    }

    public static String generarCodigo(String prefijo, int numero) {
        return prefijo + "-" + String.format("%04d", numero);
    }

    public static boolean esMayorEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }
}