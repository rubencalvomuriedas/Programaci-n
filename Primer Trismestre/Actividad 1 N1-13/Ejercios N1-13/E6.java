import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {

        /*
        Ejercicio 6: Escribe un programa que dado el precio de un artículo y el precio de venta real nos
        muestre el porcentaje de descuento realizado.

         */
        System.out.println("\nejercicio 06");
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresar el precio del articulo");
        double precioV = sc.nextDouble();
        System.out.println("el precio del articulo es: " + precioV);
        double precioR = sc.nextDouble();
        System.out.println("el precio real es: " + precioR);

        double porcentaje = ((precioV - precioR) / precioV) *100.0;
        System.out.println("porcentaje es: " + porcentaje + " % ");


    }
}
