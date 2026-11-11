package com.cidead.pmdm.altocampo.Conectar;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    public static Connection conexion() throws IOException, SQLException {
        Properties propiedades = new Properties();
        InputStream flujoEntrada = Conexion.class.getResourceAsStream("/Datos/acceso.properties");
        if (flujoEntrada == null) {
            throw new IOException("No se encontró el archivo /conexion.properties");
        }
        try (InputStream entrada = flujoEntrada) {
            propiedades.load(entrada);
        }
        String url = propiedades.getProperty("url");
        String usuario = propiedades.getProperty("user");
        String contrasena = propiedades.getProperty("password");
        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
