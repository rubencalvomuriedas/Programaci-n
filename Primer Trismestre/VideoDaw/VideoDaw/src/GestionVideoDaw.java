import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VideoDaw videoclub = null;

        int opcion = 0;
        int contadorPeliculas = 1;
        int contadorClientes = 1;

        while (opcion != 8) {

            System.out.println("\n--- MENÚ VIDEO DAW ---");
            System.out.println("1. Crear videoclub");
            System.out.println("2. Registrar película");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Alquilar película");
            System.out.println("5. Devolver película");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja película");
            System.out.println("8. Salir");
            System.out.print("Elige opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Introduce CIF: ");
                    String cif = sc.nextLine();
                    while (!MiUtils.validarCIF(cif)) {
                        System.out.print("CIF inválido. Intenta de nuevo: ");
                        cif = sc.nextLine();
                    }
                    System.out.print("Introduce dirección: ");
                    String dir = sc.nextLine();
                    videoclub = new VideoDaw(cif, dir);
                    System.out.println("Videoclub creado correctamente.");
                    break;

                case 2:
                    if (videoclub == null) {
                        System.out.println("Primero debes crear un videoclub.");
                        break;
                    }

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Género (ACCION, COMEDIA...): ");
                    Enums.Genero gen = Enums.Genero.valueOf(sc.nextLine().toUpperCase());

                    String codPel = MiUtils.generarCodigo("P", contadorPeliculas++);
                    Pelicula nueva = new Pelicula(codPel, titulo, gen);

                    videoclub.registrarPelicula(nueva);
                    System.out.println("Película registrada con éxito.");
                    break;

                case 3:
                    if (videoclub == null) {
                        System.out.println("Crea un videoclub primero.");
                        break;
                    }

                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    while (!MiUtils.validarDNI(dni)) {
                        System.out.print("DNI incorrecto. Introduce otro: ");
                        dni = sc.nextLine();
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Dirección: ");
                    String dcli = sc.nextLine();

                    System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                    LocalDate feNac = LocalDate.parse(sc.nextLine());
                    while (!MiUtils.esMayorEdad(feNac)) {
                        System.out.print("Debe ser mayor de edad. Nueva fecha: ");
                        feNac = LocalDate.parse(sc.nextLine());
                    }

                    String numSoc = MiUtils.generarCodigo("S", contadorClientes++);
                    Cliente cli = new Cliente(dni, nombre, numSoc, dcli, feNac);

                    videoclub.registrarCliente(cli);
                    System.out.println("Cliente registrado.");
                    break;

                case 4:
                    if (videoclub == null) break;

                    System.out.println("Selecciona cliente:");
                    Cliente clienteA = seleccionarCliente(videoclub, sc);
                    if (clienteA == null) break;

                    System.out.println("Selecciona película:");
                    Pelicula peliculaA = seleccionarPelicula(videoclub, sc);
                    if (peliculaA == null) break;

                    videoclub.alquilarPelicula(peliculaA, clienteA);
                    System.out.println("Película alquilada.");
                    break;

                case 5:
                    if (videoclub == null) break;

                    System.out.println("Selecciona cliente:");
                    Cliente clienteB = seleccionarCliente(videoclub, sc);
                    if (clienteB == null) break;

                    System.out.println("Selecciona película:");
                    Pelicula peliculaB = seleccionarPelicula(videoclub, sc);
                    if (peliculaB == null) break;

                    videoclub.devolverPelicula(peliculaB, clienteB);
                    System.out.println("Película devuelta.");
                    break;

                case 6:
                    if (videoclub == null) break;

                    System.out.println("Selecciona cliente para dar de baja:");
                    Cliente clienteC = seleccionarCliente(videoclub, sc);
                    if (clienteC == null) break;

                    videoclub.darBajaCliente(clienteC);
                    System.out.println("Cliente dado de baja.");
                    break;

                case 7:
                    if (videoclub == null) break;

                    System.out.println("Selecciona película para dar de baja:");
                    Pelicula peliculaC = seleccionarPelicula(videoclub, sc);
                    if (peliculaC == null) break;

                    videoclub.darBajaPelicula(peliculaC);
                    System.out.println("Película dada de baja.");
                    break;

                case 8:
                    System.out.println("Gracias por usar VideoDAW. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        }

        sc.close();
    }

    public static Cliente seleccionarCliente(VideoDaw v, Scanner sc) {
        Cliente[] lista = v.getClientes();

        int num = 1;
        for (Cliente c : lista) {
            if (c != null) {
                System.out.println(num + ". " + c.getNombre() + " (" + c.getDni() + ")");
            }
            num++;
        }

        System.out.print("Elige número: ");
        int eleccion = Integer.parseInt(sc.nextLine());

        if (eleccion < 1 || eleccion >= num) return null;

        int pos = 0;
        for (Cliente c : lista) {
            if (c != null) {
                if (eleccion == 1) return c;
                eleccion--;
            }
        }
        return null;
    }

    public static Pelicula seleccionarPelicula(VideoDaw v, Scanner sc) {
        Pelicula[] lista = v.getPeliculas();

        int num = 1;
        for (Pelicula p : lista) {
            if (p != null) {
                System.out.println(num + ". " + p.getTitulo());
            }
            num++;
        }

        System.out.print("Elige número: ");
        int eleccion = Integer.parseInt(sc.nextLine());

        if (eleccion < 1 || eleccion >= num) return null;

        for (Pelicula p : lista) {
            if (p != null) {
                if (eleccion == 1) return p;
                eleccion--;
            }
        }
        return null;
    }
}