public class E13 {
    public static void main(String[] args) {

    /* Ejercicio 13: . Realiza un programa que calcule y escriba la suma y el producto de los 10 primeros
    números naturales
     */
        int sumar = 0;
        int multiplicar = 1;
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            sumar = sumar + i;
            multiplicar = multiplicar *1;
        }

        System.out.println("La suma de los 10 primeros numeros naturales es "+ sumar);
        System.out.println("La multiplicacion de los 10 primeros numeros naturales es "+ multiplicar);
    }
}
