public class Contacto {

    private String nombre;
    private String telefono;
    private String correo;

    // Constructor
    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    // Métodos de validación sencillos
    public static boolean validarNombre(String nombre) {
        return nombre.matches("[A-Z][a-zA-Z ]*");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("[0-999][0-9][0-9][0-9]");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("[a-z0-9_.-]+@[a-z]+\\.[a-z]{2,4}");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " | Teléfono: " + telefono +
                " | Correo: " + correo;
    }
}
