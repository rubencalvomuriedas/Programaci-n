import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {

        /*
        Ejercicio 9: Escribe un programa que recibe como datos de entrada una hora expresada en horas,
        minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
        transcurrido un segundo
         */

        Scanner sc = new Scanner(System.in);

        int hora;
        int minutos;
        int segundos;

        System.out.println("Ingrese la hor actual (1-24): ");
        hora = sc.nextInt();

        System.out.println("Ingrese los minutos actuales (1-60): ");
        minutos = sc.nextInt();

        System.out.println("Ingrese los segundos (1-60): ");
        segundos = sc.nextInt();

        segundos++;

        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }

        if (minutos == 60) {
            minutos = 0;
            hora++;
        }

        if (hora == 60) {
            hora = 0;
        }

        System.out.printf("La nueva hora es: " + hora +":"+ minutos+ ":" + segundos);
    }
}
