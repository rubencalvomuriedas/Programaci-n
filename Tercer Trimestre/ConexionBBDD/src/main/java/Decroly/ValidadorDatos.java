package Decroly;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDatos {

    //private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean obtenerBooleanoValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje + " (si/no): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("si") || entrada.equals("s") || entrada.equals("true")) return true;
            if (entrada.equals("no") || entrada.equals("n") || entrada.equals("false")) return false;

            System.out.println(" Error: Responde con 'si' o 'no'.");
        }
    }

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

    public static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Formato de precio inválido (usa el punto para decimales, ej: 19.99).");
        }
    }


//    public String obtenerCodBibliotecaValido() {
//      Scanner sc = new Scanner(System.in);
//      String codigo;

//      while (true) {
//            System.out.println("Ingrese el código de la biblioteca (Ej: ABC123):");
//            codigo = sc.nextLine().toUpperCase();

//            if (codigo.matches("^[A-Z]{3}\\d{3}$")) {
//                return codigo;
//            }
//            System.out.println("Código inválido. Intente de nuevo.");
//        }
//    }

//    public String obtenerCIFValido (String mensaje, Scanner scanner) {
//        Scanner sc = new Scanner(System.in);
//        String cif;
//        while (true) {
//            System.out.println("Ingrese un CIF valido para la empresa (Ejemplo: A1234567891):");
//            cif = sc.nextLine().toUpperCase();
//            if (validarCIF(cif)) {
//                System.out.println("\nCIF admitido correctamente.");
//                return cif;
//
//            }
//            System.out.println("CIF invalido. Por favor vuelva a intentarlo.");
//        }
//    }
//    private static boolean validarCIF(String cif) {
//        return cif.matches("^[A-Z]\\d{10}$");
//    }
//
//
//    public  boolean esEmailValido(String email) {
//        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,7}$");
//    }
//
//    public boolean esTelefonoValido(String tel) {
//        return tel.matches("^(\\+\\d{1,3})?\\d{9,12}$");
//    }
//
//    public  boolean esNumeroSS(String SS) {
//        return SS.matches("^\\d{10}$");
//    }


}
