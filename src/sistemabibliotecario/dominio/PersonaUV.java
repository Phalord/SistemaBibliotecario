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
    
    public List<PrestamoDeRecurso> obtenerPrestamos() {
        return this.prestamosDeRecurso;
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
}
