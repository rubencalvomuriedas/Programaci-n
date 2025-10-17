import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
    /* Ejercicio 3:Crea un programa que pida veinte números enteros por teclado, los almacene en un
    array y luego muestre por separado la suma de todos los valores positivos y negativos.
     */
        Scanner sc = new Scanner(System.in);

        double valores [] = new double [20];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }
        double sumaPositivos = 0;
        double sumaNegativos = 0;

        for (int i = 1; i < valores.length; i++){
            if (valores[i] > 0) {
                sumaPositivos += valores[i];
            } else if (valores[i] < 0) {
                sumaNegativos += valores[i];
            }
        }
        System.out.println("La suma de los positivos: "+sumaPositivos);
        System.out.println("La suma de los negativos es: "+sumaNegativos);

    }
}


