import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

    /*
    Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25
    y luego muestre la matriz por pantalla.

     */
        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[5][5];
        int contador = 1;


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = contador++;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}