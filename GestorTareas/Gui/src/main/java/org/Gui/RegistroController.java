package org.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;

public class RegistroController {

    private MainApp mainApp;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private PasswordField contrasena;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void manejarRegistro() {
        // Lógica de registro
        System.out.println("registrado");
    }
}
