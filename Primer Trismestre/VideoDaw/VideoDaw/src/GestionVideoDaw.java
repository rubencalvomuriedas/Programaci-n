import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        GestionVideoDaw videoclub = null;

        int opcion = 0;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Crear videoclub");
            System.out.println("2. Registrar película");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Alquilar película");
            System.out.println("5. Devolver película");
            System.out.println("6. Salir");
            System.out.print("Elige: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                
                case 1:
                    System.out.print("CIF: ");
                    String cif = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dir = sc.nextLine();
                    videoclub = new GestionVideoDaw(cif, dir);
                    break;

                case 2:
                    if (videoclub == null) { System.out.println("Primero crea un videoclub."); break; }
                    System.out.print("Código: ");
                    String cod = sc.nextLine();
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Género (ACCION/COMEDIA/...): ");
                    Genero g = Genero.valueOf(sc.nextLine().toUpperCase());
                    videoclub.registrarPelicula(new Pelicula(cod, tit, g));
                    break;

                case 3:
                    if (videoclub == null) { System.out.println("Primero crea un videoclub."); break; }
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Num socio: ");
                    String ns = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dc = sc.nextLine();
                    System.out.print("Año nacimiento: ");
                    int an = sc.nextInt();
                    System.out.print("Mes: ");
                    int me = sc.nextInt();
                    System.out.print("Día: ");
                    int di = sc.nextInt(); sc.nextLine();
                    LocalDate fn = LocalDate.of(an, me, di);

                    videoclub.registrarCliente(new Cliente(dni, nombre, ns, dc, fn));
                    break;

                case 4:
                    System.out.println("Función de ejemplo, faltaría buscar objetos.");
                    break;

                case 5:
                    System.out.println("Función de ejemplo, faltaría buscar objetos.");
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                    default:
                        System.out.println("Opción no válida.");
                    }
                } while (opcion != 6);

                sc.close();
       

    }
}