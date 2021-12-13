/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.PersonaUV;

/**
 *
 * @author Dario Castellanos
 */
public interface IPersonaUVDAO {
    boolean agregarPersonaUV(PersonaUV personaUV);
    boolean modificarPersonaUV(PersonaUV personaUV);
    boolean eliminarPersonaUV(PersonaUV personaUV);
    PersonaUV recuperarPersonaUV(String identificador);
    List<PersonaUV> recuperarPersonasUV();
}
