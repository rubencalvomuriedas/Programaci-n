public class CocheElectrico extends Vehiculo {

    private static final long serialVersionUID = 2664607444419551263L;
    private double capacidadBateria;
    private double autonomiaRestante;
    private String comentarios;

    public CocheElectrico(String id, String modelo, double precioBaseDia, double capacidadBateria, double autonomiaRestante, String comentarios) {
        super(id, modelo, precioBaseDia);
        this.capacidadBateria = capacidadBateria;
        this.autonomiaRestante = autonomiaRestante;
        this.comentarios = comentarios;
    }

    public double getCapacidadBateria() {
        return capacidadBateria;
    }

    public double getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public void setAutonomiaRestante(double autonomiaRestante) {
        this.autonomiaRestante = autonomiaRestante;
    }

    public String getComentarios() {
        return comentarios;
    }

    @Override
    public String toString() {
        return super.toString()+
                "CocheElectrico{" +
                "capacidadBateria=" + capacidadBateria +
                ", autonomiaRestante=" + autonomiaRestante +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
