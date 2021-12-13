/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.PrestamoDeRecurso;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IPrestamoDeRecursoDAO {
    boolean agregarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso);
    boolean modificarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso);
    boolean eliminarPrestamoDeRecurso(PrestamoDeRecurso prestamoDeRecurso);
    PrestamoDeRecurso recuperarPrestamoDeRecurso(int id);
    List<PrestamoDeRecurso> recuperarPrestamos();
    List<PrestamoDeRecurso> recuperarPrestamosActivos();
    List<PrestamoDeRecurso> recuperarPrestamosAtrasados();
    List<PrestamoDeRecurso> recuperarPrestamosDevueltos();
    List<PrestamoDeRecurso> recuperarPrestamosDeRecurso(RecursoDocumental recursoDocumental);
    List<PrestamoDeRecurso> recuperarPrestamosDeRecursoAtrasados(RecursoDocumental recursoDocumental);
    List<PrestamoDeRecurso> recuperarPrestamosDeRecursoDevueltos(RecursoDocumental recursoDocumental);
}
