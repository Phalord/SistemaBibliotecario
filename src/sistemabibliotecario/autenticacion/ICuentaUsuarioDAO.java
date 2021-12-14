/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.autenticacion;

import java.sql.SQLException;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public interface ICuentaUsuarioDAO {
    CuentaUsuario recuperarCuentaUsuario(String nombreUsuario) throws SQLException;
}
