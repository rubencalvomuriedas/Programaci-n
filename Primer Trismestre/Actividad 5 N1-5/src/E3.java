import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {

        /* Ejercicio 3: Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos.
        Luego mostrará un código de usuario (en mayúsculas) formado por la concatenación de
        las tres primeras letras de cada uno de ellos. Por ejemplo, si se introduce “Lionel”,
        “Tarazón” y “Alcocer” mostrará “LIOTARALC”
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Inserte su primer apellido: ");
        String primerApellido = sc.nextLine();

        System.out.println("Inserte  su segundo apellido: ");
        String segundoApellido = sc.nextLine();

        String frag1 = nombre.substring(0, 3);
        String frag2 = primerApellido.substring(0, 3);
        String frag3 = segundoApellido.substring(0, 3);
        String mayus = frag1 + frag2 + frag3;
        System.out.println(mayus.toUpperCase());

    }
}