import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String FICHERO = "Almacen.dat";
    private static ArrayList<Producto> almacen = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarFichero();
        menu();
    }

    private static void menu() {
        int opcion;

        do {
            System.out.println("""
                    \n--- MENÚ ALMACÉN ---
                    1. Crear producto
                    2. Mostrar productos
                    3. Eliminar producto por código
                    4. Guardar productos en fichero
                    5. Salir
                    """);

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> mostrarProductos();
                case 3 -> eliminarProducto();
                case 4 -> guardarFichero();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }

        } while (opcion != 5);
    }

    private static void crearProducto() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        almacen.add(new Producto(codigo, nombre, cantidad, precio));
    }

    private static void mostrarProductos() {
        if (almacen.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto p : almacen) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarProducto() {
        System.out.print("Código a eliminar: ");
        String codigo = sc.nextLine();

        boolean eliminado = almacen.removeIf(p -> p.getCodigo().equals(codigo));

        if (!eliminado) {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void guardarFichero() {
        try (FileOutputStream fos = new FileOutputStream(FICHERO);
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (Producto p : almacen) {
                dos.writeUTF(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeInt(p.getCantidad());
                dos.writeDouble(p.getPrecio());
            }

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
        }
    }

    private static void cargarFichero() {
        File f = new File(FICHERO);
        if (!f.exists()) return;

        try (FileInputStream fis = new FileInputStream(FICHERO);
             DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                String codigo = dis.readUTF();
                String nombre = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();

                almacen.add(new Producto(codigo, nombre, cantidad, precio));
            }

        } catch (EOFException e) {
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero.");
        }
    }
}

