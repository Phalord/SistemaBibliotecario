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
public class Disco extends RecursoDocumental {
    private int tiempoDuracion;
    
    public Disco() {
        super();
        this.tiempoDuracion = -1;
    }
    
    public Disco(String titulo, List<String> autores,
            String codigoDeClasificacion, Date fechaDeEdicion, String idioma,
            List<CopiaRecurso> copias, List<String> temas,
            Biblioteca biblioteca, String estado, int tiempoDuracion) {
        super(titulo, autores, RecursoDocumental.DISCO, codigoDeClasificacion,
                fechaDeEdicion, idioma, copias, temas, estado, biblioteca);
        this.tiempoDuracion = tiempoDuracion;
    }
    
    public void ponerTiempoDuracion(int tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }
    
    public int obtenerTiempoDuracion() {
        return tiempoDuracion;
    }
}
