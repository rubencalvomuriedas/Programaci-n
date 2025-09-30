import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {

        //Ejercicio 4: Escribe un programa que lea dos números, calcule y muestre el valor de sus suma, resta.

        System.out.println("\nejercicio 04");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("ingresar primer numero");
        double numero1 = sc2.nextDouble();
        double numero2 = sc2.nextDouble();

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
