/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.dominio.DVD;

/**
 *
 * @author Dario Castellanos
 */
public interface IDVDDAO {
    boolean agregarDVD(DVD dvd) throws SQLException;
    boolean eliminarDVD(DVD dvd) throws SQLException;
    DVD recuperarDVD(String codigoClasificacion) throws SQLException;
    List<DVD> recuperarDVDs() throws SQLException;
}
