package org.example;

import java.util.Scanner;

public class Inventario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion dao = new Gestion();
        int opcion = 0;

        System.out.println("========================================");
        System.out.println("   SISTEMA DE GESTIÓN GAME-MANAGER 2026");
        System.out.println("========================================");

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

            opcion = ValidadorDatos.obtenerEnteroValido("Seleccione una opción: ", sc);

            try {
                switch (opcion) {
                    case 1 -> dao.mostrarTodos();

                    case 2 -> {
                        String refB = ValidadorDatos.obtenerTextoNoVacio("Introduce referencia: ", sc);
                        dao.buscarPorReferencia(refB);
                    }

                    case 3 -> {
                        String plat = ValidadorDatos.obtenerTextoNoVacio("¿Qué plataforma buscas?: ", sc);
                        dao.buscarPorPlataforma(plat);
                    }

                    case 4 -> {
                        System.out.println("\n--- ALTA DE NUEVO JUEGO ---");
                        String ref = ValidadorDatos.obtenerTextoNoVacio("Referencia: ", sc);
                        String nom = ValidadorDatos.obtenerTextoNoVacio("Nombre: ", sc);
                        String plataforma = ValidadorDatos.obtenerTextoNoVacio("Plataforma: ", sc);
                        String genero = ValidadorDatos.obtenerTextoNoVacio("Género: ", sc);
                        double precio = ValidadorDatos.obtenerDoubleValido("Precio: ", sc);
                        int stock = ValidadorDatos.obtenerEnteroValido("Stock inicial: ", sc);

                        Juego nuevo = new Juego(0, ref, nom, "Nuevo lanzamiento", 1,
                                stock, precio, 0, 21, false, plataforma, genero);
                        dao.insertarJuego(nuevo);
                        System.out.println("¡Juego guardado en la base de datos!");
                    }

                    case 5 -> {
                        String refA = ValidadorDatos.obtenerTextoNoVacio("Referencia del producto: ", sc);
                        int cant = ValidadorDatos.obtenerEnteroValido("Nuevo stock total: ", sc);
                        dao.actualizarStock(refA, cant);
                        System.out.println("Stock actualizado correctamente.");
                    }

                    case 6 -> {
                        String refE = ValidadorDatos.obtenerTextoNoVacio("Referencia a eliminar: ", sc);
                        if (ValidadorDatos.obtenerBooleanoValido("¿Seguro que quieres borrarlo?", sc)) {
                            dao.eliminarProducto(refE);
                            System.out.println("Producto borrado del sistema.");
                        }
                    }

                    case 7 -> {
                        String refV = ValidadorDatos.obtenerTextoNoVacio("Referencia para la venta: ", sc);
                        int vta = ValidadorDatos.obtenerEnteroValido("Cantidad de unidades: ", sc);
                        dao.venderJuego(refV, vta);
                    }

                    case 8 -> dao.calcularValorTotalInventario();

                    case 9 -> System.out.println("Saliendo del sistema... Copia de seguridad finalizada.");

                    default -> System.out.println("Opción no reconocida. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("\n[ERROR SISTEMA]: " + e.getMessage());
            }

        } while (opcion != 9);

        sc.close();
    }
}