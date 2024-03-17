/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.Gui;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.BasesDatos.InicioSesion;

public class InicioSesionController {

    
    @FXML
    private TextField nombreUsuario;

    @FXML
    private PasswordField contrasena;

    @FXML
private void manejarInicioSesion() {
    System.out.println("Intento de inicio de sesión por el usuario: " + nombreUsuario.getText());
    
    // Aquí tu lógica de autenticación
    String usuario = nombreUsuario.getText();
    String password = contrasena.getText();
    
    InicioSesion iniciar = new InicioSesion();
    int resultadoInicioSesion = iniciar.iniciarSesion(usuario, password);
    
    if(resultadoInicioSesion == -1){
        // Usando JOptionPane para mostrar el error
        // JOptionPane.showInputDialog debe ser cambiado por JOptionPane.showMessageDialog para solo mostrar el mensaje sin pedir entrada.
       Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de autenticación");
        alert.setHeaderText(null);
        alert.setContentText("La contraseña o email son incorrectos");
        alert.showAndWait();

    } else {
        // Si la autenticación es exitosa, cambia la vista.
        // Asegúrate de que MainApp.cargarOtraVista(); esté correctamente implementado para cambiar a otra vista.
         // Asumiendo que este método está correctamente implementado para cambiar la vista.
    }
}

}

        // TODO
   
    

