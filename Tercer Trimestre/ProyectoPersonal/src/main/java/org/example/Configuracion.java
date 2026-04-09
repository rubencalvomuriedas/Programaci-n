package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

    private static final String ARCHIVO_CONFIG = "application.dat";
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Configuracion.class
                .getClassLoader()
                .getResourceAsStream(ARCHIVO_CONFIG)) {

            if (is == null) {
                throw new IOException("No se pudo encontrar el archivo: " + ARCHIVO_CONFIG);
            }

            props.load(is);

        } catch (IOException e) {
            System.err.println("Error crítico cargando configuración: " + e.getMessage());
        }
    }
    public static String get(String clave) {
        return props.getProperty(clave);
    }
}