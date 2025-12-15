import java.time.LocalDate;

public class Aldea {
    private String nombre;
    private String codigo;
    private LocalDate FechaCreacion;
    private int MaxEquipos;

    public Aldea(String nombre, String codigo, LocalDate fechaCreacion, int maxEquipos) {
        this.nombre = nombre;
        this.codigo = codigo;
        FechaCreacion = fechaCreacion;
        MaxEquipos = maxEquipos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getMaxEquipos() {
        return MaxEquipos;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Aldea{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", FechaCreacion=" + FechaCreacion +
                '}';
    }
}

