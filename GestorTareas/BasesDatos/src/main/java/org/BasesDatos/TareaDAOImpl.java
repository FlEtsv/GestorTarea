/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.BasesDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steve
 */
public class TareaDAOImpl implements TareaDAO {


@Override
public void crearTarea(Tarea tarea) {
    String sql = "INSERT INTO tareas (usuario_id, titulo, descripcion, fecha_limite) VALUES (?, ?, ?, ?);";
    Connection conn = null;
    try {
        conn = ConexionDB.conectar();
        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tarea.getUsuario_id());
            pstmt.setString(2, tarea.getTitulo());
            pstmt.setString(3, tarea.getDescripcion());
            pstmt.setDate(4, java.sql.Date.valueOf(tarea.getFecha_limite()));
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Tarea creada exitosamente.");
        }
    } catch (SQLException e) {
        if (conn != null) {
            try {
                conn.rollback();
                System.out.println("Transacción fallida. Rollback realizado.");
            } catch (SQLException ex) {
                System.out.println("Error al intentar hacer rollback: " + ex.getMessage());
            }
        }
        System.out.println("No se pudo crear la tarea: " + e.getMessage());
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

@Override
public List<Tarea> verTareas(int usuarioId){
    List<Tarea> tareas = new ArrayList<>();
    String sql = "SELECT * FROM tareas WHERE usuario_id = ?;";
    try (Connection conn = ConexionDB.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, usuarioId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Tarea tarea = new Tarea();
            tarea.setId(rs.getInt("id"));
            tarea.setTitulo(rs.getString("titulo"));
            tarea.setDescripcion(rs.getString("descripcion"));
            tarea.setFecha_limite(rs.getDate("fecha_limite").toLocalDate());
            tarea.setEstado(rs.getString("estado"));
            tareas.add(tarea);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return tareas;
}




@Override
public void eliminarTarea(int tareaid,int usuarioId){
    String sql = "DELETE FROM tareas WHERE id = ? AND usuario_id = ?;";
    try (Connection conn = ConexionDB.conectar()) {
        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tareaid);
            pstmt.setInt(2, usuarioId);
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                conn.commit();
                System.out.println("Tarea eliminada correctamente.");
            } else {
                conn.rollback();
                System.out.println("No se encontró la tarea a eliminar.");
            }
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println(e.getMessage());
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}




    @Override
	public void modificarTarea(Tarea tarea) {
	    String sql = "UPDATE tareas SET titulo = ?, descripcion = ?, estado = ?, fecha_limite = ? WHERE id = ? AND usuario_id = ?;";
	    try(Connection conn = ConexionDB.conectar()){
	    	conn.setAutoCommit(false);
	    		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setString(1, tarea.getTitulo());
		        pstmt.setString(2, tarea.getDescripcion());
		        pstmt.setString(3, tarea.getEstado());
                        pstmt.setDate(4, java.sql.Date.valueOf(tarea.getFecha_limite()));
		        pstmt.setInt(5, tarea.getId());
		        pstmt.setInt(6, tarea.getUsuario_id());
		        pstmt.executeUpdate();
		        
		        conn.commit();
		        System.out.println("Tarea modificada exítosamente.");
		    }catch(SQLException e) {
		    	if(conn != null) {
		    		try {
		    			conn.rollback();
		    		}catch(SQLException ex){
		    			System.out.println(ex.getMessage());
		    		}
		    	}
		    	System.out.println(e.getMessage());
		    }
	    }catch(SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    
	}
}

