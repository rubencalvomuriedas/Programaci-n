import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Datos de la cuenta.\n" +
                "2. IBAN.\n" +
                "3. Titular.\n" +
                "4. Saldo.\n" +
                "5. Ingreso.\n" +
                "6. Retirada. \n" +
                "7. Movimientos. \n" +
                "8. Salir.  ";

        String opcion = "";

        CuentaBancaria nuevaCuenta;

        System.out.print("Bienvenido a Dawbank");

        System.out.println("\nNombre:");
        String nombre = sc.nextLine();

        System.out.println("DNI:");
        String dni = sc.nextLine();

        System.out.println("Fecha nacimiento (YYYY-MM-DD):");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.println("Telefono:");
        String telefono = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();

        System.out.println("Direccion:");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(nombre, dni, fecha, telefono, email, direccion);


        String iban = obtenerIbanValido(sc);


        double saldo = 0;

        nuevaCuenta = new CuentaBancaria(iban, cliente, saldo);

        do {
            sc = new Scanner(System.in);
            System.out.print("");
            System.out.println(menu);
            System.out.print("");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println(nuevaCuenta);

                    break;
                case "2":

                    System.out.println("Introduce IBAN: " + iban);

                    break;
                case "3":

                    System.out.println("El dueño es: " + cliente);

                    break;
                case "4":

                    System.out.println("El saldo es: " + nuevaCuenta.getSaldo());

                    break;
                case "5":

                    realizarIngreso(nuevaCuenta);
                    break;

                case "6":

                    realizarRetirada(nuevaCuenta);
                    break;
                case "7":

                    nuevaCuenta.mostrarMovimientos();

                    break;
                case "8":


                    break;
            }
        } while (!opcion.equals("8"));

    }

    private static void realizarIngreso(CuentaBancaria nuevaCuenta) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad a ingresar: ");
        double cantidadIngresada = sc.nextDouble();
        nuevaCuenta.Ingreso(cantidadIngresada);
    }

    private static void realizarRetirada(CuentaBancaria nuevaCuenta) throws MinimoCuenta {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Cantidad a retirar: ");
            double cantidadRetirada = sc.nextDouble();
            nuevaCuenta.Retiro(cantidadRetirada);
        } catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        }
    }
    private static String obtenerIbanValido(Scanner scanner){
        String IBAN = scanner.nextLine();
        while (true) {
            System.out.println("Ingrese el IBAN de la cuenta : ");
            IBAN = scanner.nextLine();
            if (validarIBAN (IBAN)) {
                return IBAN;
            }
            System.out.println("IBAN inválido.Introducelo de nuevo");
        }
    }

    private static boolean validarIBAN(String IBAN) {
        return IBAN.matches("[A-Z]{2}\\d{22}");
    }


}
