import java.io.Serializable;

public class Director extends Persona implements Serializable {

    private static final long serialVersionUID = 3134520518786193226L;
    private double Telefono;
    private String CocheEmpresa;

    public Director(String nombre, String dni, String direccion, double telefono, String cocheEmpresa) {
        super(nombre,dni, direccion);
        Telefono = telefono;
        CocheEmpresa = cocheEmpresa;
    }

    public double getTelefono() {
        return Telefono;
    }

    public void setTelefono(double telefono) {
        Telefono = telefono;
    }

    public String getCocheEmpresa() {
        return CocheEmpresa;
    }

    public void setCocheEmpresa(String cocheEmpresa) {
        CocheEmpresa = cocheEmpresa;
    }

    @Override
    public String toString() {
        return "Director{" +
                "Telefono=" + Telefono +
                ", CocheEmpresa='" + CocheEmpresa + '\'' +
                '}';
    }
}
