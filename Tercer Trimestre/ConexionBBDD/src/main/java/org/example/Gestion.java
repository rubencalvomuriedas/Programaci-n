package org.example;

import java.sql.*;

public class Gestion {

    public void mostrarTodos() throws Exception {

        Connection con = ConexionBD.conectar();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM producto");

        while (rs.next()) {
            System.out.println(rs.getString("referencia") + " - " +
                    rs.getString("nombre") + " - Cantidad: " +
                    rs.getInt("cantidad"));
        }

        con.close();
    }

    public void buscarPorReferencia(String ref) throws Exception {

        Connection con = ConexionBD.conectar();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE referencia=?");

        ps.setString(1, ref);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Producto encontrado: " +
                    rs.getString("nombre"));
        } else {
            throw new Exception("No existe producto");
        }

        con.close();
    }

    public void buscarPorTipo(int tipo) throws Exception {

        Connection con = ConexionBD.conectar();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM producto WHERE tipo=?");

        ps.setInt(1, tipo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("nombre"));
        }

        con.close();
    }

    public void buscarPorCantidad(int cantidad) throws Exception {

        Connection con = ConexionBD.conectar();

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

        Connection con = ConexionBD.conectar();


        PreparedStatement check = con.prepareStatement(
                "SELECT * FROM producto WHERE referencia=?");

        check.setString(1, p.getReferencia());

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            throw new Exception("Referencia repetida");
        }

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO producto (referencia,nombre,descripcion,tipo,cantidad,precio,descuento,iva,aplicarDto) VALUES (?,?,?,?,?,?,?,?,?)");

        ps.setString(1, p.getReferencia());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getNombre());
        ps.setInt(4, p.getTipo());
        ps.setInt(5, p.getCantidad());
        ps.setDouble(6, p.getPrecio());
        ps.setInt(7, p.getDescuento());
        ps.setInt(8, p.getIva());
        ps.setBoolean(9, p.isAplicarDto());

        ps.executeUpdate();

        con.close();
    }

    public void eliminar(String ref) throws Exception {

        Connection con = ConexionBD.conectar();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM producto WHERE referencia=?");

        ps.setString(1, ref);

        if (ps.executeUpdate() == 0) {
            throw new Exception("No existe producto");
        }

        con.close();
    }

    public void actualizar(String ref, int cantidad, double precio) throws Exception {

        Connection con = ConexionBD.conectar();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE producto SET cantidad=?, precio=? WHERE referencia=?");

        ps.setInt(1, cantidad);
        ps.setDouble(2, precio);
        ps.setString(3, ref);

        if (ps.executeUpdate() == 0) {
            throw new Exception("No actualizado");
        }

        con.close();
    }
}
