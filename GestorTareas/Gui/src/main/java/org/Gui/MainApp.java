package org.Gui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.Gui.Dialogos;

public class MainApp extends Application {

    private final StackPane mainContainer = new StackPane();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.show();

        cargarVista("/org/Gui/inicio.fxml", primaryStage);
    }

public void cargarVista(String fxmlPath, Stage stageActual) {
    Locale idiomaLocalizacion = null; // Inicializa la variable aquí
    InputStream is = null;
    try {
        // Especifica el Locale que deseas usar basado en la sesión
        if (Sesion.getInstance().getIdioma().equals("Español")) {
            idiomaLocalizacion = new Locale("es", "ES"); // Para español de España
        } else {
            idiomaLocalizacion = new Locale("en", "US"); // Para inglés de Estados Unidos
        }

        // Asegura que idiomaLocalizacion ha sido inicializado
        if (idiomaLocalizacion == null) {
            throw new RuntimeException("Locale no establecido correctamente");
        }

        // Carga el ResourceBundle para la localización con el Locale específico
        ResourceBundle bundle = ResourceBundle.getBundle("org.Gui.MessagesBundle", idiomaLocalizacion);
        
        // Intenta obtener el recurso como un stream
        is = getClass().getResourceAsStream(fxmlPath);
        if (is != null) {
            Dialogos dialogo = new Dialogos();
            dialogo.mostrarDialogoPersonalizado("Ruta encontrada y existente");
            
            FXMLLoader loader = new FXMLLoader();
            loader.setResources(bundle);  // Establece el ResourceBundle en el FXMLLoader
            loader.setLocation(getClass().getResource(fxmlPath));
            loader.setControllerFactory(type -> {
                if (BaseControlador.class.isAssignableFrom(type)) {
                    try {
                        BaseControlador controller = (BaseControlador) type.getDeclaredConstructor().newInstance();
                        controller.setMainApp(this);
                        if (controller instanceof ControladorConStage) {
                            ((ControladorConStage) controller).setStage(stageActual);
                        }
                        return controller;
                    } catch (Exception e) {
                        throw new RuntimeException("No se pudo crear el controlador para " + type.getName(), e);
                    }
                } else {
                    try {
                        return type.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("No se pudo crear el controlador para " + type.getName(), e);
                    }
                }
            });
            
            Pane vista = loader.load(is); // Esta línea corresponde con el tipo del contenedor raíz de tu FXML
            mainContainer.getChildren().clear();
            mainContainer.getChildren().setAll(vista);
        } else {
            Dialogos dialogo = new Dialogos();
            dialogo.mostrarDialogoPersonalizado("No se ha podido encontrar la ruta a la vista: " + fxmlPath);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Imprime cualquier excepción que ocurra durante el proceso
    } finally {
        if (is != null) {
            try {
                is.close(); // Cierra el InputStream en el bloque finally para asegurar que siempre se cierre
            } catch (IOException e) {
                e.printStackTrace(); // Imprime cualquier excepción ocurrida al intentar cerrar el InputStream
            }
        }
    }
}


}






/*
    public static void main(String[] args) {
        launch(args);
    }
*/

