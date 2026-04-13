package org.example;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Juego: Mantiene la herencia de Producto (UD 3.2)
 * e implementa Serializable (UD 6.3).
 */
public class Juego extends Producto implements Serializable {

    private static final int IVA_POR_DEFECTO = 21;
    private static final String GENERO_POR_DEFECTO = "General";
    private static final String DESC_POR_DEFECTO = "Sin descripción";

    private String plataforma;
    private String genero;

    // NUEVO: Constructor vacío para que la lista dinámica funcione
    // Nota: Asegúrate de que la clase Producto también tenga un constructor vacío
    public Juego() {
        super();
    }

    public Juego(int id, String ref, String nombre, String descripcion, int tipo,
                 int cantidad, double precio, int descuento, int iva,
                 boolean aplicarDto, String plataforma, String genero) {

        super(id, ref, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);

        if (precio < 0 || cantidad < 0) {
            throw new IllegalArgumentException("El precio y la cantidad no pueden ser negativos");
        }

        this.plataforma = plataforma;
        this.genero = genero;
    }

    public Juego(String ref, String nombre, String plataforma, double precio, int cantidad) {
        this(0, ref, nombre, DESC_POR_DEFECTO, 0, cantidad, precio, 0, IVA_POR_DEFECTO, false, plataforma, GENERO_POR_DEFECTO);
    }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return Objects.equals(getReferencia(), juego.getReferencia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReferencia());
    }

    @Override
    public String toString() {
        return String.format("GAME [%s] %-20s | %-11s | %-10s | Stock: %d | Precio: %.2f€",
                getReferencia(), getNombre(), plataforma, genero, getCantidad(), getPrecio());
    }
}