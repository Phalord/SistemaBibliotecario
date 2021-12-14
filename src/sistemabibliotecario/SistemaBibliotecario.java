/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package sistemabibliotecario;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistemabibliotecario.vistas.componentes.Dialogo;

/**
 *
 * @author Alejandro Sandoval Bravo
 */
public class SistemaBibliotecario extends Application {
    
    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("vistas/VistaInicioDeSesion.fxml"));
        
        try {
            Parent archivoVista;
            archivoVista = loader.load();
            Scene escena = new Scene(archivoVista, 1280, 720);
            stage.setScene(escena);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ioException) {
            Dialogo.mostrarDialogoError(
                    "Error", "Algo ha salido mal, por favor intente de nuevo");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
