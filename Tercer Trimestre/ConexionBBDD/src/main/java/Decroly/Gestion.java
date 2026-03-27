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

        String sql = "SELECT p.id, p.referencia AS ref, p.nombre, p.descripcion, " +
                "t.nombre AS nombreTipo, p.cantidad, p.precio, p.descuento, p.iva, p.Dto " +
                "FROM producto p " +
                "JOIN tipo t ON p.tipo = t.id " +
                "ORDER BY p.id";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-4s | %-12s | %-18s | %-9s | %-4s | %-7s | %-4s | %-4s | %-3s |\n",
                    "ID", "REF", "NOMBRE", "DESCRIPCIÓN", "TIPO", "CANT", "PRECIO", "DESC", "IVA", "DTO");
            System.out.println("--------------------------------------------------------------------------------------------------");

            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;

                System.out.printf("| %-2d | %-4s | %-12s | %-18s | %-9s | %-4d | %-7.2f | %-4d | %-4d | %-3s |\n",
                        rs.getInt("id"),
                        rs.getString("ref"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("nombreTipo"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio"),
                        rs.getInt("descuento"),
                        rs.getInt("iva"),
                        rs.getBoolean("Dto") ? "SÍ" : "NO");
            }

            if (!hayDatos) {
                System.out.println("No hay productos en el inventario.");
            }

            System.out.println("--------------------------------------------------------------------------------------------------");
        }
    }

    public void buscarPorReferencia(String ref) throws Exception {

        String sql = "SELECT * FROM producto WHERE referencia=?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ref);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                            rs.getString("referencia") + " | " +
                                    rs.getString("nombre") + " | " +
                                    rs.getString("descripcion")
                    );
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

        String sql = "SELECT nombre FROM producto WHERE tipo=? ORDER BY id";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTipo);

            boolean encontrado = false;

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getString("referencia") + " | " +
                                    rs.getString("nombre") + " | " +
                                    rs.getString("descripcion")
                    );
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No hay productos de ese tipo");
            }
        }
    }

    public void buscarPorCantidad(int cantidad) throws Exception {

        String sql = "SELECT nombre FROM producto WHERE cantidad=? ORDER BY id";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cantidad);

            boolean encontrado = false;

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getString("referencia") + " | " +
                                    rs.getString("nombre") + " | " +
                                    rs.getString("descripcion")
                    );
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

        String sql = "INSERT INTO producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, Dto) VALUES (?,?,?,?,?,?,?,?,?)";

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

        String sql = "UPDATE producto SET descripcion=?, cantidad=?, precio=?, descuento=?, Dto=? WHERE referencia=?";

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