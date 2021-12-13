/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class PrestamoDeRecurso {
    public static final String ACTIVO = "Activo";
    public static final String RECURSO_DEVUELTO = "Recurso devuelto";
    public static final String ATRASADO = "Atrasado";
    
    private String estado;
    private Date fechaDeDevolucion;
    private Date fechaDePrestamo;
    private Date fechaDeVencimiento;
    private PersonaUV personaUV;
    private RecursoDocumental recursoDocumental;
    
    public PrestamoDeRecurso() {
        this.estado = "";
        this.fechaDeDevolucion = null;
        this.fechaDePrestamo = null;
        this.fechaDeVencimiento = null;
        this.personaUV = null;
        this.recursoDocumental = null;
    }
    
    public PrestamoDeRecurso(String estado, Date fechaDeDevolucion,
            Date fechaDePrestamo, Date fechaDeVencimiento,
            PersonaUV personaUV, RecursoDocumental recursoDocumental) {
        this.estado = estado;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.fechaDePrestamo = fechaDePrestamo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.personaUV = personaUV;
        this.recursoDocumental = recursoDocumental;
    }
    
    public float calcularMontoDeuda() {
        float montoDeuda = 0.0f;
        
        if (fechaDeDevolucion == null) {
            LocalDate hoy = LocalDate.now();
            LocalDate fechaDeVencimientoAux =
                    this.fechaDeVencimiento.toLocalDate();
            double dias = Duration.between(hoy.atStartOfDay(),
                    fechaDeVencimientoAux.atStartOfDay()).toDays();
            
            montoDeuda = (int) dias; // La FEI cobra $1 por día de retraso en todos los recursos documentales.
        }
        
        return montoDeuda;
    }
    
    public void devolver() {
        if (!this.estado.equals(PrestamoDeRecurso.RECURSO_DEVUELTO)) {
            estado = PrestamoDeRecurso.RECURSO_DEVUELTO;
        }
    }
    
    public void ponerFechaDeDevolucion(Date fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }
    
    public void ponerFechaDePrestamo(Date fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }
    
    public void ponerFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    
    public void ponerPersonaUV(PersonaUV personaUV) {
        this.personaUV = personaUV;
    }
    
    public void ponerRecursoDocumental(RecursoDocumental recursoDocumental) {
        this.recursoDocumental = recursoDocumental;
    }
    
    public Date obtenerFechaDeDevolucion() {
        return this.fechaDeDevolucion;
    }
    
    public Date obtenerFechaDePrestamo() {
        return this.fechaDePrestamo;
    }
    
    public Date obtenerFechaDeVencimiento() {
        return this.fechaDeVencimiento;
    }
    
    public PersonaUV obtenerPersonaUV() {
        return this.personaUV;
    }
    
    public RecursoDocumental obtenerRecursoDocumental() {
        return this.recursoDocumental;
    }
}
