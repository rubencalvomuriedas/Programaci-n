import java.time.LocalDate;

public class Equipo {
    private String nombreEquipo;
    private LocalDate FechaCreacion;
    private Sensei tipoSensei;
    private int MaximoNinjas;

    public Equipo(String nombreEquipo, LocalDate fechaCreacion, Sensei tipoSensei, int maximoNinjas) {
        this.nombreEquipo = nombreEquipo;
        FechaCreacion = fechaCreacion;
        this.tipoSensei = tipoSensei;
        MaximoNinjas = maximoNinjas;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public int getMaximoNinjas() {
        return MaximoNinjas;
    }

    public void setMaximoNinjas(int maximoNinjas) {
        MaximoNinjas = maximoNinjas;
    }

    public Sensei getTipoSensei() {
        return tipoSensei;
    }

    public void setTipoSensei(Sensei tipoSensei) {
        this.tipoSensei = tipoSensei;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", tipoSensei=" + tipoSensei +
                ", FechaCreacion=" + FechaCreacion +
                '}';
    }
}
