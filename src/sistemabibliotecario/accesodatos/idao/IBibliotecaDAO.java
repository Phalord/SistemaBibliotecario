/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import sistemabibliotecario.dominio.Biblioteca;

/**
 *
 * @author Dario Castellanos
 */
public interface IBibliotecaDAO {
    boolean agregarBiblioteca(Biblioteca biblioteca);
    boolean modificarBiblioteca(Biblioteca biblioteca);
    Biblioteca recuperarBiblioteca();
}
