/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.ICopiaRecursoDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.CopiaRecurso;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class CopiaRecursoDAO implements ICopiaRecursoDAO {

    @Override
    public boolean agregarCopiaRecurso(CopiaRecurso copiaRecurso, String codigoDeClasificacion) throws SQLException {
        boolean resultado = false;
        String consulta = "INSERT INTO `CopiaRecurso`(codigoDeClasificacion, estado) VALUES (?,?)";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)){
            consultaPreparada.setString(1, codigoDeClasificacion);
            consultaPreparada.setString(2, copiaRecurso.obtenerEstado());
        }
        return resultado;
    }

    @Override
    public boolean modificarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException {
        boolean modificado = false;
        String consulta = "UPDATE `CopiaRecurso` SET estado = ? WHERE idCopia = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, copiaRecurso.obtenerEstado());
            consultaPreparada.setString(2, copiaRecurso.obtenerIdCopia());
        }
        return modificado;
    }

    @Override
    public boolean eliminarCopiaRecurso(CopiaRecurso copiaRecurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CopiaRecurso recuperarCopiaRecurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoDisponibles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoPrestadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoEnReparacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
