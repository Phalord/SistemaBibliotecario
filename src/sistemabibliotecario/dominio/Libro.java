/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author alex_
 */
public class Libro extends RecursoDocumental {
    
    private String clasificacionLC;
    private String editorial;
    private String isbn;
    private int numeroPaginas;
    
    public Libro() {
        super();
        this.clasificacionLC = "";
        this.editorial = "";
        this.isbn = "";
        this.numeroPaginas = -1;
    }
    
    public Libro(String titulo, List<String> autores, String codigoDeClasificacion,
            Date fechaDeEdicion, String idioma, List<CopiaRecurso> copias,
            List<String> temas, String estado, String clasificacionLC,
            Biblioteca biblioteca, String editorial, String isbn, int numeroPaginas) {
        super(titulo, autores, codigoDeClasificacion,
                fechaDeEdicion, idioma, copias, temas, estado, biblioteca);
        this.clasificacionLC = clasificacionLC;
        this.editorial = editorial;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
    }
    
    public void ponerClasificacionLC(String clasificacionLC) {
        this.clasificacionLC = clasificacionLC;
    }
    
    public void ponerEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public void ponerISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public void ponerNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    public String obtenerClasificacionLC() {
        return this.clasificacionLC;
    }
    
    public String obtenerEditorial() {
        return this.editorial;
    }
    
    public String obtenerisbn() {
        return this.isbn;
    }
    
    public int obtenerNoPaginas() {
        return this.numeroPaginas;
    }
    
}
