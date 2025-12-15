import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Astro> astros = new ArrayList<>();

        Planeta tierra = new Planeta("Tierra", 5.97e24, 12742,
                24, 365, 149.6e6);

        Planeta marte = new Planeta("Marte", 6.39e23, 6779,
                24.6, 687, 227.9e6);

        Satelite luna = new Satelite("Luna", 7.35e22, 3474,
                655, 27.3, 384400, tierra);


        tierra.agregarSatelite(luna);


        astros.add(tierra);
        astros.add(marte);
        astros.add(luna);

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ ===");
            System.out.println("1. Listar astros");
            System.out.println("2. Mostrar información de un astro");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < astros.size(); i++) {
                        System.out.println(i + " - " + astros.get(i).getNombre());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número del astro: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < astros.size()) {
                        astros.get(idx).muestra();
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                    }
            } while (opcion != 0);

            sc.close();
    }
}


