package Decroly;

import java.sql.*;

/**
 * Esta clase gestiona las operaciones CRUD y de búsqueda de productos y categorías
 * en la base de datos de la aplicación.
 * * <p>Utiliza JDBC para la conectividad y se apoya en la clase {@code ConexionBD}
 * para obtener las conexiones activas.</p>
 * * @author Tu Nombre o Nombre del Grupo
 * @version 1.0
 */
public class Gestion {

    /**
     * Verifica de forma interna si una referencia ya existe en la tabla de productos.
     * * @param ref El código de referencia del producto a comprobar.
     * @return {@code true} si la referencia ya está registrada, {@code false} en caso contrario.
     * @throws Exception Si ocurre un error de acceso a datos durante la consulta SQL.
     */
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

    /**
     * Obtiene el identificador único (ID) de un tipo de producto a partir de su nombre.
     * Realiza una búsqueda insensible a mayúsculas y minúsculas (Case-Insensitive).
     * * @param nombreTipo El nombre de la categoría o tipo de producto.
     * @return El ID correspondiente al tipo; {@code -1} si el tipo no se encuentra en la base de datos.
     * @throws Exception Si ocurre un error en la comunicación con el servidor de base de datos.
     */
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

    /**
     * Método público de utilidad para acceder a la búsqueda de IDs de tipo.
     * * @param nombreTipo El nombre de la categoría a consultar.
     * @return El identificador numérico de la categoría.
     * @throws Exception Si falla la consulta SQL.
     * @see #obtenerIdTipo(String)
     */
    public int obtenerIdTipoPublico(String nombreTipo) throws Exception {
        return obtenerIdTipo(nombreTipo);
    }

    /**
     * Recupera todos los productos del inventario y los muestra por consola en formato de tabla.
     * Realiza una unión (JOIN) con la tabla 'tipo' para mostrar nombres de categoría descriptivos.
     * * @throws Exception Si ocurre un error al ejecutar la consulta o al procesar el ResultSet.
     */
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

    /**
     * Busca un producto por su clave de referencia única.
     * * @param ref El código de referencia del producto deseado.
     * @throws ProductoNoEncontradoException Si no existe ningún registro con esa referencia.
     * @throws Exception Si ocurre un error técnico en la base de datos.
     */
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

    /**
     * Filtra y muestra los productos que pertenecen a una categoría específica.
     * * @param tipo El nombre de la categoría por la cual filtrar.
     * @throws Exception Si ocurre un error en la consulta o el tipo no es válido.
     */
    public void buscarPorTipo(String tipo) throws Exception {

        int idTipo = obtenerIdTipo(tipo);

        if (idTipo == -1) {
            System.out.println("El tipo de producto no existe");
            return;
        }

        // Corrección: He añadido 'referencia' y 'descripcion' al SELECT para que coincida con el print
        String sql = "SELECT referencia, nombre, descripcion FROM producto WHERE tipo=? ORDER BY id";

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

    /**
     * Busca y lista productos que tienen una cantidad exacta en stock.
     * * @param cantidad Cantidad numérica entera a buscar.
     * @throws Exception Si ocurre un error en la base de datos.
     */
    public void buscarPorCantidad(int cantidad) throws Exception {

        // Corrección: Añadido referencia y descripcion al SELECT
        String sql = "SELECT referencia, nombre, descripcion FROM producto WHERE cantidad=? ORDER BY id";

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

    /**
     * Registra un nuevo producto en la base de datos.
     * * @param p Objeto {@code Producto} que contiene todos los datos a insertar.
     * @throws ProductoDuplicadoException Si la referencia del producto ya existe en el sistema.
     * @throws Exception Si ocurre un error durante la inserción de datos.
     */
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

    /**
     * Elimina un producto de la base de datos basándose en su referencia única.
     * * @param ref Referencia del producto a eliminar.
     * @throws ProductoNoEncontradoException Si no se encuentra un producto con esa referencia para borrar.
     * @throws Exception Si falla la operación en la base de datos.
     */
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

    /**
     * Actualiza los datos de un producto ya existente.
     * * @param ref Referencia del producto (campo clave para la actualización).
     * @param descripcion Nueva descripción del producto.
     * @param cantidad Nueva cantidad en stock.
     * @param precio Nuevo precio unitario.
     * @param descuento Nuevo valor de descuento.
     * @param aplicarDto {@code true} si se debe aplicar el descuento, {@code false} en caso contrario.
     * @throws ProductoNoEncontradoException Si el producto con la referencia dada no existe.
     * @throws Exception Si ocurre un error en la actualización.
     */
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

    /**
     * Inserta un nuevo tipo de producto (categoría) en la tabla 'tipo'.
     * Antes de insertar, verifica que el nombre no exista ya para evitar duplicados.
     * * @param nombre El nombre del nuevo tipo a registrar.
     * @throws Exception Si ocurre un error técnico en la base de datos.
     */
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