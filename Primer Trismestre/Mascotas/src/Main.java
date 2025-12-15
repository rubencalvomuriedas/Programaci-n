import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       Inventario i = new Inventario();

       String opcion = "7";

       do{
           System.out.println("o Mostrar la lista de animales (solo tipo y nombre, 1 línea por animal).\n" +
                   "o Mostrar todos los datos de un animal concreto.\n" +
                   "o Mostrar todos los datos de todos los animales.\n" +
                   "o Insertar animales en el inventario.\n" +
                   "o Eliminar animales del inventario.\n" +
                   "o Vaciar el inventario. \n" + "oSalir. \n");
                    opcion = sc.nextLine();


                    switch(opcion){
                        case "1":
                            i.mostrarAnimalTipoNombre();
                        break;

                        case "2":
                            System.err.println("INSERTAR EL NOMBRE Y EL TIPO DE LA MASCOTA");
                            i.mostrarAnimalTipoNombre();

                            System.out.println("Nombre mascota");
                            String nombre = sc.nextLine();


                            int tipo;
                            do {
                                i.tipos();

                                System.out.println("Elija un tipo de mascota(id)\n");
                                tipo = sc.nextInt();
                                sc.nextLine();

                                if(tipo >= (Tipo.values().length + 1) || tipo <= 0){
                                    System.err.println("Haga el favor de elegir un tipo de la lista");
                                }

                            } while (Tipo.values().length < tipo || tipo <= 0 || tipo >= Tipo.values().length + 1);

                            Tipo t = Tipo.values()[tipo - 1];

                            i.mostrarDatosAnimalConcreto(nombre, t);
                        break;

                        case "3":
                            i.mostrarTodoAnimal();
                        break;

                        case "4":
                            System.out.println("Nombre");
                            String nombre1 = sc.nextLine();

                            System.out.println("Edad");
                            int edad1 = sc.nextInt();


                            int estado;
                            do {
                                i.estados();

                                System.out.println("Elija un estado de la mascota(id)\n");
                                estado = sc.nextInt();
                                sc.nextLine();

                                if(estado >= (Estado.values().length + 1) || estado <= 0){
                                    System.err.println("Haga el favor de elegir un estado de la lista");
                                }

                            } while (Estado.values().length < estado || estado <= 0 || estado >= Estado.values().length + 1);

                            Estado est = Estado.values()[estado - 1];

                            String nacimiento;

                                do {
                                    System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy):");
                                    nacimiento = sc.nextLine().trim();

                                } while (!validarFecha(nacimiento));


                                LocalDate fecha = LocalDate.parse(nacimiento, dtf);

                            int tipo1;
                            do{
                                i.tipos();

                                System.out.println("Elija un tipo de mascota(id)\n");
                                tipo1 = sc.nextInt();
                                sc.nextLine();

                                if(tipo1 >= (Tipo.values().length + 1) || tipo1 <= 0){
                                    System.err.println("Elegir un tipo de la lista");
                                }

                            }while (Tipo.values().length < tipo1 || tipo1 <= 0 || tipo1 >= Tipo.values().length + 1);

                            Tipo t1 = Tipo.values()[tipo1 - 1];

                                if(t1.equals(Tipo.PERRO)){

                                    System.out.println("Raza");
                                    String raza = sc.nextLine();

                                    System.out.println("Tine pulgas? (s/n)");
                                    String pulga = sc.nextLine();

                                    boolean pulgas;

                                    if(pulga.equalsIgnoreCase("s")){
                                        pulgas = true;
                                    }else{
                                        pulgas = false;
                                    }

                                    Perro p = new Perro(nombre1, edad1, est, fecha, t1, raza, pulgas);

                                    if (!i.exists(p.getNombre(), p.getTipo())) {
                                        if (i.insertarAnimal(p)) {
                                            System.out.println("Se ha insertado la mascota");
                                        } else {
                                            System.err.println("No hay espacio para insertar más mascotas");
                                        }
                                    }
                                } else if(t1.equals(Tipo.GATO)){

                                    System.out.println("Color");
                                    String color1 = sc.nextLine();

                                    System.out.println("Tine pelo largo? (s/n)");
                                    String pelo = sc.nextLine();

                                    boolean largo;

                                    if(pelo.equalsIgnoreCase("s")){
                                        largo = true;
                                    }else{
                                        largo = false;
                                    }

                                    Gato g = new Gato(nombre1, edad1, est, fecha, t1, color1, largo);

                                    if (!i.exists(g.getNombre(), g.getTipo())) {
                                        if (i.insertarAnimal(g)) {
                                            System.out.println("Se ha insertado la mascota");
                                        } else {
                                            System.err.println("No hay espacio");
                                        }
                                    }
                                
                                }else if(t1.equals(Tipo.LORO)){

                                    System.out.println("Tine pico? (s/n)");
                                    String p = sc.nextLine();

                                    boolean pico;

                                    if(p.equalsIgnoreCase("s")){
                                        pico = true;
                                    }else{
                                        pico = false;
                                    }

                                    System.out.println("Vuela? (s/n)");
                                    String v = sc.nextLine();

                                    boolean vuela;

                                    if(v.equalsIgnoreCase("s")){
                                        vuela = true;
                                    }else{
                                        vuela = false;
                                    }

                                    System.out.println("Origen");
                                    String origen = sc.nextLine();


                                    System.out.println("Habla? (s/n)");
                                    String h = sc.nextLine();

                                    boolean habla;

                                    if(h.equalsIgnoreCase("s")){
                                        habla = true;
                                    }else{
                                        habla = false;
                                    }
                                    
                                    Loro l = new Loro(nombre1, edad1, est, fecha, t1, pico, vuela, origen, habla);

                                    if (!i.exists(l.getNombre(), l.getTipo())) {
                                        if (i.insertarAnimal(l)) {
                                            System.out.println("Se ha insertado la mascota");
                                        } else {
                                            System.err.println("No hay espacio para insertar más mascotas");
                                        }
                                    }


                                }else if(t1.equals(Tipo.CANARIO)){

                                    System.out.println("Tine pico? (s/n)");
                                    String p = sc.nextLine();

                                    boolean pico;

                                    if(p.equalsIgnoreCase("s")){
                                        pico = true;
                                    }else{
                                        pico = false;
                                    }

                                    System.out.println("Vuela? (s/n)");
                                    String v = sc.nextLine();

                                    boolean vuela;

                                    if(v.equalsIgnoreCase("s")){
                                        vuela = true;
                                    }else{
                                        vuela = false;
                                    }

                                    System.out.println("Color");
                                    String color = sc.nextLine();


                                    System.out.println("Canta? (s/n)");
                                    String ca = sc.nextLine();

                                    boolean canta;

                                    if(ca.equalsIgnoreCase("s")){
                                        canta = true;
                                    }else{
                                        canta = false;
                                    }
                                    
                                    Canario c = new Canario(nombre1, edad1, est, fecha, t1, pico, vuela, color, canta);

                                    if (!i.exists(c.getNombre(), c.getTipo())) {
                                        if (i.insertarAnimal(c)) {
                                            System.out.println("Se ha insertado la mascota\n");
                                        } else {
                                            System.err.println("No hay espacio \n");
                                            System.out.println("Se ampliará el espacio para poder insertar más mascotas");
                                            i.aumentarTamanio();
                                            i.reorganizar();

                                            if (i.insertarAnimal(c)) {
                                                System.out.println("Se ha insertado la mascota tras ampliar espacio\n");
                                            } else {
                                                System.err.println("Error: No se pudo insertar la mascota \n");
                                            }
                                        }
                                    }
                                }

                        break;

                        case "5":
                            
                            i.mostrarAnimalTipoNombre();
                            
                            System.out.println("Nombre");
                            String nombre2 = sc.nextLine();

                            int tipo2;
                            do{
                                i.tipos();

                                System.out.println("Elija un tipo de mascota(introduzca el id)\n");
                                tipo2 = sc.nextInt(); //recoger id mediante entero
                                sc.nextLine();

                                if(tipo2 >= (Tipo.values().length + 1) || tipo2 <= 0){
                                    System.err.println("Haga el favor de elegir un tipo de la lista");
                                }

                            }while (Tipo.values().length < tipo2 || tipo2 <= 0 || tipo2 >= Tipo.values().length + 1);

                            Tipo t2 = Tipo.values()[tipo2 - 1];
                            
                            i.eliminarAnimal(nombre2, t2);
                            
                            i.reorganizar();
                            
                        break;
                        
                        case "6":
                            i.eliminarTodosAnimales();
                        break;
                        
                        case "7":
                            System.out.println("Gracias por usar nuestros servicios. Un placer...");
                        break;
                        
                        default:
                            System.err.println("Escoja una opcion de las expuestas");

                    }
                    
       }while(!opcion.equals("7"));

    }


    public static boolean validarFecha(String nacimiento) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";

        return Pattern.matches(regex, nacimiento);
    }
    
}