/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.CopiaRecurso;

/**
 *
 * @author DarioCastellanos
 */
public interface ICopiaRecursoDAO {
    boolean agregarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException;
    boolean modificarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException;
    boolean eliminarCopiaRecurso(CopiaRecurso copiaRecurso) throws SQLException;
    List<CopiaRecurso> recuperarCopiasRecurso(String codigoDeClasificacion) throws SQLException;
    List<CopiaRecurso> recuperarCopiasRecursoDisponibles(String codigoDeClasificacion) throws SQLException;
    List<CopiaRecurso> recuperarCopiasRecursoPrestadas(String codigoDeClasificacion) throws SQLException;
    List<CopiaRecurso> recuperarCopiasRecursoEnReparacion(String codigoDeClasificacion) throws SQLException;
}
