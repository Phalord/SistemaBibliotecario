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
import sistemabibliotecario.accesodatos.idao.IEstudianteDAO;
import sistemabibliotecario.accesodatos.idao.IPersonaUVDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.Estudiante;

/**
 *
 * @author Brandon Lopez Tenorio
 */
public class EstudianteDAO implements IEstudianteDAO {

    @Override
    public boolean agregarEstudiante(Estudiante estudiante) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        boolean resultado;
        if (personaUVDAO.agregarPersonaUV(estudiante)) {
            String consulta = "INSERT INTO `Estudiante` (estado, matricula) VALUES(?,?);";
            try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, estudiante.obtenerEstado());
                consultaPreparada.setString(2, estudiante.obtenerMatricula());
                
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    @Override
    public boolean modificarEstudiante(Estudiante estudiante) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        boolean resultado;
        if (personaUVDAO.modificarPersonaUV(estudiante)) {
            String consulta = "UPDATE `Estudiante` SET estado = ? WHERE matricula = ?";
            try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, estudiante.obtenerEstado());
                consultaPreparada.setString(2, estudiante.obtenerMatricula());
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean eliminarEstudiante(Estudiante estudiante) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        boolean resultado;
        if (personaUVDAO.eliminarPersonaUV(estudiante)) {
            String consulta = "UPDATE `Estudiante` SET estado = ? WHERE matricula = ?";
            try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(1, estudiante.obtenerEstado());
                consultaPreparada.setString(2, estudiante.obtenerMatricula());
                resultado = consultaPreparada.executeUpdate() > 0;
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public Estudiante recuperarEstudiante(String matricula) throws SQLException {
        Estudiante estudiante = null;
        String consulta = "SELECT * FROM `Estudiante` INNER JOIN `PersonaUV` ON `Estudiante`.`matricula` = `PersonaUV`.`identificador` AND `Estudiante`.`matricula` = ?;";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, matricula);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                estudiante = new Estudiante();
                estudiante.ponerMatricula(resultado.getString("identificador"));
                estudiante.ponerNombre(resultado.getString("nombre"));
                estudiante.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                estudiante.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                estudiante.ponerDomicilio(resultado.getString("domicilio"));
                estudiante.ponerEmail(resultado.getString("email"));
                estudiante.ponerNumeroTelefono(resultado.getString("telefono"));
                estudiante.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                estudiante.ponerEstado(resultado.getString("estado"));
            }
        }
        
        return estudiante;
    }

    @Override
    public List<Estudiante> recuperarEstudiantes() throws SQLException {
        List<Estudiante> estudiantes = new ArrayList<>();
        String consulta = "SELECT * FROM `Estudiante` INNER JOIN `PersonaUV` ON `Estudiante`.`matricula` = `PersonaUV`.`identificador`";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.ponerMatricula(resultado.getString("identificador"));
                estudiante.ponerTipo(resultado.getString("tipo"));
                estudiante.ponerNombre(resultado.getString("nombre"));
                estudiante.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                estudiante.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                estudiante.ponerDomicilio(resultado.getString("domicilio"));
                estudiante.ponerEmail(resultado.getString("email"));
                estudiante.ponerNumeroTelefono(resultado.getString("telefono"));
                estudiante.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                estudiante.ponerEstado(resultado.getString("estado"));
                
                estudiantes.add(estudiante);
            }   
        }
        return estudiantes;
    }

    @Override
    public List<Estudiante> recuperarEstudiantesInscritos() throws SQLException {
        List<Estudiante> estudiantesInscrito = new ArrayList<>();
        String consulta = "SELECT * FROM `Estudiante` INNER JOIN `PersonaUV` ON `Estudiante`.`matricula` = `PersonaUV`.`identificador` AND `Estudiante`.`estado` = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, Estudiante.INSCRITO);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.ponerMatricula(resultado.getString("identificador"));
                estudiante.ponerTipo(resultado.getString("tipo"));
                estudiante.ponerNombre(resultado.getString("nombre"));
                estudiante.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                estudiante.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                estudiante.ponerDomicilio(resultado.getString("domicilio"));
                estudiante.ponerEmail(resultado.getString("email"));
                estudiante.ponerNumeroTelefono(resultado.getString("telefono"));
                estudiante.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                estudiante.ponerEstado(resultado.getString("estado"));
                
                estudiantesInscrito.add(estudiante);
            }   
        }
        return estudiantesInscrito;
    }

    @Override
    public List<Estudiante> recuperarEstudiantesNoInscritos() throws SQLException {
        List<Estudiante> estudiantesNoInscritos = new ArrayList<>();
        String consulta = "SELECT * FROM `Estudiante` INNER JOIN `PersonaUV` ON `Estudiante`.`matricula` = `PersonaUV`.`identificador` AND `Estudiante`.`estado` = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, Estudiante.NO_INSCRITO);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.ponerMatricula(resultado.getString("identificador"));
                estudiante.ponerTipo(resultado.getString("tipo"));
                estudiante.ponerNombre(resultado.getString("nombre"));
                estudiante.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                estudiante.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                estudiante.ponerDomicilio(resultado.getString("domicilio"));
                estudiante.ponerEmail(resultado.getString("email"));
                estudiante.ponerNumeroTelefono(resultado.getString("telefono"));
                estudiante.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                estudiante.ponerEstado(resultado.getString("estado"));
                
                estudiantesNoInscritos.add(estudiante);
            }   
        }
        return estudiantesNoInscritos;
    }
    
}
