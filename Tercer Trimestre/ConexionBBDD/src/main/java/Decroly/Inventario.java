package Decroly;

import java.util.Scanner;

/**
 * Clase principal que actúa como la interfaz de usuario por consola (CLI).
 * <p>Esta clase gestiona el bucle principal de la aplicación, presenta el menú
 * de opciones al usuario y coordina las llamadas a la lógica de negocio en la clase {@link Gestion}.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class Inventario {

    /**
     * Método de entrada principal (Entry Point) que arranca la aplicación de inventario.
     * <p>El método inicializa el escáner para la entrada de datos, el objeto de acceso
     * a datos (DAO) y ejecuta un bucle {@code do-while} para mantener el menú activo
     * hasta que el usuario decida salir.</p>
     * * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion dao = new Gestion();

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Buscar por referencia");
            System.out.println("3. Buscar por tipo");
            System.out.println("4. Buscar por cantidad");
            System.out.println("5. Insertar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Actualizar producto");
            System.out.println("8. Insertar tipo de producto");
            System.out.println("9. Salir");

            // Uso de clase de utilidad para garantizar que la entrada sea un entero
            opcion = ValidadorDatos.obtenerEnteroValido("Introduce el número que desea: ", sc);

            try {
                switch (opcion) {

                    case 1:
                        dao.mostrarTodos();
                        break;

                    case 2:
                        String refBusqueda = ValidadorDatos.obtenerTextoNoVacio("Referencia a buscar: ", sc);
                        dao.buscarPorReferencia(refBusqueda);
                        break;

                    case 3:
                        String tipoBusqueda = ValidadorDatos.obtenerTextoNoVacio("Tipo (Fruta, Verdura, etc.): ", sc);
                        dao.buscarPorTipo(tipoBusqueda);
                        break;

                    case 4:
                        int cantBusqueda = ValidadorDatos.obtenerEnteroValido("Cantidad exacta a buscar: ", sc);
                        dao.buscarPorCantidad(cantBusqueda);
                        break;

                    case 5:
                        System.out.println("\n Nuevo Producto ");
                        String ref = ValidadorDatos.obtenerTextoNoVacio("Referencia: ", sc);
                        String nom = ValidadorDatos.obtenerTextoNoVacio("Nombre: ", sc);
                        String desc = ValidadorDatos.obtenerTextoNoVacio("Descripción: ", sc);

                        // Lógica de validación de tipo de producto
                        int idTipo = -1;
                        while (idTipo == -1) {
                            String nombreTipo = ValidadorDatos.obtenerTextoNoVacio("Nombre del Tipo: ", sc);
                            idTipo = dao.obtenerIdTipoPublico(nombreTipo);
                            if (idTipo == -1) {
                                System.out.println("El tipo '" + nombreTipo + "' no existe. Inténtalo de nuevo.");
                            }
                        }

                        int cant = ValidadorDatos.obtenerEnteroValido("Cantidad: ", sc);
                        double precio = ValidadorDatos.obtenerDoubleValido("Precio: ", sc);
                        int dto = ValidadorDatos.obtenerEnteroValido("Descuento (%): ", sc);
                        int iva = ValidadorDatos.obtenerEnteroValido("IVA (%): ", sc);
                        boolean aplicar = ValidadorDatos.obtenerBooleanoValido("¿Aplicar descuento?", sc);

                        Producto p = new Producto(0, ref, nom, desc, idTipo, cant, precio, dto, iva, aplicar);
                        dao.insertar(p);
                        System.out.println("Producto insertado correctamente.");
                        break;

                    case 6:
                        String refEliminar = ValidadorDatos.obtenerTextoNoVacio("Referencia a eliminar: ", sc);
                        dao.eliminar(refEliminar);
                        System.out.println("Producto eliminado.");
                        break;

                    case 7:
                        System.out.println("\n ACTUALIZAR PRODUCTO ");
                        String r = ValidadorDatos.obtenerTextoNoVacio("Referencia del producto: ", sc);
                        String nuevaDesc = ValidadorDatos.obtenerTextoNoVacio("Nueva descripción: ", sc);
                        int c = ValidadorDatos.obtenerEnteroValido("Nueva cantidad: ", sc);
                        double pr = ValidadorDatos.obtenerDoubleValido("Nuevo precio: ", sc);
                        int dto2 = ValidadorDatos.obtenerEnteroValido("Nuevo descuento: ", sc);
                        boolean aplicar2 = ValidadorDatos.obtenerBooleanoValido("¿Aplicar descuento?", sc);

                        dao.actualizar(r, nuevaDesc, c, pr, dto2, aplicar2);
                        System.out.println("Producto actualizado.");
                        break;

                    case 8:
                        String nuevoTipo = ValidadorDatos.obtenerTextoNoVacio("Nombre del nuevo tipo: ", sc);
                        dao.insertarTipo(nuevoTipo);
                        System.out.println("Tipo '" + nuevoTipo + "' registrado.");
                        break;

                    case 9:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente entre 1 y 9.");
                }

            } catch (Exception e) {
                // Captura centralizada de errores para evitar que la aplicación se cierre abruptamente
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (opcion != 9);

        sc.close();
    }
}