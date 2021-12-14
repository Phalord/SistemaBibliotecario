/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author alex_
 */
public class RecursoDocumentalDAO implements IRecursoDocumentalDAO {

    @Override
    public boolean agregarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
        boolean resultado = false;
        String query = "INSERT INTO RecursoDocumental(codigoDeClasificacion, autor, fechaDeEdicion, idioma, titulo, estado, numCopias, temas) VALUES(?,?,?,?,?,?,?,?)";
        String temas = unificarTemas(recursoDocumental);
        String autores = unificarAutores(recursoDocumental);
        try (Connection conexion = ConexionBD.abrirConexionBD();
             PreparedStatement consultaPreparada = conexion.prepareStatement(query)) {
            consultaPreparada.setString(1, recursoDocumental.obtenerCodigoDeClasificacion());
            consultaPreparada.setString(2, autores);
            consultaPreparada.setDate(3, recursoDocumental.fechaDeEdicion());
            consultaPreparada.setString(4, recursoDocumental.obtenerIdioma());
            consultaPreparada.setString(5, recursoDocumental.obtenerTitulo());
            consultaPreparada.setString(6, recursoDocumental.obtenerEstado());
            consultaPreparada.setInt(7, recursoDocumental.obtenerNumeroCopias());
            consultaPreparada.setString(8, temas);
            
            int numeroFilasAfectadas = consultaPreparada.executeUpdate();
            resultado = numeroFilasAfectadas > 0;
        } catch (SQLException excepcion) {
            throw excepcion;
        }
        return resultado;
    }

    @Override
    public boolean modificarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RecursoDocumental recuperarRecursoDocumental(String codigoDeClasificacion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecursoDocumental> recuperarRecursosDocumentales() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecursoDocumental> recuperarRecursosDocumentalesDisponibles() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String unificarTemas(RecursoDocumental recursoDocumental) {
        String temas = "";
        for (String tema : recursoDocumental.obtenerTemas()) {
            temas += String.format("%s;", tema);
        }
        return temas;
    }

    private String unificarAutores(RecursoDocumental recursoDocumental) {
        String autores = "";
        for (String autor : recursoDocumental.obtenerAutores()) {
            autores += String.format("%s;", autor);
        }
        return autores;
    }
    
}
