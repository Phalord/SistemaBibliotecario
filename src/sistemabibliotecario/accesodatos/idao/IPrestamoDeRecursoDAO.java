/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.PrestamoDeRecurso;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IPrestamoDeRecursoDAO {
    boolean agregarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException;
    boolean modificarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException;
    boolean eliminarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso) throws SQLException;
    PrestamoDeRecurso recuperarPrestamoDeRecurso(String identificadorPersona, String codigoRecurso, Date fechaPrestamo) throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamos() throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosActivos() throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosAtrasados() throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosDevueltos() throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosDeRecurso(RecursoDocumental recursoDocumental) throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosDeRecursoAtrasados(RecursoDocumental recursoDocumental) throws SQLException;
    List<PrestamoDeRecurso> recuperarPrestamosDeRecursoDevueltos(RecursoDocumental recursoDocumental) throws SQLException;
}
