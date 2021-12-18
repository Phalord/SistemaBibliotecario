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
    static final String PRESTADA = "Prestada";
    static final String DISPONIBLE = "Disponible";
    static final String EN_REPARACION = "En Reparacion";
    
    private String idCopia;
    private String estado;
    
    public CopiaRecurso() {
        this.estado = CopiaRecurso.DISPONIBLE;
    }
    
    public CopiaRecurso(String estado) {
        this.estado = estado;
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

    public String obtenerIdCopia() {
        return idCopia;
    }
    
    public String obtenerEstado() {
        return estado;
    }
}
