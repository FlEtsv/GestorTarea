/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.BasesDatos.ConexionDB;
import org.BasesDatos.Tarea;

/**
 *
 * @author stevefletesalfaro
 */
public class GestorTareas {
    
    public String obtenerEmailPorId(int id) {
        String email = null;
        String sql = "SELECT email FROM usuarios WHERE id = ?"; // Asegúrate de que 'id' y 'usuarios' sean correctos

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                email = rs.getString("email");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el email del usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return email;
    }

    public void verificarYEnviarNotificaciones(List<Tarea> tareas, int diasAntes) {
        for (Tarea tarea : tareas) {
            if (FechaTarea.debeNotificar(tarea.getFecha_limite(), diasAntes)) {
                EmailService emailService = null;
                emailService.sendEmail("from@example.com", obtenerEmailPorId(Sesion.getInstance().getResultadoInicioSesion()) , 
                        "Recordatorio de Tarea", "Recuerda que tienes una tarea próxima: " + tarea.getDescripcion());
                System.out.println("Notificación enviada para la tarea: " + tarea.getDescripcion());
            }
        }
    }
}

