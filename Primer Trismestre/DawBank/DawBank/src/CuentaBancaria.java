public class CuentaBancaria {


    private String titular;
    private String IBAN;
    private double saldo;
    private Movimiento[] movimientos;
    private int numMovimientos;

    public CuentaBancaria(String titular, String IBAN) {
        this.titular = titular;
        this.IBAN = IBAN;
        this.saldo =0;
        this.movimientos = new Movimiento[100];
        this.numMovimientos = 0;
    }
    public String getIBAN() {return IBAN; }
    public String gettitular() {return titular; }
    public double getsaldo() {return saldo; }
    private void registrarmovimiento(Movimiento m){
        if (numMovimientos <100){
            movimientos[numMovimientos++] = m;
        }
    }
    public void mostrarMovimientos(){
        if (numMovimientos == 0);
        System.out.println("No hay movimientos registrados");
        return;
    }
    for (int i = 0; i < numMovimientos; i++){
        movimientos[i].mostrarMovimientos();
    }
    public void Ingresar(double cantidad, String fecha){
        if (cantidad <= 0){
            System.out.println("Cantidad Erronea");
            return;
        }
        saldo += cantidad;
        registrarmovimiento(new Movimiento(fecha, "Ingreso", cantidad));
        if (cantidad <=)
    }
}

