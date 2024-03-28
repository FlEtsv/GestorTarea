package org.Gui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.Gui.Dialogos;

public class MainApp extends Application {

    private final StackPane mainContainer = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.show();

        cargarVista("/org/Gui/inicio.fxml", primaryStage);
    }

public void cargarVista(String fxmlPath, Stage stageActual) {
    // Intenta obtener el recurso como un stream
    InputStream is = getClass().getResourceAsStream(fxmlPath);
    if (is != null) {
        try {
            // Cerramos el InputStream ya que solo quiero comprobar su existencia
            is.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlPath));
            VBox vista = loader.load();

            // Inyectar la instancia de MainApp
            BaseControlador controller = loader.getController();
            controller.setMainApp(this);

            if (controller instanceof ControladorConStage) {
                ((ControladorConStage) controller).setStage(stageActual);
            }
            mainContainer.getChildren().clear();
            mainContainer.getChildren().setAll(vista);
        } catch (IOException e) {
            System.err.println("No se pudo cargar el recurso: " + fxmlPath);
        }
    } else {
        String dialogoPerso = "No se ha podido encontrar la ruta a la vista";
        Dialogos dialogo = new Dialogos();
        dialogo.mostrarDialogoPersonalizado(dialogoPerso);
    }
}


}


/*
    public static void main(String[] args) {
        launch(args);
    }
*/

