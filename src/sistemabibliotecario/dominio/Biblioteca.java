/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.dominio;

import java.util.List;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class Biblioteca {
    private int id;
    private String direccion;
    private String nombre;
    private String region;
    private String telefono;
    private List<VisitaSala> visitasSala;
    private List<RecursoDocumental> recursosDocumentales;
    private List<PrestamoDeRecurso> prestamosDeRecursos;
    private List<PrestamoInterbibliotecario> prestamosInterbibliotecarios;
    
    public Biblioteca() {
        this.direccion = "";
        this.nombre = "";
        this.region = "";
        this.telefono = "";
        this.visitasSala = null;
        this.recursosDocumentales = null;
        this.prestamosDeRecursos = null;
        this.prestamosInterbibliotecarios = null;
    }
    
    public Biblioteca(String direccion, String nombre, String region,
            String telefono, List<VisitaSala> visitasSala,
            List<RecursoDocumental> recursosDocumentales,
            List<PrestamoDeRecurso> prestamosDeRecursos,
            List<PrestamoInterbibliotecario> prestamosInterbibliotecarios) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.region = region;
        this.telefono = telefono;
        this.visitasSala = visitasSala;
        this.recursosDocumentales = recursosDocumentales;
        this.prestamosDeRecursos = prestamosDeRecursos;
        this.prestamosInterbibliotecarios = prestamosInterbibliotecarios;
    }

    
    public void RegistrarPrestamoInterbibliotecario(
            PrestamoInterbibliotecario prestamoInterbibliotecario) {
        this.prestamosInterbibliotecarios.add(prestamoInterbibliotecario);
    }
    
    public void registrarVisita(VisitaSala visitaSala) {
        visitasSala.add(visitaSala);
    }
    
    public void modificarInformacion(Biblioteca biblioteca) {
        this.direccion = biblioteca.direccion;
        this.nombre = biblioteca.nombre;
        this.region = biblioteca.region;
        this.telefono = biblioteca.telefono;
    }
    
    public void ponerID(int id) {
        this.id = id;
    }
    
    public void ponerDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void ponerNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void ponerRegion(String region) {
        this.region = region;
    }
    
    public void ponerTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void ponerVisitasSala(List<VisitaSala> visitasSala) {
        this.visitasSala = visitasSala;
    }
    
    public void ponerRecursosDocumentales(
            List<RecursoDocumental> recursosDocumentales) {
        this.recursosDocumentales = recursosDocumentales;
    }
    
    public void ponerPrestamosDeRecursos(
            List<PrestamoDeRecurso> prestamosDeRecursos) {
        this.prestamosDeRecursos = prestamosDeRecursos;
    }
    
    public void ponerPrestamosInterbibliotecarios(
            List<PrestamoInterbibliotecario> prestamosInterbibliotecarios) {
        this.prestamosInterbibliotecarios = prestamosInterbibliotecarios;
    }
    
    public int obtenerID() {
        return this.id;
    }
    
    public String obtenerDireccion() {
        return this.direccion;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public String obtenerRegion() {
        return this.region;
    }
    
    public String obtenerTelefono() {
        return this.telefono;
    }
    
    public List<VisitaSala> obtenerVisitasSala() {
        return this.visitasSala;
    }
    
    public List<RecursoDocumental> obtenerRecursosDocumentales() {
        return this.recursosDocumentales;
    }
    
    public List<PrestamoDeRecurso> obtenerPrestamosDeRecursos() {
        return this.prestamosDeRecursos;
    }
    
    public List<PrestamoInterbibliotecario> obtenerPrestamosInterbibliotecarios() {
        return this.prestamosInterbibliotecarios;
    }
}
