/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Libro;

/**
 *
 * @author Dario Castellanos
 */
public interface ILibroDAO {
    boolean agregaLibro(Libro libro) throws SQLException;
    boolean modificarLibro(Libro libro) throws SQLException;
    boolean eliminarLibro(Libro libro) throws SQLException;
    Libro recuperarLibro(String codigoClasificacion) throws SQLException;
    List<Libro> recuperarLibros() throws SQLException;
    List<Libro> recuperarLibrosPrestados() throws SQLException;
    List<Libro> recuperarLibrosDisponibles() throws SQLException;
    List<Libro> recuperarLibrosNoDisponibles() throws SQLException;
}
