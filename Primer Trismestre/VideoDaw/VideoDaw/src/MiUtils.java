import java.time.LocalDate;

public class MiUtils {
    public static boolean validarDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }


    public static boolean validarCIF(String cif) {
        return cif.matches("[A-Z]\\d{8}");
    }


}
