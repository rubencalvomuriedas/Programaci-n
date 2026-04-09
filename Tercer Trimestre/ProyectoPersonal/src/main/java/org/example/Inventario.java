package org.example;

import java.sql.SQLException;

public class Inventario {

    public static void main(String[] args) {

        Gestion dao = new Gestion();
        int opcion = 0;

        System.out.println("========================================");
        System.out.println("   SISTEMA DE GESTIÓN GAME 2026");

        do {
            System.out.println("\n----------- MENÚ PRINCIPAL -----------");
            System.out.println("1.  Listar todo el catálogo");
            System.out.println("2.  Buscar por Referencia");
            System.out.println("3.  Buscar por Plataforma (PS5, PC, Switch...)");
            System.out.println("4.  Añadir nuevo Juego al sistema");
            System.out.println("5.  Actualizar Stock manual");
            System.out.println("6.  Eliminar Producto");
            System.out.println("7.  REALIZAR VENTA");
            System.out.println("8.  Ver Valor Total del Inventario");
            System.out.println("9.  SALIR");
            System.out.println("--------------------------------------");

            opcion = ValidadorDatos.obtenerEnteroValido("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> dao.mostrarTodos();

                    case 2 -> {
                        String refB = ValidadorDatos.obtenerTextoNoVacio("Introduce referencia: ");
                        dao.buscarPorReferencia(refB);
                    }

                    case 3 -> {
                        String plat = ValidadorDatos.obtenerTextoNoVacio("¿Qué plataforma buscas?: ");
                        dao.buscarPorPlataforma(plat);
                    }

                    case 4 -> {
                        System.out.println("\n--- ALTA DE NUEVO JUEGO ---");
                        String ref = ValidadorDatos.obtenerTextoNoVacio("Referencia: ");
                        String nom = ValidadorDatos.obtenerTextoNoVacio("Nombre: ");
                        String plataforma = ValidadorDatos.obtenerTextoNoVacio("Plataforma: ");
                        String genero = ValidadorDatos.obtenerTextoNoVacio("Género: ");
                        double precio = ValidadorDatos.obtenerDoubleValido("Precio: ");
                        int stock = ValidadorDatos.obtenerEnteroValido("Stock inicial: ");

                        Juego nuevo = new Juego(0, ref, nom, "Lanzamiento 2026", 1,
                                stock, precio, 0, 21, false, plataforma, genero);

                        dao.insertarJuego(nuevo);
                        System.out.println(">> OK: Juego registrado correctamente.");
                    }

                    case 5 -> {
                        String refA = ValidadorDatos.obtenerTextoNoVacio("Referencia del producto: ");
                        int cant = ValidadorDatos.obtenerEnteroValido("Nuevo stock total: ");
                        dao.actualizarStock(refA, cant);
                        System.out.println(">> OK: Stock actualizado.");
                    }

                    case 6 -> {
                        String refE = ValidadorDatos.obtenerTextoNoVacio("Referencia a eliminar: ");
                        if (ValidadorDatos.obtenerBooleanoValido("¿Seguro que quieres borrarlo?")) {
                            dao.eliminarProducto(refE);
                            System.out.println(">> OK: Producto eliminado.");
                        } else {
                            System.out.println(">> Operación cancelada.");
                        }
                    }

                    case 7 -> {
                        String refV = ValidadorDatos.obtenerTextoNoVacio("Referencia para la venta: ");
                        int vta = ValidadorDatos.obtenerEnteroValido("Cantidad de unidades: ");
                        dao.venderJuego(refV, vta);
                    }

                    case 8 -> dao.calcularValorTotalInventario();

                    case 9 -> System.out.println("Saliendo del sistema... Copia de seguridad finalizada.");

                    default -> System.out.println("Opción no válida.");
                }
            }
            catch (ProductoNoEncontradoException | StockAgotadoException | ReferenciaDuplicadaException e) {
                System.out.println("\n[AVISO]: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("\n[ERROR BASE DE DATOS]: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n[ERROR INESPERADO]: " + e.getMessage());
            }

        } while (opcion != 9);
    }
}