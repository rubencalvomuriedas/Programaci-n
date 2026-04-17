package Decroly;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase de utilidad encargada de gestionar la conexión con el servidor de base de datos.
 * * <p>Esta clase centraliza la carga del driver JDBC y la obtención de credenciales
 * mediante una clase externa de configuración.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 * @see Configuracion
 */
public class ConexionBD {

    /**
     * Nombre cualificado de la clase del Driver JDBC para MySQL/MariaDB.
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Establece y devuelve una conexión activa con la base de datos.
     * * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     * <li>Carga dinámicamente el driver especificado en {@link #DRIVER}.</li>
     * <li>Recupera los parámetros de conexión (URL, usuario y contraseña) desde {@link Configuracion}.</li>
     * <li>Valida que los parámetros no sean nulos.</li>
     * <li>Solicita la conexión al {@link DriverManager}.</li>
     * </ol>
     * * @return Un objeto {@link Connection} listo para realizar operaciones SQL.
     * @throws Exception Si el driver no es encontrado, si faltan datos de configuración
     * o si la conexión falla por problemas de red/credenciales.
     */
    public static Connection getConnection() throws Exception {

        // Carga del driver
        Class.forName(DRIVER);

        // Recuperación de credenciales desde el sistema de configuración
        String url = Configuracion.get("url");
        String user = Configuracion.get("user");
        String pass = Configuracion.get("password");

        // Validación de integridad de configuración
        if (url == null || user == null || pass == null) {
            throw new Exception("Error de configuración: Faltan parámetros (url, user o password) en el archivo de propiedades.");
        }

        // Intento de conexión
        return DriverManager.getConnection(url, user, pass);
    }
}