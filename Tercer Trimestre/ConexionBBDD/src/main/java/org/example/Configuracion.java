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

            props.load(is);

        } catch (Exception e) {
            System.out.println("Error cargando configuración");
        }
    }

    public static String get(String clave) {
        return props.getProperty(clave);
    }
}
