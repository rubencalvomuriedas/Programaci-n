import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        //Ejercicio 3: un programa que calcule el área de un cuadrado cuyo lado se introduce por teclado.

                System.out.println("\nEjercicio 03");
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el valor del lado del cuadrado");
        double lado2 = sc.nextDouble();

        double area2 = lado2 * lado2;
        System.out.println("lado = " + lado2);
        System.out.println("area = " + area2);

    }
}
