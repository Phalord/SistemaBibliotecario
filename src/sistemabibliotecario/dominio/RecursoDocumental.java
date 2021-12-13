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
public class RecursoDocumental {
    static final String DISPONIBLE = "Disponible";
    static final String NO_DISPONIBLE = "No disponible";
    
    protected String titulo;
    protected List<String> autores;
    protected String codigoDeClasificacion;
    protected Date fechaDeEdicion;
    protected String idioma;
    protected List<CopiaRecurso> copias;
    protected List<String> temas;
    protected String estado;
    protected Biblioteca biblioteca;
    
    public RecursoDocumental() {
        this.titulo = "";
        this.autores = null;
        this.codigoDeClasificacion = "";
        this.fechaDeEdicion = null;
        this.idioma = "";
        this.copias = null;
        this.temas = null;
        this.estado = RecursoDocumental.NO_DISPONIBLE;
    }
    
    public RecursoDocumental(String titulo, List<String> autores,
            String codigoDeClasificacion, Date fechaDeEdicion, String idioma,
            List<CopiaRecurso> copias, List<String> temas, String estado, Biblioteca biblioteca) {
        this.titulo = titulo;
        this.autores = autores;
        this.codigoDeClasificacion = codigoDeClasificacion;
        this.fechaDeEdicion = fechaDeEdicion;
        this.idioma = idioma;
        this.copias = copias;
        this.temas = temas;
        this.estado = estado;
        this.biblioteca = biblioteca;
    }
    
    public void prestarCopia(int indice) {
        if (hayCopiasDisponibles()) {
            copias.get(indice).prestar();
            if (!hayCopiasDisponibles()) {
                estado = RecursoDocumental.NO_DISPONIBLE;
            }
        }
    }
    
    public void repararCopia(int indice) {
        if (hayCopiasDisponibles()) {
            copias.get(indice).ingresarReparacion();
            if (!hayCopiasDisponibles()) {
                estado = RecursoDocumental.NO_DISPONIBLE;
            }
        }
    }
    
    public void agregarCopia() {
        if (estado.equals(RecursoDocumental.NO_DISPONIBLE)) {
            estado = RecursoDocumental.DISPONIBLE;
        }
        copias.add(new CopiaRecurso());
    }
    
    public void editarInformacion(RecursoDocumental recursoModificado) {
        if (!recursoDocumentalEsIgual(recursoModificado)) {
            this.titulo = recursoModificado.titulo;
            this.autores = recursoModificado.autores;
            this.codigoDeClasificacion = recursoModificado.codigoDeClasificacion;
            this.fechaDeEdicion = recursoModificado.fechaDeEdicion;
            this.idioma = recursoModificado.idioma;
            this.copias = recursoModificado.copias;
            this.temas = recursoModificado.temas;
        }
    }
    
    public void eliminarCopia(CopiaRecurso copia) {
        this.copias.remove(copia);
        if (copias.isEmpty()) {
            estado = RecursoDocumental.NO_DISPONIBLE;
        }
    }

    private boolean recursoDocumentalEsIgual(RecursoDocumental recursoModificado) {
        return (this.titulo.equals(recursoModificado.titulo) &&
                this.autores.equals(recursoModificado.autores) &&
                this.codigoDeClasificacion.equals(
                        recursoModificado.codigoDeClasificacion) &&
                this.fechaDeEdicion.equals(recursoModificado.fechaDeEdicion) &&
                this.idioma.equals(recursoModificado.idioma) &&
                this.copias.equals(recursoModificado.copias) &&
                this.temas.equals(recursoModificado.temas));
    }

    private boolean hayCopiasDisponibles() {
        boolean hayCopiasDisponibles = false;
        for (CopiaRecurso copia : copias) {
            if (copia.obtenerEstado().equals(CopiaRecurso.DISPONIBLE)) {
                hayCopiasDisponibles = true;
                break;
            }
        }
        return hayCopiasDisponibles;
    }
    
    public void ponerTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void ponerAutores(List<String> autores) {
        this.autores = autores;
    }
    
    public void ponerCodigoDeClasificacion(String codigoDeClasificacion) {
        this.codigoDeClasificacion = codigoDeClasificacion;
    }
    
    public void ponerFechaDeEdicion(Date fechaDeEdicion) {
        this.fechaDeEdicion = fechaDeEdicion;
    }
    
    public void ponerIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public void ponerCopias(List<CopiaRecurso> copias) {
        this.copias = copias;
    }
    
    public void ponerTemas(List<String> temas) {
        this.temas = temas;
    }
    
    public void ponerEstado(String estado) {
        this.estado = estado;
    }
    
    public String obtenerTitulo() {
        return this.titulo;
    }
    
    public List<String> obtenerAutores() {
        return this.autores;
    }
    
    public Date fechaDeEdicion() {
        return this.fechaDeEdicion;
    }
    
    public String idioma() {
        return this.idioma;
    }
    
    public List<CopiaRecurso> obtenerCopias() {
        return this.copias;
    }
    
    public List<String> obtenerTemas() {
        return this.temas;
    }
    
    public String obtenerEstado() {
        return this.estado;
    }
}