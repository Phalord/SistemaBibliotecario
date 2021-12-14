/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Tesis;

/**
 *
 * @author Dario Castellanos
 */
public interface ITesisDAO {
    boolean agregarTesis(Tesis tesis) throws SQLException;
    boolean modificarTesis(Tesis tesis) throws SQLException;
    boolean eliminarTesis(Tesis tesis) throws SQLException;
    Tesis recuperarTesis(String codigoDeClasificacio) throws SQLException;
    List<Tesis> recuperarListaTesis() throws SQLException;
}
