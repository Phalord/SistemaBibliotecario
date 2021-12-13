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
public class Periodico extends RecursoDocumental {
    private String editorial;
    private String notaPrincipal;
    
    public Periodico() {
        super();
        this.editorial = "";
        this.notaPrincipal = "";
    }
    
    public Periodico(String titulo, List<String> autores, String codigoDeClasificacion,
            Date fechaDeEdicion, String idioma, List<CopiaRecurso> copias,
            List<String> temas, String estado, Biblioteca biblioteca,
            String editorial, String notaPrincipal) {
        super(titulo, autores, codigoDeClasificacion,
                fechaDeEdicion, idioma, copias, temas, estado, biblioteca);
        this.editorial = editorial;
        this.notaPrincipal = notaPrincipal;
    }
    
    public void ponerEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public void ponerNotaPrincipal(String notaPrincipal) {
        this.notaPrincipal = notaPrincipal;
    }
    
    public String obtenerEditorial() {
        return this.editorial;
    }
    
    public String obtenerNotaPrincipal() {
        return this.notaPrincipal;
    }
}
