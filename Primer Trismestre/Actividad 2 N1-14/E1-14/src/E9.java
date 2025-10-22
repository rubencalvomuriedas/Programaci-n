import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {

        /*
        Ejercicio 9: Escribe un programa que recibe como datos de entrada una hora expresada en horas,
        minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
        transcurrido un segundo
         */

        Scanner sc = new Scanner(System.in);
        int horas;
        int minutos;
        int segundos;

        System.out.println("Ingrese la hora actual : ");
        horas = sc.nextInt();

        System.out.println("Ingrese los minutos : ");
        minutos = sc.nextInt();

        System.out.println("Ingrese los segundos : ");
        segundos = sc.nextInt();

        segundos++;

        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }

        if (minutos == 60) {
            minutos = 0;
            horas++;
        }

        if (horas == 24) {
            horas = 0;
        }

        System.out.printf("La hora actual es: " + horas +":"+ minutos+ ":" + segundos);
    }
}
