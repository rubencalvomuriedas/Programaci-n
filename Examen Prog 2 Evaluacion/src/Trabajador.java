import java.io.Serializable;

public class Trabajador extends Persona implements Serializable {

    private static final long serialVersionUID = 1404480466975884193L;
    private double numeroSS;
    private String email;
    private double salario;
    private String departamentoEnum;


    public Trabajador(String nombre, String dni, String direccion, double numeroSS, String email, double salario, String departamentoEnum) {
        super(nombre, dni, direccion);
        this.numeroSS = numeroSS;
        this.email = email;
        this.salario = salario;
        this.departamentoEnum = departamentoEnum;
    }

    public double getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(double numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamentoEnum() {
        return departamentoEnum;
    }

    public void setDepartamentoEnum(String departamentoEnum) {
        this.departamentoEnum = departamentoEnum;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "super" +
                "numeroSS='" + numeroSS + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", departamento=" + departamentoEnum +
                '}';
    }
}
