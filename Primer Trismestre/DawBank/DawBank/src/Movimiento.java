import java.time.LocalDate;

public class Movimiento {

    public enum TipoMovimiento {
        INGRESO, RETIRADA
    }
    private int id;
    private TipoMovimiento tipo;
    private String fecha;;
    private double cantidad;

    public Movimiento(int id, TipoMovimiento tipo, double cantidad) {
        this.id = id;
        this.fecha = LocalDate.now().toString();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public void mostrarMovimientos(){
        System.out.println("---------");
        System.out.println("ID" + id);
        System.out.println("Fecha: " + fecha);
        System.out.println("Tipo: " + tipo);
        System.out.println("Cantidad: " + cantidad + "€");
        System.out.println("---------");
    }
}
