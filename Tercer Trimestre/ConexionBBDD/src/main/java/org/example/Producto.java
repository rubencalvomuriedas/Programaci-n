package org.example;

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
    private boolean aplicar_dto;


    public Producto(int id, String referencia, String nombre, String descripcion, int tipo, int cantidad, double precio, int descuento, int iva, boolean aplicar_dto) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public boolean isAplicar_dto() {
        return aplicar_dto;
    }

    public void setAplicar_dto(boolean aplicar_dto) {
        this.aplicar_dto = aplicar_dto;
    }

    @Override
    public String toString() {
        String nombreTipo = (tipo == 0) ? "Sin tipo" : String.valueOf(tipo);

        return String.format(
                "\n| %-8s | %-15s | %-20s | %-12s | %3d uds | %6.2f€ | Dto: %2d%% | IVA: %2d%% | Aplicar: %s |",
                referencia,
                nombre,
                descripcion,
                nombreTipo,
                cantidad,
                precio,
                descuento,
                iva,
                (aplicar_dto ? "SÍ" : "NO")
        );
    }
}