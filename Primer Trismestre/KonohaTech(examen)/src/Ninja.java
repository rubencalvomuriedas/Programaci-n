import java.time.LocalDate;

public class Ninja {
    private boolean idNinja;
    private String TecnicaSecreta;
    private LocalDate FechaAlta;
    private double Ataque = 0;
    private double Defensa = 0;
    private int i;

    public Ninja(String tecnicaSecreta, LocalDate fechaAlta, double ataque, double defensa) {
        TecnicaSecreta = tecnicaSecreta;
        FechaAlta = fechaAlta;
        Ataque = ataque;
        Defensa = defensa;
    }

    public Ninja(String tecnicaSecreta) {
        TecnicaSecreta = tecnicaSecreta;
    }

    public boolean getIdNinja() {
        return idNinja;
    }

    public String getTecnicaSecreta() {
        return TecnicaSecreta;
    }

    public LocalDate getFechaAlta() {
        return FechaAlta;
    }

    public double getAtaque() {
        return Ataque;
    }

    public double getDefensa() {
        return Defensa;
    }

    public void setIdNinja(boolean idNinja) {
        this.idNinja = idNinja;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        FechaAlta = fechaAlta;
    }

    public void setAtaque(double ataque) {
        Ataque = ataque;
    }

    public void setDefensa(double defensa) {
        Defensa = defensa;
    }

    public boolean registrarNinja(Ninja n) {

        Ninja[] registrarNinja = new Ninja[0];
        for (Ninja nin : registrarNinja)
            if (nin != null)
                if (nin.getIdNinja()) {
                    System.out.println("ERROR: Ya existe un ninja con ese ID.");
                    return false;
                }

        Ninja[] Ninja = null;
        if (Ninja[i] == null) {

            Ninja = new Ninja[0];
            Ninja[i] = n;
            System.out.println("Ninja registrado correctamente.");
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "idNinja=" + idNinja +
                ", TecnicaSecreta='" + TecnicaSecreta + '\'' +
                ", FechaAlta=" + FechaAlta +
                ", Ataque=" + Ataque +
                ", Defensa=" + Defensa +
                ", i=" + i +
                '}';
    }
}