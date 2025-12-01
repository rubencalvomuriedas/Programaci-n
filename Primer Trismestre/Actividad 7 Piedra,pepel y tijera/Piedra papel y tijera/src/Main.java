import java.util.Scanner;

public class Main {
    public static <Explicarle> void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String option = "c";


        do {
            System.out.println("Elija Piedra, Papel o Tijeras para jugar, o salir para cerrar el juego.");
            System.out.println("P.Piedra");
            System.out.println("L.Papel");
            System.out.println("T. Tijeras");
            System.out.println("S. Salir");
            option = sc.nextLine().toUpperCase();
            int Pc = (int) Math.floor(Math.random() * 3);
            int Win = 0;
            int Lose = 0;
            int Tie = 0;
            System.out.println("Has ganado " + Win + " veces");
            System.out.println("Has perdido " + Lose + " veces");
            System.out.println("Has empatado " + Tie + " veces");





            switch (option) {
                case "P":
                    int optionP = 0;
                    System.out.println("Tu: Piedra");
                    if (Pc != optionP) {

                        if (Pc == 1) {
                            //Papel
                            System.out.println("Pc: Papel");
                            if (optionP == 0) {
                                System.out.println("Has ganado!!");

                                Win++;

                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }
                        if (Pc == 2) {

                            //Tijera
                            System.out.println("Pc: Tijeras");
                            if (optionP == 1) {
                                System.out.println("Has ganado!!");

                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }

                    } else {
                        System.out.println("PC: Piedra");
                        System.out.println("Es un empate!");

                    }
                    break;
                case "L":
                    int optionL = 1;
                    System.out.println("Tu: Papel");
                    if (Pc != optionL) {
                        if (Pc == 0) {

                            //piedra
                            System.out.println("PC: Piedra");
                            if (optionL == 2) {
                                System.out.println("Has ganado!!");
                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }
                        if (Pc == 2) {

                            //Tijera
                            System.out.println("Pc: Tijeras");
                            if (optionL == 1) {
                                System.out.println("Has ganado!!");

                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }

                    } else {
                        System.out.println("PC: Papel");
                        System.out.println("Es un empate!");
                    }
                    break;
                case "T":
                    int optionT = 2;
                    System.out.println("Tu: Tijera");

                    if (Pc != optionT) {
                        if (Pc == 0) {
                            //piedra
                            System.out.println("Pc: Piedra");
                            if (optionT == 2) {
                                System.out.println("Has ganado!!");
                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }
                        if (Pc == 1) {
                            //Papel
                            System.out.println("Pc: Papel");
                            if (optionT == 0) {
                                System.out.println("Has ganado!!");

                            } else {
                                System.out.println("Has Perdido ;_;");
                            }
                        }

                    } else {
                        System.out.println("PC: Tijera");
                        System.out.println("Es un empate!");
                    }
                    break;
                case "S":
                    System.out.println("El juego se cerrara.");


                    break;
                default:
                    System.out.println("Opcion no valida");
                    System.out.println("Por favor elija una opcion correcta");

            }


        } while (!option.equals("S"));


    }

}CAMILO SE LA COME DOBLADA Y TAMBIEN LE GUSTA DAR SENTONES