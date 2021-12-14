/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String consulta = "INSERT INTO `Persona UV`(clave, identificador, nombre, apellidoPaterno, apellidoMaterno, domicilio, email, telefono, montoDeuda) VALUES(?,?,?,?,?,?,?,?,?)";
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
    public boolean modificarPersonaUV(PersonaUV personaUV) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPersonaUV(PersonaUV personaUV) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaUV recuperarPersonaUV(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaUV> recuperarPersonasUV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
