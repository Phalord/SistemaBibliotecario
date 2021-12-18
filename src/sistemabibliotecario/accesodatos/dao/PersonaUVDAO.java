/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        boolean resultado = false;
        String consulta = "INSERT INTO `PersonaUV`(identificador, nombre, apellidoPaterno, apellidoMaterno, domicilio, email, telefono, montoDeuda) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conexion = ConexionBD.abrirConexionBD();
             PreparedStatement consultaPreparada = conexion.prepareStatement(consulta)) {
            consultaPreparada.setString(1, personaUV.obtenerIdentificador());
            consultaPreparada.setString(2, personaUV.obtenerNombre());
            consultaPreparada.setString(3, personaUV.obtenerApellidoPaterno());
            consultaPreparada.setString(4, personaUV.obtenerApellidoMaterno());
            consultaPreparada.setString(5, personaUV.obtenerDomicilio());
            consultaPreparada.setString(6, personaUV.obtenerEmail());
            consultaPreparada.setString(7, personaUV.obtenerNumeroTelefono());
            consultaPreparada.setFloat(8, personaUV.obtenerMontoDeuda());
            
            int resultadFilasAfectadas = consultaPreparada.executeUpdate();
            resultado = resultadFilasAfectadas > 0;
        }
        return resultado;
    }

    @Override
    public boolean modificarPersonaUV(PersonaUV personaUV) throws SQLException {
        boolean agregado = false;
        String consulta = "UPDATE `PersonaUV` SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, domicilio=?, email=?, telefono=?, montoDeuda=? WHERE identificador = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, personaUV.obtenerNombre());
            consultaPreparada.setString(2, personaUV.obtenerApellidoPaterno());
            consultaPreparada.setString(3, personaUV.obtenerApellidoMaterno());
            consultaPreparada.setString(4, personaUV.obtenerDomicilio());
            consultaPreparada.setString(5, personaUV.obtenerEmail());
            consultaPreparada.setString(6, personaUV.obtenerNumeroTelefono());
            consultaPreparada.setFloat(7, personaUV.obtenerMontoDeuda());
            consultaPreparada.setString(8, personaUV.obtenerIdentificador());
            
            agregado = consultaPreparada.executeUpdate() > 0;
        }
        return agregado;
    }

    @Override
    public boolean eliminarPersonaUV(PersonaUV personaUV) throws SQLException {
        boolean eliminado = false;
        String consulta = "DELETE FROM `PersonaUV` WHERE identificador = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, personaUV.obtenerIdentificador());
            eliminado = consultaPreparada.executeUpdate() > 0;
        }
        return eliminado;
    }

    @Override
    public PersonaUV recuperarPersonaUV(String identificador) throws SQLException {
        PersonaUV persona = null;
        String consulta = "SELECT * FROM `PersonaUV` WHERE identificador = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, identificador);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                persona.ponerIdentificador(resultado.getString("identificador"));
                persona.ponerNombre(resultado.getString("nombre"));
                persona.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                persona.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                persona.ponerDomicilio(resultado.getString("domicilio"));
                persona.ponerEmail(resultado.getString("email"));
                persona.ponerNumeroTelefono(resultado.getString("telefono"));
                persona.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
            }
        }
        return persona;
    }

    @Override
    public List<PersonaUV> recuperarPersonasUV() throws SQLException {
        List<PersonaUV> personasUV = null;
        String consulta = "SELECT * FROM `PersonaUV`";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            ResultSet resultado = consultaPreparada.executeQuery();
            while (resultado.next()) {
                PersonaUV persona = new PersonaUV();
                persona.ponerIdentificador(resultado.getString("identificador"));
                persona.ponerNombre(resultado.getString("nombre"));
                persona.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                persona.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                persona.ponerDomicilio(resultado.getString("domicilio"));
                persona.ponerEmail(resultado.getString("email"));
                persona.ponerNumeroTelefono(resultado.getString("telefono"));
                persona.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
                personasUV.add(persona);
            }
        }
        return personasUV;
    }
    
}
