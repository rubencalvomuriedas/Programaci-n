import java.util.Scanner;

public class PruebaExcepciones {
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("El número no es positivo");
        }
        System.out.println("Positivo: " + p);
    }
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("El número no es negativo");
        }
        System.out.println("Negativo: " + n);
    }
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            for (int i = 0; i < 5; i++) {
                System.out.print("Introduce un número entero: ");
                int num = sc.nextInt();

                try {
                    imprimePositivo(num);
                    imprimeNegativo(num);
                } catch (Exception e) {
                    System.out.println("Excepción capturada: " + e.getMessage());
                }

                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error en la entrada de datos.");
        }
    }
}
