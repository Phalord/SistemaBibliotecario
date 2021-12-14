/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Mapa;

/**
 *
 * @author Dario Castellanos
 */
public interface IMapaDAO {
    boolean agregarMapa(Mapa mapa) throws SQLException;
    boolean modificarMapa(Mapa mapa) throws SQLException;
    boolean eliminarMapa(Mapa mapa) throws SQLException;
    Mapa recuperarMapa(String codigoClasificacion) throws SQLException;
    List<Mapa> recuperarMapas() throws SQLException;
    List<Mapa> recuperarMapasDisponibles() throws SQLException;
    List<Mapa> recuperarMapasEnReparacion() throws SQLException;
    List<Mapa> recuperarMapasPrestados() throws SQLException;
}
