/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IRecursoDocumental {
    boolean agregarRecursoDocumental(RecursoDocumental recursoDocumental);
    boolean modificarRecursoDocumental(RecursoDocumental recursoDocumental);
    boolean eliminarRecursoDocumental(RecursoDocumental recursoDocumental);
    RecursoDocumental recuperarRecursoDocumental(String codigoDeClasificacion);
    List<RecursoDocumental> recuperarRecursosDocumentales();
    List<RecursoDocumental> recuperarRecursosDocumentalesDisponibles();
}
