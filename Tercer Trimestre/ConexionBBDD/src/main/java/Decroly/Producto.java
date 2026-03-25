package Decroly;

public class Producto {

    private int id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private int tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    public Producto(int id, String referencia, String nombre, String descripcion,
                    int tipo, int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) {
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    public int getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicarDto() {
        return aplicarDto;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-4s | %-12s | %-18s | %-3d | %3d | %5.2f€ | %2d%% | %2d%% | %-3s |",
                referencia, nombre, descripcion, tipo,
                cantidad, precio, descuento, iva,
                (aplicarDto ? "SÍ" : "NO")
        );
    }
}