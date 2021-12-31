/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.SQLException;
import java.util.List;
import sistemabibliotecario.accesodatos.idao.IMapaDAO;
import sistemabibliotecario.dominio.Mapa;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class MapaDAO implements IMapaDAO {

    @Override
    public boolean agregarMapa(Mapa mapa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarMapa(Mapa mapa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarMapa(Mapa mapa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mapa recuperarMapa(String codigoClasificacion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> recuperarMapas() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> recuperarMapasDisponibles() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> recuperarMapasEnReparacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> recuperarMapasPrestados() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[] dividirTemas(String temas) {
            return temas.split(";");
    }

    private String[] dividirAutores(String autores) {
            return autores.split(";");
    }
    
}
