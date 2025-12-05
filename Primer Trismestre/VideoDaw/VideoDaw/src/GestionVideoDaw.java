import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VideoDaw videoclub = null;
        int contadorClientes = 1;
        int contadorPeliculas = 1;

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Crear y registrar VideoClub");
            System.out.println("2. Registrar película");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Alquilar película");
            System.out.println("5. Devolver película");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja película");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("CIF: ");
                    String cif = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dir = sc.nextLine();

                    videoclub = new VideoDaw(cif, dir);
                    System.out.println("Videoclub creado.");
                    break;

                case 2:
                    if (videoclub == null) {
                        System.out.println("Crea primero el videoclub.");
                        break;
                    }

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.println("Género:");
                    for (Genero g : Genero.values()) System.out.println("- " + g);

                    Genero genero = Genero.valueOf(sc.nextLine().toUpperCase());
                    String cod = MiUtils.generarCodigo("P", contadorPeliculas++);

                    Pelicula p = new Pelicula(cod, titulo, genero);
                    videoclub.registrarPelicula(p);
                    break;

                case 3:
                    if (videoclub == null) {
                        System.out.println("Crea primero el videoclub.");
                        break;
                    }
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Dirección cliente: ");
                    String d = sc.nextLine();

                    String socio = MiUtils.generarCodigo("S", contadorClientes++);

                    Cliente c = new Cliente(dni, nombre, socio, d, LocalDate.of(2000, 1, 1));
                    videoclub.registrarCliente(c);
                    break;

                case 4:
                    if (videoclub == null) {
                        System.out.println("Crea primero el videoclub.");
                        break;
                    }

                    System.out.print("Código película: ");
                    String cp = sc.nextLine();

                    Pelicula peliA = videoclub.getPeliculas()
                            .stream()
                            .filter(x -> x.getCod().equals(cp)).findFirst().orElse(null);

                    System.out.print("DNI cliente: ");
                    String dc = sc.nextLine();

                    Cliente cliA = videoclub.getClientes()
                            .stream()
                            .filter(x -> x.getDni().equals(dc)).findFirst().orElse(null);

                    if (peliA != null && cliA != null)
                        videoclub.alquilarPelicula(peliA, cliA);
                    else
                        System.out.println("Cliente/película no encontrados.");
                    break;

                case 5:
                    if (videoclub == null) {
                        System.out.println("Crea primero el videoclub.");
                        break;
                    }

                    System.out.print("Código película: ");
                    String dp = sc.nextLine();

                    Pelicula peliD = videoclub.getPeliculas()
                            .stream()
                            .filter(x -> x.getCod().equals(dp)).findFirst().orElse(null);

                    System.out.print("DNI cliente: ");
                    String dcli = sc.nextLine();

                    Cliente cliD = videoclub.getClientes()
                            .stream()
                            .filter(x -> x.getDni().equals(dcli)).findFirst().orElse(null);

                    if (peliD != null && cliD != null)
                        videoclub.devolverPelicula(peliD, cliD);
                    else
                        System.out.println("Cliente/película no encontrados.");
                    break;

                case 6:
                    System.out.print("DNI cliente: ");
                    String dniBC = sc.nextLine();

                    Cliente cliBC = videoclub.getClientes()
                            .stream()
                            .filter(x -> x.getDni().equals(dniBC)).findFirst().orElse(null);

                    if (cliBC != null)
                        videoclub.darDeBajaCliente(cliBC);
                    else
                        System.out.println("Cliente no encontrado.");
                    break;

                case 7:
                    System.out.print("Código película: ");
                    String codBP = sc.nextLine();

                    Pelicula peliBP = videoclub.getPeliculas()
                            .stream()
                            .filter(x -> x.getCod().equals(codBP)).findFirst().orElse(null);

                    if (peliBP != null)
                        videoclub.darDeBajaPelicula(peliBP);
                    else
                        System.out.println("Pelicula no encontrada.");
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
