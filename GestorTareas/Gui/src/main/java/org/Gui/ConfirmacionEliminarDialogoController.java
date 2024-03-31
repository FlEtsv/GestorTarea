package org.Gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */



/**
 * FXML Controller class
 *
 * @author steve
 */


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaDAOImpl;

public class ConfirmacionEliminarDialogoController {
    
    int usuarioId = Sesion.getInstance().getResultadoInicioSesion();
    TareaDAO tareaDAO = new TareaDAOImpl();
    int tareaId = Sesion.getInstance().getIdTarea();
    @FXML
    private Button botonSi;

    @FXML
    private Button botonNo;



    @FXML
    private void manejarSi() {
        tareaDAO.eliminarTarea(tareaId, usuarioId);
        cerrarVentana();
    }

    @FXML
    private void manejarNo() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) botonNo.getScene().getWindow();
        stage.close();
    }

}

