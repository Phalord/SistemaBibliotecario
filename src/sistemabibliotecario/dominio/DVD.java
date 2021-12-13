/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class DVD extends RecursoDocumental {
    private int tiempoDuracion;
    private char region;
    
    public DVD() {
        super();
        this.tiempoDuracion = -1;
        this.region = 'x';
    }
    
    public DVD(String titulo, List<String> autores, String codigoDeClasificacion,
            Date fechaDeEdicion, String idioma, List<CopiaRecurso> copias,
            List<String> temas, String estado, Biblioteca biblioteca,
            int tiempoDuracion, char region) {
        super(titulo, autores, codigoDeClasificacion, fechaDeEdicion, idioma,
                copias, temas, estado, biblioteca);
        this.tiempoDuracion = tiempoDuracion;
        this.region = region;
    }
    
    public void ponerTiempoDuracion(int tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }
    
    public void ponerRegion(char region) {
        this.region = region;
    }
    
    public int obtenerTiempoDuracion() {
        return tiempoDuracion;
    }
    
    public char obtenerRegion() {
        return region;
    }
}
