/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

/**
 *
 * @author stevefletesalfaro
 */
import java.time.LocalDate;
import java.time.Period;

public class FechaTarea {
    public static boolean debeNotificar(LocalDate fechaTarea, int diasAntes) {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaNotificacion = fechaTarea.minusDays(diasAntes);

        // Retorna true si hoy es igual o después de la fecha de notificación y antes de la fecha de la tarea
        return !hoy.isBefore(fechaNotificacion) && hoy.isBefore(fechaTarea);
    }
}

