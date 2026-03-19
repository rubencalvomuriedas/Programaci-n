package org.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexionBD {

    public static Connection databaseLink;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String SCHEMA = "mercadaw";
    private static final String USUARIO = "developer";
    private static final String CLAVE = "developer";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            databaseLink = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        System.out.println("Conexión exitosa a la base de datos.");

        return databaseLink;
    }
}