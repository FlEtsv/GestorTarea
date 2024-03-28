/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author steve
 */
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Dialogos {

    public void mostrarDialogoPersonalizado(String dialogoPersonalizado) {
        // Asegura que la UI se modifique en el Application Thread
        Platform.runLater(() -> {
            Stage dialogStage = new Stage();
            dialogStage.setTitle(dialogoPersonalizado);

            Button closeButton = new Button("Cerrar");
            closeButton.setOnAction(e -> dialogStage.close());

            StackPane layout = new StackPane();
            layout.getChildren().add(closeButton);

            Scene scene = new Scene(layout, 300, 200);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        });
    }
}

