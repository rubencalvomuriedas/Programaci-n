package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidadorDatos {

    private static final Scanner sc = new Scanner(System.in);

    public static int obtenerEnteroValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < 0) {
                    System.out.println("  Error: El número no puede ser negativo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  Error: Debes introducir un número entero válido.");
            }
        }
    }

    public static double obtenerDoubleValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().replace(",", ".");
            try {
                double valor = Double.parseDouble(entrada);
                if (valor < 0) {
                    System.out.println(" Error: El valor no puede ser negativo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debes introducir un decimal válido (ej: 19.99).");
            }
        }
    }

    public static String obtenerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println(" Error: Este campo es obligatorio.");
        }
    }


    public static String obtenerDniValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String dni = sc.nextLine().trim().toUpperCase();


            if (Pattern.matches("^[0-9]{8}[A-Z]$", dni)) {
                return dni;
            }
            System.out.println(" Error: Formato de DNI inválido (deben ser 8 números y 1 letra, ej: 12345678X).");
        }
    }

    public static boolean obtenerBooleanoValido(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("si") || entrada.equals("s")) return true;
            if (entrada.equals("no") || entrada.equals("n")) return false;
            System.out.println(" Error: Responde 's' para sí o 'n' para no.");
        }
    }
}