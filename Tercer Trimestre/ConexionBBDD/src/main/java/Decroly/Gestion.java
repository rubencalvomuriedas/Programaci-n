package Decroly;

import java.sql.*;

public class Gestion {

    private boolean existeReferencia(String ref) throws Exception {

        String sql = "SELECT 1 FROM producto WHERE referencia=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    private int obtenerIdTipo(String nombreTipo) throws Exception {

        String sql = "SELECT id FROM tipo WHERE LOWER(nombre)=LOWER(?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreTipo.trim());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    return -1;
                }
            }
        }
    }

    public int obtenerIdTipoPublico(String nombreTipo) throws Exception {
        return obtenerIdTipo(nombreTipo);
    }

    public void mostrarTodos() throws Exception {

        String sql = "SELECT p.*, t.nombre AS nombreTipo " +
                "FROM producto p " +
                "JOIN tipo t ON p.tipo = t.id";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-10s | %-12s | %-18s | %-10s | %-4s | %-6s | %-3s | %-3s | %-10s |\n",
                    "ID", "REFERENCIA", "NOMBRE", "DESCRIPCIÓN", "TIPO", "CANT", "PRECIO", "DTO", "IVA", "DTO APLIC");
            System.out.println("---------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-2d | %-10s | %-12s | %-18s | %-10s | %-4d | %-6.2f | %-3d | %-3d | %-10s |\n",
                        rs.getInt("id"),
                        rs.getString("referencia"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("nombreTipo"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getInt("descuento"),
                        rs.getInt("iva"),
                        rs.getBoolean("aplicarDto") ? "SÍ" : "NO");
            }

            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }
    }

    public void buscarPorReferencia(String ref) throws Exception {

        String sql = "SELECT p.*, t.nombre AS nombreTipo " +
                "FROM producto p " +
                "JOIN tipo t ON p.tipo = t.id " +
                "WHERE p.referencia=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Referencia: " + rs.getString("referencia"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Descripción: " + rs.getString("descripcion"));
                    System.out.println("Tipo: " + rs.getString("nombreTipo"));
                    System.out.println("Cantidad: " + rs.getInt("cantidad"));
                    System.out.println("Precio: " + rs.getDouble("precio"));
                    System.out.println("Descuento: " + rs.getInt("descuento"));
                    System.out.println("IVA: " + rs.getInt("iva"));
                    System.out.println("Aplicar descuento: " + rs.getBoolean("aplicarDto"));
                } else {
                    throw new ProductoNoEncontradoException("No existe producto");
                }
            }
        }
    }

    public void buscarPorTipo(String tipo) throws Exception {

        int idTipo = obtenerIdTipo(tipo);

        if (idTipo == -1) {
            System.out.println("El tipo de producto no existe");
            return;
        }

        String sql = "SELECT p.*, t.nombre AS nombreTipo " +
                "FROM producto p " +
                "JOIN tipo t ON p.tipo = t.id " +
                "WHERE p.tipo=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTipo);

            boolean encontrado = false;

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Referencia: " + rs.getString("referencia"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Descripción: " + rs.getString("descripcion"));
                    System.out.println("Tipo: " + rs.getString("nombreTipo"));
                    System.out.println("Cantidad: " + rs.getInt("cantidad"));
                    System.out.println("Precio: " + rs.getDouble("precio"));
                    System.out.println("Descuento: " + rs.getInt("descuento"));
                    System.out.println("IVA: " + rs.getInt("iva"));
                    System.out.println("Aplicar descuento: " + rs.getBoolean("aplicarDto"));
                    System.out.println("-----------------------------------");
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No hay productos de ese tipo");
            }
        }
    }

    public void buscarPorCantidad(int cantidad) throws Exception {

        String sql = "SELECT p.*, t.nombre AS nombreTipo " +
                "FROM producto p " +
                "JOIN tipo t ON p.tipo = t.id " +
                "WHERE p.cantidad=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cantidad);

            boolean encontrado = false;

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Referencia: " + rs.getString("referencia"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Descripción: " + rs.getString("descripcion"));
                    System.out.println("Tipo: " + rs.getString("nombreTipo"));
                    System.out.println("Cantidad: " + rs.getInt("cantidad"));
                    System.out.println("Precio: " + rs.getDouble("precio"));
                    System.out.println("Descuento: " + rs.getInt("descuento"));
                    System.out.println("IVA: " + rs.getInt("iva"));
                    System.out.println("Aplicar descuento: " + rs.getBoolean("aplicarDto"));
                    System.out.println("-----------------------------------");
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No hay productos con esa cantidad");
            }
        }
    }

    public void insertar(Producto p) throws Exception {

        if (existeReferencia(p.getReferencia())) {
            throw new ProductoDuplicadoException("La referencia ya existe");
        }

        String sql = "INSERT INTO producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getReferencia());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getDescripcion());
            ps.setInt(4, p.getTipo());
            ps.setInt(5, p.getCantidad());
            ps.setDouble(6, p.getPrecio());
            ps.setInt(7, p.getDescuento());
            ps.setInt(8, p.getIva());
            ps.setBoolean(9, p.isAplicarDto());

            ps.executeUpdate();
        }
    }

    public void eliminar(String ref) throws Exception {

        String sql = "DELETE FROM producto WHERE referencia=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);

            if (ps.executeUpdate() == 0) {
                throw new ProductoNoEncontradoException("No existe producto");
            }
        }
    }

    public void actualizar(String ref, String descripcion, int cantidad,
                           double precio, int descuento, boolean aplicarDto) throws Exception {

        String sql = "UPDATE producto SET descripcion=?, cantidad=?, precio=?, descuento=?, aplicarDto=? WHERE referencia=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, descripcion);
            ps.setInt(2, cantidad);
            ps.setDouble(3, precio);
            ps.setInt(4, descuento);
            ps.setBoolean(5, aplicarDto);
            ps.setString(6, ref);

            if (ps.executeUpdate() == 0) {
                throw new ProductoNoEncontradoException("No existe producto");
            }
        }
    }

    public void insertarTipo(String nombre) throws Exception {

        String sqlComprobar = "SELECT 1 FROM tipo WHERE LOWER(nombre)=LOWER(?)";
        String sqlInsertar = "INSERT INTO tipo (nombre) VALUES (?)";

        try (Connection con = ConexionBD.getConnection()) {

            try (PreparedStatement ps1 = con.prepareStatement(sqlComprobar)) {
                ps1.setString(1, nombre.trim());

                try (ResultSet rs = ps1.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Ese tipo ya existe");
                        return;
                    }
                }
            }

            try (PreparedStatement ps2 = con.prepareStatement(sqlInsertar)) {
                ps2.setString(1, nombre.trim());
                ps2.executeUpdate();
            }
        }
    }
}