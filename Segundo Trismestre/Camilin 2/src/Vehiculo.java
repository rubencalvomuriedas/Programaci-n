import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 4807033814688750657L;

    private static final DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter dtfCompleto = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String id;
    private String modelo;
    private double precioBaseDia;
    private boolean disponible;

    private LocalDate fechaDevolucion;
    private LocalDateTime fechaAlquiler;

    public Vehiculo(String id, String modelo, double precioBaseDia) {
        this.id = id;
        this.modelo = modelo;
        this.precioBaseDia = precioBaseDia;
        this.disponible = true;
        this.fechaDevolucion = null;
        this.fechaAlquiler = null;
    }

    public String getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioBaseDia() {
        return precioBaseDia;
    }

    public void setPrecioBaseDia(double precioBaseDia) {
        this.precioBaseDia = precioBaseDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void alquilar(LocalDate fechaDevolucion) {
        this.disponible = false;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaAlquiler = LocalDateTime.now();
    }

    public void devolver() {
        this.disponible = true;
        this.fechaDevolucion = null;
        this.fechaAlquiler = null;
    }

    @Override
    public String toString() {

        String fechaAlquilerStr = (fechaAlquiler == null) ? "N/A" : fechaAlquiler.format(dtfCompleto);
        String fechaDevolucionStr = (fechaDevolucion == null) ? "N/A" : fechaDevolucion.format(Fecha);

        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precioBaseDia=" + precioBaseDia +
                ", disponible=" + disponible +
                ", fechaAlquiler=" + fechaAlquilerStr +
                ", fechaDevolucion=" + fechaDevolucionStr +
                '}';
    }
}