import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

    // 1. Crear 5 instancia de producto:
    Producto p1 = new Producto("Manazanas",10);
    Producto p2 = new Producto("Peras", 5);
    Producto p3 = new Producto("Naranjas",20);
    Producto p4 = new Producto("Platanos",15);
    Producto p5 = new Producto("Limones",8);

    // 2. Crear un ArrayList:
    ArrayList<Producto>listaProductos = new ArrayList<>();

    // 3. Añadir los 5 productos al ArrayList:

    listaProductos.add(p1);
    listaProductos.add(p2);
    listaProductos.add(p3);
    listaProductos.add(p4);
    listaProductos.add(p5);

    // 4. Visualizar el contenido usando Iterator:

    System.out.println("contenido");
        Iterator<Producto>itera=listaProductos.iterator();
        while (itera.hasNext()){
            System.out.println(itera.next());
        }

    // 5. Elimina dos elementos del ArrayList:

    listaProductos.remove(0);
    listaProductos.remove(5);


    // 6. Insertar un nuevo producto en medio de la lista:

    Producto nuevo = new Producto("Fresas",12);
    listaProductos.add(listaProductos.size()/2, nuevo);

    // 7. Visualizar de nuevo el contenido usando iterator:

    System.out.println("\n Ver lista de nuevo");
    itera = listaProductos.iterator();
    while (itera.hasNext()){
        System.out.println(itera.next());
    }

    // 8. Ordenar la lista por nombre:


    }
}