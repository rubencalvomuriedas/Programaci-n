import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {

    /* Ejercicio 13: Crea un programa que permita al usuario almacenar una secuencia aritmética en un
    array y luego mostrarla. Una secuencia aritmética es una serie de números que
    comienza por un valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1
    e I=2, la secuencia sería 1, 3, 5, 7, 9… Con V=7 e I=10, la secuencia sería 7, 17, 27, 37… El
    programa solicitará al usuario V, I además de N (nº de valores a crear).
     */
    Scanner sc = new Scanner(System.in);
    System.out.println("introduce el valor Inicial V: ");
    int vInicial = sc.nextInt();
    System.out.println("introduce el incremento I: ");
    int iInicial = sc.nextInt();
    System.out.println("Introduce la cantidad de valores que se desean obtener: ");
    int cantidadN = sc.nextInt();

    int[] valores = new int[cantidadN];
    valores [0] = vInicial;
    for(int i = 1;
    valores[i] =

    }
}
