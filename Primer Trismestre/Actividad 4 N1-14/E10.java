import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {

        /* Ejercicio 10: Crea un programa para realizar cálculos relacionados con la altura (en metros) de
        personas. Pedirá un valor N y luego almacenará en un array N alturas introducidas por
        teclado. Luego mostrará la altura media, máxima y mínima, así como cuántas personas
        miden por encima y por debajo de la media.

         */
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantas personas hay? ");
        int longitud = sc.nextInt();

        double [] altura = new double [longitud];

        for (int i = 0; i < altura.length; i++) {
            System.out.print("Ingresa el altura de la persona en metros "+(i+1)+": ");
            altura[i] = sc.nextDouble();
        }
        double suma = 0;
        double media = 0;
        double maximo = altura[0];
        double minimo = altura[0];

        System.out.print("\nLos numeros que hay en el array son: ");
        for (int i = 0; i < altura.length; i++){
            System.out.print(altura[i]+" ");
        }

        for  (int i = 0; i < altura.length; i++){
            suma  += altura[i];
            media =  suma / altura.length;

            if (altura[i] > maximo){
                maximo = altura[i];
            }
            if (altura[i] < minimo){
                minimo = altura[i];
            }
        }
        System.out.println("\n");
        System.out.println("\nLa media de los numeros es: " + media);
        System.out.println("El maximo de los numeros es: " + maximo);
        System.out.println("El minimo de los numeros es: " + minimo);

    }
}
