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
public class Tesis extends RecursoDocumental {
    private String asesor;
    private int numeroPaginas;
    private DVD dvd;
    
    public Tesis() {
        super();
        this.asesor = "";
        this.numeroPaginas = -1;
        this.dvd = null;
    }
    
    public Tesis(String titulo, List<String> autores,
            String codigoDeClasificacion, Date fechaDeEdicion, String idioma,
            List<CopiaRecurso> copias, List<String> temas, String estado,
            Biblioteca biblioteca, String asesor, int numeroPaginas, DVD dvd) {
        super(titulo, autores, RecursoDocumental.TESIS, codigoDeClasificacion,
                fechaDeEdicion, idioma, copias, temas, estado, biblioteca);
        this.asesor = asesor;
        this.numeroPaginas = numeroPaginas;
        this.dvd = dvd;
    }
    
    public void ponerAsesor(String asesor) {
        this.asesor = asesor;
    }
    
    public void ponerNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    public void ponerDVD(DVD dvd) {
        this.dvd = dvd;
    }
    
    public String obtenerAsesor() {
        return this.asesor;
    }
    
    public int obtenerNumeroPaginas() {
        return this.numeroPaginas;
    }
    
    public DVD obtenerDVD() {
        return this.dvd;
    }
}
