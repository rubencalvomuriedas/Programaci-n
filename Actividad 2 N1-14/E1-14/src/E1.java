import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        /*
        Ejercicio 1: Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “Eres
        mayor de edad” solo si lo somos.

         */
        Scanner sc = new Scanner (System.in);

        int edad;


        System.out.println("Por favor ingrese su edad actual: ");
        edad = sc.nextInt();

        if  (edad >= 18) {
            System.out.println("Eres mayor de edad");

        }

    }
}