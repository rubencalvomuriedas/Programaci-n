package Decroly;

/**
 * Excepción personalizada utilizada para señalizar que una operación de búsqueda,
 * actualización o borrado ha fallado porque el producto no existe en la base de datos.
 * * <p>Esta excepción es capturada habitualmente en la interfaz de usuario para
 * mostrar mensajes de error específicos al operador del sistema.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class ProductoNoEncontradoException extends Exception {

    /**
     * Crea una nueva instancia de la excepción con un mensaje descriptivo.
     * * @param mensaje Texto que detalla la razón por la cual no se encontró el producto.
     */
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}