import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
    /* Ejercicio 3:Crea un programa que pida diez números reales por teclado, los almacene en un array,
    y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
     */
        Scanner sc = new Scanner(System.in);

        double valores [] = new double [10];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }


        double maximo = valores[0];
        double minimo = valores[0];


        for (int i = 1; i < valores.length; i++){
            if  (valores[i] > maximo){
                maximo = valores[i];
            }
            if  (valores[i] < minimo){
                minimo = valores[i];
            }
        }

        System.out.println("\nEl numero maximo es:  " + maximo);
        System.out.println("El numero minimo es:  " + minimo);

    }
}