/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.BasesDatos;

import java.util.List;

/**
 *
 * @author steve
 */
public interface TareaDAO {
    void crearTarea(Tarea tarea);
    List<Tarea> verTareas(int usuarioId);
    void modificarTarea(Tarea tarea);
    void eliminarTarea(int tareaId, int usuarioId);
}
