package org.example;

import java.util.Scanner;

public class Inventario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConexionBD.getConnection();


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
                        //dao.mostrarTodos();
                        break;

                    case 2:
                        System.out.print("Referencia: ");
                        String refBus = sc.nextLine();
                        //dao.buscarPorReferencia(refBus);
                        break;

                    case 3:
                        System.out.print("Tipo: ");
                        if (sc.hasNextInt()) {
                            int tipo = sc.nextInt();
                            sc.nextLine();
//                            dao.buscarPorTipo(tipo);
                        } else {
                            System.out.println("Tipo debe ser número");
                            sc.nextLine();
                        }
                        break;

                    case 4:
                        System.out.print("Cantidad mínima: ");
                        if (sc.hasNextInt()) {
                            int cantidad = sc.nextInt();
                            sc.nextLine();
                            //dao.buscarPorCantidad(cantidad);
                        } else {
                            System.out.println("Cantidad debe ser número");
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

                        System.out.print("Tipo (ID): ");
                        int tipoInsert;
                        if (sc.hasNextInt()) {
                            tipoInsert = sc.nextInt();
                        } else {
                            System.out.println("Tipo inválido");
                            sc.nextLine();
                            break;
                        }

                        System.out.print("Cantidad: ");
                        int cant;
                        if (sc.hasNextInt()) {
                            cant = sc.nextInt();
                        } else {
                            System.out.println("Cantidad inválida");
                            sc.nextLine();
                            break;
                        }

                        System.out.print("Precio: ");
                        double precio;
                        if (sc.hasNextDouble()) {
                            precio = sc.nextDouble();
                        } else {
                            System.out.println("Precio inválido");
                            sc.nextLine();
                            break;
                        }

                        sc.nextLine();

                        Producto p = new Producto(ref, nom, desc,
                                tipoInsert, cant, precio, 0, 21, true);

//                        dao.insertar(p);
                        System.out.println("Producto insertado");
                        break;

                    case 6:
                        System.out.print("Referencia: ");
//                        dao.eliminar(sc.nextLine());
                        break;

                    case 7:
                        System.out.print("Referencia: ");
                        String r = sc.nextLine();

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

                        sc.nextLine();

                        //dao.actualizar(r, c, pr);
                        System.out.println("Producto actualizado");
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
