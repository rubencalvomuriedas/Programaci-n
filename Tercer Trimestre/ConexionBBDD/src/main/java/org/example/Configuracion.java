package org.example;

import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

    private static Properties props = new Properties();

    static {
        try {
            InputStream is = Configuracion.class
                    .getClassLoader()
                    .getResourceAsStream("application.dat");

            if (is == null) {
                throw new RuntimeException("No se encontró application.dat");
            }

            props.load(is);

        } catch (Exception e) {
            System.out.println("Error cargando configuración: " + e.getMessage());
        }
    }

    public static String get(String clave) {
        return props.getProperty(clave);
    }
}