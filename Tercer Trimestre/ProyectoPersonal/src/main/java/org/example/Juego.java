package org.example;

import java.io.Serializable;


public class Juego extends Producto implements Serializable {

    private String plataforma;
    private String genero;

    public Juego(int id, String ref, String nombre, String descripcion, int tipo,
                 int cantidad, double precio, int descuento, int iva,
                 boolean aplicarDto, String plataforma, String genero) {

        super(id, ref, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);

        this.plataforma = plataforma;
        this.genero = genero;
    }

    public Juego(String ref, String nombre, String plataforma, double precio, int cantidad) {
        super(0, ref, nombre, "Sin descripción", 0, cantidad, precio, 0, 21, false);
        this.plataforma = plataforma;
        this.genero = "General";
    }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public String toString() {
        return String.format("GAME [%s] %-20s | %-10s | %-10s | Stock: %d | Precio: %.2f€",
                getReferencia(), getNombre(), plataforma, genero, getCantidad(), getPrecio());
    }
}
