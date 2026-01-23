import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    double [] vector = new double[5];
    int i = 0;

        try (Scanner sc = new Scanner(System.in)) {

            while (i < vector.length) {
                try {
                    System.out.println("Introducir valor" + i + ": ");
                    vector[i] = sc.nextDouble();
                    i++;
                } catch (InputMismatchException e) {
                    System.out.println("Error: introduce un numero valido");
                    sc.next();
                }

            }
        }
        System.out.println("\n Vector correcto: ");
        for ( double num : vector) {
            System.out.println(num);
        }
    }
}