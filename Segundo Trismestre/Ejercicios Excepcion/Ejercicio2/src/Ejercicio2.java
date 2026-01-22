import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce el valor A: ");
            int A = sc.nextInt();

            System.out.print("Introduce el valor B: ");
            int B = sc.nextInt();

            int resultado = A / B;
            System.out.println("Resultado de A/B: " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Error: valor introducido incorrecto");
            e.printStackTrace();

        } catch (ArithmeticException e) {
            System.out.println("Error: división entre cero");
            e.printStackTrace();
        }

        sc.close();
    }
}
