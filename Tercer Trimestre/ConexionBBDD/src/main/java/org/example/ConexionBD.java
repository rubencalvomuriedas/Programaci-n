package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws Exception {

        Class.forName(DRIVER);

        String url = Configuracion.get("url");
        String user = Configuracion.get("user");
        String pass = Configuracion.get("password");

        if (url == null || user == null || pass == null) {
            throw new Exception("Faltan datos de configuración");
        }

        return DriverManager.getConnection(url, user, pass);
    }
} 