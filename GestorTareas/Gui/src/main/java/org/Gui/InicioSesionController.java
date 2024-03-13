/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.Gui;



import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionController {

    
    @FXML
    private TextField nombreUsuario;

    @FXML
    private PasswordField contrasena;

    @FXML
    private void manejarInicioSesion() {
        System.out.println("Intento de inicio de sesión por el usuario: " + nombreUsuario.getText());
        // Aquí tu lógica de autenticación
        
        // Si la autenticación es exitosa, cambia la vista
        // MainApp.cargarOtraVista();
    }
}

        // TODO
   
    

