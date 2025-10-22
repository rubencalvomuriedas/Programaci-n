import java.util.Scanner;

public class E12 {
    public static void main(String[] args) {

        //Ejercicio 12: Escribe un programa que lee 2 números y muestra el mayor.

        System.out.println("\nejercicio 08");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar numeros");
        double numero1 = sc.nextDouble();
        System.out.println("numero 1: " + numero1);
        double numero2 = sc.nextDouble();
        System.out.println("numero 2: " + numero2);


        System.out.println("El mayor es: " + " - " + Math.max(numero1,numero2));

    }
}
