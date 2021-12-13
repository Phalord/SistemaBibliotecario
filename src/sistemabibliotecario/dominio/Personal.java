/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class Personal extends PersonaUV {
    private String numeroPersonal;
    
    public Personal() {
        super();
        this.numeroPersonal = "";
    }
    
    public Personal(String nombre, String apellidos, String email,
            String numeroTelefono, float montoDeuda, String numeroPersonal) {
        super(nombre, apellidos, email, numeroTelefono, montoDeuda);
        this.numeroPersonal = numeroPersonal;
    }
    
    public void ponerNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }
    
    public String obtenerNumeroPersonal() {
        return this.numeroPersonal;
    }
}
