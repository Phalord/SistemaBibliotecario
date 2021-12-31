/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sistemabibliotecario.accesodatos.idao.IRecursoDocumentalDAO;
import sistemabibliotecario.dominio.ConexionBD;
import sistemabibliotecario.dominio.RecursoDocumental;

/**
 * @author alex_
 */
public class RecursoDocumentalDAO implements IRecursoDocumentalDAO {
	
	@Override
	public boolean agregarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
            boolean resultado;
            String query = "INSERT INTO `RecursoDocumental` " +
                "(codigoClasificacion, autor, fechaDeEdicion, idioma, titulo, estado, numCopias, temas) " +
                "VALUES(?,?,?,?,?,?,?,?)";
            String temas = unificarTemas(recursoDocumental);
            String autores = unificarAutores(recursoDocumental);
            try (PreparedStatement consultaPreparada =
                         ConexionBD.abrirConexionBD().prepareStatement(query)) {
                consultaPreparada.setString(
                        1, recursoDocumental.obtenerCodigoDeClasificacion());
                consultaPreparada.setString(2, autores);
                consultaPreparada.setDate(
                        3, recursoDocumental.fechaDeEdicion());
                consultaPreparada.setString(
                        4, recursoDocumental.obtenerIdioma());
                consultaPreparada.setString(
                        5, recursoDocumental.obtenerTitulo());
                consultaPreparada.setString(
                        6, recursoDocumental.obtenerEstado());
                consultaPreparada.setInt(
                        7, recursoDocumental.obtenerNumeroCopias());
                consultaPreparada.setString(8, temas);

                int numeroFilasAfectadas = consultaPreparada.executeUpdate();
                resultado = numeroFilasAfectadas > 0;
            }
            return resultado;
	}
	
	@Override
	public boolean modificarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
            boolean resultado;
            String query = "UPDATE `RecursoDocumental` " +
                "SET autor = ?, fechaDeEdicion = ?, idioma = ?, titulo = ?, estado = ?, numCopias = ?, " +
                "temas = ?, codigoDeClasificacion = ? " +
                "WHERE id = ?";
            try (PreparedStatement consulta =
                    ConexionBD.abrirConexionBD().prepareStatement(query)) {
                consulta.setString(1, unificarAutores(recursoDocumental));
                consulta.setDate(2, recursoDocumental.fechaDeEdicion());
                consulta.setString(3, recursoDocumental.obtenerIdioma());
                consulta.setString(4, recursoDocumental.obtenerTitulo());
                consulta.setString(5, recursoDocumental.obtenerEstado());
                consulta.setInt(6, recursoDocumental.obtenerNumeroCopias());
                consulta.setString(7, unificarTemas(recursoDocumental));
                consulta.setString(
                        8, recursoDocumental.obtenerCodigoDeClasificacion());
                consulta.setInt(9, recursoDocumental.obtenerId());
                resultado = consulta.executeUpdate() > 0;
            }
            return resultado;
	}
	
	@Override
	public boolean eliminarRecursoDocumental(RecursoDocumental recursoDocumental) throws SQLException {
            boolean eliminado;
            String consulta = "DELETE FROM `RecursoDocumental` WHERE codigoDeClasificacion = ?";
            try (PreparedStatement consultaPreparada =
                    ConexionBD.abrirConexionBD().prepareStatement(consulta)) {
                consultaPreparada.setString(
                        1, recursoDocumental.obtenerCodigoDeClasificacion());
                eliminado = consultaPreparada.executeUpdate() > 0;
            }
            return eliminado;
	}
	
	@Override
	public RecursoDocumental recuperarRecursoDocumental(String codigoDeClasificacion) throws SQLException {
            RecursoDocumental recursoDocumental = null;
            String query = "SELECT * FROM `RecursoDocumental` WHERE codigoDeClasificacion = ?";
		
            try (PreparedStatement seleccion =
                    ConexionBD.abrirConexionBD().prepareStatement(query)) {
                seleccion.setString(1, codigoDeClasificacion);

                ResultSet resultado = seleccion.executeQuery();
                if (resultado.getFetchSize() == 1) {
                    recursoDocumental = new RecursoDocumental();
                    recursoDocumental.ponerCodigoDeClasificacion(
                            resultado.getString("codigoDeClasificacion"));
                    recursoDocumental.ponerAutores(Arrays.asList(
                            dividirAutores(resultado.getString("autor"))));
                    recursoDocumental.ponerFechaDeEdicion(
                            resultado.getDate("fechaDeEdicion"));
                    recursoDocumental.ponerIdioma(
                            resultado.getString("idioma"));
                    recursoDocumental.ponerTitulo(
                            resultado.getString("titulo"));
                    recursoDocumental.ponerEstado(
                            resultado.getString("estado"));
                    recursoDocumental.ponerNumeroCopias(
                            resultado.getInt("numCopias"));
                    recursoDocumental.ponerTemas(Arrays
                            .asList(dividirTemas(resultado.getString("temas"))));
                }
            }
            return recursoDocumental;
	}
	
	@Override
	public List<RecursoDocumental> recuperarRecursosDocumentales() throws SQLException {
            List<RecursoDocumental> recursos = new ArrayList<>();
            String query = "SELECT * FROM `RecursoDocumental`";

            try (PreparedStatement seleccion =
                    ConexionBD.abrirConexionBD().prepareStatement(query)) {
                ResultSet resultados = seleccion.executeQuery();
                while (resultados.next()) {
                    RecursoDocumental recursoTemp = new RecursoDocumental();
                    recursoTemp.ponerId(resultados.getInt("id"));
                    recursoTemp.ponerAutores(Arrays.asList(
                            dividirAutores(resultados.getString("autor"))));
                    recursoTemp.ponerFechaDeEdicion(
                            resultados.getDate("fechaDeEdicion"));
                    recursoTemp.ponerIdioma(resultados.getString("idioma"));
                    recursoTemp.ponerTitulo(resultados.getString("titulo"));
                    recursoTemp.ponerEstado(resultados.getString("estado"));
                    recursoTemp.ponerNumeroCopias(
                            resultados.getInt("numCopias"));
                    recursoTemp.ponerTemas(Arrays.asList(
                            dividirTemas(resultados.getString("temas"))));
                    recursoTemp.ponerCodigoDeClasificacion(
                            resultados.getString("codigoClasificacion"));
                    recursos.add(recursoTemp);
                }
            }
            return recursos;
	}
	
	@Override
	public List<RecursoDocumental> recuperarRecursosDocumentalesDisponibles() throws SQLException {
		List<RecursoDocumental> recursos = new ArrayList<>();
		recuperarRecursosDocumentales().forEach(recursoDocumental -> {
			if (recursoDocumental.hayCopiasDisponibles()) {
				recursos.add(recursoDocumental);
			}
		});
		return recursos;
	}
	
	private String unificarTemas(RecursoDocumental recursoDocumental) {
		String temas = "";
		for (String tema: recursoDocumental.obtenerTemas()) {
			temas += String.format("%s;", tema);
		}
		return temas;
	}
	
	private String unificarAutores(RecursoDocumental recursoDocumental) {
		String autores = "";
		for (String autor: recursoDocumental.obtenerAutores()) {
			autores += String.format("%s;", autor);
		}
		return autores;
	}
	
	private String[] dividirTemas(String temas) {
		return temas.split(";");
	}
	
	private String[] dividirAutores(String autores) {
		return autores.split(";");
	}
	
}
