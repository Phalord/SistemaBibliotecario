/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class Estudiante extends PersonaUV {
    public static final String INSCRITO = "Inscrito";
    public static final String NO_INSCRITO = "No Inscrito";
    
    private String matricula;
    private String estado;
    
    public Estudiante() {
        super();
        this.matricula = "";
        this.estado = Estudiante.NO_INSCRITO;
    }
    
    public Estudiante(String nombre, String apellidoMaterno, String apellidoPaterno,
            String email, String numeroTelefono, float montoDeuda, String matricula, String estado) {
        super(nombre, apellidoMaterno, apellidoPaterno, email,
                numeroTelefono, montoDeuda, PersonaUV.ESTUDIANTE);
        this.matricula = matricula;
        this.estado = estado;
    }
    
    public void ponerMatricula(String matricula) {
        this.matricula = matricula;
        super.ponerIdentificador(matricula);
    }
    
    public void ponerEstado(String estado) {
        this.estado = estado;
    }
    
    public String obtenerMatricula() {
        return this.matricula;
    }
    
    public String obtenerEstado() {
        return this.estado;
    }
}
