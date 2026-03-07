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

                    System.out.println("Introduzca el CIF del videoclub:(Ej:73287389L)");
                    String cif = sc.nextLine();

                    System.out.println("Introduzca la dirección del videoclub:(Ej:Calle lealtad)");
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

                        Gestion.registrarPelicula(sc, videoClub);

                    } else if (tipo.equals("2")) {

                        Gestion.registrarVideojuego(sc, videoClub);

                    } else {

                        System.out.println("Opción inválida");

                    }

                    break;

                case "3":

                    if (videoClub == null) {
                        System.out.println("Primero debe crear el videoclub.");
                        break;
                    }

                    Gestion.crearRegistrarCliente(sc, videoClub);

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
}


