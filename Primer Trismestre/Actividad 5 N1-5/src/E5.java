import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {

    /* Ejercicio 5: Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo
    o no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas).
    Supondremos que el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni
    acentos, etc.). Un palíndromo es un texto que se lee igual de izquierda a derecha que de
    derecha a izquierda.
    Por ejemplo:
    Amigo no gima
    Dabale arroz a la zorra el abad
    Amo la pacífica paloma
    A man a plan a canal Panama
    */
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        // Convertimos a minúsculas y quitamos los espacios
        frase = frase.toLowerCase().replace(" ", "");

        // Invertimos la frase
        String invertida = "";
        for (int i = frase.length() - 1; i >= 0; i--) {
            invertida += frase.charAt(i);
        }

        // Comparamos
        if (frase.equals(invertida)) {
            System.out.println("La frase es un palíndromo.");
        } else {
            System.out.println("La frase NO es un palíndromo.");
        }
    }
}
