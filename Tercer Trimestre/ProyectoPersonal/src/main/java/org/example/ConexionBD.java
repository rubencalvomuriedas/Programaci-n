package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection getConnection() throws SQLException {

        String driver = Configuracion.get("driver");
        String url = Configuracion.get("url");
        String schema = Configuracion.get("schema");
        String user = Configuracion.get("user");
        String pass = Configuracion.get("password");

        if  (driver==null || url == null || schema==null || user == null || pass == null) {
            throw new SQLException("Error crítico: Faltan parámetros (driver, url, schema, user o password) en el archivo .dat");
        }

        try {
            return DriverManager.getConnection(url+schema, user, pass);
        } catch (SQLException e) {
            System.err.println("Error de conexión (Verifica si MySQL está activo): " + e.getMessage());
            throw e;
        }
    }
}