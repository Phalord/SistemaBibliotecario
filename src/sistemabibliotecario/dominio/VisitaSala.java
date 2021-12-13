/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class VisitaSala {
    private String nombreVisitante;
    private Date fechaVisita;
    private String razon;
    
    public VisitaSala() {
        this.nombreVisitante = "";
        this.fechaVisita = null;
        this.razon = "";
    }
    
    public VisitaSala(String nombreVisitante, Date fechaVisita, String razon) {
        this.nombreVisitante = nombreVisitante;
        this.fechaVisita = fechaVisita;
        this.razon = razon;
    }
    
    public void ponerNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }
    
    public void ponerFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    
    public void ponerRazon(String razon) {
        this.razon = razon;
    }
    
    public String obtenerNombreVisitante() {
        return this.nombreVisitante;
    }
    
    public Date obtenerFechaVisita() {
        return this.fechaVisita;
    }
    
    public String obtenerRazon() {
        return this.razon;
    }
}
