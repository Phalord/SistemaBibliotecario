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
import sistemabibliotecario.accesodatos.idao.IPersonaUVDAO;
import sistemabibliotecario.accesodatos.idao.IPersonalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.PersonaUV;
import sistemabibliotecario.dominio.Personal;

/**
 *
 * @author Brandon Lopez Tenorio
 */
public class PersonalDAO implements IPersonalDAO {

    @Override
    public boolean agregarPersonal(Personal personal) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        return (personaUVDAO.agregarPersonaUV(personal));
    }

    @Override
    public boolean modificarPersonal(Personal personal) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        return (personaUVDAO.modificarPersonaUV(personal));
    }

    @Override
    public boolean eliminarPersonal(Personal personal) throws SQLException {
        IPersonaUVDAO personaUVDAO = new PersonaUVDAO();
        return (personaUVDAO.eliminarPersonaUV(personal));
    }

    @Override
    public Personal recuperarPersonal(String numeroPersonal) throws SQLException {
        Personal personal = null;
        String consulta = "SELECT * FROM `PersonaUV` WHERE `identificador` = ?";
        
        try (PreparedStatement consultaPreparada = 
                ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, numeroPersonal);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                personal = new Personal();
                personal.ponerNumeroPersonal(resultado.getString("identificador"));
                personal.ponerTipo(resultado.getString("tipo"));
                personal.ponerNombre(resultado.getString("nombre"));
                personal.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                personal.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                personal.ponerDomicilio(resultado.getString("domicilio"));
                personal.ponerEmail(resultado.getString("email"));
                personal.ponerNumeroTelefono(resultado.getString("telefono"));
                personal.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
            }
        }
        return personal;
    }

    @Override
    public List<Personal> recuperarListaPersonal() throws SQLException {
        List<Personal> listaPersonal = new ArrayList<>();
        String consulta = "SELECT * FROM `PersonaUV` WHERE `tipo` = ?";
        
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, PersonaUV.PERSONAL);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                Personal personal = new Personal();
                personal.ponerNumeroPersonal(resultado.getString("identificador"));
                personal.ponerTipo(resultado.getString("tipo"));
                personal.ponerNombre(resultado.getString("nombre"));
                personal.ponerApellidoPaterno(resultado.getString("apellidoPaterno"));
                personal.ponerApellidoMaterno(resultado.getString("apellidoMaterno"));
                personal.ponerDomicilio(resultado.getString("domicilio"));
                personal.ponerEmail(resultado.getString("email"));
                personal.ponerNumeroTelefono(resultado.getString("telefono"));
                personal.ponerMontoDeuda(resultado.getFloat("montoDeuda"));
            }
        }
        return listaPersonal;
    }
    
}
