import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
    private String Titulo;
    private String Cod;
    private Genero Genero;
    private LocalDate FechaRegistro;
    private LocalDate FechaBaja;
    private LocalDateTime FechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String Titulo,String Cod,Genero Genero) {
        this.Cod = Cod;
        this.Titulo = Titulo;
        this.Genero = Genero;
        this.FechaRegistro = LocalDate.now();
        this.isAlquilada = false;
    }

    public String getCod() { return Cod; }
    public boolean isAlquilada() {
        return isAlquilada;
    }
    public void setAlquilada(boolean a) {
        isAlquilada = a;
    }
    public void setFechaAlquiler(LocalDateTime f) {
        LocalDateTime setfechaAlquiler = FechaAlquiler = f;
    }
    public LocalDateTime getFechaAlquiler() {
        return FechaAlquiler;
    }
    public void setFechaBaja(LocalDate f) {
        FechaBaja = f;
    }
    public void setIsAlquilada(boolean b) {
        this.isAlquilada = b;
    }
    public boolean getIsAlquilada() {
        return isAlquilada;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void mostrarInformacionPelicula(){
        System.out.println("-----------");
        System.out.println("--- Película ---");
        System.out.println("Título: " + Titulo);
        System.out.println("Código: " + Cod);
        System.out.println("Género: " + Genero);
        System.out.println("Fecha registro: " + FechaRegistro);
        System.out.println("Fecha baja: " + FechaBaja);
        System.out.println("Alquilada: " + (isAlquilada ? "Sí" : "No"));
        System.out.println("-----------");
    }

}
