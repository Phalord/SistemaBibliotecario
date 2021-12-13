/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Personal;

/**
 *
 * @author Dario Castellanos
 */
public interface IPersonalDAO {
    boolean agregarPersonal(Personal personal);
    boolean modificarPersonal(Personal personal);
    boolean eliminarPersonal(Personal personal);
    Personal recuperarPersonal(String numeroPersonal);
    List<Personal> recuperarListaPersonal();
}
