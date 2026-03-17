import java.io.Serializable;

public class GerenteDep extends Persona implements Serializable {

    private static final long serialVersionUID = 4324881409554501554L;
    private double NumTrabajadoresDep;
    private Gerencia gerenciaEnum;
    private double ColtrabajadoresDep;

    public GerenteDep(String nombre, String dni, String direccion, double numTrabajadoresDep, String gerenciagerenciaEnum, double coltrabajadoresDep) {
        super(nombre, dni, direccion);
        NumTrabajadoresDep = numTrabajadoresDep;
        this.gerenciaEnum = gerenciaEnum;
        ColtrabajadoresDep = coltrabajadoresDep;
    }

    public double getNumTrabajadoresDep() {
        return NumTrabajadoresDep;
    }

    public void setNumTrabajadoresDep(double numTrabajadoresDep) {
        NumTrabajadoresDep = numTrabajadoresDep;
    }

    public Gerencia getGerencia() {
        return gerenciaEnum;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerenciaEnum = gerencia;
    }

    public double getColtrabajadoresDep() {
        return ColtrabajadoresDep;
    }

    public void setColtrabajadoresDep(double coltrabajadoresDep) {
        ColtrabajadoresDep = coltrabajadoresDep;
    }

    @Override
    public String toString() {
        return "GerenteDep{" + "super" +
                "NumTrabajadoresDep=" + NumTrabajadoresDep +
                ", gerencia=" + gerenciaEnum +
                ", ColtrabajadoresDep=" + ColtrabajadoresDep +
                '}';
    }
}

