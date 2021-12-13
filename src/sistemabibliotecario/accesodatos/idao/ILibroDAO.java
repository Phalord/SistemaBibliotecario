/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Libro;

/**
 *
 * @author Dario Castellanos
 */
public interface ILibroDAO {
    boolean agregaLibro(Libro libro);
    boolean modificarLibro(Libro libro);
    boolean eliminarLibro(Libro libro);
    Libro recuperarLibro(String codigoClasificacion);
    List<Libro> recuperarLibros();
    List<Libro> recuperarLibrosPrestados();
    List<Libro> recuperarLibrosDisponibles();
    List<Libro> recuperarLibrosEnReparacion();
}
