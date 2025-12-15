import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Crear equipo");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Fecha de creacion: ");
        System.out.println("año creacion");
        int año = sc.nextInt();
        System.out.println("Mes creacion");
        int mes = sc.nextInt();
        System.out.println("dia creacion");
        int dia = sc.nextInt();

        int opcion;

        do {
            System.out.println("1. Registrar Ninja en el equipo. \n" +
                    "2. Mostrar el número de ninjas totales en la Aldea. \n" +
                    "3. Mostrar información de un equipo. \n" +
                    "4. Mostrar información de todos los equipos. \n" +
                    "5. Mostrar información de toda la Aldea. \n" +
                    "6. Calcular estadísticas de toda la Aldea. \n" +
                    "7. Cambiar ninja de un equipo. \n" +
                    "8. Eliminar ninja de la aldea. \n" +
                    "9. Salir de la aplicación. \n");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("nombre:");
                    String nom = sc.nextLine();
                    System.out.println("Codigo Ninja: ");
                    String cod = sc.nextLine();
                    System.out.println("Ninja creado");
                    break;

                case 2:
                    System.out.println("Numero de Ninja totales");
                    String tot = sc.nextLine();

                    break;
                case 3:
                    System.out.println("Mostrar informacion de un equipo");
                    String inf1 = sc.nextLine();

                    break;
                case 4:
                    System.out.println("Mostrar informacion de todos los equipos");
                    String infT = sc.nextLine();

                    break;
                case 5:
                    System.out.println("Mostrar informacion de toda la aladea");

                    break;
                case 6:
                    System.out.println("Calcular estadisticas de toda la aldea");

                    break;
                case 7:
                    System.out.println("Cambiar ninja de equipo");

                    break;
                case 8:
                    System.out.println("Eliminar ninja");

                    break;

                case 9:
                    System.out.println("Cerrando...");
                    break;

            }
        }
        while(opcion!=10);
            sc.close();
    }
}