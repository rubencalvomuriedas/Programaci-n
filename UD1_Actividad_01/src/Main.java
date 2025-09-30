import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ejercicio 1

        System.out.println("Buenos dias futuros programadores");

        /*
        Ejercicio 2: Escribe un programa que calcule y muestre el área de un cudrado igual a 5.
        */
        System.out.println("ejercicio 02");
        double lado = 5;
        double area = lado * lado;
        System.out.println("lado: " + lado);
        System.out.println("area: " + area);

        /*
        Ejercicio 3: un programa que calcule el área de un cuadrado cuyo lado se introduce por teclado.

        */
        System.out.println("\nEjercicio 03");
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el valor del lado del cuadrado");
        double lado2 = sc.nextDouble();

        double area2 = lado2 * lado2;
        System.out.println("lado = " + lado2);
        System.out.println("area = " + area2);
        /*

        Ejercicio 4: Escribe un programa que lea dos números, calcule y muestre el valor de sus suma, resta,
        producto y división.

        */
        System.out.println("\nejercicio 04");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("ingresar primer numero");
        double numero1 = sc.nextDouble();
        System.out.println("ingresar segundo numero");
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