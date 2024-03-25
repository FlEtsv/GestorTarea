package org.Gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import org.BasesDatos.ConsultasDB;
import org.BasesDatos.HashPassword;

public class RegistroController extends BaseControlador {


    @FXML
    private TextField nombreUsuario;
    
    @FXML
    private TextField email;

    @FXML
    private PasswordField contrasena;




@FXML
private void manejarRegistro() {
    String nombre = nombreUsuario.getText().trim();
    String contrasenaString = contrasena.getText().trim();
    String emailString = email.getText().trim();

    // Validación de Entradas
    ConsultasDB insertar = new ConsultasDB();
    if(nombre.isEmpty() || contrasenaString.isEmpty() || emailString.isEmpty()) {
        mostrarAlerta("Error", "Por favor, completa todos los campos.", Alert.AlertType.ERROR);
        return;
    }

    if(!emailValido(emailString)) {
        mostrarAlerta("Error", "El email no tiene un formato válido.", Alert.AlertType.ERROR);
        return;
    }
    if(insertar.usuarioExiste(nombre)){
        mostrarAlerta("Cuidado","El nombre de usuario no esta disponible.",Alert.AlertType.ERROR);
        return;
    }

    // Lógica de registro
    try {
        
        
        insertar.insertarUsuario(nombre, contrasenaString, emailString);
        mostrarAlerta("Registro exitoso", "El usuario ha sido registrado correctamente.", Alert.AlertType.INFORMATION);
        
    } catch(Exception e) {
        mostrarAlerta("Error", "No se pudo registrar el usuario. Inténtalo de nuevo.", Alert.AlertType.ERROR);
    }
    if(mainApp != null) {
            System.out.println("Cargando vista de registro...");
            mainApp.cargarVista("/org/Gui/inicio.fxml");
        } else {
            System.out.println("mainApp es null");
        }
}

private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
    Alert alert = new Alert(tipo);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

private boolean emailValido(String email) {
    String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
}

}


