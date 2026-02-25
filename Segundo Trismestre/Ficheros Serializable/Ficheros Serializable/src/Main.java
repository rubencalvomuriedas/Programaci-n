import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("""
                \n--- MENÚ BIBLIOTECA ---
                1. Crear Libro
                2. Mostrar Libros
                3. Eliminar Libro por ISBN
                4. Guardar Libros
                5. Guardar y Salir
                """);
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        LocalDate fecha = LocalDate.parse(sc.nextLine());

                        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, fecha));
                        System.out.println("Libro añadido correctamente.");
                    }
                    case 2 -> biblioteca.mostrarLibros();

                    case 3 -> {
                        System.out.print("ISBN a eliminar: ");
                        biblioteca.eliminarLibro(sc.nextLine());
                        System.out.println("Libro eliminado.");
                    }
                    case 4 -> {
                        biblioteca.guardar();
                        System.out.println("Datos guardados.");
                    }
                    case 5 -> {
                        biblioteca.guardar();
                        System.out.println("Guardando y saliendo...");
                    }
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 5);

        sc.close();
    }
}