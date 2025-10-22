import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {

        /* Ejercicio 8: Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
        utilizando Math.random(), y luego le pida al usuario un valor real R. Por último, mostrará
        cuántos valores del array son igual o superiores a R
         */
        Scanner sc = new Scanner(System.in);

        double [] numerosAleatorios = new double [100];

//       Random rand = new Random();


        for (int i = 0; i < numerosAleatorios.length; i++) {

//          numerosAleatorios[i] = rand.nextDouble(2);
            numerosAleatorios[i] = Math.random();

        }

        System.out.println("Los numeros almacenados en el array son: ");
        for (double num : numerosAleatorios) {
            System.out.println(num);
        }

        double r;
        double numerosSuperior = 0;

        System.out.println("\nIntroduzca el valor R (Entre 0 a 1): ");
        r = sc.nextDouble();

        System.out.println("\nNumeros mayores a R: ");
        boolean encontrado = false;
        for (double num : numerosAleatorios) {
            if (num > r) {
                System.out.println(num);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron numeros mayores a R");
        }
    }
}

