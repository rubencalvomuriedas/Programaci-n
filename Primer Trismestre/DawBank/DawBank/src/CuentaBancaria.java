public class CuentaBancaria {


    private String titular;
    private String IBAN;
    private double saldo;
    private Movimiento[] movimientos;
    private int contadorMovimientos;

    public static final int NUMERO_MAXIMO_DE_MOVIMIENTOS=100;
    public CuentaBancaria(String titular, String IBAN) {
        this.titular = titular;
        this.IBAN = IBAN;
        this.saldo =0;
        movimientos = new Movimiento[NUMERO_MAXIMO_DE_MOVIMIENTOS];
        contadorMovimientos = 0;
    }
    public String getIBAN() {return IBAN; }
    public String gettitular() {return titular; }
    public double getsaldo() {return saldo; }
    public static boolean validarIBAN(String iban) {
        if (iban.length() < 6) return false;
        return Character.isLetter(iban.charAt(0)) &&
                Character.isLetter(iban.charAt(1));
    }

    private void registrarMovimiento(Movimiento.TipoMovimiento tipo, double cantidad) {
        if (contadorMovimientos < NUMERO_MAXIMO_DE_MOVIMIENTOS) {
            movimientos[contadorMovimientos] = new Movimiento(contadorMovimientos + 1, tipo, cantidad);
            contadorMovimientos++;
        }
    }

    public boolean ingresar(double cantidad) {
        if (cantidad <= 0) return false;
        if (contadorMovimientos >= NUMERO_MAXIMO_DE_MOVIMIENTOS) return false;

        saldo += cantidad;
        registrarMovimiento(Movimiento.TipoMovimiento.INGRESO, cantidad);
        return true;
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= 0) return false;
        if (contadorMovimientos >= NUMERO_MAXIMO_DE_MOVIMIENTOS) return false;

        if (saldo - cantidad < -50) return false; // límite de descubierto

        saldo -= cantidad;
        registrarMovimiento(Movimiento.TipoMovimiento.RETIRADA, cantidad);
        return true;
    }

    public void mostrarDatos() {
        System.out.println("IBAN: " + IBAN);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo + "€");
        if (saldo < 0) System.out.println("AVISO: Saldo negativo");
    }

    public void mostrarMovimientos() {
        if (contadorMovimientos == 0) {
            System.out.println("No hay movimientos.");
            return;
        }

        for (int i = 0; i < contadorMovimientos; i++) {
            movimientos[i].mostrarMovimientos();
        }
    }
}

