/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.PrestamoInterbibliotecario;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IPrestamoInterbibliotecarioDAO {
    boolean agregarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario) throws SQLException;
    boolean modificarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario) throws SQLException;
    boolean eliminarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario) throws SQLException;
    PrestamoInterbibliotecario recuperarPrestamoInterbibliotecario(int id) throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosActivos() throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosDevueltos() throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosAtrasados() throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoActivos(RecursoDocumental recursoDocumental) throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoDevueltos(RecursoDocumental recursoDocumental) throws SQLException;
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoAtrasados(RecursoDocumental recursoDocumental) throws SQLException;
}
