package org.Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;


public class MainApp extends Application {

    private static StackPane mainContainer = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplicación con Contenedor Principal");
        primaryStage.show();

        // Carga la vista de inicio de sesión
        cargarVistaInicioSesion();
    }
    
    public static void cargarVistaInicioSesion() {
        try {
            StackPane inicioSesion = FXMLLoader.load(MainApp.class.getResource("/org/gui/InicioSesion.fxml"));

            mainContainer.getChildren().setAll(inicioSesion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
