import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {

        //Ejercicio 9: Escribe un programa que lee dos números y nos dice cuál es el mayor o si son iguales.

        System.out.println("\nejercicio 09");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar numeros");
        double numero1 = sc.nextDouble();
        System.out.println("numero 1: " + numero1);
        double numero2 = sc.nextDouble();
        System.out.println("numero 2: " + numero2);

        System.out.println("mayor: " + Math.max(numero1, numero2));
        System.out.println("iguales = " + (numero1 == numero2));





    }
}
