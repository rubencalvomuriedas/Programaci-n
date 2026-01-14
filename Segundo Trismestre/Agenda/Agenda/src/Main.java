import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {

            System.out.println("\n----- Menu -----");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Visualizar agenda");
            System.out.println("5. Todos los contactos");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");

            opcion= sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    agenda.añadirContacto();
                    break;
                case 2:
                    agenda.buscarContacto();
                    break;
                case 3:
                    agenda.eliminarContacto();
                    break;
                case 4:
                    agenda.mostrarAgenda();
                    break;
                case 5:
                    System.out.println("Contactos: " + agenda.numeroContactos());
                    break;
                case 6:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }
    }
}