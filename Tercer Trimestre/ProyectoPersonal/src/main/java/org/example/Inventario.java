package org.example;

import java.sql.SQLException;

public class Inventario {

    public static void main(String[] args) {

        Gestion dao = new Gestion();
        int opcion = 0;

        System.out.println("========================================");
        System.out.println("   SISTEMA DE GESTIÓN GAME 2026");
        System.out.println("========================================");

        do {
            mostrarMenu();
            opcion = ValidadorDatos.obtenerEnteroValido("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> dao.mostrarTodos();

                    case 2 -> {
                        String refB = ValidadorDatos.obtenerTextoNoVacio("Introduce referencia: ");
                        dao.buscarPorReferencia(refB);
                    }

                    case 3 -> {
                        mostrarMenuPlataformas();
                        int subOp = ValidadorDatos.obtenerEnteroValido("Seleccione plataforma: ");
                        String platBusqueda = obtenerNombrePlat(subOp);

                        if (platBusqueda != null) {
                            dao.buscarPorPlataforma(platBusqueda);
                        } else {
                            System.out.println(">> Opción no válida.");
                        }
                    }

                    case 4 -> {
                        String refV = ValidadorDatos.obtenerTextoNoVacio("Referencia para la venta: ");
                        int vta = ValidadorDatos.obtenerEnteroValido("Cantidad de unidades: ");
                        dao.venderJuego(refV, vta);
                    }

                    case 5 -> {
                        System.out.println("\n--- ALTA DE NUEVO JUEGO ---");
                        mostrarMenuPlataformas();
                        int platOp = ValidadorDatos.obtenerEnteroValido("Seleccione plataforma: ");

                        String prefijo = obtenerPrefijo(platOp);

                        if (prefijo == null) {
                            System.out.println(">> Plataforma no válida.");
                        } else {
                            String refAuto = dao.generarSiguienteReferencia(prefijo);
                            String nombrePlat = obtenerNombrePlat(platOp);

                            System.out.println(">> Referencia asignada: " + refAuto);
                            String nom = ValidadorDatos.obtenerTextoNoVacio("Nombre del juego: ");
                            double precio = ValidadorDatos.obtenerDoubleValido("Precio: ");
                            int stock = ValidadorDatos.obtenerEnteroValido("Stock inicial: ");

                            Juego nuevo = new Juego(0, refAuto, nom, "Sin descripción", 1,
                                    stock, precio, 0, 21, false, nombrePlat, "General");

                            dao.insertarJuego(nuevo);
                            System.out.println(">> OK: Juego registrado correctamente.");
                        }
                    }

                    case 6 -> {
                        System.out.println("\n--- ACTUALIZAR STOCK ---");
                        java.util.List<Juego> juegosActuales = dao.obtenerListaJuegos();

                        if (juegosActuales.isEmpty()) {
                            System.out.println("No hay juegos en el inventario.");
                        } else {

                            for (int i = 0; i < juegosActuales.size(); i++) {
                                Juego j = juegosActuales.get(i);
                                System.out.printf("%d. [%s] %s (Stock actual: %d)%n",
                                        (i + 1), j.getReferencia(), j.getNombre(), j.getCantidad());
                            }

                            int seleccion = ValidadorDatos.obtenerEnteroValido("Seleccione el número del juego: ");

                            if (seleccion > 0 && seleccion <= juegosActuales.size()) {
                                Juego elegido = juegosActuales.get(seleccion - 1);
                                int nuevoStock = ValidadorDatos.obtenerEnteroValido("Nuevo stock total para " + elegido.getNombre() + ": ");

                                dao.actualizarStock(elegido.getReferencia(), nuevoStock);
                                System.out.println(">> OK: Stock actualizado correctamente.");
                            } else {
                                System.out.println(">> Opción fuera de rango.");
                            }
                        }
                    }

                    case 7 -> {
                        String refE = ValidadorDatos.obtenerTextoNoVacio("Referencia a eliminar: ");
                        if (ValidadorDatos.obtenerBooleanoValido("¿Seguro que quieres borrarlo?")) {
                            dao.eliminarProducto(refE);
                            System.out.println(">> OK: Producto eliminado.");
                        }
                    }

                    case 8 -> dao.mostrarClientes();

                    case 9 -> {
                        System.out.println("\n--- REGISTRO DE CLIENTE ---");
                        String dni = ValidadorDatos.obtenerDniValido("DNI(Ej:12345678H): ");
                        String nombre = ValidadorDatos.obtenerTextoNoVacio("Nombre: ");
                        String dir = ValidadorDatos.obtenerTextoNoVacio("Dirección: ");
                        dao.registrarCliente(new Cliente(dni, nombre, dir));
                    }

                    case 10 -> {
                        System.out.println("\n--- DAR DE BAJA CLIENTE ---");
                        java.util.List<Cliente> clientesActivos = dao.obtenerListaClientes();

                        if (clientesActivos.isEmpty()) {
                            System.out.println("No hay clientes registrados en el sistema.");
                        } else {

                            for (int i = 0; i < clientesActivos.size(); i++) {
                                Cliente c = clientesActivos.get(i);
                                System.out.printf("%d. [ID: %d] %s (DNI: %s)%n",
                                        (i + 1), c.getId(), c.getNombre(), c.getDni());
                            }

                            int seleccion = ValidadorDatos.obtenerEnteroValido("Seleccione el número del cliente a eliminar: ");

                            if (seleccion > 0 && seleccion <= clientesActivos.size()) {
                                Cliente elegido = clientesActivos.get(seleccion - 1);

                                String confirmacion = "Confirmar eliminación de " + elegido.getNombre() + " (ID: " + elegido.getId() + ")";
                                if (ValidadorDatos.obtenerBooleanoValido(confirmacion)) {
                                    dao.darDeBajaCliente(elegido.getId());
                                    System.out.println(">> OK: Cliente eliminado del sistema.");
                                } else {
                                    System.out.println(">> Operación cancelada.");
                                }
                            } else {
                                System.out.println(">> Opción no válida.");
                            }
                        }
                    }

                    case 11 -> dao.calcularValorTotalInventario();

                    case 12 -> System.out.println("Saliendo del sistema...");

                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR]: " + e.getMessage());
            }

        } while (opcion != 12);
    }

    private static void mostrarMenu() {
        System.out.println("\n----------- MENÚ PRINCIPAL -----------");
        System.out.println("1.  Catálogo");
        System.out.println("2.  Buscar por Referencia");
        System.out.println("3.  Buscar por Plataforma");
        System.out.println("4.  Hacer una Venta");
        System.out.println("5.  Añadir nuevo Juego");
        System.out.println("6.  Actualizar Stock");
        System.out.println("7.  Eliminar Juego");
        System.out.println("8.  Lista de Clientes Registrados");
        System.out.println("9.  Registrar Nuevo Cliente");
        System.out.println("10. Dar de Baja Cliente (ID)");
        System.out.println("11. Valor total del Inventario");
        System.out.println("12. SALIR");
        System.out.println("--------------------------------------");
    }

    private static void mostrarMenuPlataformas() {
        System.out.println("\n--- PLATAFORMAS ---");
        System.out.println("1. PS5");
        System.out.println("2. Nintendo Switch");
        System.out.println("3. Xbox");
        System.out.println("4. PC");
        System.out.println("5. Multiplataforma");
    }

    private static String obtenerNombrePlat(int op) {
        return switch (op) {
            case 1 -> "PS5";
            case 2 -> "Switch";
            case 3 -> "Xbox";
            case 4 -> "PC";
            case 5 -> "Multi";
            default -> null;
        };
    }

    private static String obtenerPrefijo(int op) {
        return switch (op) {
            case 1 -> "PS5";
            case 2 -> "NSW";
            case 3 -> "XBX";
            case 4 -> "PC";
            case 5 -> "MUL";
            default -> null;
        };
    }
}