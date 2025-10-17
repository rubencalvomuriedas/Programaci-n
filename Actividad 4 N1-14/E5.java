import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
    /* Ejercicio 5:Crea un programa que pida veinte números reales por teclado, los almacene en un array
    y luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores.
     */

        Scanner sc = new Scanner(System.in);

        double valores [] = new double [20];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }
    }
}

