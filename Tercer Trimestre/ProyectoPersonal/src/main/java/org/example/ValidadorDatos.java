package org.example;

import java.util.Scanner;


public class ValidadorDatos {

    public static int obtenerEnteroValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debes introducir un número entero válido.");
            }
        }
    }

    public static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().replace(",", "."); // Acepta coma o punto
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println(" Error: Debes introducir un precio o valor decimal válido.");
            }
        }
    }

    public static String obtenerTextoNoVacio(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println(" Error: Este campo es obligatorio y no puede estar vacío.");
        }
    }

    public static boolean obtenerBooleanoValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.print(mensaje + " (si/no): ");
            String entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("si") || entrada.equals("s")) return true;
            if (entrada.equals("no") || entrada.equals("n")) return false;
            System.out.println(" Error: Por favor, responde 'si' o 'no'.");
        }
    }
}