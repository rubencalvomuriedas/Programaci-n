import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {

        //Ejercicio 10: Escribe un programa que lea tres números distintos y nos diga cuál es el mayor.

        System.out.println("\nejercicio 10");
        Scanner sc = new Scanner(System.in);
        System.out.println("Numeros");
        double numero1 = sc.nextDouble();
        System.out.println("numero 1: " + numero1);
        double numero2 = sc.nextDouble();
        System.out.println("numero 2: " + numero2);
        double numero3 = sc.nextDouble();
        System.out.println("numero 3: " + numero3);

        double max = Math.max(Math.max(numero1,numero2), numero3);
        System.out.println("El mayo es: " + max);
    }
}
