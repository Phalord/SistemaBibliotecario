/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.autenticacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.dominio.ConexionBD;

/**
 *
 * @author Sandoval Bravo Alejandro
 */
public class CuentaUsuarioDAO implements ICuentaUsuarioDAO {

    @Override
    public CuentaUsuario recuperarCuentaUsuario(String nombreUsuario) throws SQLException {
        CuentaUsuario cuentaUsuario = null;
        String consulta = "SELECT * FROM `Cuentas Usuario` WHERE nombreUsuario = ?";
        try (Connection conexion = ConexionBD.abrirConexionBD();
             PreparedStatement consultaPreparada = conexion.prepareStatement(consulta)) {
            consultaPreparada.setString(1, nombreUsuario);
            try (ResultSet resultado = consultaPreparada.executeQuery()) {
                while(resultado.next()) {
                    cuentaUsuario = new CuentaUsuario();
                    cuentaUsuario.ponerNombreUsuario(resultado.getString("nombreUsuario"));
                    cuentaUsuario.ponerContrasena(resultado.getString("contrasena"));
                    cuentaUsuario.ponerTipo(resultado.getString("tipo"));
                }
            }
        } catch (SQLException sqlException) {
            throw sqlException;
        }
        return cuentaUsuario;
    }
    
}
