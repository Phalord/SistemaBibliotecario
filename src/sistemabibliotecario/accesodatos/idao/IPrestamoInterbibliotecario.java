/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.PrestamoInterbibliotecario;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IPrestamoInterbibliotecario {
    boolean agregarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario);
    boolean modificarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario);
    boolean eliminarPrestamoInterbibliotecario(PrestamoInterbibliotecario prestamoInterbibliotecario);
    PrestamoInterbibliotecario recuperarPrestamoInterbibliotecario(int id);
    List<PrestamoInterbibliotecario> recuperarPrestamosActivos();
    List<PrestamoInterbibliotecario> recuperarPrestamosDevueltos();
    List<PrestamoInterbibliotecario> recuperarPrestamosAtrasados();
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoActivos(RecursoDocumental recursoDocumental);
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoDevueltos(RecursoDocumental recursoDocumental);
    List<PrestamoInterbibliotecario> recuperarPrestamosDeRecursoAtrasados(RecursoDocumental recursoDocumental);
}
