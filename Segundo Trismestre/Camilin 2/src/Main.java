import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion gestion = new Gestion();

        gestion.cargarDatos();

        String menu = "\n1. Añadir vehiculo.\n" +
                "2. Lista de flota.\n" +
                "3. Realizar alquiler.\n" +
                "4. Devolver vehiculo.\n" +
                "5. Eliminar vehiculo.\n" +
                "6. Generar reporte de ganancias. \n" +
                "7. Guardar y salir. ";

        String opcion = "";

        do{
                sc = new Scanner(System.in);
                System.out.println(menu);
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextLine();


            switch (opcion) {

                case "1":
                    System.out.println("ID:");
                    String id = sc.nextLine();

                    System.out.println("Modelo:");
                    String modelo = sc.nextLine();

                    System.out.println("Precio base por día:");
                    double precioBasedia = sc.nextDouble();

                    System.out.printf("Elegir tipo:\n1. Coche electrico. \n2. Dron de carga. %n");

                    int tipoVehiculo = sc.nextInt();

                    if (tipoVehiculo == 1) {
                        sc= new Scanner(System.in);

                        System.out.println("Capacidad batería:");
                        double capacidad = Double.parseDouble(sc.nextLine());

                        System.out.println("Autonomía restante:");
                        double autonomia = Double.parseDouble(sc.nextLine());

                        System.out.println("Comentarios:");
                        String comentarios = sc.nextLine();

                        CocheElectrico coche = new CocheElectrico(id, modelo, precioBasedia, capacidad, autonomia, comentarios);
                        gestion.registrarVehiculo(coche);

                    } else if (tipoVehiculo == 2) {
                        sc = new Scanner(System.in);

                        System.out.println("Peso máximo:");
                        double pesoMaximo = Double.parseDouble(sc.nextLine());

                        System.out.println("Número de hélices:");
                        int numHelices = Integer.parseInt(sc.nextLine());

                        DronCarga dron = new DronCarga(id, modelo, precioBasedia, pesoMaximo, numHelices);
                        gestion.registrarVehiculo(dron);
                    }
                    else {
                        System.out.println("Vehiculo no valido");
                    }

                    break;

                case "2":
                    gestion.verFlota();
                    break;



                case "3":

                    gestion.mostrarnodelosId();

                    System.out.print("Selecciona un vehiculo: ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    Vehiculo v = gestion.obtenerVehiculoPorNumero(num);

                    if (v != null) {

                        boolean exitoAlquilar = gestion.alquilarVehiculo(v.getId());

                        if (exitoAlquilar) {
                            System.out.println("Vehiculo alquilado exitosamente");
                        } else {
                            System.out.println("Vehiculo no alquilado exitosamente");
                        }

                    } else {
                        System.out.println("Vehiculo no encontrado");
                    }

                    break;

                case "4":
                    sc = new Scanner(System.in);

                    System.out.println("ID Vehiculo:");
                    id = sc.nextLine();

                    boolean devolverVehiculo = gestion.devolverVehiculo(id);
                    if (devolverVehiculo) {
                        System.out.println("Se devolvio con exito.");
                    } else {
                        System.out.println("No se devolvio con exito.");
                    }
                    break;
                case "5":

                    gestion.mostrarnodelosId();

                    System.out.print("Selecciona vehiculo a eliminar: ");
                    num = sc.nextInt();
                    sc.nextLine();

                    v = gestion.obtenerVehiculoPorNumero(num);

                    if (v != null) {

                        boolean eliminado = gestion.eliminarVehiculo(v.getId());

                        if (eliminado) {
                            System.out.println("Vehiculo eliminado");
                        } else {
                            System.out.println("Vehiculo no eliminado");
                        }

                    } else {
                        System.out.println("Vehiculo no encontrado");
                    }

                    break;
                case "6":



                    break;

                case "7":

                gestion.guardarDatos();

                System.out.println("Guardar y salir");
                break;

            }
        }while (!opcion.equals("7"));

    }

    private static LocalDate obtenerFechaValida() {

        Scanner sc = new Scanner(System.in);
        String fecha;

       if (true){
            System.out.print("Fecha: ");
            fecha = sc.nextLine();
        }
       if (false){
           System.out.print("Fecha invalida:");
            fecha = sc.nextLine();
       }
        return null;
    }
}