import java.util.Scanner;
public class E1 {
    public static void main(String[] args) {

    /* Ejercicio 1: Crea un programa que pida una cadena de texto por teclado y luego muestre cada
    palabra de la cadena en una línea distinta
     */

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor inserte la frase que quiere componer: ");
        String texto = sc.nextLine();

        String[] palabras = texto.split(" ");


        for (String palabra : palabras) {
            System.out.println(" ");
            System.out.println(palabra);
        }

    }
}