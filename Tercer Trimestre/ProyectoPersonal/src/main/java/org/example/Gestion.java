package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gestion {

    public void mostrarTodos() throws SQLException {
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

    public void buscarPorReferencia(String ref) throws SQLException, ProductoNoEncontradoException {
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

    public void buscarPorPlataforma(String plataforma) throws SQLException {
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
                            rs.getString("referencia"), rs.getString("nombre"),
                            rs.getDouble("precio"), rs.getInt("cantidad")));
                }
                if (!hayResultados) System.out.println("No se encontraron juegos para esa plataforma.");
            }
        }
    }

    public void insertarJuego(Juego j) throws SQLException, ReferenciaDuplicadaException {
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

    public void eliminarProducto(String ref) throws SQLException, ProductoNoEncontradoException {
        String sql = "DELETE FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ref);
            if (ps.executeUpdate() == 0) {
                throw new ProductoNoEncontradoException("No se pudo eliminar: la referencia no existe.");
            }
        }
    }

    public void actualizarStock(String ref, int nuevaCantidad) throws SQLException {
        String sql = "UPDATE producto SET cantidad = ? WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, ref);
            ps.executeUpdate();
        }
    }

    public void venderJuego(String ref, int unidades) throws SQLException, StockAgotadoException, ProductoNoEncontradoException {
        String sql = "SELECT nombre, cantidad, precio FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int stockActual = rs.getInt("cantidad");
                    if (stockActual < unidades) throw new StockAgotadoException("Stock insuficiente.");
                    actualizarStock(ref, stockActual - unidades);
                    generarTicket(rs.getString("nombre"), unidades, rs.getDouble("precio"));
                } else {
                    throw new ProductoNoEncontradoException("Producto no encontrado.");
                }
            }
        }
    }

    private void generarTicket(String nombre, int cant, double precio) {
        String nombreFichero = "ticket_" + System.currentTimeMillis() + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
            bw.write("TICKET DE VENTA\nPRODUCTO: " + nombre + "\nCANTIDAD: " + cant + "\nTOTAL: " + (cant * precio) + "€");
            System.out.println("Ticket generado: " + nombreFichero);
        } catch (IOException e) {
            System.err.println("Error al crear ticket: " + e.getMessage());
        }
    }

    public void calcularValorTotalInventario() throws SQLException {
        String sql = "SELECT SUM(precio * cantidad) AS valor_total FROM producto";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.format("VALOR TOTAL DEL STOCK: %.2f €\n", rs.getDouble("valor_total"));
            }
        }
    }

    private boolean existeReferencia(String ref) throws SQLException {
        String sql = "SELECT 1 FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}