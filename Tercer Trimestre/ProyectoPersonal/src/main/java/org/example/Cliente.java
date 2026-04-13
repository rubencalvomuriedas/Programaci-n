package org.example;

public class Cliente {
    private int id;
    private String dni;
    private String nombre;
    private String direccion;

    public Cliente(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
}