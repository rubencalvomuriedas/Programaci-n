import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    public Producto(String referencia, String descripcion, String tipo,
                    int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        return referencia + " | " + descripcion + " | " + tipo +
                " | Cantidad: " + cantidad +
                " | Precio: " + precio;
    }
}