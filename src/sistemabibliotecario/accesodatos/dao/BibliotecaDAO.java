/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.accesodatos.idao.IBibliotecaDAO;
import sistemabibliotecario.dominio.Biblioteca;
import sistemabibliotecario.dominio.ConexionBD;

/**
 *
 * @author Brandon Lopez Tenorio
 */
public class BibliotecaDAO implements IBibliotecaDAO {

    @Override
    public boolean agregarBiblioteca(Biblioteca biblioteca) throws SQLException {
        boolean resultado;
        String consulta = "INSERT INTO `Biblioteca` (direccion, nombre, region, telefono) VALUES (?,?,?,?)";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, biblioteca.obtenerDireccion());
            consultaPreparada.setString(2, biblioteca.obtenerNombre());
            consultaPreparada.setString(3, biblioteca.obtenerRegion());
            consultaPreparada.setString(4, biblioteca.obtenerTelefono());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        return resultado;
    }

    @Override
    public boolean modificarBiblioteca(Biblioteca biblioteca) throws SQLException {
        boolean resultado;
        String consulta = "UPDATE `Biblioteca` SET direccion = ?, nombre = ?, region = ?, telefono = ? WHERE `idBiblioteca` = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setString(1, biblioteca.obtenerDireccion());
            consultaPreparada.setString(2, biblioteca.obtenerNombre());
            consultaPreparada.setString(3, biblioteca.obtenerRegion());
            consultaPreparada.setString(4, biblioteca.obtenerTelefono());
            consultaPreparada.setInt(5, biblioteca.obtenerID());
            
            resultado = consultaPreparada.executeUpdate() > 0;
        }
        
        return resultado;
    }

    @Override
    public Biblioteca recuperarBiblioteca(int idBiblioteca) throws SQLException {
        Biblioteca biblioteca = null;
        String consulta = "SELECT * FROM `Biblioteca` WHERE idBiblioteca = ?";
        try (PreparedStatement consultaPreparada = ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
            consultaPreparada.setInt(1, idBiblioteca);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            if (resultado.next()) {
                biblioteca = new Biblioteca();
                biblioteca.ponerID(resultado.getInt("idBiblioteca"));
                biblioteca.ponerNombre(resultado.getString("nombre"));
                biblioteca.ponerDireccion(resultado.getString("direccion"));
                biblioteca.ponerRegion(resultado.getString("region"));
                biblioteca.ponerTelefono(resultado.getString("telefono"));
            }
        }
        return biblioteca;
    }    
}
