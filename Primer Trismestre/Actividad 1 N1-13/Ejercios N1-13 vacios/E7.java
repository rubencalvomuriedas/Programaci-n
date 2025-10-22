import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {

        /*
        Ejercicio 7: Escribe un programa que lea un valor correspondiente a una distancia en millas marinas
        y escriba la distancia en metros. Sabiendo que una milla marina equivale a 1.852 metros.

         */
        System.out.println("\nejercicio 07");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar millas marinas");
        double millas = sc.nextDouble();
        System.out.println("millas son: " + millas);

        double metros = millas * 1852.0;
        System.out.println("metros son: " + metros);


    }
}
