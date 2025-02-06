package org.base.apps.empresariales;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_base";
        String usuario = "root";
        String contraseña = "12345";
        String rutaSQL = Main.class.getResource("/script.sql").getPath();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Reader reader = new FileReader(rutaSQL)) {

            ScriptRunner scriptRunner = new ScriptRunner(conexion);
            scriptRunner.setLogWriter(null); // Opcional: No mostrar logs en consola
            scriptRunner.runScript(reader);

            System.out.println("Archivo SQL ejecutado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
