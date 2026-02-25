import java.io.*;
import java.util.*;

public class Biblioteca {

    private Map<String, Libro> libros;
    private final String FICHERO = "Biblioteca.dat";

    public Biblioteca() {
        libros = new HashMap<>();
        cargar();
    }

    public void agregarLibro(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            throw new IllegalArgumentException("El ISBN ya existe.");
        }
        libros.put(libro.getIsbn(), libro);
    }

    public void eliminarLibro(String isbn) {
        if (libros.remove(isbn) == null) {
            throw new NoSuchElementException("No existe un libro con ese ISBN.");
        }
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.values().forEach(System.out::println);
        }
    }

    public void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FICHERO))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero.");
        }
    }

    @SuppressWarnings("unchecked")
    private void cargar() {
        File f = new File(FICHERO);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FICHERO))) {
            libros = (Map<String, Libro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el fichero.");
        }
    }
}