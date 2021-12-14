/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistemabibliotecario.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import sistemabibliotecario.autenticacion.CuentaUsuario;
import sistemabibliotecario.autenticacion.CuentaUsuarioDAO;
import sistemabibliotecario.autenticacion.ICuentaUsuarioDAO;
import sistemabibliotecario.vistas.componentes.Dialogo;

/**
 * FXML Controller class
 *
 * @author Sandoval Bravo Alejandro
 */
public class ControladorInicioDeSesion implements Initializable {

    @FXML
    private TextField campoNombreUsuario;
    @FXML
    private PasswordField campoContrasena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarFormateadorCampoContrasena();
        inicializarFormateadorCampoNombreUsuario();
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        ICuentaUsuarioDAO cuentaUsuarioDAO = new CuentaUsuarioDAO();
        String nombreUsuario = campoNombreUsuario.getText();
        String contrasena = campoContrasena.getText();
        CuentaUsuario usuario = null;
        
        try {
            usuario = cuentaUsuarioDAO.recuperarCuentaUsuario(nombreUsuario);
        } catch(SQLException excepcion) {
            Dialogo.mostrarDialogoError("Error de conexion", "Error al comunicarse con la base de datos");
        }
        
        if (usuario != null) {
            if (BCrypt.checkpw(contrasena, usuario.obtenerContrasena())) {
                desplegarMenuPrincipal(usuario);
            } else {
                mostrarCredencialesIncorrectas();
            }
        } else {
            mostrarCredencialesIncorrectas();
        }
        
    }
    
    private void inicializarFormateadorCampoContrasena() {
        UnaryOperator<TextFormatter.Change> rechazarCambio = cambio -> {
            if (cambio.isContentChange()) {
                if (cambio.getControlNewText().length() > 30) {
                    mostrarMuchosCaracteres((short) 30);
                    return null;
                }
                if (cambio.getControlNewText()
                        .matches("^[!¡?\\[\\]*´|'-.^~`}{:¨;,\"$% &/()=¿+#]+")) {
                    campoContrasena.setText("");
                    return null;
                }
            }
            return cambio;
        };
        campoContrasena.setTextFormatter(new TextFormatter<TextFormatter.Change>(rechazarCambio));
    }

    private void inicializarFormateadorCampoNombreUsuario() {
        UnaryOperator<TextFormatter.Change> rechazarCambio = cambio -> {
            if (cambio.isContentChange()) {
                if (cambio.getControlNewText().length() > 30) {
                    mostrarMuchosCaracteres((short) 30);
                    return null;
                }
                if (!cambio.getControlNewText().matches("^[a-zA-Z0-9ñÑ.]*$")) {
                    campoNombreUsuario.setText("");
                    return null;
                }
            }
            return cambio;
        };
        campoNombreUsuario.setTextFormatter(new TextFormatter<TextFormatter.Change>(rechazarCambio));
    }
    
    public void mostrarMuchosCaracteres(short characterLength) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Límite de caracteres excedido");
        alert.setContentText(String.format("El límite de es de %d. caracteres", characterLength));
        alert.showAndWait();
    }
    
    private void mostrarCredencialesIncorrectas() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Credenciales Incorrectas");
        alert.setContentText("Usuario o contraseña incorrectas. Por favor intente nuevamente.");
        alert.showAndWait();
    }

    private void desplegarMenuPrincipal(CuentaUsuario usuario) {
        Stage ventana = (Stage) campoNombreUsuario.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sistemabibliotecario/vistas/VistaMenuPrincipal.fxml"));
        
        try {
            Parent archivoDeVista;
            archivoDeVista = loader.load();
            ControladorMenuPrincipal menuPrincipal = loader.getController();
            menuPrincipal.ponerCuentaUsuario(usuario);
            ventana.setScene(new Scene(archivoDeVista, 1280, 720));
        } catch(IOException excepcion) {
            Dialogo.mostrarDialogoError("Error de lectura", excepcion.getMessage());
        }
    }
}
