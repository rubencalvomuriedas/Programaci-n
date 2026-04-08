package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    public void mostrarTodos() throws Exception {
        String sql = "SELECT * FROM producto";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- INVENTARIO COMPLETO ---");
            while (rs.next()) {
                System.out.println(String.format("ID: %d | Ref: %s | Nombre: %s | Stock: %d | Precio: %.2f€",
                        rs.getInt("id"), rs.getString("referencia"), rs.getString("nombre"),
                        rs.getInt("cantidad"), rs.getDouble("precio")));
            }
        }
    }

    public void buscarPorReferencia(String ref) throws Exception, ProductoNoEncontradoException {
        String sql = "SELECT * FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Encontrado: " + rs.getString("nombre") + " - Stock: " + rs.getInt("cantidad"));
                } else {
                    throw new ProductoNoEncontradoException("No existe ningún producto con referencia: " + ref);
                }
            }
        }
    }


    public void insertarJuego(Juego j) throws Exception {
        if (existeReferencia(j.getReferencia())) {
            throw new ReferenciaDuplicadaException("La referencia " + j.getReferencia() + " ya está registrada.");
        }

        String sql = "INSERT INTO producto (referencia, nombre, descripcion, cantidad, precio, plataforma, genero) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, j.getReferencia());
            ps.setString(2, j.getNombre());
            ps.setString(3, j.getDescripcion());
            ps.setInt(4, j.getCantidad());
            ps.setDouble(5, j.getPrecio());
            ps.setString(6, j.getPlataforma());
            ps.setString(7, j.getGenero());

            ps.executeUpdate();
        }
    }

    public void eliminarProducto(String ref) throws Exception, ProductoNoEncontradoException {
        String sql = "DELETE FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);
            int filasAffected = ps.executeUpdate();
            if (filasAffected == 0) {
                throw new ProductoNoEncontradoException("No se pudo eliminar: la referencia no existe.");
            }
        }
    }

    public void actualizarStock(String ref, int nuevaCantidad) throws Exception {
        String sql = "UPDATE producto SET cantidad = ? WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nuevaCantidad);
            ps.setString(2, ref);
            ps.executeUpdate();
        }
    }

    public void venderJuego(String ref, int unidades) throws Exception {

        String sql = "SELECT nombre, cantidad, precio FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int stockActual = rs.getInt("cantidad");
                    if (stockActual < unidades) {
                        throw new StockAgotadoException("Stock insuficiente. Disponible: " + stockActual);
                    }

                    actualizarStock(ref, stockActual - unidades);

                    generarTicket(rs.getString("nombre"), unidades, rs.getDouble("precio"));
                    System.out.println("Venta realizada. Ticket generado.");

                } else {
                    throw new ProductoNoEncontradoException("Producto no encontrado.");
                }
            }
        }
    }

    private void generarTicket(String nombre, int cant, double precio) {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = ahora.format(formato);

        String nombreFichero = "ticket_" + ahora.getMinute() + ahora.getSecond() + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            bw.write("=====================================");
            bw.newLine();
            bw.write("       TICKET DE VENTA - GAME        ");
            bw.newLine();
            bw.write("=====================================");
            bw.newLine();
            bw.write("FECHA: " + fechaFormateada);
            bw.newLine();
            bw.write("PRODUCTO: " + nombre);
            bw.newLine();
            bw.write("CANTIDAD: " + cant);
            bw.newLine();
            bw.write("PRECIO UNIDAD: " + precio + "€");
            bw.newLine();
            bw.write("-------------------------------------");
            bw.newLine();
            bw.write("TOTAL A PAGAR: " + (cant * precio) + "€");
            bw.newLine();
            bw.write("=====================================");
            bw.newLine();
            bw.write("¡Gracias por su compra!");

            System.out.println("Archivo creado con éxito: " + nombreFichero);

        } catch (IOException e) {
            System.err.println("Error al escribir el ticket: " + e.getMessage());
        }
    }

    public void buscarPorPlataforma(String plataforma) throws Exception {
        String sql = "SELECT * FROM producto WHERE plataforma LIKE ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + plataforma + "%");

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\n--- RESULTADOS PARA: " + plataforma.toUpperCase() + " ---");
                boolean hayResultados = false;

                while (rs.next()) {
                    hayResultados = true;
                    System.out.println(String.format("[%s] %s - Precio: %.2f€ - Stock: %d",
                            rs.getString("referencia"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad")));
                }

                if (!hayResultados) {
                    System.out.println("No se encontraron juegos para esa plataforma.");
                }
            }
            private boolean existeReferencia (String ref) throws Exception {
                String sql = "SELECT 1 FROM producto WHERE referencia = ?";
                try (Connection con = ConexionBD.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, ref);
                    try (ResultSet rs = ps.executeQuery()) {
                        return rs.next();
                    }
                }

                public void calcularValorTotalInventario () throws Exception {
                    // Usamos SUM() para que MySQL calcule el total rápidamente
                    String sql = "SELECT SUM(precio * cantidad) AS valor_total FROM producto";

                    try (Connection con = ConexionBD.getConnection();
                         PreparedStatement ps = con.prepareStatement(sql);
                         ResultSet rs = ps.executeQuery()) {

                        if (rs.next()) {
                            double total = rs.getDouble("valor_total");
                            System.out.println("   INFORME FINANCIERO DE LA TIENDA");
                            System.out.format(" VALOR TOTAL DEL STOCK: %.2f €\n", total);
                        }
                    }
                }
            }
        }
    }
}