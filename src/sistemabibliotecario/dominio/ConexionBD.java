/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class ConexionBD {
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String BASE_DE_DATOS = "SistemaBibliotecario";
    private static final String NOMBRE_HOST = "amigosinformaticos.ddns.net";
    private static final String PUERTO = "3306";
    private static final String URL = String.format("jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false",
            NOMBRE_HOST, PUERTO, BASE_DE_DATOS);
    private static final String NOMBRE_USUARIO = "sistBibl";
    private static final String CONTRASENA = "1wdqscaxz";
    
    public static Connection abrirConexionBD() {
        Connection conexion = null;
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager
                    .getConnection(URL, NOMBRE_USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return conexion;
    }
}
