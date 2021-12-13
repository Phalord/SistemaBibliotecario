/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Mapa;

/**
 *
 * @author Dario Castellanos
 */
public interface IMapaDAO {
    boolean agregarMapa(Mapa mapa);
    boolean modificarMapa(Mapa mapa);
    boolean eliminarMapa(Mapa mapa);
    Mapa recuperarMapa(String codigoClasificacion);
    List<Mapa> recuperarMapas();
    List<Mapa> recuperarMapasDisponibles();
    List<Mapa> recuperarMapasEnReparacion();
    List<Mapa> recuperarMapasPrestados();
}
