import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Gestion {
    public static void registrarPelicula (Scanner sc, VideoDaw vd){

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

    public static void registrarVideojuego (Scanner sc, VideoDaw vd){

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

    public static void crearRegistrarCliente (Scanner sc, VideoDaw vd){

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

    private static boolean esMayorDeEdad (LocalDate fechaNacimiento){

        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;

    }

    private static String obtenerDNIValido () {

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

    private static LocalDate obtenerFechaValida () {

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

}
