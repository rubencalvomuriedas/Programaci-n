package org.example;

public class Producto {

    private int id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicar_dto;

    public Producto(int id, String referencia, String nombre, String descripcion,
                    String tipo, int cantidad, double precio,
                    int descuento, int iva, boolean aplicar_dto) {

        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicar_dto = aplicar_dto;
    }

    public String getReferencia() { return referencia; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public int getDescuento() { return descuento; }
    public int getIva() { return iva; }
    public boolean isAplicar_dto() { return aplicar_dto; }

    @Override
    public String toString() {
        return String.format(
                "| %-4s | %-12s | %-18s | %-10s | %3d | %5.2f€ | %2d%% | %2d%% | %-3s |",
                referencia,
                nombre,
                descripcion,
                tipo,
                cantidad,
                precio,
                descuento,
                iva,
                (aplicar_dto ? "SÍ" : "NO")
        );
    }
}