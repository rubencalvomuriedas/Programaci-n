public class E11 {
    public static void main(String[] args) {

    /* Ejercicio 11: Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en
    el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores
    del primer array al segundo array en orden inverso, y mostrar ambos por pantalla.
     */
    int [] bucle_1 = new int [100];


    for  (int i = 0; i < bucle_1.length; i++) {
        bucle_1[i] = i + 1;
    }

    int [] bucle_2 = new int [bucle_1.length];

    System.out.println("Numeros de bucle 1: ");
    for(int i = 0; i < bucle_1.length; i++) {
        System.out.print(bucle_1[i] + " ");
        bucle_2[i] = bucle_1[bucle_1.length - 1 - i];
    }


    System.out.println(" ");

    System.out.println("\nNumeros de bucle 2: ");
    for(int i = 0; i < bucle_2.length; i++) {
        System.out.print(bucle_2[i] + " ");
    }
}
}

