public class Movimiento {

    private int contadorID;
    private int id;
    private String fecha;
    private String tipo;

    private double cantidad;

    public Movimiento(String fecha, String tipo, double cantidad) {
        this.id = contadorID++;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public void mostrarMovimientos(){
        System.out.println("ID" + id);
        System.out.println("Fecha" + fecha);
        System.out.println("Tipo" + tipo);
        System.out.println("Cantidad" + cantidad);
        System.out.println("--------------------------------------------------------");
    }
}
