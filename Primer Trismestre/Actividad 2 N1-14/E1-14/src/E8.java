import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {

        //Ejercicio 8: Realiza un programa que lea un número positivo N y calcule y visualice su factorial N!

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Ingrese numero positivo: ");
        n = sc.nextInt();
        if (n < 0) {
            System.out.println("Error: el número debe ser positivo.");
        } else {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
            System.out.println("El factorial es: " + factorial);
        }
    }
}