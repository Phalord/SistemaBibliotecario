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
import sistemabibliotecario.accesodatos.idao.IMapaDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.Mapa;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class MapaDAO implements IMapaDAO {

    @Override
    public boolean agregarMapa(Mapa mapa) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(mapa)) {
            String consulta = "INSERT INTO `Mapa` (codigoDeClasificacion, escala, tipoProyeccion) VALUES(?, ?, ?);";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(
                        1, mapa.obtenerCodigoDeClasificacion());
                consultaPreparada.setString(2, mapa.obtenerEscala());
                consultaPreparada.setString(3, mapa.obtenerTipoProyeccion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean modificarMapa(Mapa mapa) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(mapa)) {
            String consulta = "UPDATE `Mapa` SET escala = ?, tipoProyeccion = ? where codigoDeClasificacion = ?";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, mapa.obtenerEscala());
                consultaPreparada.setString(2, mapa.obtenerTipoProyeccion());
                consultaPreparada.setString(
                        3, mapa.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarMapa(Mapa mapa) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `Mapa` WHERE codigoDeClasificacion = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, mapa.obtenerCodigoDeClasificacion());
            
            if (consultaPreparada.executeUpdate() > 0) {
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                resultado = recursoDocumentalDAO.eliminarRecursoDocumental(mapa);
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }

    @Override
    public Mapa recuperarMapa(String codigoClasificacion) throws SQLException {
        Mapa mapa = null;
        String consulta = "SELECT * FROM `Mapa` INNER JOIN `RecursoDocumental` ON `Mapa`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` AND `Mapa`.`codigoDeClasificacion` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoClasificacion);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                mapa = new Mapa();
                mapa.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                mapa.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                mapa.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                mapa.ponerIdioma(
                        resultado.getString("idioma"));
                mapa.ponerTitulo(
                        resultado.getString("titulo"));
                mapa.ponerEstado(
                        resultado.getString("estado"));
                mapa.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                mapa.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                mapa.ponerTipoProyeccion(resultado.getString("tipoProyeccion"));
                mapa.ponerEscala(resultado.getString("escala"));
            }
        }
        
        return mapa;
    }

    @Override
    public List<Mapa> recuperarMapas() throws SQLException {
        List<Mapa> mapas = new ArrayList<>();
        String consulta = "SELECT * FROM `Mapa` INNER JOIN `RecursoDocumental` ON `Mapa`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion`;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                Mapa mapa = new Mapa();
                mapa.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                mapa.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                mapa.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                mapa.ponerIdioma(
                        resultado.getString("idioma"));
                mapa.ponerTitulo(
                        resultado.getString("titulo"));
                mapa.ponerEstado(
                        resultado.getString("estado"));
                mapa.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                mapa.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                mapa.ponerTipoProyeccion(resultado.getString("tipoProyeccion"));
                mapa.ponerEscala(resultado.getString("escala"));
                mapas.add(mapa);
            }
        }
        
        return mapas;
    }

    @Override
    public List<Mapa> recuperarMapasDisponibles() throws SQLException {
        List<Mapa> mapasDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `Mapa` INNER JOIN `RecursoDocumental` ON `Mapa`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Mapa`.`codigoDeClasificacion` AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Mapa mapa = new Mapa();
                mapa.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                mapa.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                mapa.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                mapa.ponerIdioma(
                        resultado.getString("idioma"));
                mapa.ponerTitulo(
                        resultado.getString("titulo"));
                mapa.ponerEstado(
                        resultado.getString("estado"));
                mapa.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                mapa.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                mapa.ponerTipoProyeccion(resultado.getString("tipoProyeccion"));
                mapa.ponerEscala(resultado.getString("escala"));
                mapasDisponibles.add(mapa);
            }
        }
        return mapasDisponibles;
    }

    @Override
    public List<Mapa> recuperarMapasNoDisponibles() throws SQLException {
        List<Mapa> mapasNoDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM `Mapa` INNER JOIN `RecursoDocumental` ON `Mapa`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Mapa`.`codigoDeClasificacion` AND `RecursoDocumental`.`estado` = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, RecursoDocumental.NO_DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Mapa mapa = new Mapa();
                mapa.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                mapa.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                mapa.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                mapa.ponerIdioma(
                        resultado.getString("idioma"));
                mapa.ponerTitulo(
                        resultado.getString("titulo"));
                mapa.ponerEstado(
                        resultado.getString("estado"));
                mapa.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                mapa.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                mapa.ponerTipoProyeccion(resultado.getString("tipoProyeccion"));
                mapa.ponerEscala(resultado.getString("escala"));
                mapasNoDisponibles.add(mapa);
            }
        }
        return mapasNoDisponibles;
    }

    @Override
    public List<Mapa> recuperarMapasPrestados() throws SQLException {
        List<Mapa> mapasPrestados = new ArrayList<>();
        String consulta = "SELECT * FROM `Mapa` INNER JOIN `RecursoDocumental` ON `Mapa`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` INNER JOIN `PrestamoDeRecurso` ON `PrestamoDeRecurso`.`codigoDeClasificacion` = `Mapa`.`codigoDeClasificacion`;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                Mapa mapa = new Mapa();
                mapa.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                mapa.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                mapa.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                mapa.ponerIdioma(
                        resultado.getString("idioma"));
                mapa.ponerTitulo(
                        resultado.getString("titulo"));
                mapa.ponerEstado(
                        resultado.getString("estado"));
                mapa.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                mapa.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                mapa.ponerTipoProyeccion(resultado.getString("tipoProyeccion"));
                mapa.ponerEscala(resultado.getString("escala"));
                mapasPrestados.add(mapa);
            }
        }
        return mapasPrestados;
    }
    
    private String[] dividirTemas(String temas) {
            return temas.split(";");
    }

    private String[] dividirAutores(String autores) {
            return autores.split(";");
    }
    
}
