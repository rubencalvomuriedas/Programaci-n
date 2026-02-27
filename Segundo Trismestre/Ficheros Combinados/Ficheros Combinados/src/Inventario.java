import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        cargarCSV();
        cargarBinario();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ INVENTARIO ---");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Eliminar producto por referencia");
            System.out.println("3. Guardar y salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> mostrarProductos();
                    case 2 -> eliminarProducto(sc);
                    case 3 -> guardarYSalir();
                    default -> System.out.println("Opción incorrecta");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 3);
    }
    private static void cargarCSV() {
        File f = new File("productos.csv");

        if (!f.exists()) {
            System.out.println("No existe productos.csv");
            return;
        }

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                Producto p = new Producto(
                        datos[0],
                        datos[1],
                        datos[2],
                        Integer.parseInt(datos[3]),
                        Double.parseDouble(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]),
                        Boolean.parseBoolean(datos[7])
                        
                );
                productos.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cargarBinario() {
        File f = new File("almacen.dat");

        if (!f.exists()) {
            System.out.println("No existe almacen.dat");
            return;
        }

        try (FileInputStream fis = new FileInputStream(f);
             DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                String ref = dis.readUTF();
                String desc = dis.readUTF();
                String tipo = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();
                int dto = dis.readInt();
                int iva = dis.readInt();
                boolean aplicar = dis.readBoolean();

                productos.add(new Producto(ref, desc, tipo,
                        cantidad, precio, dto, iva, aplicar));
            }

        } catch (EOFException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarProducto(Scanner sc) throws Exception {
        System.out.print("Referencia a eliminar: ");
        String ref = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getReferencia().equals(ref)) {
                productos.remove(i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            throw new Exception("Producto no encontrado");
        }

        System.out.println("Producto eliminado correctamente");
    }

    private static void guardarYSalir() {
        try (FileOutputStream fos = new FileOutputStream("inventario.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Producto p : productos) {
                oos.writeObject(p);
            }

            System.out.println("Inventario guardado. Saliendo...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}