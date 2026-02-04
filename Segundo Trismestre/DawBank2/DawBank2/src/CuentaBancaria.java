import java.util.ArrayList;
import java.util.Iterator;

public class CuentaBancaria {

    private String iban;
    private Cliente cliente;
    private double saldo;

    ArrayList<Movimiento> nuevoMovimientos = new ArrayList<>();

    public CuentaBancaria(String iban, Cliente cliente, double saldo) {
        this.iban = iban;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void Ingreso (double cantidad) {
        double limite = 3000;
        if (cantidad <= 0) {
            System.out.println("\nLa cantidad debe ser mayor o igual a 0");
            return;
        }

        if (cantidad >= limite) {
            System.out.println("\nAVISO: Cantidad superior a la permitida. Avisando a Hacienda");
        }

        System.out.println("\nCantidad procesada correctamente: " + cantidad + "\nEsperando...");

        saldo += cantidad;
        agregarMovimientos(new Movimiento(TipoMovimiento.Ingreso, cantidad));
        System.out.println(
                "\nMovimiento confirmado" +
                        "\nUsted ha retirado: " + cantidad + "$" +
                        "\nDe la cuenta: " + iban
        );

    }
    public void Retiro (double cantidad){
        double minimo = -50;
        if (cantidad <= 0){
            System.out.println("\n cantidad de dinero debe ser mayor o igual a 0");
            return;
        }
        if (saldo - cantidad < minimo) {
            throw new MinimoCuenta(
                    "Movimiento no permitido. No puede superar la cantidad"
            );
        }
        saldo -= cantidad;
        agregarMovimientos(new Movimiento(TipoMovimiento.Retirada, cantidad));
        System.out.println(
                "\nMovimiento confirmado" +
                        "\nUsted ha retirado: " + cantidad + "$" +
                        "\nDe la cuenta: " + iban
        );
    }
    public void agregarMovimientos(Movimiento mov){
        nuevoMovimientos.add(mov);
    }
    public void mostrarMovimientos() {
        if (nuevoMovimientos.isEmpty()) {
            System.out.println("\nNo hay movimientos registrados");
            return;
        }
        System.out.println("\nMostrando movimientos: ");
        Iterator<Movimiento> itera = nuevoMovimientos.iterator();
        while (itera.hasNext()) {
            System.out.println(itera.next());
        }
    }
    @Override
    public String toString() {
        return "\n<---CuentaBancaria--->" +
                "\nIBAN: " + iban +
                "\n" + cliente +
                "\nSaldo: " + saldo +
                "\n>>>>>>>>>>>><<<<<<<<<<<";
    }
}

