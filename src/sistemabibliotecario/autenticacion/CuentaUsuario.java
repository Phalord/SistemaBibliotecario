/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.autenticacion;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class CuentaUsuario {
    public static final String BIBLIOTECARIO = "Bibliotecario";
    public static final String SECRETARIA = "Secretaria";
    public static final String DIRECTOR = "Director";
    
    private String nombreUsuario;
    private String contrasena;
    private String tipo;
    
    public void ponerNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void ponerContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void ponerTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public String obtenernombreUsuario() {
        return this.nombreUsuario;
    }
    
    public String obtenerContrasena() {
        return this.contrasena;
    }
    
    public String obtenerTipo() {
        return this.tipo;
    }
}
