/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import sistemabibliotecario.dominio.Biblioteca;

/**
 *
 * @author Dario Castellanos
 */
public interface IBibliotecaDAO {
    boolean agregarBiblioteca(Biblioteca biblioteca) throws SQLException;
    boolean modificarBiblioteca(Biblioteca biblioteca) throws SQLException;
    Biblioteca recuperarBiblioteca() throws SQLException;
}
