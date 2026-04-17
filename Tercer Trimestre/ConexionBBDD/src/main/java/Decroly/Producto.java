package Decroly;

/**
 * Representa la entidad Producto dentro del sistema de inventario.
 * <p>Esta clase es un modelo de datos que almacena las propiedades físicas y
 * comerciales de un artículo, incluyendo su identificación, stock y política de precios.</p>
 * * @author Tu Nombre o Equipo de Desarrollo
 * @version 1.0
 */
public class Producto {

    private int id;
    private String ref;
    private String nombre;
    private String descripcion;
    private int tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    /**
     * Constructor completo para instanciar un Producto con todos sus atributos.
     * * @param id Identificador único autoincremental en la base de datos.
     * @param ref Código de referencia único del producto.
     * @param nombre Nombre comercial del artículo.
     * @param descripcion Detalle o especificaciones del producto.
     * @param tipo ID de la categoría a la que pertenece el producto.
     * @param cantidad Unidades disponibles en stock.
     * @param precio Precio unitario antes de impuestos y descuentos.
     * @param descuento Porcentaje de descuento aplicable (0-100).
     * @param iva Porcentaje de IVA aplicado al producto.
     * @param aplicarDto Flag que indica si el descuento debe ser procesado.
     */
    public Producto(int id, String ref, String nombre, String descripcion,
                    int tipo, int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) {
        this.id = id;
        this.ref = ref;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    /** @return El ID interno del producto. */
    public int getId() {
        return id;
    }

    /** @return La referencia única del producto. */
    public String getReferencia() {
        return ref;
    }

    /** @return El nombre del producto. */
    public String getNombre() {
        return nombre;
    }

    /** @return La descripción detallada del producto. */
    public String getDescripcion() {
        return descripcion;
    }

    /** @return El identificador del tipo de categoría. */
    public int getTipo() {
        return tipo;
    }

    /** @return La cantidad actual en el inventario. */
    public int getCantidad() {
        return cantidad;
    }

    /** @return El precio unitario base. */
    public double getPrecio() {
        return precio;
    }

    /** @return El porcentaje de descuento definido. */
    public int getDescuento() {
        return descuento;
    }

    /** @return El porcentaje de IVA aplicado. */
    public int getIva() {
        return iva;
    }

    /** @return {@code true} si el descuento está activo, {@code false} de lo contrario. */
    public boolean isAplicarDto() {
        return aplicarDto;
    }

    /**
     * Devuelve una representación textual del producto formateada en columnas.
     * <p>Ideal para visualización rápida en consola siguiendo un esquema tabular.</p>
     * * @return Una cadena de texto con los atributos principales alineados.
     */
    @Override
    public String toString() {
        return String.format(
                "| %-1s | %-10s | %-18s | %-3d | %3d | %5.2f€ | %2d%% | %2d%% | %-3s |",
                ref, nombre, descripcion, tipo,
                cantidad, precio, descuento, iva,
                (aplicarDto ? "SÍ" : "NO")
        );
    }
}