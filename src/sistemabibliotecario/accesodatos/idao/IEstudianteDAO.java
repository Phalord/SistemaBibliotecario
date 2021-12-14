/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.Estudiante;

/**
 *
 * @author Dario Castellanos
 */
public interface IEstudianteDAO {
    boolean agregarEstudiante(Estudiante estudiante) throws SQLException;
    boolean modificarEstudiante(Estudiante estudiante) throws SQLException;
    boolean eliminarEstudiante(Estudiante estudiante) throws SQLException;
    Estudiante recuperarEstudiante(String matricula) throws SQLException;
    List<Estudiante> recuperarEstudiantes() throws SQLException;
    List<Estudiante> recuperarEstudiantesInscritos() throws SQLException;
    List<Estudiante> recuperarEstudiantesNoInscritos() throws SQLException;
}
