/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.Tesis;

/**
 *
 * @author Dario Castellanos
 */
public interface ITesisDAO {
    boolean agregarTesis(Tesis tesis);
    boolean modificarTesis(Tesis tesis);
    boolean eliminarTesis(Tesis tesis);
    Tesis recuperarTesis(String codigoDeClasificacio);
    List<Tesis> recuperarListaTesis();
}
