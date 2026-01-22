import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce un valor entero: ");
            int A = sc.nextInt();
            System.out.println("Valor introducido: " + A);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto");
            e.printStackTrace();
        }

        sc.close();
    }
}
