/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.ILibroDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.Libro;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class LibroDAO implements ILibroDAO {

    @Override
    public boolean agregaLibro(Libro libro) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(libro)) {
            String consulta = "INSERT INTO `Libro` (isbn, editorial, clasificacionLC, numeroPaginas, codigoDeClasificacion) VALUES(?, ?, ?, ?, ?);";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, libro.obtenerISBN());
                consultaPreparada.setString(2, libro.obtenerEditorial());
                consultaPreparada.setString(3, libro.obtenerClasificacionLC());
                consultaPreparada.setInt(4, libro.obtenerNumeroPaginas());
                consultaPreparada.setString(
                        5, libro.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean modificarLibro(Libro libro) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.modificarRecursoDocumental(libro)) {
            String consulta = "UPDATE `Libro` SET isbn = ?, editorial = ?, clasificacion = ?, numeroPaginas = ? WHERE codigoDeClasificacion = ?;";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, libro.obtenerISBN());
                consultaPreparada.setString(2, libro.obtenerEditorial());
                consultaPreparada.setString(3, libro.obtenerClasificacionLC());
                consultaPreparada.setInt(4, libro.obtenerNumeroPaginas());
                consultaPreparada.setString(
                        5, libro.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarLibro(Libro libro) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `Libro` WHERE `codigoDeClasificacion` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, libro.obtenerCodigoDeClasificacion());
            
            if (consultaPreparada.executeUpdate() > 0) {
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                resultado = 
                        recursoDocumentalDAO.eliminarRecursoDocumental(libro);
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }

    @Override
    public Libro recuperarLibro(String codigoClasificacion) throws SQLException {
        Libro libro = null;
        String consulta = "SELECT * FROM `Libro` INNER JOIN `RecursoDocumental` ON `Libro`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` AND `Libro`.`codigoDeClasificacion` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoClasificacion);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                libro = new Libro();
                libro.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                libro.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                libro.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                libro.ponerIdioma(
                        resultado.getString("idioma"));
                libro.ponerTitulo(
                        resultado.getString("titulo"));
                libro.ponerEstado(
                        resultado.getString("estado"));
                libro.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                libro.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                libro.ponerISBN(resultado.getString("isbn"));
                libro.ponerEditorial(resultado.getString("Editorial"));
                libro.ponerClasificacionLC(resultado.getString("clasificacionLC"));
                libro.ponerNumeroPaginas(resultado.getInt("numeroPaginas"));
            }
        }
        
        return libro;
    }

    @Override
    public List<Libro> recuperarLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String consulta = "SELECT * FROM `Libro` INNER JOIN `RecursoDocumental` ON `Libro`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion`;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Libro libro = new Libro();
                libro.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                libro.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                libro.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                libro.ponerIdioma(
                        resultado.getString("idioma"));
                libro.ponerTitulo(
                        resultado.getString("titulo"));
                libro.ponerEstado(
                        resultado.getString("estado"));
                libro.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                libro.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                libro.ponerISBN(resultado.getString("isbn"));
                libro.ponerEditorial(resultado.getString("Editorial"));
                libro.ponerClasificacionLC(resultado.getString("clasificacionLC"));
                libro.ponerNumeroPaginas(resultado.getInt("numeroPaginas"));
                libros.add(libro);
            }
        }
        
        return libros;
    }

    @Override
    public List<Libro> recuperarLibrosPrestados() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String consulta = "SELECT * FROM `Libro` INNER JOIN `RecursoDocumental` ON `Libro`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Libro`.`codigoDeClasificacion`;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Libro libro = new Libro();
                libro.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                libro.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                libro.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                libro.ponerIdioma(
                        resultado.getString("idioma"));
                libro.ponerTitulo(
                        resultado.getString("titulo"));
                libro.ponerEstado(
                        resultado.getString("estado"));
                libro.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                libro.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                libro.ponerISBN(resultado.getString("isbn"));
                libro.ponerEditorial(resultado.getString("Editorial"));
                libro.ponerClasificacionLC(resultado.getString("clasificacionLC"));
                libro.ponerNumeroPaginas(resultado.getInt("numeroPaginas"));
                libros.add(libro);
            }
        }
        
        return libros;
    }

    @Override
    public List<Libro> recuperarLibrosDisponibles() throws SQLException {
        List<Libro> librosDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `Libro` INNER JOIN `RecursoDocumental` ON `Libro`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Libro`.`codigoDeClasificacion` AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Libro libro = new Libro();
                libro.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                libro.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                libro.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                libro.ponerIdioma(
                        resultado.getString("idioma"));
                libro.ponerTitulo(
                        resultado.getString("titulo"));
                libro.ponerEstado(
                        resultado.getString("estado"));
                libro.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                libro.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                libro.ponerISBN(resultado.getString("isbn"));
                libro.ponerEditorial(resultado.getString("Editorial"));
                libro.ponerClasificacionLC(resultado.getString("clasificacionLC"));
                libro.ponerNumeroPaginas(resultado.getInt("numeroPaginas"));
                librosDisponibles.add(libro);
            }
        }
        
        return librosDisponibles;
    }

    @Override
    public List<Libro> recuperarLibrosNoDisponibles() throws SQLException {
        List<Libro> librosNoDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `Libro` INNER JOIN `RecursoDocumental` ON `Libro`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Libro`.`codigoDeClasificacion` AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.NO_DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Libro libro = new Libro();
                libro.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                libro.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                libro.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                libro.ponerIdioma(
                        resultado.getString("idioma"));
                libro.ponerTitulo(
                        resultado.getString("titulo"));
                libro.ponerEstado(
                        resultado.getString("estado"));
                libro.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                libro.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                libro.ponerISBN(resultado.getString("isbn"));
                libro.ponerEditorial(resultado.getString("Editorial"));
                libro.ponerClasificacionLC(resultado.getString("clasificacionLC"));
                libro.ponerNumeroPaginas(resultado.getInt("numeroPaginas"));
                librosNoDisponibles.add(libro);
            }
        }
        
        return librosNoDisponibles;
    }
    
    private String[] dividirTemas(String temas) {
            return temas.split(";");
    }

    private String[] dividirAutores(String autores) {
            return autores.split(";");
    }
}
