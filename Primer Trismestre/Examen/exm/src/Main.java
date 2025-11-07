import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int indiceActual = 0;
        int numeros = 0;
        int numerosReales = 0;
        int [] array = new int [10];
        String opcion = "d";
        do {
            System.out.println("Modificar colección: ");
            System.out.println("a. Insertar numero: ");
            System.out.println("b. Borrar número: ");
            System.out.println("c. Modificar número de una posición específica ");
            System.out.println("d. Estadisticas de la coleccion ");
            System.out.println("e. Media de todos los valores no nulos ");
            System.out.println("f. Suma de todos los valores ");
            System.out.println("g. Máximo de la colección ");
            System.out.println("h. Mínimo de la colección ");
            System.out.println("j. Salir ");

            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
            switch (opcion) {

                case "a":
                    sc = new Scanner(System.in);
                    System.out.println("Introduce la posicion donde quieras insertar el valor: ");
                    int contadorPosicion = sc.nextInt();
                    if(contadorPosicion < array.length && contadorPosicion >= 0){
                        array[contadorPosicion] = sc.nextInt();
                    }

                    break;
                case "b":
                    sc = new Scanner(System.in);
                    System.out.println("Borrar numero");
                    int numerquedeseaborrar = sc.nextInt();

                    break;
                case "c":
                    sc = new Scanner(System.in);
                    System.out.println("modificar numero de una posicion específica");
                    int modificarnumero = sc.nextInt();

                    break;
                case "d":
                    sc= new Scanner(System.in);
                    System.out.println("Estadisticas de la coleccion");
                    break;
                case "e":
                    System.out.println("Media de todos los valores no nulos");
                    break;
                case "f":
                    System.out.println("Suma de todos los valores");
                    double suma;
                    suma = (numeros + numeros);
                    sc = new Scanner(System.in);
                    double [] numerosReales5 = new double [10];
                    double suma5 = 0.0;
                    for (int i = 0; i < numeros; i++) {

                    }
                    System.out.println("La suma es: " + suma);
                    System.out.println("La media es: " + (suma / numerosReales5.length));

                    break;
                case "g":
                    System.out.println("Máximo de la colección");
                    break;
                case "h":
                    sc = new Scanner(System.in);
                    System.out.println("Mínimo de la colección");

                        break;
                case "j":
                    sc = new Scanner(System.in);
                    System.out.println("El programa se cerrara");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + opcion);
            }

        }while(!opcion.equals("j"));
    }
}
