/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

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
    
    public Personal(String numeroPersonal, String nombre, String apellidoMaterno, String apellidoPaterno,
            String email, String numeroTelefono, float montoDeuda) {
        super(nombre, apellidoMaterno, apellidoPaterno,
                email, numeroTelefono, montoDeuda, PersonaUV.PERSONAL);
        this.numeroPersonal = numeroPersonal;
    }
    
    public void ponerNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
        super.ponerIdentificador(numeroPersonal);
    }
    
    public String obtenerNumeroPersonal() {
        return this.numeroPersonal;
    }
}
