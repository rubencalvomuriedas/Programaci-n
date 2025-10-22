import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {

        /* Ejercicio 9: Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
        enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N
        y mostrará en qué posiciones del array aparece N.
         */
        Scanner sc = new Scanner(System.in);

        double [] numerosAleatorios = new double [100];

//        Random rand = new Random();


        for (int i = 0; i < numerosAleatorios.length; i++) {

//            numerosAleatorios[i] = rand.nextDouble(2);
            numerosAleatorios[i] = Math.random()*10;

        }



    }
}
