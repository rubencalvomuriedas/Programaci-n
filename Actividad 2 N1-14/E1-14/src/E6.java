import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {

        /*
        Ejercicio 6: Realiza un programa que muestre los números desde el 1 hasta un número N que se
        introducirá por teclado
         */
        Scanner sc = new Scanner(System.in);

        int numero;

        System.out.println("Ingrese un numero hasta donde contar: ");
        numero = sc.nextInt();

        System.out.println("");
        for  (int i = 1; i <= numero; i++) {
            System.out.println(i);
        }

    }
}
