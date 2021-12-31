/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class CopiaRecurso {
    public static final String PRESTADA = "Prestada";
    public static final String DISPONIBLE = "Disponible";
    public static final String EN_REPARACION = "En Reparacion";
            
    private String idCopia;
    private String estado;
    private String codigoDeClasificacion;
    
    public CopiaRecurso() {
        this.estado = CopiaRecurso.DISPONIBLE;
        this.codigoDeClasificacion = "";
    }
    
    public CopiaRecurso(String estado, String codigoDeClasificacion) {
        this.estado = estado;
        this.codigoDeClasificacion = codigoDeClasificacion;
    }
    
    public boolean prestar() {
        boolean sePresto = false;
        if (estado.equals(CopiaRecurso.DISPONIBLE)) {
            estado = CopiaRecurso.PRESTADA;
            sePresto = true;
        }
        return sePresto;
    }
    
    public boolean ingresarReparacion() {
        boolean ingresadoReparacion = false;
        if (estado.equals(CopiaRecurso.DISPONIBLE)) {
            estado = CopiaRecurso.EN_REPARACION;
            ingresadoReparacion = true;
        }
        return ingresadoReparacion;
    }
    
    public boolean colocarEnEstante(){
        boolean colocadoEnEstante = false;
        if (!estado.equals(CopiaRecurso.DISPONIBLE)) {
            estado = CopiaRecurso.DISPONIBLE;
            colocadoEnEstante = true;
        }
        return colocadoEnEstante;
    }
    
    public void ponerIdCopia(String idCopia) {
        this.idCopia = idCopia;
    }
    
    public void ponerEstado(String estado) {
        this.estado = estado;
    }
    
    public void ponerCodigoDeClasificacion(String codigoDeClasificacion) {
        this.codigoDeClasificacion = codigoDeClasificacion;
    }
    
    public String obtenerIdCopia() {
        return this.idCopia;
    }
    
    public String obtenerEstado() {
        return estado;
    }
    
    public String obtenerCodigoDeClasificacion() {
        return this.codigoDeClasificacion;
    }
}
