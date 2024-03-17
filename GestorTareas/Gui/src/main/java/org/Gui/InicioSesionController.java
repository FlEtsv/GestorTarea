package org.Gui;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.BasesDatos.InicioSesion;
import javafx.scene.input.MouseEvent;

public class InicioSesionController {

    // Referencia a MainApp
    private MainApp mainApp;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private PasswordField contrasena;

    // Setter para inyectar la referencia de MainApp
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void manejarInicioSesion() {
        System.out.println("Intento de inicio de sesión por el usuario: " + nombreUsuario.getText());

        // Aquí tu lógica de autenticación
        String usuario = nombreUsuario.getText();
        String password = contrasena.getText();

        InicioSesion iniciar = new InicioSesion();

        try {
            int resultadoInicioSesion = iniciar.iniciarSesion(usuario, password);
            if(resultadoInicioSesion == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de autenticación");
                alert.setHeaderText(null);
                alert.setContentText("La contraseña o email son incorrectos");
                alert.showAndWait();
            } else {
                // Si la autenticación es exitosa, cambia la vista.
                System.out.println("Autenticación exitosa.");
                // Aquí deberías llamar al método para cambiar de vista, si está implementado.
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al iniciar sesión");
            alert.setContentText("Ocurrió un error al intentar iniciar sesión: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void registrarte(MouseEvent event) {
        System.out.println("Registrarte clickeado");
        if(mainApp != null) {
            System.out.println("Cargando vista de registro...");
            mainApp.cargarVista("/org/Gui/registro.fxml");
        } else {
            System.out.println("mainApp es null");
        }
    }

}


