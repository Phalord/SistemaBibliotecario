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
    protected String apellidos;
    protected String nombre;
    protected String email;
    protected String domicilio;
    protected String numeroTelefono;
    protected float montoDeuda;
    List<PrestamoDeRecurso> prestamosDeRecurso;
    
    public PersonaUV() {
        this.nombre = "";
        this.apellidos = "";
        this.email = "";
        this.numeroTelefono = "";
        this.montoDeuda = 0.0f;
    }
    
    public PersonaUV(String nombre, String apellidos, String email,
            String numeroTelefono, float montoDeuda) {
        this.nombre = nombre;
        this.apellidos = apellidos;
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
    
    public void ponerApellidos(String apellidos) {
        this.apellidos = apellidos;
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
    
    public String obtenerApellidos() {
        return this.apellidos;
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
