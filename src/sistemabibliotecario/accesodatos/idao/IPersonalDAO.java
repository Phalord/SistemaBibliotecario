/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Personal;

/**
 *
 * @author Dario Castellanos
 */
public interface IPersonalDAO {
    boolean agregarPersonal(Personal personal) throws SQLException;
    boolean modificarPersonal(Personal personal) throws SQLException;
    boolean eliminarPersonal(Personal personal) throws SQLException;
    Personal recuperarPersonal(String numeroPersonal) throws SQLException;
    List<Personal> recuperarListaPersonal() throws SQLException;
}
