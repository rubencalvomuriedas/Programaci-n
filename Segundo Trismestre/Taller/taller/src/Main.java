import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Taller taller = new Taller();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMENÚ");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        taller.anadeElemento();
                        break;
                    case 2:
                        taller.eliminaElemento();
                        break;
                    case 3:
                        System.out.println("\nSaliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Formato incorrecto. Introduce un número.");
                sc.nextLine();
            }

        } while (opcion != 3);


        taller.visualizaMatriculas();
        taller.visualizaCoches();
        taller.visualizaTaller();
    }
}
