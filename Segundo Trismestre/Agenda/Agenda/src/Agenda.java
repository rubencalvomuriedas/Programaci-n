import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void añadirContacto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        if (!Contacto.validarNombre(nombre)){
            System.out.println("Nombre Incorrecto. ");
            return;
        }

        if (existeContacto(nombre)){
            System.out.println("El contacto ya existe. ");
            return;
        }

        System.out.println("correo: ");
        String correo = sc.nextLine();

        if (!Contacto.validarCorreo(correo)){
            System.out.println("Correo incorrecto. ");
        }

        String telefono = null;
        Contacto c = new Contacto(nombre, telefono, correo);
        contactos.add(c);
        System.out.println("Contacto añadido correctamente. ");
    }

    public void buscarContacto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre que deseas buscar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < contactos.size(); i++){
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                System.out.println(contactos.get(i));
                return;
            }
            System.out.println("Contacto no encontrado. ");
        }
    }

    public void eliminarContacto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre a eliminar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void mostrarAgenda() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println(contactos.get(i));
            }
        }
    }

    public int numeroContactos() {
        return contactos.size();
    }

    private boolean existeContacto(String nombre) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}