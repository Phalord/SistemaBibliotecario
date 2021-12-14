/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.accesodatos.dao;

import java.util.List;
import sistemabibliotecario.accesodatos.idao.ICopiaRecursoDAO;
import sistemabibliotecario.dominio.CopiaRecurso;

/**
 *
 * @author Brandon Lopez
 */
public class CopiaRecursoDAO implements ICopiaRecursoDAO {

    @Override
    public boolean agregarCopiaRecurso(CopiaRecurso copiaRecurso) {
        boolean resultado = false;
        
        return resultado;
    }

    @Override
    public boolean modificarCopiaRecurso(CopiaRecurso copiaRecurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarCopiaRecurso(CopiaRecurso copiaRecurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CopiaRecurso recuperarCopiaRecurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoDisponibles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoPrestadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CopiaRecurso> recuperarCopiasRecursoEnReparacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
