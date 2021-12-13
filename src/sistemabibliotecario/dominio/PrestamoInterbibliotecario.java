/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class PrestamoInterbibliotecario {
    private String bibliotecaPrestadora;
    private Date fechaVencimiento;
    private Date fechaExpedicion;
    private Date fechaDevolucion;
    
    public void ponerBibliotecaPrestadora(String biblioteca) {
        this.bibliotecaPrestadora = biblioteca;
    }
    
    public void ponerFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public void ponerFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    public void ponerfechaDevolucion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    public String obtenerBibliotecaPrestadora() {
        return this.bibliotecaPrestadora;
    }
    
    public Date obtenerFechaVencimiento() {
        return this.fechaVencimiento;
    }
    
    public Date obtenerFechaExpedicion() {
        return this.fechaExpedicion;
    }
    
    public Date obtenerFechaDevolucion() {
        return this.fechaDevolucion;
    }
}
