import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String menu = "\n1. Crear y registrar VideoDaw.\n" +
                    "2. Registrar artículo en VideoDaw.\n" +
                    "3. Crear y registrar cliente en VideoDaw.\n" +
                    "4. Alquilar artículo.\n" +
                    "5. Devolver artículo.\n" +
                    "6. Dar de baja cliente.\n" +
                    "7. Mostrar artículos.\n" +
                    "8. Mostrar clientes.\n" +
                    "9. Salir.";

            String opcion;

            VideoDaw videoClub = VideoDaw.cargarDatos();

            System.out.println("Bienvenido a VideoDaw");

            do {

                System.out.println(menu);
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextLine();

                switch (opcion) {

                    case "1":

                        String cif = obtenerCIFValido();

                        System.out.println("Introduzca la dirección del videoclub:");
                        String direccion = sc.nextLine();

                        videoClub = new VideoDaw(cif, direccion);

                        System.out.println("VideoClub creado correctamente");

                        break;

                    case "2":

                        if (videoClub == null) {
                            System.out.println("Primero debe crear el videoclub.");
                            break;
                        }

                        System.out.println("\n¿Qué desea registrar?");
                        System.out.println("1. Película");
                        System.out.println("2. Videojuego");

                        String tipo = sc.nextLine();

                        if (tipo.equals("1")) {

                            registrarPelicula(sc, videoClub);

                        } else if (tipo.equals("2")) {

                            registrarVideojuego(sc, videoClub);

                        } else {

                            System.out.println("Opción inválida");

                        }

                        break;

                    case "3":

                        if (videoClub == null) {
                            System.out.println("Primero debe crear el videoclub.");
                            break;
                        }

                        crearRegistrarCliente(sc, videoClub);

                        break;

                    case "4":

                        if (videoClub == null) {
                            System.out.println("Primero debe crear el videoclub.");
                            break;
                        }

                        System.out.println("Introduzca número de socio:");
                        String socio = sc.nextLine().toUpperCase();

                        System.out.println("Introduzca código del artículo:");
                        String cod = sc.nextLine().toUpperCase();

                        videoClub.alquilar(cod, socio);

                        System.out.println("Alquiler realizado");

                        break;

                    case "5":

                        if (videoClub == null) {
                            System.out.println("Primero debe crear el videoclub.");
                            break;
                        }

                        System.out.println("Introduzca número de socio:");
                        socio = sc.nextLine().toUpperCase();

                        System.out.println("Introduzca código del artículo:");
                        cod = sc.nextLine().toUpperCase();

                        try {

                            videoClub.devolver(cod, socio);
                            System.out.println("Artículo devuelto correctamente");

                        } catch (TiempoAlquilerExcedidoException e) {

                            System.out.println(e.getMessage());

                        }

                        break;

                    case "6":

                        if (videoClub == null) {
                            System.out.println("Primero debe crear el videoclub.");
                            break;
                        }

                        System.out.println("Introduzca número de socio:");
                        socio = sc.nextLine().toUpperCase();

                        Cliente c = videoClub.buscarCliente(socio);

                        if (c != null) {

                            videoClub.darBajaCliente(c);
                            System.out.println("Cliente dado de baja");

                        } else {

                            System.out.println("Cliente no encontrado");

                        }

                        break;

                    case "7":

                        if (videoClub != null)
                            videoClub.mostrarArticulosRegistrados();

                        break;

                    case "8":

                        if (videoClub != null)
                            videoClub.mostrarClientesRegistrados();

                        break;

                    case "9":

                        if (videoClub != null) {
                            videoClub.guardarDatos();
                        }

                        System.out.println("Saliendo del sistema");

                        break;

                    default:

                        System.out.println("Opción inválida");

                }

            } while (!opcion.equals("9"));

        }

        private static void registrarPelicula(Scanner sc, VideoDaw vd) {

            String cod = vd.generarCodigoPelicula();
            System.out.println("Código generado automáticamente: " + cod);

            System.out.println("Introduzca el título:");
            String titulo = sc.nextLine();

            GeneroPelicula genero;

            int opcion;

            do {

                System.out.println("Seleccione género:");

                for (GeneroPelicula g : GeneroPelicula.values()) {
                    System.out.println((g.ordinal() + 1) + ". " + g);
                }

                opcion = Integer.parseInt(sc.nextLine());

            } while (opcion < 1 || opcion > GeneroPelicula.values().length);

            genero = GeneroPelicula.values()[opcion - 1];

            Pelicula p = new Pelicula(cod, titulo, genero);

            vd.registrarArticulo(p);

            System.out.println("Película registrada correctamente");

        }

        private static void registrarVideojuego(Scanner sc, VideoDaw vd) {

            String cod = vd.generarCodigoVideojuego();
            System.out.println("Código generado automáticamente: " + cod);

            System.out.println("Introduzca el título:");
            String titulo = sc.nextLine();

            GeneroVideojuego genero;

            int opcion;

            do {

                System.out.println("Seleccione género:");

                for (GeneroVideojuego g : GeneroVideojuego.values()) {
                    System.out.println((g.ordinal() + 1) + ". " + g);
                }

                opcion = Integer.parseInt(sc.nextLine());

            } while (opcion < 1 || opcion > GeneroVideojuego.values().length);

            genero = GeneroVideojuego.values()[opcion - 1];

            Videojuego v = new Videojuego(cod, titulo, genero);

            vd.registrarArticulo(v);

            System.out.println("Videojuego registrado correctamente");

        }

        private static void crearRegistrarCliente(Scanner sc, VideoDaw vd) {

            String dni = obtenerDNIValido();

            System.out.println("Introduzca nombre:");
            String nombre = sc.nextLine();

            System.out.println("Introduzca dirección:");
            String direccion = sc.nextLine();

            LocalDate fechaNacimiento;

            while (true) {

                fechaNacimiento = obtenerFechaValida();

                if (esMayorDeEdad(fechaNacimiento))
                    break;

                System.out.println("El cliente debe ser mayor de edad");

            }

            System.out.println("Introduzca número de socio (Ej: S-0001):");
            String numSocio = sc.nextLine().toUpperCase();

            Cliente c = new Cliente(dni, nombre, direccion, fechaNacimiento, numSocio);

            try {

                vd.registrarCliente(c);

                System.out.println("Cliente registrado correctamente");

            } catch (ClienteDuplicadoException e) {

                System.out.println(e.getMessage());

            }

        }

        private static String obtenerCIFValido() {

            Scanner sc = new Scanner(System.in);

            String cif;

            while (true) {

                System.out.println("Introduzca CIF (Ej: A1234567J):");

                cif = sc.nextLine().toUpperCase();

                if (cif.matches("^[A-HJNP-S]\\d{7}[0-9A-J]$"))
                    return cif;

                System.out.println("CIF inválido");

            }

        }

        private static String obtenerDNIValido() {

            Scanner sc = new Scanner(System.in);

            String dni;

            while (true) {

                System.out.println("Introduzca DNI (Ej: 12345678A):");

                dni = sc.nextLine().toUpperCase();

                if (dni.matches("^\\d{8}[A-Za-z]$"))
                    return dni;

                System.out.println("DNI inválido");

            }

        }

        private static LocalDate obtenerFechaValida() {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("Introduzca fecha de nacimiento (dd-MM-yyyy):");

                String fecha = sc.nextLine();

                if (fecha.matches("^\\d{2}-\\d{2}-\\d{4}$")) {

                    String[] p = fecha.split("-");

                    int dia = Integer.parseInt(p[0]);
                    int mes = Integer.parseInt(p[1]);
                    int año = Integer.parseInt(p[2]);

                    return LocalDate.of(año, mes, dia);

                }

                System.out.println("Fecha inválida");

            }

        }

        private static boolean esMayorDeEdad(LocalDate fechaNacimiento) {

            return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;

        }

    }

        private static String obtenerCIFValido() {

            Scanner sc = new Scanner(System.in);

            String cif;

            while (true) {

                System.out.println("Introduzca CIF (Ej: A1234567J):");

                cif = sc.nextLine().toUpperCase();

                if (cif.matches("^[A-HJNP-S]\\d{7}[0-9A-J]$"))
                    return cif;

                System.out.println("CIF inválido");

            }

        }

        private static String obtenerDNIValido() {

            Scanner sc = new Scanner(System.in);

            String dni;

            while (true) {

                System.out.println("Introduzca DNI (Ej: 12345678A):");

                dni = sc.nextLine().toUpperCase();

                if (dni.matches("^\\d{8}[A-Za-z]$"))
                    return dni;

                System.out.println("DNI inválido");

            }

        }

        private static LocalDate obtenerFechaValida() {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("Introduzca fecha de nacimiento (dd-MM-yyyy):");

                String fecha = sc.nextLine();

                if (fecha.matches("^\\d{2}-\\d{2}-\\d{4}$")) {

                    String[] p = fecha.split("-");

                    int dia = Integer.parseInt(p[0]);
                    int mes = Integer.parseInt(p[1]);
                    int año = Integer.parseInt(p[2]);

                    return LocalDate.of(año, mes, dia);

                }

                System.out.println("Fecha inválida");

            }

        }

        private static boolean esMayorDeEdad(LocalDate fechaNacimiento) {

            return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;

        }
    }
}


