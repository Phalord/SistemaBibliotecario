/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.CopiaRecurso;

/**
 *
 * @author DarioCastellanos
 */
public interface ICopiaRecursoDAO {
    boolean agregarCopiaRecurso(CopiaRecurso copiaRecurso);
    boolean modificarCopiaRecurso(CopiaRecurso copiaRecurso);
    boolean eliminarCopiaRecurso(CopiaRecurso copiaRecurso);
    CopiaRecurso recuperarCopiaRecurso();
    List<CopiaRecurso> recuperarCopiasRecurso();
    List<CopiaRecurso> recuperarCopiasRecursoDisponibles();
    List<CopiaRecurso> recuperarCopiasRecursoPrestadas();
    List<CopiaRecurso> recuperarCopiasRecursoEnReparacion();
}
