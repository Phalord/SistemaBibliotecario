/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.PersonaUV;

/**
 *
 * @author Dario Castellanos
 */
public interface IPersonaUVDAO {
    boolean agregarPersonaUV(PersonaUV personaUV) throws SQLException;
    boolean modificarPersonaUV(PersonaUV personaUV) throws SQLException;
    boolean eliminarPersonaUV(PersonaUV personaUV) throws SQLException;
    PersonaUV recuperarPersonaUV(String identificador) throws SQLException;
    List<PersonaUV> recuperarPersonasUV() throws SQLException;
}
