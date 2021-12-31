/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.ICopiaRecursoDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.CopiaRecurso;

/**
 *
 * @author Brandon Lopez
 */
public class CopiaRecursoDAO implements ICopiaRecursoDAO {

    @Override
    public boolean agregarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException {
        boolean resultado;
        String consulta = "INSERT INTO `CopiaRecurso` (codigoDeClasificacion, estado) VALUES(?,?);";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, copiaRecurso.obtenerCodigoDeClasificacion());
            consultaPreparada.setString(2, copiaRecurso.obtenerEstado());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        
        return resultado;
    }

    @Override
    public boolean modificarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException {
        boolean resultado;
        String consulta = "UPDATE `CopiaRecurso` SET codigoDeClasificacion = ?, estado = ? WHERE idCopia = ?;";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, copiaRecurso.obtenerCodigoDeClasificacion());
            consultaPreparada.setString(2, copiaRecurso.obtenerEstado());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public boolean eliminarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException {
        boolean resultado;
        String consulta = "DELETE FROM `CopiaRecurso` WHERE `idCopia` = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, copiaRecurso.obtenerIdCopia());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecurso(String codigoDeClasificacion) throws SQLException {
        List<CopiaRecurso> copiasRecurso = new ArrayList<>();
        String consulta = "SELECT * FROM `CopiaRecurso` WHERE codigoDeClasificacion = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoDeClasificacion);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                CopiaRecurso copiaRecurso = new CopiaRecurso();
                copiaRecurso.ponerIdCopia(resultado.getString("idCopia"));
                copiaRecurso.ponerCodigoDeClasificacion(resultado.getString("codigoDeClasificacion"));
                copiaRecurso.ponerEstado(resultado.getString("estado"));
                
                copiasRecurso.add(copiaRecurso);
            }
        }
        return copiasRecurso;
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoDisponibles(String codigoDeClasificacion) throws SQLException {
                List<CopiaRecurso> copiasRecurso = new ArrayList<>();
        String consulta = "SELECT * FROM `CopiaRecurso` WHERE codigoDeClasificacion = ? AND estado = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoDeClasificacion);
            consultaPreparada.setString(2, CopiaRecurso.DISPONIBLE);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                CopiaRecurso copiaRecurso = new CopiaRecurso();
                copiaRecurso.ponerIdCopia(resultado.getString("idCopia"));
                copiaRecurso.ponerCodigoDeClasificacion(resultado.getString("codigoDeClasificacion"));
                copiaRecurso.ponerEstado(resultado.getString("estado"));
                
                copiasRecurso.add(copiaRecurso);
            }
        }
        return copiasRecurso;
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoPrestadas(String codigoDeClasificacion) throws SQLException {
        List<CopiaRecurso> copiasRecurso = new ArrayList<>();
        String consulta = "SELECT * FROM `CopiaRecurso` WHERE codigoDeClasificacion = ? AND estado = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoDeClasificacion);
            consultaPreparada.setString(2, CopiaRecurso.PRESTADA);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                CopiaRecurso copiaRecurso = new CopiaRecurso();
                copiaRecurso.ponerIdCopia(resultado.getString("idCopia"));
                copiaRecurso.ponerCodigoDeClasificacion(resultado.getString("codigoDeClasificacion"));
                copiaRecurso.ponerEstado(resultado.getString("estado"));
                
                copiasRecurso.add(copiaRecurso);
            }
        }
        return copiasRecurso;
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoEnReparacion(String codigoDeClasificacion) throws SQLException {
        List<CopiaRecurso> copiasRecurso = new ArrayList<>();
        String consulta = "SELECT * FROM `CopiaRecurso` WHERE codigoDeClasificacion = ? AND estado = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, codigoDeClasificacion);
            consultaPreparada.setString(2, CopiaRecurso.EN_REPARACION);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                CopiaRecurso copiaRecurso = new CopiaRecurso();
                copiaRecurso.ponerIdCopia(resultado.getString("idCopia"));
                copiaRecurso.ponerCodigoDeClasificacion(resultado.getString("codigoDeClasificacion"));
                copiaRecurso.ponerEstado(resultado.getString("estado"));
                
                copiasRecurso.add(copiaRecurso);
            }
        }
        return copiasRecurso;
    }
    
}
