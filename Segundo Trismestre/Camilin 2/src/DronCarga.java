public class DronCarga extends Vehiculo {

    private double pesoMaximo;
    private int numHelices;

    private static final long serialVersionUID = -9129368513958031897L;

    public DronCarga(String id, String modelo, double precioBaseDia, double pesoMaximo, int numHelices) {
        super(id, modelo, precioBaseDia);
        this.pesoMaximo = pesoMaximo;
        this.numHelices = numHelices;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNumHelices() {
        return numHelices;
    }

    @Override
    public String toString() {
        return "DronCarga{" +
                "pesoMaximo=" + pesoMaximo +
                ", numHelices=" + numHelices +
                '}';
    }
}
