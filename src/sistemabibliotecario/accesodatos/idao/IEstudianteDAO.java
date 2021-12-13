/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Estudiante;

/**
 *
 * @author Dario Castellanos
 */
public interface IEstudianteDAO {
    boolean agregarEstudiante(Estudiante estudiante);
    boolean modificarEstudiante(Estudiante estudiante);
    boolean eliminarEstudiante(Estudiante estudiante);
    Estudiante recuperarEstudiante(String matricula);
    List<Estudiante> recuperarEstudiantes();
    List<Estudiante> recuperarEstudiantesInscritos();
    List<Estudiante> recuperarEstudiantesNoInscritos();
}
