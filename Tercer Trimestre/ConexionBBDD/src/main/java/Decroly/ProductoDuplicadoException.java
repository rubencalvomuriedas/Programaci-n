package Decroly;

/**
 * Excepción personalizada lanzada cuando se intenta registrar un producto
 * cuya referencia ya existe en el sistema.
 * * <p>Esta excepción permite diferenciar errores de integridad de datos
 * de otros errores generales de SQL o conexión.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class ProductoDuplicadoException extends Exception {

    /**
     * Construye una nueva excepción con un mensaje detallado.
     * * @param mensaje El mensaje explicativo que describe la causa del error.
     */
    public ProductoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}