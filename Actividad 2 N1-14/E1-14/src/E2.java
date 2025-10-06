import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {

        /*
        Ejercicio 2: Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “eres
        //mayor de edad” o el mensaje de “eres menor de edad”

         */
        Scanner input = new Scanner(System.in);

        int edad;


        System.out.println("Por favor ingrese su edad actual: ");
        edad = input.nextInt();

        if  (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else if (edad < 18) {
            System.out.println("Eres menor de edad");
        }



    }
}
