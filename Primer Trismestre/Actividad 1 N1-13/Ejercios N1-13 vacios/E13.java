import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {

        /*
        Ejercicio 13: Escribe un programa que lee un número y me dice si es positivo o negativo
        consideraremos el cero como positivo.

         */
        System.out.println("\nejercicio 04");
        Scanner sc = new Scanner(System.in);
        double numero1 = sc.nextDouble();
        System.out.println("¿El numero es positivo?" +(numero1 >= 0));
    }
}
