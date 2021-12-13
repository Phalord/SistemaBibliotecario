/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Disco;

/**
 *
 * @author Dario Castellanos
 */
public interface IDiscoDAO {
    boolean agregarDisco(Disco disco);
    boolean modificarDisco(Disco disco);
    boolean eliminarDisco(Disco disco);
    Disco recuperarDisco(String codigoClasificacion);
    List<Disco> recuperarDiscos();
    List<Disco> recuperarDiscosPrestados();
    List<Disco> recuperarDiscosDisponibles();
    List<Disco> recuperarDiscosEnReparacion();
}
