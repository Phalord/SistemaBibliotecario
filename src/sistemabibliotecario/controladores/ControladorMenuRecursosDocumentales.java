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
import sun.reflect.generics.reflectiveObjects.NotImplementedException;



/**
 * FXML Controller class
 *
 * @author alex_
 */
public class ControladorMenuRecursosDocumentales {

    @FXML
    private GridPane contenedorDeVentana;

    @FXML
    private void registrarRecursoDocumental(ActionEvent event) {
        throw new NotImplementedException();
    }

    @FXML
    private void modificarRecursoDocumental(ActionEvent event) {
        throw new NotImplementedException();
    }

    @FXML
    private void pausarRecursoDocumental(ActionEvent event) {
        throw new NotImplementedException();
    }

    @FXML
    private void reactivarRecursoDocumental(ActionEvent event) {
        throw new NotImplementedException();
    }

    @FXML
    private void eliminarRecursoDocumental(ActionEvent event) {
        throw new NotImplementedException();
    }

    @FXML
    private void navegarAtras(ActionEvent event) {
        Stage ventana = (Stage) contenedorDeVentana.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/sistemabibliotecario/vistas/VistaMenuPrincipal.fxml"));
        
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
