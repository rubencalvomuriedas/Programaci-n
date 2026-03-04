import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion nuevaGestion = new Gestion();

        // FICHEROS CARGAR DATOS
        nuevaGestion.cargarDatos();

        String menu = "\n1. Crear y registrar plataforma en franquicia\n" +
                "2. Registrar artículo (Pelicula o Videojuego)\n" +
                "3. Registrar cliente\n" +
                "4. Alquilar artículo\n"+
                "5. Devolver artículo\n" +
                "6. Dar de baja cliente\n" +
                "7. Dar de baja artículo\n" +
                "8. Mostrar todos los artículos\n" +
                "9. Mostrar todos los clientes\n" +
                "10. Salir\n";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    break;
                case "2":
                    sc = new Scanner(System.in);

                    System.out.println("(1)Pelicula o (2)Videojuego");
                    int seleccion = sc.nextInt();

                    System.out.println("Indique el ID del articulo");
                    String id = sc.next();
                    System.out.println("Indique el titulo del articulo");
                    String titulo = sc.next();

                        if (seleccion == 1) {

                            sc = new Scanner(System.in);
                            System.out.println("Indique la duracion de la pelicula");
                            int duracion = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Indique el genero (ACCION, COMEDIA, DRAMA, TERROR, CIENCIA_FICCION, ANIMACION, AVENTURA)");
                            Genero genero = Genero.valueOf(sc.nextLine().toUpperCase());
                            Pelicula p = new Pelicula(id, titulo, duracion, genero);

                            nuevaGestion.agregarArticulo(p);
                        }

                        if (seleccion == 2) {
                            sc = new Scanner(System.in);
                            System.out.println("Indique la plataforma");
                            String plataforma = sc.nextLine();

                            System.out.println("Indique el PEGI");
                            int pegi = sc.nextInt();
                            sc.nextLine();

                            Videojuego v = new Videojuego(id, titulo, plataforma, pegi);

                            nuevaGestion.agregarArticulo(v);
                        }
                        break;
                        case "3":

                            System.out.println("Indique el dni del cliente");
                            String dni = sc.nextLine();

                            System.out.println("Indique el nombre del cliente");
                            String nombre = sc.nextLine();

                            Cliente c = new Cliente(dni, nombre);
                            nuevaGestion.agregarCliente(c);
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        case "6":
                            System.out.println("Indique el dni del cliente");
                            dni = sc.nextLine();

                            boolean eliminadoCliente =  nuevaGestion.eliminarCliente(dni);
                            if(eliminadoCliente){
                                System.out.println("Cliente eliminado");
                            } else {
                                System.out.println("Cliente no eliminado");
                            }
                            break;
                        case "7":
                            System.out.println("Indique el id del articulo");
                            id = sc.nextLine();

                            boolean eliminarArticulo = nuevaGestion.eliminarArticulo(id);
                            if(eliminarArticulo){
                                System.out.println("Articulo eliminado");
                            } else {
                                System.out.println("Articulo no eliminado");
                            }
                            break;
                        case "8":
                            nuevaGestion.mostrarArticulo();
                            break;
                        case "9":
                            nuevaGestion.mostrarCliente();
                            break;
                        case "10":
                            nuevaGestion.guardarDatos();
                            break;

            }



        } while (!opcion.equals("10")) ;
    }
}