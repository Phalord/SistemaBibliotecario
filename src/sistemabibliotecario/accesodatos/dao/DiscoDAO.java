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
import sistemabibliotecario.accesodatos.idao.IDiscoDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.Disco;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class DiscoDAO implements IDiscoDAO {

    @Override
    public boolean agregarDisco(Disco disco) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(disco)) {
            String consulta = "INSERT INTO `Disco` (tiempoDuracion, codigoDeClasificacion) VALUES(?, ?);";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setInt(1, disco.obtenerTiempoDuracion());
                consultaPreparada.setString(
                        2, disco.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean modificarDisco(Disco disco) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.modificarRecursoDocumental(disco)) {
            String consulta = "UPDATE `Disco` SET tiempoDuracion = ? WHERE codigoDeClasificacion = ?;";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setInt(1, disco.obtenerTiempoDuracion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarDisco(Disco disco) throws SQLException {
        boolean resultado;
        
        String consulta = "DELETE FROM `Disco` WHERE codigoDeClasificacion = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(
                    1, disco.obtenerCodigoDeClasificacion());
            if (consultaPreparada.executeUpdate() > 0) {
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                resultado =
                        recursoDocumentalDAO.eliminarRecursoDocumental(disco);
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }

    @Override
    public Disco recuperarDisco(String codigoClasificacion) throws SQLException {
        Disco disco = null;
        String consulta = "SELECT * FROM `Disco` INNER JOIN `RecursoDocumental` ON `Disco`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` AND `Disco`.`codigoDeClasificacion` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoClasificacion);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                disco = new Disco();
                disco.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                disco.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                disco.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                disco.ponerIdioma(
                        resultado.getString("idioma"));
                disco.ponerTitulo(
                        resultado.getString("titulo"));
                disco.ponerEstado(
                        resultado.getString("estado"));
                disco.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                disco.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                disco.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
            }
        }
        
        return disco;
    }

    @Override
    public List<Disco> recuperarDiscos() throws SQLException {
        List<Disco> discos = new ArrayList<>();
        String consulta = "SELECT * FROM `Disco` INNER JOIN `RecursoDocumental` ON `Disco`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion`;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Disco disco = new Disco();
                disco.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                disco.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                disco.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                disco.ponerIdioma(
                        resultado.getString("idioma"));
                disco.ponerTitulo(
                        resultado.getString("titulo"));
                disco.ponerEstado(
                        resultado.getString("estado"));
                disco.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                disco.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                disco.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
                discos.add(disco);
            }
        }
        return discos;
    }

    @Override
    public List<Disco> recuperarDiscosPrestados() throws SQLException {
        List<Disco> discosPrestados = new ArrayList<>();
        String consulta = "SELECT * FROM `PrestamoDeRecurso` INNER JOIN `RecursoDocumental` ON `PrestamoDeRecurso`.`codigoClasificacionRecurso` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `Disco` ON `RecursoDocumental`.`codigoDeClasificacion` = `Disco`.`codigoDeClasificacion` AND `RecursoDocumental`.`tipoDeRecurso` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.DISCO);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Disco disco = new Disco();
                disco.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                disco.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                disco.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                disco.ponerIdioma(
                        resultado.getString("idioma"));
                disco.ponerTitulo(
                        resultado.getString("titulo"));
                disco.ponerEstado(
                        resultado.getString("estado"));
                disco.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                disco.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                disco.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
                discosPrestados.add(disco);
            }
        }
        
        return discosPrestados;
    }

    @Override
    public List<Disco> recuperarDiscosDisponibles() throws SQLException {
        List<Disco> discosDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `PrestamoDeRecurso` INNER JOIN `RecursoDocumental` ON `PrestamoDeRecurso`.`codigoClasificacionRecurso` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `Disco` ON `RecursoDocumental`.`codigoDeClasificacion` = `Disco`.`codigoDeClasificacion` AND `RecursoDocumental`.`tipoDeRecurso` = ? AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.DISCO);
            consultaPreparada.setString(2, RecursoDocumental.DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Disco disco = new Disco();
                disco.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                disco.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                disco.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                disco.ponerIdioma(
                        resultado.getString("idioma"));
                disco.ponerTitulo(
                        resultado.getString("titulo"));
                disco.ponerEstado(
                        resultado.getString("estado"));
                disco.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                disco.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                disco.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
                discosDisponibles.add(disco);
            }
        }
        
        return discosDisponibles;
    }

    @Override
    public List<Disco> recuperarDiscosNoDisponibles() throws SQLException {
        List<Disco> discosNoDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `PrestamoDeRecurso` INNER JOIN `RecursoDocumental` ON `PrestamoDeRecurso`.`codigoClasificacionRecurso` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `Disco` ON `RecursoDocumental`.`codigoDeClasificacion` = `Disco`.`codigoDeClasificacion` AND `RecursoDocumental`.`tipoDeRecurso` = ? AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.DISCO);
            consultaPreparada.setString(2, RecursoDocumental.NO_DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Disco disco = new Disco();
                disco.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                disco.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                disco.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                disco.ponerIdioma(
                        resultado.getString("idioma"));
                disco.ponerTitulo(
                        resultado.getString("titulo"));
                disco.ponerEstado(
                        resultado.getString("estado"));
                disco.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                disco.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                disco.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
                discosNoDisponibles.add(disco);
            }
        }
        
        return discosNoDisponibles;
    }
    
    private String[] dividirTemas(String temas) {
            return temas.split(";");
    }

    private String[] dividirAutores(String autores) {
            return autores.split(";");
    }
}
