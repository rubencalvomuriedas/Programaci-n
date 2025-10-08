import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("\n Ejercicio 1");
        Scanner entrada = new Scanner(System.in);
        int edad;
        System.out.println("Ingrese su edad");

        edad = entrada.nextInt();
        if (edad >=18) {
            System.out.println("Eres mayor de edad");
        }

        System.out.println("\n Ejercicio 2");
        Scanner sc = new Scanner(System.in);
        int Edad;
        System.out.println("Ingrese su edad");

        Edad = sc.nextInt();
        if (Edad >=18) {
            System.out.println("Eres mayor de edad");
        } else if ( Edad <=17 && Edad >= 0) {
            System.out.println("Eres menor de edad");
        }
        else{
            System.out.println("La edad no tiene sentido");
        }

        System.out.println("\n Ejercicio 3");
         sc = new Scanner(System.in);
         for (int i = 1; i <= 20; i++) {
             System.out.println("Numero:" + i);
         }

        System.out.println("\n Ejercicio 4");
        sc = new Scanner(System.in);
        for (int i = 0; i <= 200; i +=2) {
            System.out.println("Numero:" + i);
        }

        System.out.println("\n Ejercicio 5");
        sc = new Scanner(System.in);
        for (int i = 2; i <= 200; i++)
            if(1 % 2 == 0){
            System.out.println("Numero:" + i);
        }

        System.out.println("\n Ejercicio 6");
        sc = new Scanner(System.in);
        int max;
        System.out.print("Introduce el numero:");
        max = sc.nextInt();
        for (int i = 1; i <= max; i++) {
            System.out.println("Numero:" + i);
        }


        System.out.println("\n Ejercicio 7");
        sc = new Scanner(System.in);
        int nota;
        System.out.println("Introduce tu calificacion entre el 0 y el 10");
        nota = sc.nextInt();
        if (nota <= 3) {
            System.out.println("Muy deficiente");
        } else if (nota <= 5) {
            System.out.println("Insuficiente");
        } else if (nota <= 6) {
            System.out.println("Bien");
        } else if (nota < 9) {
            System.out.println("Notable");
        } else if (nota <= 10) {
            System.out.println("Sobresaliente");
        }

        System.out.println("\n Ejercicio 8");
        sc = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int N = sc.nextInt();

        if (N < 0) {
            System.out.println("Error: el número debe ser positivo.");
        } else {
            int factorial = 1;

            for (int i = 1; i <= N; i++) {
                factorial *= i;
            }

            System.out.println("El factorial de " + N + " es: " + factorial);

        }

        System.out.println("\n Ejercicio 9");
        sc = new Scanner(System.in);






    }
}