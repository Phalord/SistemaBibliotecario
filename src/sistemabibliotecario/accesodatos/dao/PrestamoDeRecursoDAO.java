/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.IPersonaUVDAO;
import sistemabibliotecario.accesodatos.idao.IPrestamoDeRecursoDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.PrestamoDeRecurso;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author alex_
 */
public class PrestamoDeRecursoDAO implements IPrestamoDeRecursoDAO {

    @Override
    public boolean agregarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException {
        boolean resultado;
        String consulta = "INSERT INTO `PrestamoDeRecurso` (identificadorPersonaUV, codigoDeClasificacionRecurso, fechaDevolucion, fechaPrestamo, fechaVencimiento) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, prestamoDeRecurso
                    .obtenerPersonaUV().obtenerIdentificador());
            consultaPreparada.setString(2, prestamoDeRecurso
                    .obtenerRecursoDocumental().obtenerCodigoDeClasificacion());
            consultaPreparada.setDate(
                    3, prestamoDeRecurso.obtenerFechaDeDevolucion());
            consultaPreparada.setDate(
                    4, prestamoDeRecurso.obtenerFechaDePrestamo());
            consultaPreparada.setDate(
                    5, prestamoDeRecurso.obtenerFechaDeVencimiento());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public boolean modificarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException {
        boolean resultado;
        String consulta = "UPDATE `PrestamoDeRecurso` SET fechaDevolucion = ?, fechaVencimiento = ? WHERE identificadorPersonaUV = ? AND codigoDeClasificacionRecurso = ? AND fechaPrestamo = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setDate(
                    1, prestamoDeRecurso.obtenerFechaDeDevolucion());
            consultaPreparada.setDate(
                    2, prestamoDeRecurso.obtenerFechaDeVencimiento());
            consultaPreparada.setString(3, prestamoDeRecurso
                    .obtenerPersonaUV().obtenerIdentificador());
            consultaPreparada.setString(4, prestamoDeRecurso
                    .obtenerRecursoDocumental().obtenerCodigoDeClasificacion());
            consultaPreparada.setDate(
                    5, prestamoDeRecurso.obtenerFechaDePrestamo());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public boolean eliminarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `PrestamoDeRecurso` WHERE identificadorPersonaUV = ? AND codigoDeClasificacionRecurso = ? AND fechaPrestamo = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, prestamoDeRecurso
                    .obtenerPersonaUV().obtenerIdentificador());
            consultaPreparada.setString(2, prestamoDeRecurso
                    .obtenerRecursoDocumental().obtenerCodigoDeClasificacion());
            consultaPreparada.setDate(
                    3, prestamoDeRecurso.obtenerFechaDePrestamo());
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public PrestamoDeRecurso recuperarPrestamoDeRecurso(String identificadorPersona, String codigoRecurso, Date fechaPrestamo) throws SQLException {
        PrestamoDeRecurso prestamoDeRecurso = null;
        String consulta = "SELECT * FROM `PrestamoDeRecurso` WHERE identificadorPersonaUV = ? AND codigoDeClasificacionRecurso = ? AND fechaPrestamo = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, identificadorPersona);
            consultaPreparada.setString(2, codigoRecurso);
            consultaPreparada.setDate(3, fechaPrestamo);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                prestamoDeRecurso = new PrestamoDeRecurso();
                prestamoDeRecurso.ponerFechaDeDevolucion(
                        resultado.getDate("fechaDevolucion"));
                prestamoDeRecurso.ponerFechaDePrestamo(
                        resultado.getDate("fechaPrestamo"));
                prestamoDeRecurso.ponerFechaDeVencimiento(
                        resultado.getDate("fechaVencimiento"));
                prestamoDeRecurso.ponerPersonaUV(
                        personaUVDAO.recuperarPersonaUV(identificadorPersona));
                prestamoDeRecurso.ponerRecursoDocumental(recursoDocumentalDAO
                        .recuperarRecursoDocumental(codigoRecurso));
            }
        }
        return prestamoDeRecurso;
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosActivos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosAtrasados() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosDevueltos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosDeRecurso(RecursoDocumental recursoDocumental) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosDeRecursoAtrasados(RecursoDocumental recursoDocumental) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDeRecurso> recuperarPrestamosDeRecursoDevueltos(RecursoDocumental recursoDocumental) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
