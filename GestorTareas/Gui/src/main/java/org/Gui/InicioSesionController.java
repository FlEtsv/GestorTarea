package org.Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.BasesDatos.InicioSesion;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InicioSesionController extends BaseControlador implements  ControladorConStage {
    private Stage stage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    

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

        try {
            int resultadoInicioSesion = iniciar.iniciarSesion(usuario, password);
            if(resultadoInicioSesion == -3){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de autenticación");
                alert.setHeaderText(null);
                alert.setContentText("La contraseña o email son incorrectos");
                alert.showAndWait();
            } else {
                Sesion.getInstance().setResultadoInicioSesion(resultadoInicioSesion);
                // Si la autenticación es exitosa, cambia la vista.
                System.out.println("Autenticación exitosa. cargando vista tareas");
                mainApp.cargarVista("/org/Gui/vistaTareas.fxml", stage);
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
            mainApp.cargarVista("/org/Gui/registro.fxml", stage);
        } else {
            System.out.println("mainApp es null");
        }
    }
    
    public void cambiarIdioma(ActionEvent event) {
    if (Sesion.getInstance().getIdioma().equals("Español")) {
        Sesion.getInstance().setIdioma("Ingles");
    } else {
        Sesion.getInstance().setIdioma("Español");
    }

        actualizarTextos();
    }

    private void actualizarTextos() {
        mainApp.cargarVista("/org/Gui/inicio.fxml", stage);
    }
    }




