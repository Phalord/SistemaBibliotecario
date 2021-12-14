/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.util.List;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class PersonaUV {
    private int clave;
    private String identificador;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombre;
    protected String email;
    protected String domicilio;
    protected String numeroTelefono;
    protected float montoDeuda;
    List<PrestamoDeRecurso> prestamosDeRecurso;
    
    public PersonaUV() {
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.email = "";
        this.numeroTelefono = "";
        this.montoDeuda = 0.0f;
    }
    
    public PersonaUV(String nombre, String apellidoMaterno, String apellidoPaterno,
            String email, String numeroTelefono, float montoDeuda) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.montoDeuda = montoDeuda;
    }
    
    public void asignarPrestamo(PrestamoDeRecurso prestamoDeRecuros) {
        this.prestamosDeRecurso.add(prestamoDeRecuros);
    }
    
    public void pagarDeuda(float montoPago) {
        this.montoDeuda -= montoPago;
    }
    
    public float calcularDeuda() {
        float deudaTotal = 0.0f;
        for (PrestamoDeRecurso prestamo : this.prestamosDeRecurso) {
            deudaTotal += prestamo.calcularMontoDeuda();
        }
        return deudaTotal;
    }
    
    public void ponerClave(int clave) {
        this.clave = clave;
    }
    
    public void ponerIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public void ponerApellidoMaterno(String apellido) {
        this.apellidoMaterno = apellido;
    }
    
    public void ponerApellidoPaterno(String apellido) {
        this.apellidoPaterno = apellido;
    }
    
    public void ponerNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void ponerEmail(String email) {
        this.email = email;
    }
    
    public void ponerDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public void ponerNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    public void ponerMontoDeuda(float montoDeuda) {
        this.montoDeuda = montoDeuda;
    }
    
    public void ponerPrestamos(List<PrestamoDeRecurso> prestamosDeRecurso) {
        this.prestamosDeRecurso = prestamosDeRecurso;
    }
    
    public int obtenerClave() {
        return this.clave;
    }
    
    public String obtenerIdentificador() {
        return this.identificador;
    }
    
    public String obtenerApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public String obtenerApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public String obtenerEmail() {
        return this.email;
    }
    
    public String obtenerDomicilio() {
        return this.domicilio;
    }
    
    public String obtenerNumeroTelefono() {
        return this.numeroTelefono;
    }
    
    public float obtenerMontoDeuda() {
        return this.montoDeuda;
    }
    
    public List<PrestamoDeRecurso> obtenerPrestamos() {
        return this.prestamosDeRecurso;
    }
}
