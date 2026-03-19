package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection databaseLink;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            String url = Configuracion.get("url");
            String user = Configuracion.get("user");
            String pass = Configuracion.get("password");

            databaseLink = DriverManager.getConnection(url, user, pass);

            System.out.println("Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return databaseLink;
    }
}