import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion gestion = new Gestion();

        Gestion.cargarDatos();

        String menu = "\n1. Registrar trabajador.\n" +
                "2. Mostrar informacion general.\n" +
                "3. Mostrar numero de trabajadores.\n" +
                "4. Mostrar informacion 1 dep.\n" +
                "5. Eliminar trabajador de la empresa.\n" +
                "6. Guardar. \n" +
                "7. Guardar y salir. ";

        String opcion = "";

        do{
            sc = new Scanner(System.in);
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine();


            switch (opcion) {

                case "1":
                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();


                    System.out.println("Dni:");
                    String dni = sc.nextLine();

                    System.out.println("Direccion:");
                    String direccion = sc.nextLine();

                    System.out.printf("Elegir tipo:\n1. Director. \n2. GerenteDep. n\3. Trabajador.");

                    int Persona = sc.nextInt();

                    Persona p = null;
                    String departamentoEnum = null;
                    if (Persona == 1) {
                        sc = new Scanner(System.in);

                        System.out.println("Telefono:");
                        double Telefono = Double.parseDouble(sc.nextLine());

                        System.out.println("Coche Empresa:");
                        String CocheEmpresa = sc.nextLine();


                        Director d = new Director(nombre,dni, direccion, Telefono, CocheEmpresa);
                        Gestion.registrarPersona(p);

                    } else if (Persona == 2) {
                        sc = new Scanner(System.in);

                        System.out.println("Numero trabajadores:");
                        double NumTrabajadoresDep = Double.parseDouble(sc.nextLine());

                        System.out.println("Gerencia:");
                        String gerenciaEnum = sc.nextLine();

                        System.out.println("Coleccion de trabajadores:");
                        double ColtrabajadoresDep = sc.nextDouble();


                        GerenteDep g = new GerenteDep(nombre,dni, direccion, NumTrabajadoresDep, gerenciaEnum, ColtrabajadoresDep);
                        Gestion.registrarPersona(p);

                    } else if (Persona == 3) {

                        sc = new Scanner(System.in);

                        System.out.println("Numero SS:");
                        double numeroSS = Double.parseDouble(sc.nextLine());

                        System.out.println("Email:");
                        String Email = sc.nextLine();

                        System.out.println("Salario:");
                        double Salario = sc.nextDouble();

                        System.out.println("Departamento:");
                        departamentoEnum = sc.nextLine();


                        Trabajador t = new Trabajador(nombre, dni, direccion, numeroSS, Email, Salario, departamentoEnum);
                        Gestion.registrarPersona(p);

                        System.out.println("Opcion invalida");
                    } else {
                        System.out.println("Persona no valida");
                    }
                    break;

                case "2":

                    Gestion.verInformacionGeneral();

                    break;

                case "3":

                    Gestion.verOrganigrama();

                    break;

                case "4":



                    break;

                /*case "5":
                    System.out.println("Ingrese el Dni de la persona: ");
                    sc.nextLine();

                    if (!(p == null)) {

                        boolean eliminado = Gestion.eliminarPersona((p.getDni()));

                        boolean eliminarPersona = false;
                        if (eliminarPersona) {
                            System.out.println("Persona eliminada");
                        } else {
                            System.out.println("Persona no eliminada");
                        }

                    } else {
                        System.out.println("Persona no econtrada");
                    }

                    break;*/

                case "6":

                    break;

                case "7":

                    Gestion.guardarDatos();

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcion);
            }

        }while (!opcion.equals("7"));
    }
}