/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistemabibliotecario.controladores;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistemabibliotecario.autenticacion.CuentaUsuario;
import sistemabibliotecario.vistas.componentes.Dialogo;

/**
 * FXML Controller class
 *
 * @author Alejandro Sandoval Bravo
 */
public class ControladorMenuPrincipal {
    
    private static CuentaUsuario cuentaUsuario = null;

    @FXML
    private GridPane contenedorDeVentana;
    @FXML
    private Button btnMenuAnaliticas;
    @FXML
    private Button btnPrestamos;
    
    public void ponerCuentaUsuario(CuentaUsuario cuentaUsuario) {
        ControladorMenuPrincipal.cuentaUsuario = cuentaUsuario;
        if (ControladorMenuPrincipal.cuentaUsuario.obtenerTipo()
                .equals(CuentaUsuario.BIBLIOTECARIO)) {
            this.btnMenuAnaliticas.setDisable(true);
        } else if (ControladorMenuPrincipal.cuentaUsuario.obtenerTipo()
                .equals(CuentaUsuario.SECRETARIA)) {
            this.btnPrestamos.setDisable(true);
        }
    }
    
    public static CuentaUsuario obtenerCuentaUsuario() {
        return ControladorMenuPrincipal.cuentaUsuario;
    }

    @FXML
    private void desplegarMenuAnaliticas(ActionEvent event) {
        desplegarMenu("/sistemabibliotecario/vistas/VistaMenuAnaliticas.fxml");
    }

    @FXML
    private void desplegarMenuGestionPersonasUV(ActionEvent event) {
        desplegarMenu("/sistemabibliotecario/vistas/VistaGestionDePersonas.fxml");
    }

    @FXML
    private void desplegarMenuGestionRecursosDocumentales(ActionEvent event) {
        desplegarMenu("/sistemabibliotecario/vistas/VistaMenuRecursosDocumentales.fxml");
    }

    @FXML
    private void desplegarMenuPréstamos(ActionEvent event) {
        desplegarMenu("/sistemabibliotecario/vistas/VistaMenuPrestamos.fxml");
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage ventana = (Stage) contenedorDeVentana.getScene().getWindow();
        ventana.close();
    }
    
    private void desplegarMenu(String ubicacionVista) {
        Stage ventana = (Stage) contenedorDeVentana.getScene().getWindow();
        FXMLLoader loader = 
                new FXMLLoader(getClass().getResource(ubicacionVista));
        
        try {
            Parent archivoDeVista;
            archivoDeVista = loader.load();
            ventana.setScene(new Scene(archivoDeVista, 1280, 720));
        } catch (IOException ioException) {
            Dialogo.mostrarDialogoError(
                    "Error", "Algo ha salido mal, por favor intente de nuevo");
        }
    }
    
}
