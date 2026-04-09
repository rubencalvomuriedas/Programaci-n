package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {

    private static final int IVA_DEFECTO = 21;
    private static final String DESC_VACIA = "Sin descripción";

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

    public Producto(int id, String ref, String nombre, String descripcion, int tipo,
                    int cantidad, double precio, int descuento, int iva, boolean aplicarDto) {

        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
        if (cantidad < 0) throw new IllegalArgumentException("El stock no puede ser negativo");
        if (iva < 0) throw new IllegalArgumentException("El IVA no puede ser negativo");

        this.id = id;
        this.ref = ref;
        this.nombre = nombre;
        this.descripcion = (descripcion == null || descripcion.isEmpty()) ? DESC_VACIA : descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    public Producto(String ref, String nombre, int cantidad, double precio) {
        this(0, ref, nombre, DESC_VACIA, 0, cantidad, precio, 0, IVA_DEFECTO, false);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getReferencia() { return ref; }
    public void setReferencia(String ref) { this.ref = ref; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getTipo() { return tipo; }
    public void setTipo(int tipo) { this.tipo = tipo; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getDescuento() { return descuento; }
    public void setDescuento(int descuento) { this.descuento = descuento; }

    public int getIva() { return iva; }
    public void setIva(int iva) { this.iva = iva; }

    public boolean isAplicarDto() { return aplicarDto; }
    public void setAplicarDto(boolean aplicarDto) { this.aplicarDto = aplicarDto; }

    @Override
    public String toString() {
        return String.format("Ref: %-10s | Nombre: %-20s | Stock: %d | Precio: %.2f€",
                ref, nombre, cantidad, precio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(ref, producto.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref);
    }
}