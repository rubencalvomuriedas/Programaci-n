import java.util.Scanner;

public class E1 {
    public static void main (String[] args) {

    /*
    Ejercicio 1: Realiza un programa que dada una cantidad de euros que el usuario introduce por
    teclado (múltiplo de 5 €) mostrará los billetes de cada tipo que serán necesarios para
    alcanzar dicha cantidad (utilizando billetes de 500, 200, 100, 50, 20, 10 y 5). Hay que
    indicar el mínimo de billetes posible. Por ejemplo, si el usuario introduce 145 el
    programa indicará que será necesario 1 billete de 100 €, 2 billetes de 20 € y 1 billete de
    5 € (no será válido por ejemplo 29 billetes de 5, que aunque sume 145 € no es el mínimo
    número de billetes posible).
     */

        Scanner input = new Scanner(System.in);

        int cantidadInsertada;

        do {
            System.out.print("Por favor, ingrese el dinero (Solo se admiten billetes multiplos de 5): ");
            cantidadInsertada = input.nextInt();

            if (cantidadInsertada % 5 != 0) {
                System.out.println("Solo se admiten multiplos de 5");
            }
        }while (cantidadInsertada % 5 != 0) ;

        int billete500 = cantidadInsertada / 500;
        cantidadInsertada %= 500;

        int billete200 = cantidadInsertada / 200;
        cantidadInsertada %= 200;

        int billete100 = cantidadInsertada / 100;
        cantidadInsertada %= 100;

        int billete50 = cantidadInsertada / 50;
        cantidadInsertada %= 50;

        int billete20 = cantidadInsertada / 20;
        cantidadInsertada %= 20;

        int billete10 = cantidadInsertada / 10;
        cantidadInsertada %= 10;

        int billete5 = cantidadInsertada / 5;
        cantidadInsertada %= 5;

        if (billete500 > 0) {
            System.out.println("Billetes500: " + billete500);
        }
        if (billete200 >0) {
            System.out.println("Billetes200: " + billete200);
        }
        if (billete100 >0) {
            System.out.println("Billetes100: " + billete100);
        }
        if (billete50 >0) {
            System.out.println("Billetes50: " + billete50);
        }
        if (billete20 >0) {
            System.out.println("Billetes20: " + billete20);
        }
        if (billete10 >0) {
            System.out.println("Billetes10: " + billete10);
        }
        if (billete5 >0) {
            System.out.println("Billetes5: " + billete5);
        }
    }
}

