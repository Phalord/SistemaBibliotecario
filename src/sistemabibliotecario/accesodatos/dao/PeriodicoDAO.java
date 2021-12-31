/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.IPeriodicoDAO;
import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.Periodico;

/**
 *
 * @author Dario Castellanos
 */
public class PeriodicoDAO implements IPeriodicoDAO {

    @Override
    public boolean agregarPeriodico(Periodico periodico) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(periodico)) {
            String consulta = "INSERT INTO `Periodico` (editorial, notaPrincipal, codigoDeClasificacion) VALUES(?, ?, ?);";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, periodico.obtenerEditorial());
                consultaPreparada.setString(2, periodico.obtenerNotaPrincipal());
                consultaPreparada.setString(
                        3, periodico.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean modificarPeriodico(Periodico periodico) throws SQLException {
        boolean resultado;
        IRecursoDocumentalDAO recursoDocumentalDAO = new RecursoDocumentalDAO();
        if (recursoDocumentalDAO.agregarRecursoDocumental(periodico)) {
            String consulta = "UPDATE `Periodico` SET editorial = ?, notaPrincipal = ? where codigoDeClasificacion = ?";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, periodico.obtenerEditorial());
                consultaPreparada.setString(2, periodico.obtenerNotaPrincipal());
                consultaPreparada.setString(
                        3, periodico.obtenerCodigoDeClasificacion());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarPeriodico(Periodico periodico) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `Periodico` WHERE codigoDeClasificacion = ?;";
        try (PreparedStatement consultaPreparada =
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(
                    1, periodico.obtenerCodigoDeClasificacion());
            
            if (consultaPreparada.executeUpdate() > 0) {
                IRecursoDocumentalDAO recursoDocumentalDAO =
                        new RecursoDocumentalDAO();
                resultado = recursoDocumentalDAO
                        .eliminarRecursoDocumental(periodico);
            } else {
                resultado = false;
            }
        }
        
        return resultado;
    }

    @Override
    public Periodico recuperarPeriodico(String codigoClasificacion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodico> recuperarPeriodicos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodico> recuperarPeriodicosPrestados() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodico> recuperarPeriodicosDisponibles() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodico> recuperarPeriodicosNoDisponibles() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
