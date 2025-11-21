import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a DawBank");

        String iban;
        do {
            System.out.print("Introduzca IBAN: ");
            iban = sc.nextLine();
            if (!CuentaBancaria.validarIBAN(iban)) {
                System.out.println("IBAN no válido (debe empezar por dos letras y tiene que tener 22 digitos). Intente de nuevo.");
            }
        } while (!CuentaBancaria.validarIBAN(iban));

        System.out.print("Introduzca titular: ");
        String titular = sc.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(titular, iban);

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("\n MENÚ ");
            System.out.println("1. Ver datos");
            System.out.println("2. Ver IBAN");
            System.out.println("3. Ver titular");
            System.out.println("4. Ver saldo");
            System.out.println("5. Ingresar");
            System.out.println("6. Retirar");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.print("Elige opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    cuenta.mostrarDatos();
                    break;

                case 2:
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    break;

                case 3:
                    System.out.println("Titular: " + cuenta.gettitular());
                    break;

                case 4:
                    System.out.println("Saldo: " + cuenta.getsaldo() + "€");
                    break;

                case 5:
                    System.out.print("Cantidad a ingresar: ");
                    double ing = Double.parseDouble(sc.nextLine());
                    if (cuenta.ingresar(ing)) System.out.println("Ingreso realizado.");
                    else System.out.println("No se pudo ingresar.");
                    break;

                case 6:
                    System.out.print("Cantidad a retirar: ");
                    double ret = Double.parseDouble(sc.nextLine());
                    if (cuenta.retirar(ret)) System.out.println("Retirada realizada.");
                    else System.out.println("No se pudo retirar.");
                    break;

                case 7:
                    cuenta.mostrarMovimientos();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}