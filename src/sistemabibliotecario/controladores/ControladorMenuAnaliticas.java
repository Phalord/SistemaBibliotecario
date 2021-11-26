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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sistemabibliotecario.vistas.componentes.Dialogo;

/**
 * FXML Controller class
 *
 * @author Alejandro Sandoval Bravo
 */
public class ControladorMenuAnaliticas {

    @FXML
    private GridPane contenedorDeVentana;

    @FXML
    private void desplegarVistaReportePrestamos(ActionEvent event) {
        Stage ventana = (Stage) contenedorDeVentana.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/sistemabibliotecario/vistas/VistaReporteDePrestamo.fxml"));
        
        try {
            Parent archivoDeVista;
            archivoDeVista = loader.load();
            ventana.setScene(new Scene(archivoDeVista, 1280, 720));
        } catch (IOException ioException) {
            Dialogo.mostrarDialogo(
                    "Error", "Algo ha salido mal, por favor intente de nuevo");
        }
    }

    @FXML
    private void desplegarVistaReporteVisitas(ActionEvent event) {
                Stage ventana = (Stage) contenedorDeVentana.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/sistemabibliotecario/vistas/VistaReporteDeVisitas.fxml"));
        
        try {
            Parent archivoDeVista;
            archivoDeVista = loader.load();
            ventana.setScene(new Scene(archivoDeVista, 1280, 720));
        } catch (IOException ioException) {
            Dialogo.mostrarDialogo(
                    "Error", "Algo ha salido mal, por favor intente de nuevo");
        }
    }
    
}
