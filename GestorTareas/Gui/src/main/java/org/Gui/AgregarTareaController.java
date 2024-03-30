/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

/**
 *
 * @author steve
 */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import org.BasesDatos.Tarea;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaDAOImpl;
import org.BasesDatos.TareaServicio;

public class AgregarTareaController {
    int usuarioId = SesionUsuario.getInstance().getResultadoInicioSesion();
    TareaDAO tareaDAO = new TareaDAOImpl(); 
    TareaServicio tareaServicio = new TareaServicio(tareaDAO);
    TareaDAOImpl TareaDaoImp = new TareaDAOImpl();
    @FXML
    private TextField tituloTextField;
    @FXML
    private TextField descripcionTextField;
    @FXML
    private DatePicker fechaLimiteDatePicker;
    @FXML
    private ComboBox<String> estadoComboBox;
        @FXML
    private void initialize() {
        // Ahora llenamos el ComboBox con los estados posibles después de que la UI ha sido cargada
        estadoComboBox.setItems(FXCollections.observableArrayList("Pendiente", "En Progreso", "Completado"));
    }

    @FXML
    private void agregarTarea() {
        String titulo = tituloTextField.getText();
        String descripcion = descripcionTextField.getText();
        LocalDate fechaLimite = fechaLimiteDatePicker.getValue();
        String estado = estadoComboBox.getValue();
        
        Tarea nuevaTarea = new Tarea();


        nuevaTarea.setUsuario_id(usuarioId);
        nuevaTarea.setTitulo(titulo);
        nuevaTarea.setDescripcion(descripcion);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setFecha_limite(fechaLimite);
        
        TareaDaoImp.crearTarea(nuevaTarea);

        
        cerrarVentana();
    }
    
    @FXML
    private void cancelar() {
        cerrarVentana();
    }
    
    private void cerrarVentana() {
        tituloTextField.getScene().getWindow().hide(); // Cierra la ventana actual
    }
}

