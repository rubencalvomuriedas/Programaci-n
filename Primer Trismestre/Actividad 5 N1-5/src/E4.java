import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {

    /* Ejericico 4: Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas
    ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
    mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me mima” dirá que hay:
    Nº de A's: 3
    Nº de E's: 1
    Nº de I's: 2
    Nº de O's: 0
    Nº de U's: 0
     */
        Scanner sc = new Scanner(System.in);

        String frase;
        int a, e, i, o, u, cont;

        a = 0;
        e = 0;
        i = 0;
        o = 0;
        u = 0;

        System.out.println("Por favor inserte su frase: ");
        frase = sc.nextLine();

        frase = frase.toLowerCase();

        for (cont = 0; cont < frase.length(); cont++) {
            switch (frase.charAt(cont)) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
            }
        }

        System.out.println("El número de 'a' es: " + a);
        System.out.println("El número de 'e' es: " + e);
        System.out.println("El número de 'i' es: " + i);
        System.out.println("El número de 'o' es: " + o);
        System.out.println("El número de 'u' es: " + u);
    }
}