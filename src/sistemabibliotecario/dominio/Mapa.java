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
public class Mapa extends RecursoDocumental {
    private String escala;
    private String tipoProyeccion;
    
    public Mapa() {
        super();
        this.escala = "";
        this.tipoProyeccion = "Mercator";
    }
    
    public Mapa(String titulo, List<String> autores, String codigoDeClasificacion,
            Date fechaDeEdicion, String idioma, List<CopiaRecurso> copias,
            List<String> temas, String estado, Biblioteca biblioteca,
            String escala, String tipoProyeccion) {
        super(titulo, autores, codigoDeClasificacion,
                fechaDeEdicion, idioma, copias, temas, estado, biblioteca);
    }
    
    public void ponerEscala(String escala) {
        this.escala = escala;
    }
    
    public void ponerTipoProyeccion(String tipoProyeccion) {
        this.tipoProyeccion = tipoProyeccion;
    }
    
    public String obtenerEscala() {
        return this.escala;
    }
    
    public String obtenerTipoProyeccion() {
        return this.tipoProyeccion;
    }
}
