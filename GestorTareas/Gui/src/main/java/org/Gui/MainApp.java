package org.Gui;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private StackPane mainContainer = new StackPane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Configura y muestra la escena principal
        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicación con Contenedor Principal");
        primaryStage.show();

        // Carga la vista de inicio de sesión como inicial
        cargarVistaInicioSesion();
    }

private void cargarVistaInicioSesion() {
    try {
        URL url = getClass().getResource("/org/Gui/inicio.fxml");

        System.out.println("URL del FXML: " + url);
        
        // Asegúrate de que 'url' no sea null antes de continuar
        if (url != null) {
            // Carga la vista desde la URL y la asigna a una variable
            VBox inicioSesion = FXMLLoader.load(url);
            
            // Ahora puedes utilizar 'inicioSesion' correctamente
            mainContainer.getChildren().setAll(inicioSesion);
        } else {
            // Maneja el caso en que la URL sea null para evitar una NullPointerException
            System.err.println("No se pudo cargar el recurso: InicioSesion.fxml");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}}

