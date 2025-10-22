public class E5 {
    public static void main(String[] args) {

        /*
        Ejercicio 5: Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
        Esta vez utiliza un contador sumando de 1 en 1:
         */
        System.out.println("Numero pares del 1 al 200:" );
        for (int i = 1; i <= 200; i++) {
            if( i % 2 ==0 ) {
                System.out.println("Numero " + i);
            }
        }

    }
}
