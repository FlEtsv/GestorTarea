package org.Gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final StackPane mainContainer = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.show();

        cargarVista("/org/Gui/inicio.fxml");
    }

public void cargarVista(String fxmlPath) {
    try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        VBox vista = loader.load();

        // Inyectar la instancia de MainApp
        BaseControlador controller = loader.getController();
        controller.setMainApp(this);

        mainContainer.getChildren().setAll(vista);
    } catch (IOException e) {
        System.err.println("No se pudo cargar el recurso: " + fxmlPath);
    }
}

/*
    public static void main(String[] args) {
        launch(args);
    }
*/
}
