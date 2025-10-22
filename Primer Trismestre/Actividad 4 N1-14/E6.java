import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
    /* Ejercicio 3:Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño
    N, escriba M en todas sus posiciones y lo muestre por pantalla.
     */
        Scanner sc = new Scanner(System.in);

        double valores []  = new double [20];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Introduce el valor: "+ (i+1)+": ");
            valores[i] = sc.nextDouble();
        }

        double suma = 0;
        double media = 0;

        for (int i = 0; i < valores.length; i++){
            suma += valores[i];
            media =  suma / valores.length;
        }

        System.out.println("La suma de los numeros es: " + suma);
        System.out.println("La media de los numeros es: " + media);
    }
}

