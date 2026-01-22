import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taller {

    private HashMap<String, Coche> coches;
    private Scanner sc;

    public Taller() {
        coches = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void anadeElemento() {
        System.out.print("Introduce matrícula: ");
        String matricula = sc.nextLine().toUpperCase();

        if (!validaMatricula(matricula)) {
            System.out.println("Matrícula no válida.");
            return;
        }

        if (coches.containsKey(matricula)) {
            System.out.println("Ya existe un coche con esa matrícula.");
            return;
        }

        System.out.print("Introduce marca: ");
        String marca = sc.nextLine();

        System.out.print("Introduce color: ");
        String color = sc.nextLine();

        Coche coche = new Coche(color, marca);
        coches.put(matricula, coche);

        System.out.println("Coche añadido correctamente.");
    }

    public void eliminaElemento() {
        System.out.print("Introduce matrícula a eliminar: ");
        String matricula = sc.nextLine().toUpperCase();

        if (coches.remove(matricula) != null) {
            System.out.println("Coche eliminado.");
        } else {
            System.out.println("No existe un coche con esa matrícula.");
        }
    }

    public void visualizaMatriculas() {
        System.out.println("\nMATRÍCULAS:");
        for (String matricula : coches.keySet()) {
            System.out.println(matricula);
        }
    }

    public void visualizaCoches() {
        System.out.println("\nCOCHES:");
        for (Coche coche : coches.values()) {
            System.out.println(coche);
        }
    }

    public void visualizaTaller() {
        System.out.println("\nTALLER COMPLETO:");
        for (Map.Entry<String, Coche> entry : coches.entrySet()) {
            System.out.println("Matrícula: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    private boolean validaMatricula(String matricula) {
        return matricula.matches("\\d{4}[A-Z]{3}");
    }
}

