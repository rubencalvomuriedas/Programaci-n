import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {

        /*
        Ejercicio 11: Escribe un programa que lee dos números, calcula y muestra el valor de su suma, resta,
        producto y división.

         */

        System.out.println("\nejercicio 04");
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresar primer numero (no puedo ser 0) ");
        double numero1 = sc.nextDouble();
        double numero2 = sc.nextDouble();

        double suma = numero1 + numero2;
        double resta = numero1 - numero2;
        double multiplicacion = numero1 * numero2;
        double division = numero1 / numero2;

        System.out.println("suma: = " + suma);
        System.out.println("resta: = " + resta);
        System.out.println("multiplicacion: = " + multiplicacion);
        System.out.println("division: = " + division);
    }
}
