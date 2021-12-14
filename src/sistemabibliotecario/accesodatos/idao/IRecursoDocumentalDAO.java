/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 *
 * @author Dario Castellanos
 */
public interface IRecursoDocumentalDAO {
    boolean agregarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException;
    boolean modificarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException;
    boolean eliminarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException;
    RecursoDocumental recuperarRecursoDocumental(String codigoDeClasificacion) throws SQLException;
    List<RecursoDocumental> recuperarRecursosDocumentales() throws SQLException;
    List<RecursoDocumental> recuperarRecursosDocumentalesDisponibles() throws SQLException;
}
