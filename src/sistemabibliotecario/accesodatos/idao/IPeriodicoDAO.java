/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Periodico;

/**
 *
 * @author Dario Castellanos
 */
public interface IPeriodicoDAO {
    boolean agregarPeriodico(Periodico periodico) throws SQLException;
    boolean modificarPeriodico(Periodico periodico) throws SQLException;
    boolean eliminarPeriodico(Periodico periodico) throws SQLException;
    Periodico recuperarPeriodico(String codigoClasificacion) throws SQLException;
    List<Periodico> recuperarPeriodicos() throws SQLException;
    List<Periodico> recuperarPeriodicosPrestados() throws SQLException;
    List<Periodico> recuperarPeriodicosDisponibles() throws SQLException;
    List<Periodico> recuperarPeriodicosNoDisponibles() throws SQLException;
}
