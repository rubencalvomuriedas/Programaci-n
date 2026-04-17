package Decroly;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase de utilidad para la validación y captura de datos por consola.
 * <p>Proporciona métodos estáticos que garantizan que la entrada del usuario
 * cumpla con los formatos requeridos antes de procesarlos en la aplicación.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class ValidadorDatos {

    /**
     * Solicita y valida una entrada booleana permitiendo múltiples variantes de respuesta.
     * * @param mensaje El texto descriptivo que se mostrará al usuario.
     * @param sc El objeto {@link Scanner} para leer la entrada.
     * @return {@code true} si el usuario introduce 'si', 's' o 'true';
     * {@code false} si introduce 'no', 'n' o 'false'.
     */
    public static boolean obtenerBooleanoValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje + " (si/no): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("si") || entrada.equals("s") || entrada.equals("true")) return true;
            if (entrada.equals("no") || entrada.equals("n") || entrada.equals("false")) return false;

            System.out.println(" Error: Responde con 'si' o 'no'.");
        }
    }

    /**
     * Solicita una cadena de texto y garantiza que no esté vacía o compuesta solo por espacios.
     * * @param mensaje Instrucción que se mostrará al usuario.
     * @param sc Instancia de {@link Scanner}.
     * @return La cadena de texto validada.
     */
    public static String obtenerTextoNoVacio(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("Error: Este campo es obligatorio.");
        }
    }

    /**
     * Solicita un número entero y valida que la entrada contenga exclusivamente dígitos.
     * <p>Utiliza la expresión regular {@code \d+} para verificar el formato antes del parsing.</p>
     * * @param mensaje Instrucción para el usuario.
     * @param sc Instancia de {@link Scanner}.
     * @return El valor entero validado.
     */
    public static int obtenerEnteroValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("Error: Debes introducir un número entero (ej: 10).");
        }
    }

    /**
     * Solicita un número decimal (double) y valida su formato.
     * <p>Se requiere el uso del punto (.) como separador decimal conforme al estándar técnico.</p>
     * * @param mensaje Instrucción para el usuario.
     * @param sc Instancia de {@link Scanner}.
     * @return El valor decimal validado.
     */
    public static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            // Regex para números enteros o decimales con punto
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Formato de precio inválido (usa el punto para decimales, ej: 19.99).");
        }
    }
}