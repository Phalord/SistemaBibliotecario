/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.IPersonaUVDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.PersonaUV;

/**
 *
 * @author Brandon Lopez
 */
public class PersonaUVDAO implements IPersonaUVDAO {

    @Override
    public boolean agregarPersonaUV(PersonaUV personaUV) throws SQLException {
        boolean resultado;
        String consulta = "INSERT INTO `PersonaUV`(clave, identificador, nombre, apellidoPaterno, apellidoMaterno, domicilio, email, telefono, montoDeuda) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conexion = ConexionBD.abrirConexionBD();
             PreparedStatement consultaPreparada = conexion.prepareStatement(consulta)) {
            consultaPreparada.setInt(1, personaUV.obtenerClave());
            consultaPreparada.setString(2, personaUV.obtenerIdentificador());
            consultaPreparada.setString(3, personaUV.obtenerNombre());
            consultaPreparada.setString(4, personaUV.obtenerApellidoPaterno());
            consultaPreparada.setString(5, personaUV.obtenerApellidoMaterno());
            consultaPreparada.setString(6, personaUV.obtenerDomicilio());
            consultaPreparada.setString(7, personaUV.obtenerEmail());
            consultaPreparada.setFloat(8, personaUV.obtenerMontoDeuda());
            
            int resultadFilasAfectadas = consultaPreparada.executeUpdate();
            resultado = resultadFilasAfectadas > 0;
        }
        return resultado;
    }

    @Override
    public boolean modificarPersonaUV(PersonaUV personaUV) throws SQLException {
        boolean resultado;
        String consulta = "UPDATE `PersonaUV SET` nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, domicilio = ?, email = ?, telefono = ?, montoDeuda = ? WHERE identificador = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, personaUV.obtenerNombre());
            consultaPreparada.setString(2, personaUV.obtenerApellidoPaterno());
            consultaPreparada.setString(3, personaUV.obtenerApellidoMaterno());
            consultaPreparada.setString(4, personaUV.obtenerDomicilio());
            consultaPreparada.setString(5, personaUV.obtenerEmail());
            consultaPreparada.setString(6, personaUV.obtenerNumeroTelefono());
            consultaPreparada.setFloat(7, personaUV.obtenerMontoDeuda());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarPersonaUV(PersonaUV personaUV) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaUV recuperarPersonaUV(String identificador) throws SQLException {
        PersonaUV personaUV = null;
        String consulta = "SELECT * FROM `PersonaUV` WHERE `identificador` = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, identificador);
            
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                personaUV = new PersonaUV();
                personaUV.ponerIdentificador(resultado.getString("identificador"));
                personaUV.ponerNombre(resultado.getString("nombre"));
                personaUV.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                personaUV.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                personaUV.ponerDomicilio(resultado.getString("domicilio"));
                personaUV.ponerEmail(resultado.getString("email"));
                personaUV.ponerNumeroTelefono(resultado.getString("telefono"));
                personaUV.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                personaUV.ponerTipo(resultado.getString("tipo"));
            }
        }
        return personaUV;
    }

    @Override
    public List<PersonaUV> recuperarPersonasUV() throws SQLException {
        List<PersonaUV> personasUV = new ArrayList<>();
        String consulta = "SELECT * FROM `PersonaUV`";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                PersonaUV personaUV = new PersonaUV();
                personaUV.ponerIdentificador(resultado.getString("identificador"));
                personaUV.ponerNombre(resultado.getString("nombre"));
                personaUV.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                personaUV.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                personaUV.ponerDomicilio(resultado.getString("domicilio"));
                personaUV.ponerEmail(resultado.getString("email"));
                personaUV.ponerNumeroTelefono(resultado.getString("telefono"));
                personaUV.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                personaUV.ponerTipo(resultado.getString("tipo"));
                personasUV.add(personaUV);
            }
        }
        return personasUV;
    }
    
}
