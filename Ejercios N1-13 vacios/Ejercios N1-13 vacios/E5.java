import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        /*
        Ejercicio 5: Escribe un programa que toma como dato de entrada un número que corresponde a la
            longitud de un radio y nos escribe la longitud de la circunferencia, el área del círculo y el
            volumen de la esfera que corresponden con dicho radio.

         */
        System.out.println("\nejercicio 05");
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresar el radio");
        double radio = sc.nextDouble();

        double circulo = 2 * Math.PI * radio;
        System.out.println("el radio es: " + circulo);
        double area = Math.PI * radio * radio;
        System.out.println("el area es: " + area);
        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
        System.out.println("el volumen es: " + volumen);



    }
}