package Decroly;

import java.io.InputStream;
import java.util.Properties;

/**
 * Clase encargada de la carga y gestión de los parámetros de configuración de la aplicación.
 * <p>Lee las propiedades desde un archivo externo ubicado en el classpath, permitiendo
 * que valores como la URL de la base de datos o las credenciales no estén hardcodeadas.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class Configuracion {

    /**
     * Objeto que almacena los pares clave-valor cargados desde el archivo de configuración.
     */
    private static Properties props = new Properties();

    /**
     * Bloque inicializador estático.
     * <p>Se ejecuta una sola vez cuando la clase es cargada en memoria. Intenta localizar
     * y leer el archivo {@code application.dat} desde el directorio de recursos (classpath).</p>
     * * @throws RuntimeException si el archivo de configuración no se encuentra en la ruta especificada.
     */
    static {
        try {
            // Intento de carga del archivo desde el classloader
            InputStream is = Configuracion.class
                    .getClassLoader()
                    .getResourceAsStream("application.dat");

            if (is == null) {
                throw new RuntimeException("Archivo de configuración 'application.dat' no encontrado en el classpath.");
            }

            props.load(is);

        } catch (Exception e) {
            System.err.println("Error crítico cargando la configuración: " + e.getMessage());
        }
    }

    /**
     * Recupera el valor asociado a una clave de configuración específica.
     * * @param clave El nombre de la propiedad que se desea obtener (ej: "url", "user", "password").
     * @return El valor de la propiedad como {@link String}, o {@code null} si la clave no existe.
     */
    public static String get(String clave) {
        return props.getProperty(clave);
    }
}