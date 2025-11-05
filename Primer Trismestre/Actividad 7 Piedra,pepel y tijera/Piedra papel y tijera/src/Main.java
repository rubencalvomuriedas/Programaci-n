import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Se debe realizar un proyecto para crear el juego de “Piedra, papel o tijera”, el programa debe
        de seguir la siguiente estructura.
         Explicarle al jugador cómo se juega.
         Generar la jugada aleatoria del ordenador.
         Pedir al jugador su jugada mediante una letra (P para piedra, L para papel, T para tijeras,
        o S para salir terminando la partida):
         Decidir quién ha ganado.
        Una cosa es saber como se juega y otra es saberlo programar, los pasos a seguir serían:
         Preparar el esqueleto y las constantes necesarias.
         Mostrar instrucciones al usuario.
         Generar la jugada del ordenador.
         Recoger la jugada del usuario.
         Interpretar la jugada del usuario.
         Mostrar el resultado de la jugada.
         Hacer el juego repetitivo.
        Se admiten y se evaluarán mejoras sustanciales en el programa o en la complejidad del juego
         */
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        int victorias = 0;
        int derrotas = 0;
        int empates = 0;

        String Papel;
        String Piedra;
        String Tijeras;
        String opcionJugador = "";

        String menu = "a. Jugar\n" +
                "b. Victorias y derrotas\n" +
                "c. Salir";


        do {
            sc =  new Scanner(System.in);

            System.out.print("");
            System.out.println(menu);
            System.out.print("");

            opcion = sc.nextLine();

            switch (opcion.toLowerCase()) {

                case "a":
                    System.out.println("Eliga su opcion:  ");
                    sc =  new Scanner(System.in);
                    System.out.print("");
                    System.out.println("\nP - Piedra\n" +
                            "L - Papel\n" +
                            "T - Tijeras\n" +
                            "S - Salir");
                    opcionJugador = sc.nextLine();

                    switch (opcionJugador.toUpperCase()) {
                        case "P":
                            opcionJugador = "Piedra";
                            break;
                        case "L":
                            opcionJugador = "Papel";
                            break;
                        case "T":
                            opcionJugador = "Tijeras";
                            break;
                        case "S":
                            System.out.println("Saliendo al menu principal");
                            break;
                    }

                    int [] numeros = {1, 2 , 3};
                    int randomNum = numeros[(int) (Math.random() * numeros.length)];
                    String decisionIA;

                    switch (randomNum) {
                        case 1: decisionIA = "Piedra";
                            break;
                        case 2: decisionIA = "Papel";
                            break;
                        case 3: decisionIA = "Tijeras";
                            break;
                        default: decisionIA = "";
                    }
                    System.out.print("");
                    System.out.println("Has elegido: " + opcionJugador);
                    System.out.println("El ordenador saca: " + decisionIA);


                    if (opcionJugador.equals("Piedra") && decisionIA.equals("Piedra")) {
                        System.out.println("¡Empate!");
                        empates ++;
                    } else if (opcionJugador.equals("Piedra") && decisionIA.equals("Tijeras")) {
                        System.out.println("¡Win!");
                        victorias ++;
                    } else if (opcionJugador.equals("Piedra") && decisionIA.equals("Papel")) {
                        System.out.println("¡Lose!");
                        derrotas++;
                    } else if (opcionJugador.equals("Papel") && decisionIA.equals("Papel")) {
                        System.out.println("¡Empate!");
                        empates ++;
                    } else if (opcionJugador.equals("Papel") && decisionIA.equals("Piedra")) {
                        System.out.println("¡Win!");
                        victorias ++;
                    } else if (opcionJugador.equals("Papel") && decisionIA.equals("Tijeras")) {
                        System.out.println("¡Lose!");
                        derrotas ++;
                    } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Tijeras")) {
                        System.out.println("¡Empate!");
                        empates ++;
                    } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Papel")) {
                        System.out.println("¡Win!");
                        victorias ++;
                    } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Piedra")) {
                        System.out.println("¡Lose!");
                        derrotas ++;
                    }

                    break;
                case "b":
                    System.out.println("");
                    System.out.println("Victorias: " + victorias);
                    System.out.println("Derrotas: " + derrotas);
                    System.out.println("Empates: " + empates);

                    break;
                case "c":
                    System.out.println("\nTheEnd");
                    break;
                default:
                    System.out.println("\nOpcion erronea, vuelve a darle");
            }
        } while(!opcion.equals("d"));{}
    }
}