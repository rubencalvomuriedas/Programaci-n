package org.example;

import java.util.Scanner;

public class Inventario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gestion dao = new Gestion();

        int opcion = 0;

        do {
            System.out.println("\n1. Mostrar productos");
            System.out.println("2. Buscar por referencia");
            System.out.println("3. Buscar por tipo");
            System.out.println("4. Buscar por cantidad");
            System.out.println("5. Insertar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Actualizar producto");
            System.out.println("8. Insertar tipo de producto");
            System.out.println("9. Salir");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Debes introducir un número");
                sc.nextLine();
                continue;
            }

            try {
                switch (opcion) {

                    case 1:
                        dao.mostrarTodos();
                        break;

                    case 2:
                        System.out.print("Referencia: ");
                        dao.buscarPorReferencia(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Tipo (Fruta, Verdura, Carne, Pescado, Lacteos, Panaderia, Bebidas): ");
                        String tipo = sc.nextLine();
                        dao.buscarPorTipo(tipo);
                        break;

                    case 4:
                        System.out.print("Cantidad mínima: ");
                        if (sc.hasNextInt()) {
                            dao.buscarPorCantidad(sc.nextInt());
                            sc.nextLine();
                        } else {
                            System.out.println("Cantidad inválida");
                            sc.nextLine();
                        }
                        break;

                    case 5:
                        System.out.print("Referencia: ");
                        String ref = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nom = sc.nextLine();

                        System.out.print("Descripción: ");
                        String desc = sc.nextLine();

                        System.out.print("Tipo (Fruta, Verdura, Carne, Pescado, Lacteos, Panaderia, Bebidas): ");
                        String tipoProd = sc.nextLine();

                        System.out.print("Cantidad: ");
                        int cant = sc.nextInt();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        System.out.print("Descuento: ");
                        int dto = sc.nextInt();

                        System.out.print("IVA: ");
                        int iva = sc.nextInt();

                        System.out.print("Aplicar descuento (true/false): ");
                        boolean aplicar = sc.nextBoolean();

                        sc.nextLine();

                        Producto p = new Producto(
                                0, ref, nom, desc,
                                tipoProd,
                                cant, precio, dto, iva, aplicar
                        );

                        dao.insertar(p);
                        System.out.println("Producto insertado");
                        break;

                    case 6:
                        System.out.print("Referencia: ");
                        dao.eliminar(sc.nextLine());
                        break;

                    case 7:
                        System.out.print("Referencia: ");
                        String r = sc.nextLine();

                        System.out.print("Nueva descripción: ");
                        String nuevaDesc = sc.nextLine();

                        System.out.print("Cantidad: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Cantidad inválida");
                            sc.nextLine();
                            break;
                        }
                        int c = sc.nextInt();

                        System.out.print("Precio: ");
                        if (!sc.hasNextDouble()) {
                            System.out.println("Precio inválido");
                            sc.nextLine();
                            break;
                        }
                        double pr = sc.nextDouble();

                        System.out.print("Descuento: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Descuento inválido");
                            sc.nextLine();
                            break;
                        }
                        int dto2 = sc.nextInt();

                        System.out.print("Aplicar descuento (true/false): ");
                        if (!sc.hasNextBoolean()) {
                            System.out.println("Valor inválido");
                            sc.nextLine();
                            break;
                        }
                        boolean aplicar2 = sc.nextBoolean();

                        sc.nextLine();

                        dao.actualizar(r, nuevaDesc, c, pr, dto2, aplicar2);

                        System.out.println("Producto actualizado");
                        break;

                    case 8:
                        System.out.print("Nombre del tipo: ");
                        String nombreTipo = sc.nextLine();

                        dao.insertarTipo(nombreTipo);

                        System.out.println("Tipo insertado correctamente");
                        break;

                    case 9:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 9);

        sc.close();
    }
}
