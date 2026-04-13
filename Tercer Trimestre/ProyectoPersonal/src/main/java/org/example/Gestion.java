package org.example;

import java.sql.*;

public class Gestion {

    public void mostrarTodos() throws SQLException {
        String sql = "SELECT * FROM producto ORDER BY referencia ASC";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n" + "=".repeat(60));
            System.out.printf("%-2s | %-7s | %-22s | %-5s | %-10s%n", "ID", "REF", "NOMBRE", "STOCK", "PRECIO");
            System.out.println("-".repeat(60));

            while (rs.next()) {
                System.out.printf("%-2d | %-7s | %-22s | %5d | %-5.2f€%n",
                        rs.getInt("id"), rs.getString("referencia"), rs.getString("nombre"),
                        rs.getInt("cantidad"), rs.getDouble("precio"));
            }
            System.out.println("=".repeat(60));
        }
    }

    public void buscarPorReferencia(String ref) throws SQLException, ProductoNoEncontradoException {
        String sql = "SELECT * FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n[DATOS DEL PRODUCTO]");
                    System.out.println("Nombre:     " + rs.getString("nombre"));
                    System.out.println("Plataforma: " + rs.getString("plataforma"));
                    System.out.println("Stock:      " + rs.getInt("cantidad"));
                    System.out.println("Precio:     " + rs.getDouble("precio") + "€");
                } else {
                    throw new ProductoNoEncontradoException("La referencia '" + ref + "' no existe.");
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
                System.out.println("\n--- CATÁLOGO: " + plataforma.toUpperCase() + " ---");
                boolean hayResultados = false;
                while (rs.next()) {
                    hayResultados = true;
                    System.out.printf("[%s] %-20s | %.2f€ | Stock: %d%n",
                            rs.getString("referencia"), rs.getString("nombre"),
                            rs.getDouble("precio"), rs.getInt("cantidad"));
                }
                if (!hayResultados) System.out.println("No hay juegos para: " + plataforma);
            }
        }
    }

    public void insertarJuego(Juego j) throws SQLException, ReferenciaDuplicadaException {
        if (existeReferencia(j.getReferencia())) {
            throw new ReferenciaDuplicadaException("La referencia " + j.getReferencia() + " ya existe.");
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
                throw new ProductoNoEncontradoException("Referencia no encontrada.");
            }
        }
    }

    public void actualizarStock(String ref, int nuevaCantidad) throws SQLException, ProductoNoEncontradoException {
        String sql = "UPDATE producto SET cantidad = ? WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, ref);
            if (ps.executeUpdate() == 0) {
                throw new ProductoNoEncontradoException("No se pudo actualizar: referencia inexistente.");
            }
        }
    }

    public void venderJuego(String ref, int unidades) throws SQLException, StockAgotadoException, ProductoNoEncontradoException {
        String sql = "SELECT nombre, cantidad FROM producto WHERE referencia = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int stockActual = rs.getInt("cantidad");

                    if (stockActual < unidades) {
                        throw new StockAgotadoException("Stock insuficiente. Solo quedan " + stockActual + " unidades de " + nombre);
                    }

                    actualizarStock(ref, stockActual - unidades);
                    System.out.println(">> VENTA REGISTRADA: " + nombre + " (" + unidades + " unidad/es)");
                } else {
                    throw new ProductoNoEncontradoException("Producto no encontrado para la venta.");
                }
            }
        }
    }

    public void calcularValorTotalInventario() throws SQLException {
        String sql = "SELECT SUM(precio * cantidad) AS valor_total FROM producto";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.printf("\nVALOR TOTAL DEL INVENTARIO: %.2f €%n", rs.getDouble("valor_total"));
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

    public void registrarCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO cliente (dni, nombre, direccion) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    System.out.println(">> OK: Cliente registrado con el NÚMERO: " + rs.getInt(1));
                }
            }
        }
    }

    public void darDeBajaCliente(int idCliente) throws SQLException, ProductoNoEncontradoException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            if (ps.executeUpdate() == 0) {
                throw new ProductoNoEncontradoException("No existe el cliente con ID: " + idCliente);
            }
        }
    }

    public void mostrarClientes() throws SQLException {
        String sql = "SELECT * FROM cliente";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- LISTADO DE CLIENTES ---");
            System.out.printf("%-3s | %-9s | %-10s | %-20s%n", "ID", "DNI", "NOMBRE", "DIRECCIÓN");
            System.out.println("-".repeat(60));

            while (rs.next()) {
                System.out.printf("%-3d | %-9s | %-10s | %-20s%n",
                        rs.getInt("id"), rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("direccion"));
            }
        }
    }

    public String generarSiguienteReferencia(String prefijo) throws SQLException {

        String sql = "SELECT referencia FROM producto WHERE referencia LIKE ? ORDER BY referencia DESC LIMIT 1";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, prefijo + "-%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String ultimaRef = rs.getString("referencia"); // Ej: "PS5-005"
                    int ultimoNumero = Integer.parseInt(ultimaRef.split("-")[1]);
                    return String.format("%s-%03d", prefijo, ultimoNumero + 1);
                }
            }
        }
        return prefijo + "-001";
    }

    public java.util.List<Juego> obtenerListaJuegos() throws SQLException {
        java.util.List<Juego> lista = new java.util.ArrayList<>();
        String sql = "SELECT referencia, nombre, cantidad FROM producto ORDER BY referencia ASC";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                Juego j = new Juego();
                j.setReferencia(rs.getString("referencia"));
                j.setNombre(rs.getString("nombre"));
                j.setCantidad(rs.getInt("cantidad"));
                lista.add(j);
            }
        }
        return lista;
    }

    public java.util.List<Cliente> obtenerListaClientes() throws SQLException {
        java.util.List<Cliente> lista = new java.util.ArrayList<>();
        String sql = "SELECT id, dni, nombre FROM cliente ORDER BY nombre ASC";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("dni"), rs.getString("nombre"), "");
                c.setId(rs.getInt("id"));
                lista.add(c);
            }
        }
        return lista;
    }

//    public static int generarIdJuego() {
//        String sql = "SELECT MAX(ID) AS ULTIMO FROM PRODUCTO";
//        int siguiente = 1;
//
//        try (Connection con = ConexionBD.getConnection();
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery(sql)) {
//
//            if (rs.next()) {
//                String ultimo = rs.getString("ULTIMO");
//
//                if (ultimo != null) {
//                    int num = Integer.parseInt(ultimo);
//                    siguiente = num + 1;
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return siguiente;
//    }

    public static int generarIdJuego() {

        String sql = "SELECT (t1.id + 1) AS disponible " +
                "FROM producto t1 " +
                "LEFT JOIN producto t2 ON t1.id + 1 = t2.id " +
                "WHERE t2.id IS NULL " +
                "ORDER BY t1.id LIMIT 1";

        try (Connection con = ConexionBD.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            // Primero comprobamos si el ID 1 está libre (caso especial)
            if (!idExiste(1)) {
                return 1;
            }

            if (rs.next()) {
                return rs.getInt("disponible");
            }

        } catch (SQLException e) {
            System.out.println("Error al generar ID: " + e.getMessage());
        }

        return 1;
    }

    private static boolean idExiste(int id) {
        String sql = "SELECT id FROM producto WHERE id = " + id;
        try (Connection con = ConexionBD.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }
}