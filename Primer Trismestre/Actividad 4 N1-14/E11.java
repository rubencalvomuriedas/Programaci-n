public class E11 {
    public static void main(String[] args) {

    /* Ejercicio 11: Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en
    el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores
    del primer array al segundo array en orden inverso, y mostrar ambos por pantalla.
     */
    int [] array1 = new int [100];
    int [] array2 = new int [100];

    for  (int i = 0; i < array1.length; i++) {
        array1[i] = i + 1;
    }

    int [] bucle_2 = new int [array1.length];

    System.out.println("Numeros de array 1: ");
    for(int i = 0; i < array1.length; i++) {
        System.out.print(array1[i] + " ");
        array2[i] = array1[array1.length - 1 - i];
    }


    System.out.println(" ");

    System.out.println("\nNumeros de array 2: ");
    for(int i = 0; i < array2.length; i++) {
        System.out.print(array2[i] + " ");
    }
}
}

