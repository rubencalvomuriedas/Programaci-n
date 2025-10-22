import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {

        //Ejercicio 8: Escribe un programa que lee dos números y los visualiza en orden ascendente.

        System.out.println("\nejercicio 08");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar numeros");
        double numero1 = sc.nextDouble();
        System.out.println("numero 1: " + numero1);
        double numero2 = sc.nextDouble();
        System.out.println("numero 2: " + numero2);

        double menor = Math.min(numero1, numero2);
        double mayor = Math.max(numero1, numero2);
        System.out.println("numeros en orden ascendente: " +  menor + " - " + mayor);





    }
}
