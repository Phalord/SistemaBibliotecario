/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.idao;

import java.util.List;
import sistemabibliotecario.dominio.DVD;

/**
 *
 * @author Dario Castellanos
 */
public interface IDVDDAO {
    boolean agregarDVD(DVD dvd);
    boolean eliminarDVD(DVD dvd);
    DVD recuperarDVD(String codigoClasificacion);
    List<DVD> recuperarDVDs();
}
