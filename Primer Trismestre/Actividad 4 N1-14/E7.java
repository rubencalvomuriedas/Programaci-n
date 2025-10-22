import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {

        /* Ejercicio 7: Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga
         todos los valores desde P hasta Q, y lo muestre por pantalla.
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el valor de N (longitud del array): ");
        int n = sc.nextInt();
        System.out.println("Introduce el valor de M (valor que rellena el array): ");
        int m = sc.nextInt();

        int [] valores = new int[n];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = m;
        }
        System.out.println("El array con el valor M en todas sus posiciones es: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}

