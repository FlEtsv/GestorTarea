/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.BasesDatos;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


/**
 *
 * @author steve
 */
public class TareaServicio {
    private TareaDAO tareaDAO;

    public TareaServicio(TareaDAO tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    public ObservableList<Tarea> obtenerTareasParaVista(int usuarioId) {
        List<Tarea> tareas = tareaDAO.verTareas(usuarioId);
        return FXCollections.observableArrayList(tareas);
    }
}
