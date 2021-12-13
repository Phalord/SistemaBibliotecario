/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Periodico;

/**
 *
 * @author Dario Castellanos
 */
public interface IPeriodicoDAO {
    boolean agregarPeriodico(Periodico periodico);
    boolean modificarPeriodico(Periodico periodico);
    boolean eliminarPeriodico(Periodico periodico);
    Periodico recuperarPeriodico(String codigoClasificacion);
    List<Periodico> recuperarPeriodicos();
    List<Periodico> recuperarPeriodicosPrestados();
    List<Periodico> recuperarPeriodicosDisponibles();
    List<Periodico> recuperarPeriodicosEnReparacion();
}
