import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("Fanta", 6);
        Producto p2 = new Producto("Agua", 8);
        Producto p3 = new Producto("CocaCola", 4);
        Producto p4 = new Producto("Zumo", 3);
        Producto p5 = new Producto("Limonada", 9);

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        Iterator<Producto> itera = productos.iterator();
        while(itera.hasNext()){
            System.out.println(itera.next());
        }

        productos.remove(p1);
        productos.remove(p5);

        int mitad = productos.size() / 2;
        Producto nuevoMedio = new Producto("Vino", 5) ;
        productos.add(mitad, nuevoMedio);

        System.out.println("\n<------------>");

        itera = productos.iterator();
        while(itera.hasNext()){
            System.out.println(itera.next());
        }

        productos.sort(null);

        System.out.println("\n Lista ordenada de productos: ");
        Iterator<Producto> iterar = productos.iterator();
        while (iterar.hasNext()) {
            System.out.println(iterar.next());
        }
        productos.clear();

        //LinkedList

    Producto pr1 = new Producto("Pan", 10);
    Producto pr2 = new Producto("Verdura", 5);
    Producto pr3 = new Producto("Fruta", 8);
    Producto pr4 = new Producto("Carne", 12);
    Producto pr5 = new Producto("Pescado", 20);

    LinkedList<Producto> lista = new LinkedList<>();
    
        lista.add(pr1);
        lista.add(pr2);
        lista.add(pr3);
        lista.add(pr4);
        lista.add(pr5);

        System.out.println("Contenido inicial:");
    Iterator<Producto> it = lista.iterator();
        while (it.hasNext()) {
        Producto p = it.next();
        System.out.println(p.getNombre() + " - " + p.getCantidad());
    }

        lista.remove(4);
        lista.remove(2);

    Producto nuevo = new Producto("Leche", 15);
        lista.add(lista.size() / 2, nuevo);


        System.out.println("\n Nueva Lista:");
    it = lista.iterator();
        while (it.hasNext()) {
        Producto p = it.next();
        System.out.println(p.getNombre() + " - " + p.getCantidad());
    }

        Collections.sort(lista);

        System.out.println("\n Lista ordenada:");
    it = lista.iterator();
        while (it.hasNext()) {
        Producto p = it.next();
        System.out.println(p.getNombre() + " - " + p.getCantidad());
    }
        lista.clear();

        System.out.println("\n Lista vacía: " + lista.size());
    }
}


