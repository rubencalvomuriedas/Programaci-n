package org.example;

import java.sql.*;

public class Gestion {

    public void mostrarTodos() throws Exception {

        Connection con = ConexionBD.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM producto");

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("| REF  | NOMBRE       | DESCRIPCIÓN       | TIPO       | CANT | PRECIO | DTO | IVA | DTO |");
        System.out.println("---------------------------------------------------------------------------------------------");

        while (rs.next()) {

            Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("referencia"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("tipo"), // 🔥 CAMBIO CLAVE
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getInt("descuento"),
                    rs.getInt("iva"),
                    rs.getBoolean("aplicarDto")
            );

            System.out.println(p);
        }

        System.out.println("---------------------------------------------------------------------------------------------");

        con.close();
    }

    public void buscarPorReferencia(String ref) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE referencia=?");

        ps.setString(1, ref);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Producto encontrado: " + rs.getString("nombre"));
        } else {
            throw new Exception("No existe producto");
        }

        con.close();
    }

    // 🔥 CAMBIO IMPORTANTE → ahora String
    public void buscarPorTipo(String tipo) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE tipo=?");

        ps.setString(1, tipo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("nombre"));
        }

        con.close();
    }

    public void buscarPorCantidad(int cantidad) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE cantidad>=?");

        ps.setInt(1, cantidad);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("nombre"));
        }

        con.close();
    }

    public void insertar(Producto p) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement check = con.prepareStatement(
                "SELECT 1 FROM producto WHERE referencia=?");

        check.setString(1, p.getReferencia());

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            throw new Exception("Referencia repetida");
        }

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO producto (referencia,nombre,descripcion,tipo,cantidad,precio,descuento,iva,aplicarDto) VALUES (?,?,?,?,?,?,?,?,?)");

        ps.setString(1, p.getReferencia());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getDescripcion());
        ps.setString(4, p.getTipo()); // 🔥 ya es String
        ps.setInt(5, p.getCantidad());
        ps.setDouble(6, p.getPrecio());
        ps.setInt(7, p.getDescuento());
        ps.setInt(8, p.getIva());
        ps.setBoolean(9, p.isAplicar_dto());

        ps.executeUpdate();

        con.close();
    }

    public void eliminar(String ref) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM producto WHERE referencia=?");

        ps.setString(1, ref);

        if (ps.executeUpdate() == 0) {
            throw new Exception("No existe producto");
        }

        con.close();
    }

    public void actualizar(String ref, String descripcion, int cantidad,
                           double precio, int descuento, boolean aplicarDto) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE producto SET descripcion=?, cantidad=?, precio=?, descuento=?, aplicarDto=? WHERE referencia=?");

        ps.setString(1, descripcion);
        ps.setInt(2, cantidad);
        ps.setDouble(3, precio);
        ps.setInt(4, descuento);
        ps.setBoolean(5, aplicarDto);
        ps.setString(6, ref);

        if (ps.executeUpdate() == 0) {
            throw new Exception("No existe producto para actualizar");
        }

        con.close();
    }

    public void insertarTipo(String nombre) throws Exception {

        Connection con = ConexionBD.getConnection();

        PreparedStatement check = con.prepareStatement(
                "SELECT 1 FROM tipo WHERE nombre=?");

        check.setString(1, nombre);

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            throw new Exception("El tipo ya existe");
        }

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tipo (nombre) VALUES (?)");

        ps.setString(1, nombre);

        ps.executeUpdate();

        con.close();
    }
}