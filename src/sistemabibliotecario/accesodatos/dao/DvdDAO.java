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
import sistemabibliotecario.accesodatos.idao.IDvdDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.DVD;

/**
 *
 * @author Brandon Lopez Tenorio
 */
public class DvdDAO implements IDvdDAO {

    @Override
    public boolean agregarDVD(DVD dvd) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(dvd)) {
            String consulta = "INSERT INTO `DVD` (tiempoDuracion, region, codigoDeClasificacion) VALUES(?, ?, ?);";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setInt(1, dvd.obtenerTiempoDuracion());
                consultaPreparada.setInt(2, dvd.obtenerRegion());
                consultaPreparada
                        .setString(3, dvd.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarDVD(DVD dvd) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `DVD` WHERE codigoDeClasificacion = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, dvd.obtenerCodigoDeClasificacion());
            
            if (consultaPreparada.executeUpdate() > 0) {
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                resultado = recursoDocumentalDAO.eliminarRecursoDocumental(dvd);
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }

    @Override
    public DVD recuperarDVD(String codigoClasificacion) throws SQLException {
        DVD dvd = null;
        String consulta = "SELECT * FROM `DVD` INNER JOIN `RecursoDocumental` ON `DVD`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion` AND codigoDeClasificacion = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoClasificacion);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                dvd = new DVD();
                dvd.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                dvd.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                dvd.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                dvd.ponerIdioma(
                        resultado.getString("idioma"));
                dvd.ponerTitulo(
                        resultado.getString("titulo"));
                dvd.ponerEstado(
                        resultado.getString("estado"));
                dvd.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                dvd.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                dvd.ponerRegion(resultado.getInt("region"));
                dvd.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
            }
        }
        
        return dvd;
    }

    @Override
    public List<DVD> recuperarDVDs() throws SQLException {
        List<DVD> dvds = new ArrayList<>();
        String consulta = "SELECT * FROM `DVD` INNER JOIN `RecursoDocumental` ON `DVD`.`codigoDeClasificacion` = `RecursoDocumental`.`codigoDeClasificacion`";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                DVD dvd = new DVD();
                dvd.ponerCodigoDeClasificacion(
                        resultado.getString("codigoDeClasificacion"));
                dvd.ponerAutores(Arrays.asList(
                        dividirAutores(resultado.getString("autor"))));
                dvd.ponerFechaDeEdicion(
                        resultado.getDate("fechaDeEdicion"));
                dvd.ponerIdioma(
                        resultado.getString("idioma"));
                dvd.ponerTitulo(
                        resultado.getString("titulo"));
                dvd.ponerEstado(
                        resultado.getString("estado"));
                dvd.ponerNumeroCopias(
                        resultado.getInt("numCopias"));
                dvd.ponerTemas(Arrays
                        .asList(dividirTemas(resultado.getString("temas"))));
                dvd.ponerRegion(resultado.getInt("region"));
                dvd.ponerTiempoDuracion(resultado.getInt("tiempoDuracion"));
                dvds.add(dvd);
            }
        }
        
        return dvds;
    }

    private String[] dividirTemas(String temas) {
            return temas.split(";");
    }

    private String[] dividirAutores(String autores) {
            return autores.split(";");
    }
    
}
