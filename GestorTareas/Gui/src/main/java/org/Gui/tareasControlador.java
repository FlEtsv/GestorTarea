/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

import java.awt.event.ActionEvent;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.BasesDatos.Tarea;
import org.BasesDatos.TareaDAO;
import org.BasesDatos.TareaServicio;

/**
 *
 * @author steve
 */
public class TareasControlador {

    @FXML
    private ListView<Tarea> listaTareas;
    
    private TareaServicio tareaServicio;
    int usuarioId = SesionUsuario.getInstance().getResultadoInicioSesion();

    
    @FXML
    private Button verTareas, modificarTarea, nuevaTarea, eliminarTarea;
    
    @FXML
    private CheckBox filtroTareasPendientes, filtroTareasTerminadas;
    
    // Métodos para manejar eventos, por ejemplo:
    @FXML
    private void handleVerTareas(ActionEvent event) {
        // Lógica para mostrar tareas
    }
    
    @FXML
    private void handleModificarTarea(ActionEvent event) {
        // Lógica para modificar una tarea seleccionada
    }
    
    @FXML
    private void handleNuevaTarea(ActionEvent event) {
        // Lógica para añadir una nueva tarea
    }
    
    @FXML
    private void handleEliminarTarea(ActionEvent event) {
        // Lógica para eliminar una tarea seleccionada
    }
    
    @FXML
    private void initialize() {
        cargarTareas();
    }
    
    private void cargarTareas() {
                listaTareas.setItems(tareaServicio.obtenerTareasParaVista(usuarioId)); // Asegúrate de tener el usuarioId disponible
        
        listaTareas.setCellFactory(param -> new ListCell<Tarea>() {
            @Override
            protected void updateItem(Tarea tarea, boolean empty) {
                super.updateItem(tarea, empty);
                if (empty || tarea == null) {
                    setText(null);
                } else {
                    // Aquí se formatea el texto de cada tarea
                    String contenido = String.format("Título: %s - Estado: %s (Fecha límite: %s)", tarea.getTitulo(), tarea.getEstado(), tarea.getFecha_limite());
                    setText(contenido);
                }
            }
        });
    }
}
