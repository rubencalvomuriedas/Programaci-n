import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Contacto {

    private String nombre;
    private String telefono;
    private String correo;

    public Contacto (String nombre, String telefono, String correo){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
    public static boolean validaNombre(String nombre) {
        return nombre.matches("[A-Z][a-zA-Z]*");
    }
    public static boolean validaTelefono(String telefono) {
        return telefono.matches("[679][0-9]{8}");
    }
    public static boolean validaCorreo(String correo) {
        boolean matches = correo.matches("[a-zA-Z0-9_.-]+@[a-zA-Z]+[a-zA-Z]{2,4}");
        return matches;
    }
}
