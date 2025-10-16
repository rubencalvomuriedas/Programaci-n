import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

    /*Ejercicio 1: Crea un programa que pida diez números reales por teclado, los almacene en un array,
    y luego muestre todos sus valores

     */
        Scanner sc = new Scanner(System.in);
        double valores [] = new double [10];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }

        System.out.println("Los numeros que hay en el array son: ");
        for (int i = 0; i < valores.length; i++){
            System.out.print(valores[i]+" ");
        }


    }
}

