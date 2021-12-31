/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Disco;

/**
 *
 * @author Dario Castellanos
 */
public interface IDiscoDAO {
    boolean agregarDisco(Disco disco) throws SQLException;
    boolean modificarDisco(Disco disco) throws SQLException;
    boolean eliminarDisco(Disco disco) throws SQLException;
    Disco recuperarDisco(String codigoClasificacion) throws SQLException;
    List<Disco> recuperarDiscos() throws SQLException;
    List<Disco> recuperarDiscosPrestados() throws SQLException;
    List<Disco> recuperarDiscosDisponibles() throws SQLException;
    List<Disco> recuperarDiscosNoDisponibles() throws SQLException;
}
